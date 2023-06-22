create table teacher(

    id bigint not null auto_increment,
    name varchar(100) not null,
    login varchar(100) not null,
    password varchar(30) not null,
    status varchar(30) not null,

primary key(id)

);