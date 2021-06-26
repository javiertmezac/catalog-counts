package com.jtmc.apps.reforma.impl.catalogcount;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountResponse;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.MonthlyTotal;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.monthlytotal.MonthlyTotalMapper;
import org.mybatis.guice.transactional.Transactional;

import java.time.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CatalogCountImpl {

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
