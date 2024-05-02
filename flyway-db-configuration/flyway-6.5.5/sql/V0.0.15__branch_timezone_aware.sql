ALTER TABLE `catalog_count`.`branch`
    ADD COLUMN `timezoneId` INT UNSIGNED,
ADD CONSTRAINT `fk_timezonetype_branch`
FOREIGN KEY (`timezoneId`)
REFERENCES `timezone_type` (`id`);