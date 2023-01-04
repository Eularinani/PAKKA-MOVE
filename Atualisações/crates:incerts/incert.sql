
INSERT into perfil(perfil_nome) values ('Administrador');
INSERT into perfil(perfil_nome) values ('Publico');


--add usuarios
INSERT into usuario (user_nome, user_senha, user_hbd, user_email, user_perfil_id) values ('Troia ','Ecombe',to_date('1995.05.07','YYYY.MM.DD'),'Troia@gmail.com',2);--1
INSERT into usuario (user_nome, user_senha, user_hbd, user_email, user_perfil_id) values ('Creusa ','Ecombe',to_date('2000.05.07','YYYY.MM.DD'),'Cretheu@gmail.com',2);--2
INSERT into usuario (user_nome, user_senha, user_hbd, user_email, user_perfil_id) values ('Decimilde ','Decy800',to_date('1995.10.07','YYYY.MM.DD'),'Decy@gmail.com',2);--3
INSERT into usuario (user_nome, user_senha, user_hbd, user_email, user_perfil_id) values ('Adalgisa clara ','Adalgisa400',to_date('2005.05.07','YYYY.MM.DD'),'Adalgisa@gmail.com',2);--4
INSERT into usuario (user_nome, user_senha, user_hbd, user_email, user_perfil_id) values ('MAria Calunjinji','Mauricio',to_date('1995.05.07','YYYY.MM.DD'),'Maria@gmail.com',2);--5
INSERT into usuario (user_nome, user_senha, user_hbd, user_email, user_perfil_id) values ('Americo Antonio','Antonio200',to_date('1970.12.07','YYYY.MM.DD'),'americo@gmail.com',2);--6
INSERT into usuario (user_nome, user_senha, user_hbd, user_email, user_perfil_id) values ('Eularinani Sidney Ecombe ','Eravez2001',to_date('2001.05.07','YYYY.MM.DD'),'Eularinani@gmail.com',1);--7

--add estado
INSERT into estado(estado_nome) values ('Desligado');--1
INSERT into estado(estado_nome) values ('Ligado,Sem papel');--2
INSERT into estado(estado_nome) values ('Ligado, Sem papel,Sem dinheiro');--3
INSERT into estado(estado_nome) values ('Ligado, Sem Sistema');4
INSERT into estado(estado_nome) values ('Ligado, com papel,Sem dinheiro');--5
INSERT into estado(estado_nome) values ('Ligado, Sem papel,com dinheiro');--7
INSERT into estado(estado_nome) values ('Em Manutenção');--8

--add Serviçõs
INSERT into servicos(serv_tipo, serv_espc) values ('Deposito,Pagamentos e levantamentos ','Deposito especificamente para o banco que a mesma representa'); --1
INSERT into servicos(serv_tipo, serv_espc) values ('Pagamentos e levantamentos ','Levantamentos'); --2
INSERT into servicos(serv_tipo, serv_espc) values ('Deposito e levantamentos ','Para um banco especifico'); --3
INSERT into servicos(serv_tipo, serv_espc) values ('Levantamentos ','funcionalidade Principa'); --4


--add Tipo de maquina
INSERT into tipo_mac(tipo_mac_Compania, tipo_mac_Nome, tipo_mac_direcion) values ('SIBS','ATM','Sem Companinha'); --1
INSERT into tipo_mac(tipo_mac_Compania, tipo_mac_Nome, tipo_mac_direcion) values ('SIBS','Multbanco','Santader'); --2
INSERT into tipo_mac(tipo_mac_Compania, tipo_mac_Nome, tipo_mac_direcion) values ('SIBS','ATM','Sem Companinha'); --3
INSERT into tipo_mac(tipo_mac_Compania, tipo_mac_Nome, tipo_mac_direcion) values ('SIBS','ATM EXPRESS','Sem Companinha'); --4
INSERT into tipo_mac(tipo_mac_Compania, tipo_mac_Nome, tipo_mac_direcion) values ('SIBS','MULTIBANCO','CAIXA GERAL DE DEPOSITO'); --5
INSERT into tipo_mac(tipo_mac_Compania, tipo_mac_Nome, tipo_mac_direcion) values ('SIBS','ATM EXPRESS','Sem Companinha'); --6
INSERT into tipo_mac(tipo_mac_Compania, tipo_mac_Nome, tipo_mac_direcion) values ('SIBS','MULTBANCO','MONTEPIO'); --7
INSERT into tipo_mac(tipo_mac_Compania, tipo_mac_Nome, tipo_mac_direcion) values ('Euronet Worldwide.','ATM','Euronet'); --8
INSERT into tipo_mac(tipo_mac_Compania, tipo_mac_Nome, tipo_mac_direcion) values ('Euronet Worldwide.','ATM','Euronet'); --9


