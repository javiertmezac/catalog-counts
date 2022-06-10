CREATE TABLE IF NOT EXISTS `report` (
  `id`              INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `reportedBy`      INT UNSIGNED NOT NULL,
  `registration`    DATETIME NOT NULL,
  `uuid`            VARCHAR(64) NOT NULL,
  `periodId`        INT UNSIGNED NOT NULL,
  `branchId`        INT UNSIGNED NOT NULL,
  `status`          BOOLEAN NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `report_reportedBy_FK` FOREIGN KEY (`reportedBy`) REFERENCES `catalog_count`.`persona` (`id`),
  CONSTRAINT `report_periodDetails_FK` FOREIGN KEY (`periodId`, `branchId`) REFERENCES `catalog_count`.`period_details` (`periodId`, `branchId`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;