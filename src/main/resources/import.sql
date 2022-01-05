INSERT INTO tb_address(country,city,state,streat,number,complement,cep) VALUES ('Brasil','Brodowski','SP','Antonio Francisco','750','casa','14340000');
INSERT INTO tb_address(country,city,state,streat,number,complement,cep) VALUES ('Brasil','Uberlândia','MG','Avenida Platina','250','apto','38414042');

INSERT INTO tb_provider(name,address_id) VALUES ('Nestle',1);
INSERT INTO tb_provider(name,address_id) VALUES ('Cacau show',2);

INSERT INTO tb_product(name,price,qtd_store,provider_id) VALUES ('Chocolate',7.99,100,2);
INSERT INTO tb_product(name,price,qtd_store,provider_id) VALUES ('Nescal',12.50,50,1);

INSERT INTO tb_employee(name,occupation,username,password,address_id) VALUES ('Carlos Pereira','Caixa','carlos123','carlos123',1);
INSERT INTO tb_employee(name,occupation,username,password,address_id) VALUES ('Sofia Dias','Gerente','sofia123','sofia123',2);

-- TODO falta os cadastros do bonus



INSERT INTO tb_department(name) VALUES ('Gestão');
INSERT INTO tb_department(name) VALUES ('Informática');

INSERT INTO tb_user(department_id, name, email) VALUES (1, 'Maria', 'maria@gmail.com');
INSERT INTO tb_user(department_id, name, email) VALUES (1, 'Bob', 'bob@gmail.com');
INSERT INTO tb_user(department_id, name, email) VALUES (2, 'Alex', 'alex@gmail.com');
INSERT INTO tb_user(department_id, name, email) VALUES (2, 'Ana', 'ana@gmail.com');
