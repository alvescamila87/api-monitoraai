select * from usuario;

INSERT INTO colaborador (nome, email, cargo, data_nascimento) VALUES
('Ana Paula Silva', 'ana.silva@empresa.com', 'Técnico de Segurança', '1985-03-12'),
('Bruno Oliveira', 'bruno.oliveira@empresa.com', 'Supervisor de Produção', '1980-11-25'),
('Carlos Eduardo Santos', 'carlos.santos@empresa.com', 'Operador de Máquinas', '1990-06-18'),
('Daniela Rocha', 'daniela.rocha@empresa.com', 'Engenheira de Segurança', '1987-09-03'),
('Eduardo Lima', 'eduardo.lima@empresa.com', 'Auxiliar de Manutenção', '1995-01-07'),
('Fernanda Costa', 'fernanda.costa@empresa.com', 'Técnica de Enfermagem', '1989-08-22'),
('Gabriel Martins', 'gabriel.martins@empresa.com', 'Almoxarife', '1992-05-15'),
('Helena Souza', 'helena.souza@empresa.com', 'Coordenadora de Logística', '1984-12-10'),
('Igor Fernandes', 'igor.fernandes@empresa.com', 'Inspetor de Qualidade', '1991-02-27'),
('Juliana Mendes', 'juliana.mendes@empresa.com', 'Analista de Segurança do Trabalho', '1986-07-30');


INSERT INTO equipamento (descricao, tipo) VALUES
('Capacete de Segurança com Jugular', 'Proteção para cabeça'),
('Óculos de Proteção Incolor', 'Proteção para os olhos'),
('Luva de Raspa Térmica', 'Proteção para mãos'),
('Protetor Auricular tipo Plug', 'Proteção auditiva'),
('Botina de Segurança com Biqueira de Aço', 'Calçado de segurança'),
('Máscara PFF2 com Válvula', 'Proteção respiratória'),
('Cinto de Segurança tipo Paraquedista', 'Proteção contra quedas'),
('Avental de Raspa para Solda', 'Proteção para o corpo'),
('Mangote de Vaqueta', 'Proteção para braços'),
('Máscara de Solda Autoescurecimento', 'Proteção para olhos/face');


INSERT INTO emprestimo (id, colaborador_id, data_emprestimo, data_devolucao_prevista) VALUES
(1, 1, '2025-05-30', '2025-06-05'),
(2, 2, '2025-05-29', '2025-06-03');
