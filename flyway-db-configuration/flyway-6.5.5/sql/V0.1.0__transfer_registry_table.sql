CREATE TABLE IF NOT EXISTS `transferRegistry` (
  `transferRegistryId`      binary(16)      NOT NULL,
  `fromAccountId`           INT UNSIGNED    NOT NULL,
  `toAccountId`             INT UNSIGNED    NOT NULL,
  `details`                 TEXT            NOT NULL,
  `amount`                  DOUBLE          NOT NULL,
  `catalogCountEnumId`      INT UNSIGNED    NOT NULL,
  `catalogCountId`          INT UNSIGNED    NOT NULL,
  `entryPersonId`           INT UNSIGNED    NOT NULL,
  `entryDate`               DATETIME        NOT NULL,
  `transferRegistryState`   BOOLEAN DEFAULT FALSE,
  `acceptedPersonId`        INT UNSIGNED    NULL,
  `acceptedDate`            DATETIME        NULL,
  `transferRegistryStatus`  BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (`transferRegistryId`),
  CONSTRAINT `transferRegistry_catalogCountEnumId_FK` FOREIGN KEY (`catalogCountEnumId`) REFERENCES `catalog_count`.`catalog_count_enum` (`id`),
  CONSTRAINT `transferRegistry_catalogCountId_FK` FOREIGN KEY (`catalogCountId`) REFERENCES `catalog_count`.`catalog_count` (`id`),
  CONSTRAINT `transferRegistry_fromAccount_FK` FOREIGN KEY (`fromAccountId`) REFERENCES `catalog_count`.`branch` (`id`),
  CONSTRAINT `transferRegistry_toAccount_FK` FOREIGN KEY (`toAccountId`) REFERENCES `catalog_count`.`branch` (`id`),
  CONSTRAINT `transferRegistry_entryPersonId_FK` FOREIGN KEY (`entryPersonId`) REFERENCES `catalog_count`.`persona` (`id`),
  CONSTRAINT `transferRegistry_acceptedPersonId_FK` FOREIGN KEY (`acceptedPersonId`) REFERENCES `catalog_count`.`persona` (`id`)
)
 DEFAULT CHARSET =utf8mb4
 COLLATE =utf8mb4_unicode_ci;
