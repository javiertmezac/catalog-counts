DELIMITER //

DROP PROCEDURE IF EXISTS selectCumulativeSumByBranch //

CREATE PROCEDURE selectCumulativeSumByBranch(
    IN branchId INT,
    IN deadLineDay INT
)
BEGIN
    DECLARE deadline DATE DEFAULT CAST(CONCAT(YEAR(current_date()), '-', LPAD(MONTH(current_date()), 2, '0'), '-', deadLineDay) AS DATE);
    DECLARE prev_month_date DATE DEFAULT DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH);
    DECLARE min_prev_date DATE DEFAULT CAST(CONCAT(YEAR(prev_month_date), '-', LPAD(MONTH(prev_month_date), 2, '0'), '-', '01') AS DATE);
    DECLARE min_current_date DATE DEFAULT CAST(CONCAT(YEAR(current_date()), '-', LPAD(MONTH(current_date()), 2, '0'), '-', '01') AS DATE);
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
            WHEN current_date() <= deadline AND cc.registration > min_prev_date THEN 1
            WHEN cc.registration >= min_current_date THEN 1
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