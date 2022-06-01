CREATE TABLE IF NOT EXISTS `period` (
  `id`          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(64) NOT NULL,
  `from`        INT UNSIGNED NOT NULL,
  `to`          INT UNSIGNED NOT NULL,
  `year`        INT UNSIGNED NOT NULL,
  `status`      BOOLEAN NOT NULL,
  PRIMARY KEY (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;