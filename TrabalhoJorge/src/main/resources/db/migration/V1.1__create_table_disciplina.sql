create table disciplina(
    id serial,
    nome_disciplina varchar(50) not null,
    aulas_disciplina varchar(50) not null,
    constraint pk_disciplina primary key(id)
);