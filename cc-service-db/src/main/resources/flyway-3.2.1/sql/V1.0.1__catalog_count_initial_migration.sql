
CREATE TABLE `catalog_count_enum` (
  `id`                  BIGINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `identifier`          VARCHAR(64)        NOT NULL,
  `name`                VARCHAR(64)        NOT NULL,
  `description`         VARCHAR(64),
  `type`                BOOLEAN DEFAULT FALSE,
  `isDeleted`           BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;



CREATE TABLE `catalog_count` (
  `id`                  BIGINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `registrationDate`    DATE               NOT NULL,
  `durationInDays`      INT(4)             NOT NULL,
  `expirationDate`      DATE               NOT NULL,
  `catalogCountEnumId`  BIGINT(8) UNSIGNED NOT NULL,
  `amount`              DOUBLE             NOT NULL,
  `details`             VARCHAR(64)        NOT NULL,
  `isDeleted`           BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (`id`),
  CONSTRAINT `catalogCountEnumId_FK` FOREIGN KEY (`catalogCountEnumId`) REFERENCES `catalog_count_enum` (`id`)
)
  DEFAULT CHARSET =utf8
  COLLATE =utf8_unicode_ci;