CREATE TABLE IF NOT EXISTS `service` (
  `id`                      BIGINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `date`                    DATE  NOT NULL,
  PRIMARY KEY (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `attendance` (
  `id`                      BIGINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `idService`               BIGINT(8) UNSIGNED NOT NULL,
  `idPersona`               BIGINT(8) UNSIGNED NOT NULL,
  `attended`                BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (`id`),
  CONSTRAINT `idService_FK` FOREIGN KEY (`idService`) REFERENCES `service` (`id`),
  CONSTRAINT `idPersona_FK` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;