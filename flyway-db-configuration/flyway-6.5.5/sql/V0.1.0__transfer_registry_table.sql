CREATE TABLE IF NOT EXISTS `transferRegistry` (
  `transferRegistryId`          binary(16)      NOT NULL,
  `fromAccountId`               INT UNSIGNED    NOT NULL,
  `toAccountId`                 INT UNSIGNED    NOT NULL,
  `details`                     TEXT            NOT NULL,
  `amount`                      DOUBLE          NOT NULL,
  `fromAccountCatalogCountId`   INT UNSIGNED    NOT NULL,
  `toAccountCatalogCountId`     INT UNSIGNED    NULL,
  `entryPersonId`               INT UNSIGNED    NOT NULL,
  `entryDate`                   DATETIME        NOT NULL,
  `inactiveDate`                DATETIME        NULL,
  `acceptedPersonId`            INT UNSIGNED    NULL,
  `acceptedDate`                DATETIME        NULL,
  PRIMARY KEY (`transferRegistryId`),
  CONSTRAINT `transferRegistry_fromAccountCatalogCount_FK` FOREIGN KEY (`fromAccountCatalogCountId`) REFERENCES `catalog_count`.`catalog_count` (`id`),
  CONSTRAINT `transferRegistry_toAccountCatalogCount_FK` FOREIGN KEY (`toAccountCatalogCountId`) REFERENCES `catalog_count`.`catalog_count` (`id`),
  CONSTRAINT `transferRegistry_fromAccount_FK` FOREIGN KEY (`fromAccountId`) REFERENCES `catalog_count`.`branch` (`id`),
  CONSTRAINT `transferRegistry_toAccount_FK` FOREIGN KEY (`toAccountId`) REFERENCES `catalog_count`.`branch` (`id`),
  CONSTRAINT `transferRegistry_entryPersonId_FK` FOREIGN KEY (`entryPersonId`) REFERENCES `catalog_count`.`persona` (`id`),
  CONSTRAINT `transferRegistry_acceptedPersonId_FK` FOREIGN KEY (`acceptedPersonId`) REFERENCES `catalog_count`.`persona` (`id`)
)
 DEFAULT CHARSET =utf8mb4
 COLLATE =utf8mb4_unicode_ci;
