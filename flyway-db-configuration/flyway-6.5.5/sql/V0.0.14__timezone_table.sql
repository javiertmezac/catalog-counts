CREATE TABLE IF NOT EXISTS `timezone_type` (
    `id`              INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name`            VARCHAR(100) NOT NULL,
    `status`          BOOLEAN NOT NULL,
    PRIMARY KEY (`id`)
    )
    DEFAULT CHARSET =utf8mb4
    COLLATE =utf8mb4_unicode_ci;


-- insert default values
INSERT INTO timezone_type
(
    name,
    status
) VALUES
    (
        'UTC',
        1
    );

INSERT INTO timezone_type
(
    name,
    status
) VALUES
    (
        'America/Tijuana',
        1
    );

INSERT INTO timezone_type
(
    name,
    status
) VALUES
    (
        'America/Mexico_City',
        1
    );
INSERT INTO timezone_type
(
    name,
    status
) VALUES
    (
        'America/Hermosillo',
        1
    );

INSERT INTO timezone_type
(
    name,
    status
) VALUES
    (
        'America/Chihuahua',
        1
    );
INSERT INTO timezone_type
(
    name,
    status
) VALUES
    (
        'America/Ojinaga',
        1
    );

INSERT INTO timezone_type
(
    name,
    status
) VALUES
    (
        'America/Mazatlan',
        1
    );


INSERT INTO timezone_type
(
    name,
    status
) VALUES
    (
        'America/Monterrey',
        1
    );