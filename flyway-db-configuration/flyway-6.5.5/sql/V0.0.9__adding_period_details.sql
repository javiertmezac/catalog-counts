CREATE TABLE IF NOT EXISTS `period_details` (
  `confirmedBy`     INT UNSIGNED NOT NULL,
  `registration`    DATETIME NOT NULL,
  `periodId`        INT UNSIGNED NOT NULL,
  `branchId`        INT UNSIGNED NOT NULL,
  `status`          BOOLEAN NOT NULL,
  PRIMARY KEY (`branchId`, `periodId`, `confirmedBy`),
  CONSTRAINT `periodDetails_confirmedBy_FK` FOREIGN KEY (`confirmedBy`) REFERENCES `catalog_count`.`persona` (`id`),
  CONSTRAINT `periodDetails_period_FK` FOREIGN KEY (`periodId`) REFERENCES `catalog_count`.`period` (`id`),
  CONSTRAINT `periodDetails_brandh_FK` FOREIGN KEY (`branchId`) REFERENCES `catalog_count`.`branch` (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;