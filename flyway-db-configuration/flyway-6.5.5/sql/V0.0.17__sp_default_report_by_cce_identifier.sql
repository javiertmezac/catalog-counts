DELIMITER //

DROP PROCEDURE IF EXISTS selectDefaultReportByCceIdentifier //

CREATE PROCEDURE selectDefaultReportByCceIdentifier(
    IN branchId INT,
    IN reportFromMonth INT,
    IN reportFromYear INT,
    IN reportToMonth INT,
    IN reportToYear INT
)
BEGIN
    DECLARE min_date DATETIME DEFAULT CAST(CONCAT(reportFromYear, '-', LPAD(reportFromMonth, 2, '0'), '-', '01') AS DATETIME);
    DECLARE max_date_first_day DATETIME DEFAULT CAST(CONCAT(reportToYear, '-', LPAD(reportToMonth, 2, '0'), '-', '01') AS DATETIME);
    DECLARE max_date DATETIME DEFAULT ADDTIME(LAST_DAY(max_date_first_day), '23:59:59');
    DECLARE timezone_name VARCHAR(100);

    -- Assign timezone_name value using SELECT INTO
    SELECT tt.name
    INTO timezone_name
    FROM timezone_type AS tt
    JOIN branch AS b ON b.timezoneId = tt.id
    WHERE b.id = branchId;

    SELECT
        cce.identifier, cce.name, COALESCE(SUM(cc.amount), 0) AS sumAmount
    FROM
        catalog_count AS cc
    LEFT JOIN catalog_count_enum AS cce ON cc.catalogCountEnumId = cce.id
    WHERE
        cc.branchId = branchId
        AND cc.isDeleted = false
        AND CONVERT_TZ(cc.registration, 'UTC', timezone_name) BETWEEN min_date AND max_date
    GROUP BY
        cce.identifier, cce.name
   ORDER BY
        cce.identifier;
END//

DELIMITER ;