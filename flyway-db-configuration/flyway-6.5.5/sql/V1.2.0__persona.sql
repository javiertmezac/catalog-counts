CREATE TABLE IF NOT EXISTS `persona` (
  `id`                  BIGINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`               VARCHAR(64)             NOT NULL,
  `lastname`           VARCHAR(64)               NOT NULL,
  PRIMARY KEY (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;