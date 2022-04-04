CREATE TABLE IF NOT EXISTS `catalog_count` (

  `id`                  BIGINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `registrationDate`    DATETIME               NOT NULL,
  `catalogCountEnumId`  BIGINT(8) UNSIGNED NOT NULL,
  `amount`              DOUBLE             NOT NULL,
  `details`             VARCHAR(250)        NOT NULL,
  `isDeleted`           BOOLEAN DEFAULT FALSE,
  `branchId`            BIGINT(8) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `catalogCountEnumId_FK` FOREIGN KEY (`catalogCountEnumId`) REFERENCES `catalog_count`.`catalog_count_enum` (`id`)
  CONSTRAINT `branchId_FK` FOREIGN KEY (`branchId`) REFERENCES `catalog_count`.`branch` (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;