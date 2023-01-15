create table countries (
    cca3 char(3) unique not null primary key,
    capital varchar,
    capital_lat float,
    capital_lng float
)