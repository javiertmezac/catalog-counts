DELIMITER //

DROP PROCEDURE IF EXISTS selectCumulativeSumByBranch //

CREATE PROCEDURE selectCumulativeSumByBranch(
    IN branchId INT
)
BEGIN
    DECLARE deadline DATE DEFAULT CAST(CONCAT(YEAR(current_date()), '-', LPAD(MONTH(current_date()), 2, '0'), '-', '10') AS DATE);

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
            WHEN cc.registration < deadline
                AND current_date() > deadline THEN 0
            ELSE 1
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