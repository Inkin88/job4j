DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS type;


create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
    type_id int references type(id) ON DELETE CASCADE,
    expired_date timestamp,
    price INTEGER
);

insert into type(name) values ('мороженое'),
                              ('сыр'),
                              ('молоко'),
                              ('мясо');
insert into product(name, type_id, expired_date, price) values ('Коровка', 1, '22/11/2020', 100),
                                                               ('Мороженое Магнат', 1, '22/11/2020', 200),
                                                               ('Голландский', 2, '28/10/2020', 68),
                                                               ('Российский', 2, '25/10/2020', 55),
                                                               ('Простоквашино', 3, '25/10/2020', 33),
                                                               ('Челны', 3, '26/10/2020', 50),
                                                               ('Говядина', 4, '26/10/2020', 350),
                                                               ('Свинина', 4, '26/10/2020', 250);
