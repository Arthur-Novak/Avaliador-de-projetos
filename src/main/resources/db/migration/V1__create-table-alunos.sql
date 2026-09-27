create table alunos(
    id serial not null primary key,
    uuid UUID default gen_random_uuid(),
    nome varchar(50) not null,
    matricula varchar(8) not null unique,
    email varchar(100) not null unique,
    bairro varchar(100)not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null
)