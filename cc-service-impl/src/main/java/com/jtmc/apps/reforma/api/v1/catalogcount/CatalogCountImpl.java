package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.dbmapper.catalogcount.CatalogCountMapper;
import com.jtmc.apps.reforma.dbmapper.monthlytotal.MonthlyTotalMapper;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.MonthlyTotal;
import org.mybatis.guice.transactional.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

public class CatalogCountImpl implements CatalogCountApi {
    private Logger LOGGER = LoggerFactory.getLogger(CatalogCountImpl.class);


    //todo: these Mapper Classes shouldn't be used at this level
    //maybe it is better to have an interface with (CRUD) operations and maybe more
    //and internally used the DB layer/service we want!
    @Inject
    private CatalogCountMapper catalogCountMapper;

    @Inject
    private MonthlyTotalMapper monthlyTotalMapper;

    @Override
    public CatalogCountResponseList getList() {
        CatalogCountResponseList responseList = new CatalogCountResponseList();
        responseList.setCatalogCountResponseCollection(new ArrayList<>());
        responseList.setSaldoAnterior(getCorrespondingMonthlyTotal());

        Collection<CatalogCount> catalogCounts = catalogCountMapper.selectAllRecords();

        double total = responseList.getSaldoAnterior();
        for (CatalogCount next : catalogCounts) {
            total = getTotal(next, total);
            responseList.getCatalogCountResponseCollection().add(new CatalogCountResponse(
                    next.getId(),
                    next.getRegistrationDate(),
                    next.getCatalogCountEnumId(),
                    next.getAmount(),
                    next.getDetails(),
                    total
            ));
        }
        return responseList;
    }

    private double getCorrespondingMonthlyTotal() {
        int year = Year.now().getValue();
        int month = Month.from(LocalDate.now()).getValue();
        MonthlyTotal monthlyTotal = monthlyTotalMapper.selectMonthlyTotal(year, month - 1);
        if (monthlyTotal == null) {
            //todo: find appropriate exception. Consider corresponding layer
            throw new RuntimeException("MonthlyTotal null");
        }
        return monthlyTotal.getTotal();
    }

    private double getTotal(CatalogCount catalogCount, double saldo) {
        //todo: this will only work is first 3 rows from CatalogCountEnum are "incoming values"
        int incomingEnums = 3;
        if (catalogCount.getCatalogCountEnumId() <= incomingEnums)  {
            saldo = saldo + catalogCount.getAmount();
        } else {
            saldo = saldo - catalogCount.getAmount();
        }
        return saldo;
    }

    @Override
    @Transactional
    public Response insert(CatalogCountRequest catalogCountRequest) {

        CatalogCount catalogCount = new CatalogCount();
        Date registration = new Date();

        checkNotNull(catalogCountRequest, "request object cannot be null");
        catalogCount.setAmount(catalogCountRequest.getAmount());
        catalogCount.setDetails(catalogCountRequest.getDetails());
        catalogCount.setCatalogCountEnumId(catalogCountRequest.getCatalogCountEnumId());
        catalogCount.setDeleted(false);
        catalogCount.setRegistrationDate(registration);

        catalogCountMapper.insertIntoCatalogCount(catalogCount);
        //todo: this is not Json type
        return Response.ok().build();
    }

    public CatalogCountResponse getCatalogCount(int id) {
        LOGGER.info("CatalogCountId payload: " + id);

        CatalogCount catalogCount = catalogCountMapper.selectOneRecord(id);
        if (catalogCount == null) {
            //todo: bad exception handling here
           throw new RuntimeException("Catalog Count id: " + id + " not found");
        }

        return new CatalogCountResponse(
                catalogCount.getId(),
                catalogCount.getRegistrationDate(),
                catalogCount.getCatalogCountEnumId(),
                catalogCount.getAmount(),
                catalogCount.getDetails()
        );
    }

    //todo: should have a test to verify logicalDelete was done correctly
    @Transactional
    public Response logicalDeleteRecord(int id) {
        catalogCountMapper.logicalDeleteRecord(id);
        return Response.noContent().build();
    }
}
