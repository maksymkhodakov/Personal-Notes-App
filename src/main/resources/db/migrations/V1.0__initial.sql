CREATE TABLE IF NOT EXISTS persons
(
    id          BIGSERIAL PRIMARY KEY,
    first_name  TEXT NOT NULL,
    last_name   TEXT NOT NULL
)