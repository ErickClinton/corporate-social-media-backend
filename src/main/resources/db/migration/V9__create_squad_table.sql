CREATE TABLE squads (
    id UUID PRIMARY KEY,
    value TEXT NOT NULL,
    id_office UUID NOT NULL,
    id_manager UUID NOT NULL
);