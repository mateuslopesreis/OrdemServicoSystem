INSERT INTO TB_CLIENTE (nome, email, rua, bairro, numero, login, senha) VALUES ('Maria Aparecida', 'maria@gmail.com', 'Av. Dourados', 'Centro, Naviraí-MS', '123', 'luffy', 'onepiece');
INSERT INTO TB_FUNCIONARIO (nome, email, telefone, perfil, login, senha) VALUES ('Sakuragi Hanamich', 'sakuragi@gmail.com', '(67) 99874-1236', 2 , 'basquetero', 'genio');


INSERT INTO TB_ORDEM_SERVICO(titulo, tipo_Servico, prioridade, status, cliente_id) VALUES ('Verificar internet', 3, 0, 1,1);
INSERT INTO TB_ORDEM_SERVICO(titulo, tipo_Servico, prioridade, status, cliente_id) VALUES ('Instalar Modem', 3, 0, 2,1);