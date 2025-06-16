drop database apimonitoraai;

create database apimonitoraai;

select * from usuario;
select * from equipamento;
select * from colaborador;
select * from emprestimo;

create table usuario (
	id bigint primary key auto_increment,
	nome varchar(255) not null,
	email varchar(255) not null,
	senha varchar(255) not null
);


create table colaborador (
	id bigint primary key auto_increment,
	nome varchar(255) not null,
	email varchar(255) not null,
	cargo varchar(255) not null,
    data_nascimento date not null
);


create table equipamento (
	id bigint primary key auto_increment,
	tipo varchar(255) not null,
	descricao varchar(255) not null
);


create table emprestimo (
	id bigint primary key auto_increment,
    colaborador_id bigint not null,
    equipamento_id bigint not null,
	data_emprestimo date not null,
	data_devolucao date,
	observacao varchar(255),
    devolvido boolean not null default false,

    constraint fk_colaborador foreign key (colaborador_id) references colaborador(id),
    constraint fk_equipamento foreign key (equipamento_id) references equipamento(id)
);


INSERT INTO usuario (nome, email, senha) VALUES
('Camila', 'camila@gmail.com', '12345'),
('João', 'joao@gmail.com', '12345');


INSERT INTO colaborador (id, nome, email, cargo, data_nascimento) VALUES
(1, 'Moisés', 'moises@obra.com', 'Pedreiro', '1980-03-15'),
(2, 'Ester', 'ester@obra.com', 'Técnica de Segurança', '1992-07-21'),
(3, 'Josué', 'josue@obra.com', 'Servente', '1988-11-10'),
(4, 'Débora', 'debora@obra.com', 'Engenheira Civil', '1990-04-03'),
(5, 'Daniel', 'daniel@obra.com', 'Eletricista', '1985-01-27'),
(6, 'Maria', 'maria@obra.com', 'Mestre de Obras', '1979-06-12'),
(7, 'José', 'jose@obra.com', 'Operador de Betoneira', '1987-09-30'),
(8, 'Raquel', 'raquel@obra.com', 'Auxiliar de Almoxarifado', '1995-02-14'),
(9, 'Noé', 'noe@obra.com', 'Encanador', '1975-12-01'),
(10, 'Rute', 'rute@obra.com', 'Topógrafa', '1993-08-25');


INSERT INTO equipamento (id, tipo, descricao) VALUES
(1, 'Capacete', 'Capacete de segurança amarelo com jugular'),
(2, 'Luvas', 'Luvas de proteção contra abrasão e corte'),
(3, 'Óculos', 'Óculos de proteção com lentes antiembaçantes'),
(4, 'Botina', 'Botina de segurança com biqueira de aço'),
(5, 'Protetor Auricular', 'Protetor auricular tipo plug'),
(6, 'Máscara', 'Máscara PFF2 contra poeira e partículas'),
(7, 'Colete', 'Colete refletivo de alta visibilidade'),
(8, 'Cinto de Segurança', 'Cinto tipo paraquedista com talabarte'),
(9, 'Perneira', 'Perneira de proteção em couro'),
(10, 'Avental', 'Avental de raspa para solda e calor');



INSERT INTO emprestimo (id, colaborador_id, equipamento_id, data_emprestimo, devolvido) VALUES
(1, 1, 1, '2025-05-01', false),
(2, 2, 2, '2025-05-02', false),
(3, 3, 3, '2025-05-03', false),
(4, 4, 4, '2025-05-04', false),
(5, 5, 5, '2025-05-05', false),
(6, 6, 6, '2025-05-06', false),
(7, 7, 7, '2025-05-07', false),
(8, 8, 8, '2025-05-08', false),
(9, 9, 9, '2025-05-09', false),
(10, 10, 10, '2025-05-10', false);

