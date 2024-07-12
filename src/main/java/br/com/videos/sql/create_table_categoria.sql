create table categoria
(
    id     bigint not null auto_increment,
    cor    varchar(255),
    titulo varchar(255),
    primary key (id)
) engine = InnoDB