CREATE TABLE IF NOT EXISTS `catalog_count` (
  `id`                  INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `registration`        DATETIME               NOT NULL,
  `catalogCountEnumId`  INT UNSIGNED NOT NULL,
  `amount`              DOUBLE             NOT NULL,
  `details`             VARCHAR(250)        NOT NULL,
  `isDeleted`           BOOLEAN DEFAULT FALSE,
  `branchId`            INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `catalogCountEnumId_FK` FOREIGN KEY (`catalogCountEnumId`) REFERENCES `catalog_count`.`catalog_count_enum` (`id`),
  CONSTRAINT `catalogCount_branch_FK` FOREIGN KEY (`branchId`) REFERENCES `catalog_count`.`branch` (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;