--add LOCALIZAÇÃO
INSERT into local_mac(local_endereco, local_cp, local_latitude,local_longitude) values ('Avenida D. Carlos I 49','1200-646','38°42´27" N','9°9´9" W'); --1
INSERT into local_mac(local_endereco, local_cp, local_latitude,local_longitude) values ('Avenida D. Carlos I 49','1200-646','38°42´27" N','9°9´9" W'); --2
INSERT into local_mac(local_endereco, local_cp, local_latitude,local_longitude) values ('Largo Vitoriano Damásio ','1200-646','3842´29" N','9°9´10" W'); --3
INSERT into local_mac(local_endereco, local_cp, local_latitude,local_longitude) values ('Avenida D. Carlos I 60 A','1200-649','38°42´29" N','9°9´11" W'); --4
INSERT into local_mac(local_endereco, local_cp, local_latitude,local_longitude) values ('Avenida D. Carlos I 60 A','1200-649 ','38°42´29" N','9°9´11" W'); --5
INSERT into local_mac(local_endereco, local_cp, local_latitude,local_longitude) values ('Avenida D. Carlos I 72 D','1200-649','38°42´30" N','9°9´10" W'); --6
INSERT into local_mac(local_endereco, local_cp, local_latitude,local_longitude) values ('Avenida D. Carlos I 72 D','1200-649','38°42´30" N','9°9´10" W'); --7
INSERT into local_mac(local_endereco, local_cp, local_latitude,local_longitude) values ('Calçada do MARQUÊS De Abraantes 36','1200-719','38°42´30" N','9•9´10" W'); --8
INSERT into local_mac(local_endereco, local_cp, local_latitude,local_longitude) values ('Calçada do MARQUÊS De Abraantes 36','1200-719','38°42´30" N','9•9´10" W'); --9



--add MAQUINA
INSERT into maquina(mac_local_id, mac_tipo_mac_id) values ('1','1'); --1
INSERT into maquina(mac_local_id, mac_tipo_mac_id) values ('2','2');
INSERT into maquina(mac_local_id, mac_tipo_mac_id) values ('3','3');
INSERT into maquina(mac_local_id, mac_tipo_mac_id) values ('4','4');
INSERT into maquina(mac_local_id, mac_tipo_mac_id) values ('5','5');
INSERT into maquina(mac_local_id, mac_tipo_mac_id) values ('6','6');
INSERT into maquina(mac_local_id, mac_tipo_mac_id) values ('7','7');
INSERT into maquina(mac_local_id, mac_tipo_mac_id) values ('8','8');
INSERT into maquina(mac_local_id, mac_tipo_mac_id) values ('9','9');


--add ms
INSERT into ms(ms_mac_id, ms_serv_id) values ('1','2'); --1
INSERT into ms(ms_mac_id, ms_serv_id) values ('2','1'); --2
INSERT into ms(ms_mac_id, ms_serv_id) values ('3','2'); --3
INSERT into ms(ms_mac_id, ms_serv_id) values ('4','4'); --4
INSERT into ms(ms_mac_id, ms_serv_id) values ('5','1'); --5
INSERT into ms(ms_mac_id, ms_serv_id) values ('6','4'); --6
INSERT into ms(ms_mac_id, ms_serv_id) values ('7','1'); --7
INSERT into ms(ms_mac_id, ms_serv_id) values ('8','4'); --8
INSERT into ms(ms_mac_id, ms_serv_id) values ('9','4'); --9


--add ums--add ums
INSERT into usm(usm_user_id,usm_estado_id,usm_mac_id,usm_momento) values (2,4,5,now()) --1
INSERT into usm(usm_user_id,usm_estado_id,usm_mac_id,usm_momento) values (7,4,6,now()) --1
INSERT into usm(usm_user_id,usm_estado_id,usm_mac_id,usm_momento) values (4,4,1,now()) --1
INSERT into usm(usm_user_id,usm_estado_id,usm_mac_id,usm_momento) values (5,4,9,now()) --1
INSERT into usm(usm_user_id,usm_estado_id,usm_mac_id,usm_momento) values (3,4,2,now()) --1
INSERT into usm(usm_user_id,usm_estado_id,usm_mac_id,usm_momento) values (6,4,4,now()) --1
INSERT into usm(usm_user_id,usm_estado_id,usm_mac_id,usm_momento) values (7,4,8,now()) --1
INSERT into usm(usm_user_id,usm_estado_id,usm_mac_id,usm_momento) values (2,4,7,now()) --1
INSERT into usm(usm_user_id,usm_estado_id,usm_mac_id,usm_momento) values (1,2,3,now()) --1


	 /*atualizando  infomções no local*/ 
	
	UPDATE local_mac 
 SET local_latitude = '38.707572',
 	local_longitude = '-9.152853'
 WHERE local_mac.local_id = 1; 
 	
	UPDATE local_mac 
 SET local_latitude = '38.707573',
 	local_longitude = '-9.152853'
 WHERE local_mac.local_id = 2; 
 
 	UPDATE local_mac 
 SET local_latitude = '38.7082116',
 	local_longitude = '-9.152853'
 WHERE local_mac.local_id = 3; 
 
 	UPDATE local_mac 
 SET local_latitude = '38.7082116',
 	local_longitude = '-9.152711'
 WHERE local_mac.local_id = 4; 
 
 	UPDATE local_mac 
 SET local_latitude = '38.7084643', 
 	local_longitude = '-9.1527901'
 WHERE local_mac.local_id = 5; 
 
 	UPDATE local_mac 
SET local_latitude = '38.7084643', 
 	local_longitude = '-9.15279081'
 WHERE local_mac.local_id = 6; 
 
 	UPDATE local_mac 
 SET local_latitude = '38.7084643', 
 	local_longitude = '-9.1527901'
 WHERE local_mac.local_id = 7; 
 
 	UPDATE local_mac 
 SET local_latitude = '38.4231',
 	local_longitude = '-9.91000'
 WHERE local_mac.local_id = 8;
 
 	UPDATE local_mac 
 SET local_latitude = '38.708449',
 	local_longitude = '-9.910'
 WHERE local_mac.local_id = 9; 