create table classes(

    id bigint not null auto_increment,
    title varchar(100) not null,
    descrition varchar(100) not null,
    expectedClassDate varchar(10) not null,

primary key(id)

);