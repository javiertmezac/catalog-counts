CREATE TABLE IF NOT EXISTS `role` (
  `id`              INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `description`     VARCHAR(64) NOT NULL,
  `registration`    DATETIME NOT NULL,
  `status`          BOOLEAN NOT NULL,
  PRIMARY KEY (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;

--  insert into role(description, registration, status) values('Tesorero Financiero', current_timestamp(), 1);