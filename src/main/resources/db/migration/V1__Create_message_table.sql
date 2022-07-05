CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table messages (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    text varchar(100) not null
);
