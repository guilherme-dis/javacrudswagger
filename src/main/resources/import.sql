INSERT INTO tb_address(country,city,state,streat,number,complement,cep) VALUES ('Brasil','Brodowski','SP','Antonio Francisco','750','casa','14340000');
INSERT INTO tb_address(country,city,state,streat,number,complement,cep) VALUES ('Brasil','Uberlândia','MG','Avenida Platina','250','apto','38414042');


INSERT INTO tb_provider(name,address_id) VALUES ('Nestle',1);
INSERT INTO tb_provider(name,address_id) VALUES ('Cacau show',2);

INSERT INTO tb_product(name,price,qtd_store,provider_id) VALUES ('Chocolate',7.99,100,2);
INSERT INTO tb_product(name,price,qtd_store,provider_id) VALUES ('Nescal',12.50,50,1);

INSERT INTO tb_employee(name,occupation,username,password,address_id) VALUES ('Carlos Pereira','Caixa','carlos123','carlos123',1);
INSERT INTO tb_employee(name,occupation,username,password,address_id) VALUES ('Sofia Dias','Gerente','sofia123','sofia123',2);

INSERT INTO tb_bonus(cpf,score,cash_back)VALUES('70122924665',50.0,1.0);
INSERT INTO tb_bonus(cpf,score,cash_back)VALUES('12345678910',50.0,1.0);
-- INSERT INTO tb_bonus(cpf,score,cash_back)VALUES('70122924665',50.0,1.0);

-- TODO falta os cadastros do bonus


