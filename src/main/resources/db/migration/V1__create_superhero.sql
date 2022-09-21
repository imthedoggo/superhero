create sequence superhero_id_seq;

create table if not exists superhero
(
    id           bigint primary key,
    alias        varchar(255) not null,
    name         varchar(255) not null,
    origin       varchar(255) not null
);

create table if not exists weapon
(
    id           varchar(255) primary key
);

create table if not exists superhero_weapon
(
    superhero_id         bigint,
    weapon_id            varchar(255),
    primary key (superhero_id, weapon_id),
    foreign key (superhero_id) references superhero (id),
    foreign key (weapon_id) references weapon (id)
);
