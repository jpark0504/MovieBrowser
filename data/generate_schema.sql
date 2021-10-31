create table actor (
	id serial primary key,
	firstname varchar(50) not null,
	lastname varchar(50) not null,
	birth_date date,
	gender char(1)
);

create table director (
	id serial primary key,
	firstname varchar(50) not null,
	lastname varchar(50) not null,
	birth_date date
);

create table filmmaker (
	id serial primary key,
	name varchar(50) not null
);

create table movie (
	id serial primary key,
	title varchar(100) not null,
	releasedate date not null,
	boxoffice numeric(12,0),
	award boolean,
	director_id integer,
	filmmaker_id integer,
	poster bytea,
	CONSTRAINT director_fk FOREIGN KEY (director_id) references director (id),
	CONSTRAINT filmmaker_fk FOREIGN KEY (filmmaker_id) references filmmaker (id)
);

create table starring (
	id serial primary key,
	actor_id integer not null,
	movie_id integer not null,
	constraint actor_fk foreign key (actor_id) references actor (id),
	constraint movie_fk foreign key (movie_id) references movie (id)
); 