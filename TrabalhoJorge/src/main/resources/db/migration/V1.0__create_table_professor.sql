create table professor(
    id serial,
    nome_completo varchar(50) not null,
    email varchar(50) not null,
    idade integer not null,
    salario float not null,
    constraint pk_professor primary key(id)
);