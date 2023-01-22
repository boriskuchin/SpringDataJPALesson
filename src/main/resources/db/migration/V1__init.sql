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



create table users (
                       id         bigserial primary key,
                       username   varchar(36) not null,
                       password   varchar(80) not null,
                       email      varchar(50) unique,
                       created_at timestamp default current_timestamp,
                       updated_at timestamp default current_timestamp
);

create table roles (
                       id         bigserial primary key,
                       name       varchar(50) not null,
                       created_at timestamp default current_timestamp,
                       updated_at timestamp default current_timestamp
);

CREATE TABLE users_roles (
                             user_id bigint not null references users (id),
                             role_id bigint not null references roles (id),
                             primary key (user_id, role_id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password, email)
values ('user', '100', 'user@gmail.com'),
       ('admin', '100', 'admin@gmail.com');

-- values ('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com'),
--        ('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'admin@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);

