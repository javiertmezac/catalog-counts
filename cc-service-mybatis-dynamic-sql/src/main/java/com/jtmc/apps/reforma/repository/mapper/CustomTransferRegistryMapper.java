package com.jtmc.apps.reforma.repository.mapper;

import com.jtmc.apps.reforma.domain.CustomTransferRegistry;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface CustomTransferRegistryMapper extends TransferRegistryMapper {
    @Select(value = """
            SELECT
              tr.*,
              b.name AS fromAccountName,
              b1.name AS toAccountName,
              concat(p.name, ' ', p.lastname) AS entryPersonName,
              concat(p1.name, ' ', p1.lastname) AS acceptedPersonName
            FROM transferRegistry AS tr
            JOIN branch AS b ON tr.fromAccountId = b.id
            JOIN branch AS b1 ON tr.toAccountId = b1.id
            JOIN persona AS p ON tr.entryPersonId = p.id
            LEFT JOIN persona AS p1 ON tr.acceptedPersonId = p1.id
            WHERE inactiveDate is null and (tr.fromAccountId = #{accountId} OR tr.toAccountId = #{accountId})
            ORDER BY entryDate DESC
            """)
    @Options(statementType = StatementType.PREPARED)
    @Results(id="CustomTransferRegistryResult", value = {
            @Result(column="transferRegistryId", property="transferregistryid", jdbcType=JdbcType.BINARY, id=true),
            @Result(column="fromAccountId", property="fromaccountid", jdbcType=JdbcType.INTEGER),
            @Result(column="toAccountId", property="toaccountid", jdbcType=JdbcType.INTEGER),
            @Result(column="amount", property="amount", jdbcType=JdbcType.DOUBLE),
            @Result(column="fromAccountCatalogCountId", property="fromaccountcatalogcountid", jdbcType=JdbcType.INTEGER),
            @Result(column="toAccountCatalogCountId", property="toaccountcatalogcountid", jdbcType=JdbcType.INTEGER),
            @Result(column="entryPersonId", property="entrypersonid", jdbcType=JdbcType.INTEGER),
            @Result(column="entryDate", property="entrydate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="inactiveDate", property="inactivedate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="acceptedPersonId", property="acceptedpersonid", jdbcType=JdbcType.INTEGER),
            @Result(column="acceptedDate", property="accepteddate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="details", property="details", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="fromAccountName", property="fromAccountName", jdbcType=JdbcType.VARCHAR),
            @Result(column="toAccountName", property="toAccountName", jdbcType=JdbcType.VARCHAR),
            @Result(column="entryPersonName", property="entryPersonName", jdbcType=JdbcType.VARCHAR),
            @Result(column="acceptedPersonName", property="acceptedPersonName", jdbcType=JdbcType.VARCHAR)
    })
    List<CustomTransferRegistry> selectManyCustomTransferRegistry(@Param("accountId") Integer accountId);
}
