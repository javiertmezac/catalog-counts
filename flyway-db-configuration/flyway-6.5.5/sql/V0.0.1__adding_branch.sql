CREATE TABLE IF NOT EXISTS `catalog_count`.`branch` (
  `id`              INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `address`         VARCHAR(45) NOT NULL,
  `name`            VARCHAR(45) NOT NULL,
  `registration`    DATETIME NOT NULL,
  `status`          BOOLEAN NOT NULL,
  PRIMARY KEY (`id`)
 )
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;
