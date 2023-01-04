create table perfil (
					perfil_id SERIAL not null,
					perfil_nome VARCHAR(20) not null,							--4 algarismos, com 2 casas decimais
					primary key (perfil_id)
);
create table usuario (
					user_id_ SERIAL not null,
					user_nome VARCHAR not null,
					user_senha varchar not null,
					user_hbd date, 								
					user_email varchar NOT null UNIQUE,
					user_perfil_id int not null,							
					primary key (user_id_)
);
create table estado (
					estado_id SERIAL not null,
					estado_nome VARCHAR(60) not null, 
					primary key (estado_id)	
);
		     		     
create table maquina (
					mac_id SERIAL not null,
					mac_local_id int not null,
		     		mac_tipo_mac_id int not null,
					primary key (mac_id)
);
		           
create table local_mac (
					local_id SERIAL not null,
					
					 varchar(60) not null, 			--endereço
					local_cp varchar(40)  not null, 						--Codigo postal
	                local_latitude varchar (100) not null,
					local_longitude varchar (100) not null,
					primary key (local_id)
);	     
		           
create table servicos (
					serv_id SERIAL not null,
					serv_tipo varchar(40) not null, 		--class name
					serv_espc VARCHAR(100) not null, 					--Especificação
					primary key (serv_id)
);
		    
create table tipo_mac (
					tipo_mac_id SERIAL not null,
					tipo_mac_Compania VARCHAR not null,
          		    tipo_mac_Nome VARCHAR  not null,
					tipo_mac_direcion VARCHAR  not null,
					primary key (tipo_mac_id)
);		
		            
create table usm (
					usm_id SERIAL not null,
					usm_user_id int not null,
					usm_estado_id int not null,
					usm_mac_id int not null,
					usm_momento TIMESTAMP not null,
	
					primary key (usm_id)
);

create table ms (
					ms_id SERIAL not null,
					ms_mac_id int not null,
					ms_serv_id int not null,
					primary key (ms_id)
);





alter table usuario
add constraint usuario_fk_perfil
foreign key (user_perfil_id) references perfil(perfil_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table usm 
add constraint usm_fk_estado
foreign key (usm_estado_id) references estado(estado_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table usm 
add constraint usm_fk_usuario
foreign key (usm_user_id) references usuario(user_id_) 
ON DELETE NO ACTION ON UPDATE NO ACTION;
            
alter table usm 
add constraint usm_fk_maquina
foreign key (usm_mac_id) references maquina(mac_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;



alter table maquina 
add constraint maquina_fk_local_mac
foreign key (mac_local_id) references local_mac(local_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table maquina 
add constraint maquina_fk_tipo_mac
foreign key (mac_tipo_mac_id) references tipo_mac(tipo_mac_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;


alter table ms 
add constraint ms_fk_servicos
foreign key (ms_serv_id) references servicos(serv_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table ms 
add constraint ms_fk_maquina
foreign key (ms_mac_id) references maquina(mac_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;



