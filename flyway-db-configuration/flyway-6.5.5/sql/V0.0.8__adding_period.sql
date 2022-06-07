CREATE TABLE IF NOT EXISTS `period` (
  `id`          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(64) NOT NULL,
  `fromMonth`   INT UNSIGNED NOT NULL,
  `toMonth`     INT UNSIGNED NOT NULL,
  `year`        INT UNSIGNED NOT NULL,
  `status`      BOOLEAN NOT NULL,
  PRIMARY KEY (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;