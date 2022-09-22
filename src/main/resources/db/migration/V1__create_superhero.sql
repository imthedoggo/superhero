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

create table if not exists power
(
    id           varchar(255) primary key
);

create table if not exists superhero_power
(
    superhero_id         bigint,
    power_id            varchar(255),
    primary key (superhero_id, power_id),
    foreign key (superhero_id) references superhero (id),
    foreign key (power_id) references power (id)
);

create table if not exists association
(
    id           varchar(255) primary key
);

create table if not exists superhero_association
(
    superhero_id         bigint,
    association_id            varchar(255),
    primary key (superhero_id, association_id),
    foreign key (superhero_id) references superhero (id),
    foreign key (association_id) references association (id)
);