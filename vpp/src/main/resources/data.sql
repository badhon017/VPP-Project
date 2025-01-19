
create table if not exists users(
    username varchar2(255),
    password varchar2(255),
    enabled boolean);

create table if not exists authorities (
    username varchar2(255),
    authority varchar2(100));


create table if not exists battery (
    id long,
    name varchar2(255),
    post_code int,
    watt_capacity int );