CREATE TABLE IF NOT EXISTS `persona_details` (
  `id`              INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `personaId`       INT UNSIGNED NOT NULL,
  `branchId`        INT UNSIGNED NOT NULL,
  `roleId`          INT UNSIGNED NOT NULL,
  `registration`    DATETIME NOT NULL,
  `status`          BOOLEAN NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `personaDetails_persona_FK` FOREIGN KEY (`personaId`) REFERENCES `catalog_count`.`persona` (`id`),
  CONSTRAINT `personaDetails_branch_FK` FOREIGN KEY (`branchId`) REFERENCES `catalog_count`.`branch` (`id`),
  CONSTRAINT `personaDetails_role_FK` FOREIGN KEY (`roleId`) REFERENCES `catalog_count`.`role` (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;