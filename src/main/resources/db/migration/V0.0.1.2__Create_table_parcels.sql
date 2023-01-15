CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table parcels (
    id uuid DEFAULT uuid_generate_v4() NOT NULL PRIMARY KEY,
    location char(3),
    destination char(3)
);

insert into parcels (id, location, destination)
    VALUES('efbbbf34-6562-6432-6333-392d34366233', 'ITA', 'CZE');