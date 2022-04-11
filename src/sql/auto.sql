create table transmission(
    id serial primary key,
    type varchar(255)
);

create table carcase(
    id serial primary key,
    type varchar(255)
);

create table engine(
    id serial primary key,
    type varchar(255)
);

create table car(
    id serial primary key,
    name varchar(255),
    engine_id int references engine(id),
    carcase_id int references carcase(id),
    transmission_id int references engine(id)
);

insert into transmission(type) values ('automatic'), ('robotic'), ('manual');
insert into carcase(type) values ('sedan'), ('hatchback'), ('universal'), ('liftback');
insert into engine(type) values ('gasoline'), ('diesel'), ('hybrid'), ('electric'), ('hydrogen');

insert into car(name, engine_id, carcase_id, transmission_id) values ('Hyundai_Elantra', 1, 1, 1);
insert into car(name, engine_id, carcase_id, transmission_id) values ('Kia_Ceed_Wagon', 1, 3, 1);
insert into car(name, engine_id, carcase_id, transmission_id) values ('Ferrari_GT_9000', 2, 2, 3);
insert into car(name, engine_id, carcase_id, transmission_id) values ('Honda_Accord_Hybrid', 3, 1, 2);
insert into car(name, engine_id, carcase_id, transmission_id) values ('Mitsubishi_I_MIEV', 4, 2, 3);
insert into car(name, engine_id, carcase_id, transmission_id) values ('Skoda_Rapid', 1, 4, 2);
