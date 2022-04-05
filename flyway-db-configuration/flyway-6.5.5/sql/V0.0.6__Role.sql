CREATE TABLE IF NOT EXISTS `role` (
  `id`              BIGINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `description`     VARCHAR(64) NOT NULL,
  `registration`    DATETIME NOT NULL,
  `status`          BOOLEAN NOT NULL,
  PRIMARY KEY (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;