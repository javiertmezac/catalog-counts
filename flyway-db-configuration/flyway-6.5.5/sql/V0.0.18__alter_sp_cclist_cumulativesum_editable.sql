--change date to datetime and consider convert_tz
DELIMITER //

DROP PROCEDURE IF EXISTS selectCumulativeSumByBranch //

CREATE PROCEDURE selectCumulativeSumByBranch(
    IN branchId INT,
    IN deadLineDay INT
)
BEGIN
    DECLARE deadline_time DATETIME DEFAULT CAST(CONCAT(YEAR(current_date()), '-', LPAD(MONTH(current_date()), 2, '0'), '-', deadLineDay) AS DATETIME);
    DECLARE deadline DATETIME DEFAULT ADDTIME(deadline_time, '23:59:59');
    DECLARE prev_month_date DATETIME DEFAULT DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH);
    DECLARE min_prev_date DATETIME DEFAULT CAST(CONCAT(YEAR(prev_month_date), '-', LPAD(MONTH(prev_month_date), 2, '0'), '-', '01') AS DATETIME);
    DECLARE min_current_date DATETIME DEFAULT CAST(CONCAT(YEAR(current_date()), '-', LPAD(MONTH(current_date()), 2, '0'), '-', '01') AS DATETIME);
    DECLARE timezone_name VARCHAR(100);

   SELECT tt.name
   INTO timezone_name
   FROM timezone_type AS tt
   JOIN branch AS b ON b.timezoneId = tt.id
   WHERE b.id = branchId;

SELECT
    cc.id,
    cc.registration,
    CONCAT(cce.identifier, ' - ', cce.name) AS catalogCountEnum,
    cc.amount,
    cc.details,
    SUM(
            CASE
                WHEN cce.type = 0 THEN cc.amount
                WHEN cce.type = 1 THEN -cc.amount
                ELSE 0
                END
        ) OVER (ORDER BY cc.registration) AS total,
        CASE
            WHEN CONVERT_TZ(now(), 'UTC', timezone_name) <= deadline AND CONVERT_TZ(cc.registration, 'UTC', timezone_name) > min_prev_date THEN 1
            WHEN CONVERT_TZ(cc.registration, 'UTC', timezone_name) >= min_current_date THEN 1
            ELSE 0
            END AS editable
FROM
    catalog_count AS cc
        INNER JOIN
    catalog_count_enum AS cce ON cce.id = cc.catalogCountEnumId
WHERE
        cc.branchId = branchId
  AND cc.isDeleted = 0
ORDER BY
    cc.registration DESC;
END //

DELIMITER ;