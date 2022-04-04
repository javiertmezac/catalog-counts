CREATE TABLE IF NOT EXISTS `persona` (
  `id`       BIGINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`     VARCHAR(64) NOT NULL,
  `lastname` VARCHAR(64) NOT NULL,
  `registration` DATETIME NOT NULL,
  `status` BOOLEAN NOT NULL,
  `branchId` BIGINT(8) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `branchId_FK` FOREIGN KEY (`branchId`) REFERENCES `catalog_count`.`branch` (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;