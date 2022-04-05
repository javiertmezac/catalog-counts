package com.jtmc.apps.reforma.impl.catalogcount;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountResponse;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.MonthlyTotal;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.monthlytotal.MonthlyTotalMapper;
import javassist.NotFoundException;
import org.apache.commons.configuration2.resolver.CatalogResolver;
import org.mybatis.guice.transactional.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CatalogCountImpl {
    final private Logger LOGGER = LoggerFactory.getLogger(CatalogCountImpl.class);

    @Inject
    private MonthlyTotalMapper monthlyTotalMapper;

    @Inject
    private CatalogCountRepository catalogCountRepository;

    public List<CatalogCountResponse> selectAllWithTotalColumn() {
        Integer branchId = 0;
        Collection<CatalogCount> catalogCounts = catalogCountRepository.selectAllByBranch(branchId);
        final double[] total = {0};
        Stream<CatalogCountResponse> catalogCountResponseStream = catalogCounts.stream().map((cc) -> {
            total[0] = calculateTotalColumn(cc, total[0]);
            return new CatalogCountResponse(
                    cc.getId(),
                    convertToGMTMinus07Zone(cc.getRegistration().getEpochSecond()).toString(),
//                    cc.getCatalogCountEnum().getCatalogCountEnumDisplay(),
                    cc.getCatalogcountenumid().toString(),
                    cc.getAmount(),
                    cc.getDetails(),
                    total[0]
            );
        });

        List<CatalogCountResponse> responseList = catalogCountResponseStream.collect(Collectors.toList());
        Collections.reverse(responseList);
        return responseList;
    }

    //todo: this convertMethod should not be happening in backend.. remove it and use date pipe in frontend
    private LocalDate convertToGMTMinus07Zone(long epochSec) {
        ZoneId zoneId = ZoneId.of("-7");
        ZonedDateTime zonedDateTime = Instant.ofEpochSecond(epochSec).atZone(zoneId);
        return zonedDateTime.toLocalDate();
    }

    //todo: re-think if this method should be here
    public double getCorrespondingMonthlyTotal() {
        int year = Year.now().getValue();
        int month = Month.from(LocalDate.now()).getValue();
        //todo: exception when sever is not available

        MonthlyTotal monthlyTotal = monthlyTotalMapper.selectMonthlyTotal(year, month - 1);
        if (monthlyTotal == null) {
            //todo: find appropriate exception. Consider corresponding layer
            throw new RuntimeException("MonthlyTotal null");
        }
        return monthlyTotal.getTotal();
    }

    public double getCorrespondingTotal() {
        MonthlyTotal total = monthlyTotalMapper.selectTotal();

        if (total == null) {
            throw new RuntimeException("MonthlyTotal null");
        }

        return total.getTotal();
    }


    public double calculateTotalColumn(CatalogCount catalogCount, double saldo) {
        //todo: this will only work if first 3 rows from CatalogCountEnum are "incoming values"
        int incomingEnums = 3;
        if (catalogCount.getCatalogcountenumid() <= incomingEnums)  {
            saldo = saldo + catalogCount.getAmount();
        } else {
            saldo = saldo - catalogCount.getAmount();
        }
        return saldo;
    }

    @Transactional
    public void insertIntoCatalogCount(CatalogCount catalogCount) {
        catalogCountRepository.insert(catalogCount);
    }

    public CatalogCount selectOneRecord(int id) {
        Optional<CatalogCount> catalogCount = catalogCountRepository.selectOneRecord(id);
        if(!catalogCount.isPresent()) {
            //todo: improve this exception
            throw new RuntimeException("CatalogCount not found");
        }
        return catalogCount.get();
    }

    @Transactional
    public void logicalDeleteRecord(int id) {
        CatalogCount cc = new CatalogCount();
        cc.setId(id);
        catalogCountRepository.logicalDelete(cc);
    }
}
