CREATE TABLE IF NOT EXISTS `catalog_count_registry` (
  `catalogCountRegistryId`      binary(16) NOT NULL,
  `registryType`                ENUM('NEW','UPDATE','DELETE') NOT NULL, -- NEW, UPDATE, DELETE
  `entryPersonId`               INT UNSIGNED NOT NULL,
  `entryDate`                   DATETIME NOT NULL DEFAULT (UTC_TIMESTAMP()),
  `acceptedPersonId`            INT UNSIGNED NULL,
  `acceptedDate`                DATETIME NULL,
  `inactiveDate`                DATETIME NULL,
  `details`                     TEXT NOT NULL,
  `branchId`                    INT UNSIGNED NOT NULL,
  `catalogCountId`              INT UNSIGNED NULL,
  PRIMARY KEY (`catalogCountRegistryId`),
  CONSTRAINT `catalogCountRegistry_entryPersonId_FK` FOREIGN KEY (`entryPersonId`) REFERENCES `catalog_count`.`persona` (`id`),
  CONSTRAINT `catalogCountRegistry_acceptedPersonId_FK` FOREIGN KEY (`acceptedPersonId`) REFERENCES `catalog_count`.`persona` (`id`),
  CONSTRAINT `catalogCountRegistry_branchId_FK` FOREIGN KEY (`branchId`) REFERENCES `catalog_count`.`branch` (`id`),
  CONSTRAINT `catalogCountRegistry_catalogCountId_FK` FOREIGN KEY (`catalogCountId`) REFERENCES `catalog_count`.`catalog_count` (`id`)
)
 DEFAULT CHARSET =utf8mb4
 COLLATE =utf8mb4_unicode_ci;

 CREATE INDEX idx_catalogCountRegistry_branchId ON catalog_count_registry (branchId);
 CREATE INDEX idx_catalogCountRegistry_branchId_active ON catalog_count_registry (branchId, inactiveDate);
 CREATE INDEX idx_catalogCountRegistry_catalogCountId_active ON catalog_count_registry (catalogCountId, inactiveDate);
 CREATE INDEX idx_catalogCountRegistry_entryPersonId ON catalog_count_registry (entryPersonId);
 CREATE INDEX idx_catalogCountRegistry_acceptedPersonId ON catalog_count_registry (acceptedPersonId);
 CREATE INDEX idx_catalogCountRegistry_registryType ON catalog_count_registry (registryType);
