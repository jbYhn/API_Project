create table if not EXISTS utilisateur (
    id int not null,
    name varchar(255) not null,
    pasword varchar(255) not null,
    email varchar(255) not null,
    token varchar (255) not null,
    PRIMARY KEY (id)

)