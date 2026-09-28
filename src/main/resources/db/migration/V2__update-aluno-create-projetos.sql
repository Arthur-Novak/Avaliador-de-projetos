CREATE TABL projetos(
    id serial not null primary key,
    nome varchar(100) not null,
    descricao text not null,
    ano numeric(4,0) not null,
    semestre numeric(1,0) not null
);

ALTER TABLE alunos ADD COLUMN idprojeto integer;
ALTER TABLE alunos ADD CONSTRAINT aluno_projeto_fkey
    FOREIGN KEY (idprojeto) REFERENCES projetos(id);