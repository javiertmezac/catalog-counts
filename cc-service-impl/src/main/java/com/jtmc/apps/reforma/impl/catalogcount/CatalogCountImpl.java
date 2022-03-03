package com.jtmc.apps.reforma.impl.catalogcount;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountResponse;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.MonthlyTotal;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.monthlytotal.MonthlyTotalMapper;
import org.mybatis.guice.transactional.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CatalogCountImpl {
    final private Logger LOGGER = LoggerFactory.getLogger(CatalogCountImpl.class);

    @Inject
    private MonthlyTotalMapper monthlyTotalMapper;

    @Inject
    private CatalogCountRepository catalogCountRepository;

    public List<CatalogCountResponse> selectAllRecordsWithTotalColumn(double initialTotal) {
        Collection<CatalogCount> catalogCounts = catalogCountRepository.selectAll();
        List<CatalogCountResponse> responseList = new ArrayList<>();

        Object[] objects = catalogCounts.toArray();

        double total = initialTotal;
        for (int i = catalogCounts.size()-1; i >= 0; i--) {
           CatalogCount next = (CatalogCount) objects[i];
            total = calculateTotalColumn(next, total);
            responseList.add(0, new CatalogCountResponse(
                    next.getId(),
                    convertToGMTMinus07Zone(next.getRegistrationDate().getEpochSecond()).toString(),
                    next.getCatalogCountEnum().getCatalogCountEnumDisplay(),
                    next.getAmount(),
                    next.getDetails(),
                    total
            ));
        }
        return responseList;
    }

    public List<CatalogCountResponse> selectAllWithTotalColumn() {
        Collection<CatalogCount> catalogCounts = catalogCountRepository.selectAll();
        final double[] total = {0};
        Stream<CatalogCountResponse> catalogCountResponseStream = catalogCounts.stream().map((cc) -> {
            total[0] = calculateTotalColumn(cc, total[0]);
            return new CatalogCountResponse(
                    cc.getId(),
                    convertToGMTMinus07Zone(cc.getRegistrationDate().getEpochSecond()).toString(),
                    cc.getCatalogCountEnum().getCatalogCountEnumDisplay(),
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
        if (catalogCount.getCatalogCountEnum().getId() <= incomingEnums)  {
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
        return catalogCountRepository.selectOneRecord(id);
    }

    @Transactional
    public void logicalDeleteRecord(int id) {
        catalogCountRepository.logicalDelete(id);
    }
}
