INSERT INTO catalog_count_enum
(
  identifier,
  family,
  name,
  description,
  type,
  isDeleted
)
VALUES
(
  '4.6',
  'general',
  'Ahorro de los niños',
  'Cuenta de Ahorro para los niños',
  TRUE,
  FALSE
);

ALTER TABLE `catalog_count`.`branch`
    MODIFY COLUMN `address` TEXT,
    MODIFY COLUMN `name` VARCHAR(200);

ALTER TABLE `catalog_count`.`persona`
    MODIFY COLUMN `name` VARCHAR(100),
    MODIFY COLUMN `lastname` VARCHAR(100),
    ADD COLUMN `primaryEmail` VARCHAR(150),
    ADD COLUMN `secondaryEmail` VARCHAR(100);
