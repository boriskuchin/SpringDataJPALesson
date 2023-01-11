create table if not exists products
(
    id          bigserial primary key,
    name        varchar(255),
    cost        double,
--     quantity    int,
    secret_data varchar(255)
);

insert into products (name, cost, secret_data)
values ('Хлеб', 10.5, 'Secret Data'),
       ('Соль', 12,  'Secret Data'),
       ('Сахар', 15.3,  'Secret Data'),
       ('Мука', 11,  'Secret Data'),
       ('Курица', 20,  'Secret Data'),
       ('Говядина', 30.3,  'Secret Data'),
       ('Рыба', 35.2,  'Secret Data'),
       ('Краб', 50.1,  'Secret Data'),
       ('Икра', 80.6,  'Secret Data'),
       ('Макароны', 16,  'Secret Data'),
       ('Картошка', 9,  'Secret Data'),
       ('Нут', 13,  'Secret Data'),
       ('Спаржа', 15,  'Secret Data'),
       ('Капуста', 6,  'Secret Data'),
       ('Брокколи', 17.95,  'Secret Data'),
       ('Сыр', 17.65,  'Secret Data'),
       ('Колбаса', 22.99,  'Secret Data'),
       ('Кетчуп', 12.76,  'Secret Data'),
       ('Свинина', 22.2,  'Secret Data'),
       ('Молоко', 10,  'Secret Data');