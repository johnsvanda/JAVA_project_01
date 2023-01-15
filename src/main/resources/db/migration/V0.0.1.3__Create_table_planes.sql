CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table planes (
    code char(10) NOT NULL PRIMARY KEY,
    carryingCapacity integer,
    flyDistance integer
);
