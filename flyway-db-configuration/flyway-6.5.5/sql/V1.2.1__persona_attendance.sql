CREATE TABLE IF NOT EXISTS `attendance` (
  `id`                      BIGINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `idPersona`               BIGINT(8) UNSIGNED NOT NULL,
  `registrationDate`        DATE               NOT NULL,
  `attended`                BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (`id`),
  CONSTRAINT `idPersona_FK` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;