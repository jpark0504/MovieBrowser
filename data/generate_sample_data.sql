delete from starring;
delete from movie;
delete from director;
delete from actor;

-- actor

insert into actor (firstname, lastname, birth_date, gender) values ('Mark', 'Hamill', '1951-09-25', 'M');
insert into actor (firstname, lastname, birth_date, gender) values ('Harrison', 'Ford', '1942-07-13', 'M');
insert into actor (firstname, lastname, birth_date, gender) values ('Carrie', 'Fisher', '1956-10-21', 'F');

insert into actor (firstname, lastname, birth_date, gender) values ('Robert', 'Downey', '1965-04-04', 'M');

insert into actor (firstname, lastname, birth_date, gender) values ('Chris', 'Evans', '1981-06-13', 'M');

insert into actor (firstname, lastname, birth_date, gender) values ('Yoo', 'Gong', '1979-07-10', 'M');

insert into actor (firstname, lastname, birth_date, gender) values ('Kangho', 'Song', '1967-02-25', 'M');
insert into actor (firstname, lastname, birth_date, gender) values ('SoDam', 'Park', '1991-09-08', 'F');
insert into actor (firstname, lastname, birth_date, gender) values ('Hyun-jun', 'Jung', '2011-11-08', 'M');

insert into actor (firstname, lastname, birth_date, gender) values ('Eddie', 'Murphy', '1961-04-03', 'M');
insert into actor (firstname, lastname, birth_date, gender) values ('Mike', 'Myers', '1963-05-25', 'M');


insert into actor (firstname, lastname, birth_date, gender) values ('Macaulay', 'Culkin', '1980-08-26', 'M');
insert into actor (firstname, lastname, birth_date, gender) values ('Joe', 'Pesci', '1943-02-09', 'M');
insert into actor (firstname, lastname, birth_date, gender) values ('John', 'Heard', '1946-03-07', 'M');


insert into actor (firstname, lastname, birth_date, gender) values ('Jeff', 'Goldblum', '1952-10-22', 'M');
insert into actor (firstname, lastname, birth_date, gender) values ('Laura', 'Dern', '1967-02-10', 'F');

insert into actor (firstname, lastname, birth_date, gender) values ('Tobey', 'Maguire', '1975-02-27', 'M');
insert into actor (firstname, lastname, birth_date, gender) values ('Kirsten', 'Dunst', '1982-04-30', 'F');

insert into actor (firstname, lastname, birth_date, gender) values ('Chris', 'Pine', '1980-08-26', 'M');
insert into actor (firstname, lastname, birth_date, gender) values ('Zoe', 'Saldana', '1978-06-19', 'F');
insert into actor (firstname, lastname, birth_date, gender) values ('Leonard', 'Nimoy', '1931-03-26', 'M');


-- director
insert into director (firstname, lastname, birth_date) values ('George', 'Lucas', '1944-05-14');
insert into director (firstname, lastname, birth_date) values ('Jon', 'Favreau', '1966-10-19');
insert into director (firstname, lastname, birth_date) values ('Anthony', 'Russo', '1970-02-03');
insert into director (firstname, lastname, birth_date) values ('Sangho', 'Yeon', '1978-01-01');
insert into director (firstname, lastname, birth_date) values ('Joon-ho', 'Bong', '1969-09-14');
insert into director (firstname, lastname, birth_date) values ('Vicky', 'Jenson', '1960-03-04');
insert into director (firstname, lastname, birth_date) values ('Chris', 'Columbus', '1958-09-10');
insert into director (firstname, lastname, birth_date) values ('Steven', 'Spielberg', '1946-12-18');
insert into director (firstname, lastname, birth_date) values ('Sam', 'Raimi', '1959-10-23');
insert into director (firstname, lastname, birth_date) values ('J.J.', 'Abrams', '1966-06-27');

-- filmmaker
insert into filmmaker (name) values ('LucasFilm LTD.');
insert into filmmaker (name) values ('Marvel Studios');
insert into filmmaker (name) values ('Next Entertainment World');
insert into filmmaker (name) values ('Barunson E&A');
insert into filmmaker (name) values ('DreamWorks');
insert into filmmaker (name) values ('20th Century Fox');
insert into filmmaker (name) values ('Amblin Entertainment');
insert into filmmaker (name) values ('Columbia Pictures');
insert into filmmaker (name) values ('Spyglass Entertainment');
-- movie
insert into movie (title, releasedate, boxoffice, award, director_id, filmmaker_id, poster)
values ('Star Wars: Episode IV - A New Hope', '1977-05-25', 10000000, true, 
         (select id from director where lastname = 'Lucas' limit 1),
         (select id from filmmaker where name = 'LucasFilm LTD.' limit 1),
         pg_read_binary_file('C:\Work\STSWorkspace\MovieBrowser\data\starwars4.jpg'));
		 

