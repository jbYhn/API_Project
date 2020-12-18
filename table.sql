create database

create table if not EXISTS utilisateur (
    id int not null  AUTO_INCREMENT,
    name varchar(255) not null,
    pasword varchar(255) not null,
    email varchar(255) not null,
    token varchar (255) not null,
    PRIMARY KEY (id)

);


create table if not exists sondage (
	id int not null AUTO_INCREMENT,
	user_id int not null,
	description text not null,
	lieu text not null,
	primary key(id),
	foreign key (user_id) references utilisateur(id)
);


create table if not exists reponse (
	id int not null AUTO_INCREMENT,
	sond_id int not null,
	reponse longtext not null,
	nb_vote int not null,
	primary key (id),
	foreign key (sond_id) references sondage(id)
);

create table if not exists vote (
	id int not null AUTO_INCREMENT,
	user_id int not null,
	foreign key (id) references reponse(id),
	foreign key (user_id) references utilisateur(id)
);
