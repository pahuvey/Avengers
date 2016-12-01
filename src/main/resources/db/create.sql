drop table  if exists avenger; 
drop table  if exists agent; 


create table avenger (id serial primary key, last_name varchar(255) not null, 
						first_name varchar(255) not null,alias varchar(255) not null, 
						photo bytea, power int not null, id_agent int not null);
						
create table agent (id serial primary key, last_name varchar(255) not null, 
						first_name varchar(255) not null, 
						photo bytea);
						
						
						
alter table avenger add constraint FK_AGENT foreign key(agent_id) references agent(id);
						
insert into agent values(10,"FURY", "NICK", null);						
						