create table video
(
    id        bigint not null auto_increment,
    descricao varchar(255),
    titulo    varchar(255),
    url       varchar(255),
    primary key (id)
) engine = InnoDB