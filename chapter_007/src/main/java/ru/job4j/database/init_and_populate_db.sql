drop table if exists cars;

create table cars(
    id serial primary key,
    model varchar(255),
    number text UNIQUE ,
    date timestamp
);

insert into cars(model, number, date) VALUES ('KIA RIO', 'X521AC116RUS', '01/01/2020'),
                                             ('KIA RIO2', 'X777AC116RUS', '01/01/2020');

update cars set model = 'Mercedes', date = '02/02/2020' where model = 'KIA RIO2';

delete from cars where number = 'X521AC116RUS';


