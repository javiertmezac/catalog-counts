# Reports

## Informe Auditoría
- title
- mision
- period: Jan - May 2021
- saldo anterior (previous balance) : PB
- sum of each "incomes"
 - 1.1
 - 1.2
 - 1.3
 - total of 1s : SI
- sum of each "expenses"
 - 2,3,4,5,6,7,8,9
 - total of (2-9)s : SE
- total - (PB + SI) - SE

(IF)
- gastos sin comprobar: (unchecked expenses: UE)
- prestamos: (loans : L)

- total = total - (UE + L)

- Comments
- Auditor
- Tesorero : Treasurer
- Secretario: Secretary

## Helpful sql queries
```roomsql
-- returns sum of catalogCountEnumIds .. but not same catalogCountEnumId Family
-- this only works for INCOMING
-- 1, 2 , 3
-- and catalogCountEnumId in (1,2,3)
select catalogCountEnumId, sum(amount)
from catalog_count
where (registrationDate >= date('2021-06-01') and registrationDate < date('2021-07-01'))
group by catalogCountEnumId;

select catalogCountEnumId, sum(amount)
from catalog_count
where (registrationDate >= date('2021-06-01') and registrationDate < date('2021-07-01'))
and catalogCountEnumId not in (1,2,3)
group by catalogCountEnumId;


alter table catalog_count_enum add column family varchar(30) after identifier;

select sum(cc.amount), cce.family
from catalog_count as cc
inner join catalog_count_enum as cce on cc.catalogCountEnumId = cce.id
where (registrationDate >= date('2021-6-01') and registrationDate < date('2021-7-01'))
and catalogCountEnumId not in (1, 2, 3)
group by cce.family;


----- insert into monthly_total
insert into monthly_total(total, registrationDate, isActive)
values(100, date('2020-02-01'), false);

--- 'AVAILABLE MONTHS': this is to show all months available within given year
select distinct MONTH(registrationDate) from monthly_total where YEAR(registrationDate) = 2021;
-- 'FETCH PREVIOUS BALANCE': this is to fetch previous balance on given month and year
-- fetchPreviousBalance depends on 'AVAILABLE MONTHS'
select * from monthly_total where MONTH(registrationDate) = 6 and YEAR(registrationDate) = 2021 order by registrationDate asc limit 1;

```