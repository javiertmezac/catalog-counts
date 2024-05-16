DELIMITER //

DROP PROCEDURE IF EXISTS selectDefaultReportIncomesOrExpenses //

CREATE PROCEDURE selectDefaultReportIncomesOrExpenses(
    IN isIncome BIT,
    IN branchId INT,
    IN reportMonth INT,
    IN reportYear INT
)
BEGIN
    DECLARE min_date DATETIME DEFAULT CAST(CONCAT(reportYear, '-', LPAD(reportMonth, 2, '0'), '-', '01') AS DATETIME);
    DECLARE max_date DATETIME DEFAULT ADDTIME(LAST_DAY(min_date), '23:59:59');
    DECLARE incomeFamily VARCHAR(5) DEFAULT '1.';
    DECLARE initialAmount VARCHAR(5) DEFAULT '0.1';
    DECLARE timezone_name VARCHAR(100);

    -- Assign timezone_name value using SELECT INTO
    SELECT tt.name
    INTO timezone_name
    FROM timezone_type AS tt
    JOIN branch AS b ON b.timezoneId = tt.id
    WHERE b.id = branchId;

    SELECT
        cce.family, COALESCE(SUM(cc.amount), 0) AS sumAmount
    FROM
        catalog_count AS cc
    LEFT JOIN catalog_count_enum AS cce ON cc.catalogCountEnumId = cce.id
    WHERE
        cc.branchId = branchId
        AND cc.isDeleted = false
        AND CONVERT_TZ(cc.registration, 'UTC', timezone_name) BETWEEN min_date AND max_date
        AND ((isIncome AND cce.identifier LIKE CONCAT(incomeFamily, '%')) OR
            (NOT isIncome AND cce.identifier NOT LIKE CONCAT(incomeFamily, '%') AND cce.identifier <> initialAmount))
    GROUP BY
        cce.family;
END//

DELIMITER ;