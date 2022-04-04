CREATE TABLE IF NOT EXISTS `monthly_total` (
  `id`                  BIGINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `total`               DOUBLE             NOT NULL,
  `registrationDate`    DATE               NOT NULL,
  `isActive`           BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;