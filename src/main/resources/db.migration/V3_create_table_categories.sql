CREATE TABLE if not exists categories
(
    id
    BIGINT
    PRIMARY
    KEY
    GENERATED
    ALWAYS AS
    IDENTITY,
    name
    TEXT
);
