package com.jtmc.apps.reforma.repository.mybatis.dbmapper.monthlytotal;

import com.jtmc.apps.reforma.domain.MonthlyTotal;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

public interface MonthlyTotalMapper {

    @SelectProvider(
            type = MonthlyTotalMapperProvider.class,
            method = "selectMonthlyTotalRecordSql"
    )
    MonthlyTotal selectMonthlyTotal(@Param("currentDateYear") int year,
                                    @Param("currentDateMonth") int month);
}
