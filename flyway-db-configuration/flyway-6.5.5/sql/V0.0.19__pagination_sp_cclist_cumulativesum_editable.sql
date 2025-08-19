--this is an improvement to filter, still not sure if I want to filter on details, identifier and name
--as totalCount is not considered.
--only filter that can be use and still have tocal count valid is filterYear
DELIMITER //

DROP PROCEDURE IF EXISTS selectCumulativeSumByBranchAndPagination //

CREATE PROCEDURE selectCumulativeSumByBranchAndPagination(
    IN branchId INT,
    IN deadLineDay INT,
    IN filterYear INT,
    IN page INT,
    IN pageSize INT
)
BEGIN
    DECLARE offsetRows INT DEFAULT (page - 1) * pageSize;

    DECLARE deadline_time DATETIME DEFAULT CAST(CONCAT(YEAR(CURRENT_DATE()), '-', LPAD(MONTH(CURRENT_DATE()), 2, '0'), '-', deadLineDay) AS DATETIME);
    DECLARE deadline DATETIME DEFAULT ADDTIME(deadline_time, '23:59:59');
    DECLARE prev_month_date DATETIME DEFAULT DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH);
    DECLARE min_prev_date DATETIME DEFAULT CAST(CONCAT(YEAR(prev_month_date), '-', LPAD(MONTH(prev_month_date), 2, '0'), '-', '01') AS DATETIME);
    DECLARE min_current_date DATETIME DEFAULT CAST(CONCAT(YEAR(CURRENT_DATE()), '-', LPAD(MONTH(CURRENT_DATE()), 2, '0'), '-', '01') AS DATETIME);
    DECLARE timezone_name VARCHAR(100);

    -- Get timezone for the branch
    SELECT tt.name
    INTO timezone_name
    FROM timezone_type AS tt
    JOIN branch AS b ON b.timezoneId = tt.id
    WHERE b.id = branchId;

    -- Paginated results: keep totals from all history, filter display after total calculation
    SELECT *
    FROM (
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
                WHEN CONVERT_TZ(UTC_TIMESTAMP(), 'UTC', timezone_name) <= deadline
                     AND CONVERT_TZ(cc.registration, 'UTC', timezone_name) > min_prev_date THEN 1
                WHEN CONVERT_TZ(cc.registration, 'UTC', timezone_name) >= min_current_date THEN 1
                ELSE 0
            END AS editable
        FROM catalog_count AS cc
        INNER JOIN catalog_count_enum AS cce
            ON cce.id = cc.catalogCountEnumId
        WHERE cc.branchId = branchId
          AND cc.isDeleted = 0
    ) AS base
    WHERE (filterYear IS NULL OR YEAR(base.registration) = filterYear)
    ORDER BY base.registration DESC
    LIMIT pageSize OFFSET offsetRows;


    -- Total count for pagination (filtered display)
    SELECT COUNT(*) AS totalCount
    FROM catalog_count AS cc
    INNER JOIN catalog_count_enum AS cce
        ON cce.id = cc.catalogCountEnumId
    WHERE cc.branchId = branchId
      AND cc.isDeleted = 0
      AND (filterYear IS NULL OR YEAR(cc.registration) = filterYear);

END //

DELIMITER ;
