alter table professor add column disciplina_id int not null;
alter table professor
    add constraint fk_professor_disciplina
    foreign key (disciplina_id) references disciplina (id);