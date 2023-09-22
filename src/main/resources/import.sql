INSERT INTO TB_CLIENTE (nome, email, rua, bairro, numero) VALUES ('Maria Aparecida', 'maria@gmail.com', 'Av. Dourados', 'Centro, Naviraí-MS', '123');
INSERT INTO TB_CLIENTE (nome, email, rua, bairro, numero) VALUES ('Monkey D. Luffy', 'luffy@gmail.com', 'Grande Line', 'Oeste Blue', '165');
INSERT INTO TB_CLIENTE (nome, email, rua, bairro, numero) VALUES ('Roronoa Zoro', 'zoro@gmail.com', 'Grande Line', 'Norte Blue', '736');


INSERT INTO TB_FUNCIONARIO (nome, email, telefone, perfil, login, senha) VALUES ('Sakuragi Hanamich', 'sakuragi@gmail.com', '(67) 99874-1236', 2 , 'basquetero', 'genio');


INSERT INTO TB_ORDEM_SERVICO(titulo, tipo_Servico, prioridade, status, cliente_id) VALUES ('Verificar internet', 3, 0, 1,1);
INSERT INTO TB_ORDEM_SERVICO(titulo, tipo_Servico, prioridade, status, cliente_id) VALUES ('Verificar Roteador', 3, 1, 1,1);
INSERT INTO TB_ORDEM_SERVICO(titulo, tipo_Servico, prioridade, status, cliente_id) VALUES ('Verificar cabo de rede', 3, 2, 1,1);


INSERT INTO TB_ORDEM_SERVICO(titulo, tipo_Servico, prioridade, status, cliente_id) VALUES ('Instalar Modem', 3, 0, 2,1);
INSERT INTO TB_ORDEM_SERVICO(titulo, tipo_Servico, prioridade, status, cliente_id) VALUES ('Instalar Switch', 2, 1, 2,1);


INSERT INTO TB_ATENDIMENTO(relato_Tecnico, id_funcionario_fk, id_os_fk) VALUES ('Serviço feito', 1, 1);
INSERT INTO TB_ATENDIMENTO(relato_Tecnico, id_funcionario_fk, id_os_fk) VALUES ('Serviço feito', 1, 2);
INSERT INTO TB_ATENDIMENTO(relato_Tecnico, id_funcionario_fk, id_os_fk) VALUES ('Serviço feito', 1, 3);