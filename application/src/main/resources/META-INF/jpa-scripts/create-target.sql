create table Agregador (id char(16) for bit data not null, version timestamp not null, primary key (id));
create table Agregador_objetos (Agregador_id char(16) for bit data not null, dado varchar(255) not null, primary key (Agregador_id, dado));
create table Entidade (id char(16) for bit data not null, dado varchar(255) not null, version timestamp not null, agregador_id char(16) for bit data not null, primary key (agregador_id, id));
alter table Agregador_objetos add constraint FKik0rppyotjwkq3y9o5ssg5i9s foreign key (Agregador_id) references Agregador;
alter table Entidade add constraint FKl9unos3uf5415te1vfewd8s99 foreign key (agregador_id) references Agregador;