insert into movie (title, releasedate, boxoffice, award, director_id, filmmaker_id, poster)
values ('Iron Man', '2008-05-02', 2000000, true, 
         (select id from director where lastname = 'Favreau' limit 1),
         (select id from filmmaker where name = 'Marvel Studios' limit 1),
         pg_read_binary_file('C:\Work\STSWorkspace\MovieBrowser\data\ironman.jpg'));
		 
		 
insert into movie (title, releasedate, boxoffice, award, director_id, filmmaker_id, poster)
values ('Captain America: The First Avenger', '2011-07-19', 3000000, true, 
         (select id from director where lastname = 'Russo' limit 1),
         (select id from filmmaker where name = 'Marvel Studios' limit 1),
         pg_read_binary_file('C:\Work\STSWorkspace\MovieBrowser\data\captainamerica.jpg'));
		 
insert into movie (title, releasedate, boxoffice, award, director_id, filmmaker_id, poster)
values ('Train to Busan', '2016-07-22', 4000000, true, 
         (select id from director where lastname = 'Yeon' limit 1),
         (select id from filmmaker where name = 'Next Entertainment World' limit 1),
         pg_read_binary_file('C:\Work\STSWorkspace\MovieBrowser\data\traintobusan.jpg'));
		 
insert into movie (title, releasedate, boxoffice, award, director_id, filmmaker_id, poster)
values ('Parasite', '2019-10-05', 6000000, true, 
         (select id from director where lastname = 'Bong' limit 1),
         (select id from filmmaker where name = 'Barunson E&A' limit 1),
         pg_read_binary_file('C:\Work\STSWorkspace\MovieBrowser\data\parasite.jpg'));
		 
insert into movie (title, releasedate, boxoffice, award, director_id, filmmaker_id, poster)
values ('Shrek', '2001-04-21', 6000000, true, 
         (select id from director where lastname = 'Jenson' limit 1),
         (select id from filmmaker where name = 'DreamWorks' limit 1),
         pg_read_binary_file('C:\Work\STSWorkspace\MovieBrowser\data\shrek.jpg'));

insert into movie (title, releasedate, boxoffice, award, director_id, filmmaker_id, poster)
values ('Home Alone', '1990-11-16', 6000000, true, 
         (select id from director where lastname = 'Columbus' limit 1),
         (select id from filmmaker where name = '20th Century Fox' limit 1),
         pg_read_binary_file('C:\Work\STSWorkspace\MovieBrowser\data\homealone.jpg'));

insert into movie (title, releasedate, boxoffice, award, director_id, filmmaker_id, poster)
values ('Jurassic Park', '1993-06-11', 6000000, true, 
         (select id from director where lastname = 'Spielberg' limit 1),
         (select id from filmmaker where name = 'Amblin Entertainment' limit 1),
         pg_read_binary_file('C:\Work\STSWorkspace\MovieBrowser\data\jurassicpark.jpg'));
		 
insert into movie (title, releasedate, boxoffice, award, director_id, filmmaker_id, poster)
values ('Spider Man', '2002-05-03', 6000000, true, 
         (select id from director where lastname = 'Raimi' limit 1),
         (select id from filmmaker where name = 'Columbia Pictures' limit 1),
         pg_read_binary_file('C:\Work\STSWorkspace\MovieBrowser\data\spiderman.jpg'));

insert into movie (title, releasedate, boxoffice, award, director_id, filmmaker_id, poster)
values ('Star Trek', '2009-05-08', 6000000, true, 
         (select id from director where lastname = 'Abrams' limit 1),
         (select id from filmmaker where name = 'Spyglass Entertainment' limit 1),
         pg_read_binary_file('C:\Work\STSWorkspace\MovieBrowser\data\startrek.jpg'));
		 
-- starring
insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Hamill'), (select id from movie where title = 'Star Wars: Episode IV - A New Hope'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Ford'), (select id from movie where title = 'Star Wars: Episode IV - A New Hope'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Fisher'), (select id from movie where title = 'Star Wars: Episode IV - A New Hope'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Downey'), (select id from movie where title = 'Iron Man'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Evans'), (select id from movie where title = 'Captain America: The First Avenger'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Gong'), (select id from movie where title = 'Train to Busan'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Song'), (select id from movie where title = 'Parasite'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Park'), (select id from movie where title = 'Parasite'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Jung'), (select id from movie where title = 'Parasite'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Murphy'), (select id from movie where title = 'Shrek'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Myers'), (select id from movie where title = 'Shrek'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Culkin'), (select id from movie where title = 'Home Alone'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Pesci'), (select id from movie where title = 'Home Alone'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Heard'), (select id from movie where title = 'Home Alone'));


insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Goldblum'), (select id from movie where title = 'Jurassic Park'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Dern'), (select id from movie where title = 'Jurassic Park'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Maguire'), (select id from movie where title = 'Spider Man'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Dunst'), (select id from movie where title = 'Spider Man'));


insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Pine'), (select id from movie where title = 'Star Trek'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Saldana'), (select id from movie where title = 'Star Trek'));

insert into starring (actor_id, movie_id)
values ((select id from actor where lastname = 'Nimoy'), (select id from movie where title = 'Star Trek'));
