CREATE TABLE IF NOT EXISTS `catalog_count`.`login` (
  `id`              BIGINT(8) NOT NULL AUTO_INCREMENT,
  `password`        VARCHAR(45) NOT NULL,
  `username`        VARCHAR(45) NOT NULL,
  `status`          BOOLEAN NOT NULL,
  `registration`    DATETIME NOT NULL,
  `personaId`       BIGINT(8) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `login_persona_FK` FOREIGN KEY (`personaId`) REFERENCES `catalog_count`.`persona` (`id`)
 )
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;
