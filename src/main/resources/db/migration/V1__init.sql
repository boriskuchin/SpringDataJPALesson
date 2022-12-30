create table if not exists products
(
    id          bigserial primary key,
    name        varchar(255),
    cost        double,
    quantity    int,
    secret_data varchar(255)
);

insert into products (name, cost, quantity, secret_data)
values ('Хлеб', 10.5, 1, 'Secret Data'),
       ('Соль', 12, 1, 'Secret Data'),
       ('Сахар', 15.3, 1, 'Secret Data'),
       ('Мука', 11, 1, 'Secret Data'),
       ('Курица', 20, 1, 'Secret Data'),
       ('Говядина', 30.3, 1, 'Secret Data'),
       ('Рыба', 35.2, 1, 'Secret Data'),
       ('Краб', 50.1, 1, 'Secret Data'),
       ('Икра', 80.6, 1, 'Secret Data'),
       ('Макароны', 16, 1, 'Secret Data'),
       ('Картошка', 9, 1, 'Secret Data'),
       ('Нут', 13, 1, 'Secret Data'),
       ('Спаржа', 15, 1, 'Secret Data'),
       ('Капуста', 6, 1, 'Secret Data'),
       ('Брокколи', 17.95, 1, 'Secret Data'),
       ('Сыр', 17.65, 1, 'Secret Data'),
       ('Колбаса', 22.99, 1, 'Secret Data'),
       ('Кетчуп', 12.76, 1, 'Secret Data'),
       ('Свинина', 22.2, 1, 'Secret Data'),
       ('Молоко', 10, 10, 'Secret Data');