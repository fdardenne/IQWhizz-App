insert into Users values ('Arthur', 'password', 'fr', strftime('%s','1999-01-01'),
'mail@mail.be',strftime('%s','2019-02-18'),strftime('%s','now'), 'image.png');

insert into Users values ('Arnaud', '1234', 'ch', strftime('%s','1998-01-01'),
'arnaudleheros@jesuisleplusfort.be',strftime('%s','2019-02-18'), strftime('%s','now'),'achanger.png');

insert into Users values ('Hadrien', 'lutinPlop', 'fr', strftime('%s','1999-08-16'),
'hl@uclouvain.be',strftime('%s','2019-02-25'), strftime('%s','now'),'hadrien.png');

insert into Users values ('Simon', 'machin3654', 'fr', strftime('%s','1999-05-03'),
'Simonleplusfort@gmail.be',strftime('%s','2019-02-25'), strftime('%s','now'),'simon.png');

insert into Users values ('Maxime', 'vache', 'nl', strftime('%s','1999-06-08'),
'maxime@hotmail.com',strftime('%s','2019-02-25'), strftime('%s','now'),'maxime.png');

insert into Users values ('Florent', 'Coucou', 'fr', strftime('%s','1999-01-01'),
'florent@telenet.be',strftime('%s','2019-02-25'), strftime('%s','now'),'florent.png');


--INFO
insert into Questions values(1,1,'info',NULL,'Que signifient les initiales obo?');
insert into Questions values(2,2,'info',NULL,'Quel est le nom de notre assistant pour le cours de Systemes Informatiques');
insert into Questions values(3,2,'info',NULL,"De quel Professeur d\'info nous connaissons le mieux les gouts mousicaux ?");
insert into Questions values(4,4,'info',NULL,"Qu\'a lancé Mr Bonaventure récemment?");
insert into Questions values(5,1,'info',NULL,'Quel est le nombre de threads nécessaires a la lecture des fichiers pour le projet cracker');
insert into Questions values(6,3,'info',NULL,"Qui a l\'accent le plus sexy de l\'EPL ?");
--

insert into PossibleAnswers values(1, 1, 0, NULL, 'object balanced organising');
insert into PossibleAnswers values(2, 1, 200, NULL, 'Olivier Bonaventure');
insert into PossibleAnswers values(3, 1, 0, NULL, 'owner buy-out');
insert into PossibleAnswers values(4, 1, 0, NULL, "le nom d\'une ville en centrafrique");

insert into PossibleAnswers values(5, 2, 0, NULL, 'Benjamin DeCeuninck');
insert into PossibleAnswers values(6, 2 , 0, NULL, 'Quentin deConinck');
insert into PossibleAnswers values(7, 2 , 0, NULL, 'Quentin Plagiat');
insert into PossibleAnswers values(8, 2 , 200, NULL, 'Benjamin deConinck');

insert into PossibleAnswers values(9, 3, 200, NULL, 'Kim Mens');
insert into PossibleAnswers values(10, 3 , 0, NULL, 'Peter Van Roy');
insert into PossibleAnswers values(11, 3, 0, NULL, 'Charles Pêcheur');
insert into PossibleAnswers values(12, 3 , 0, NULL, 'Olivier Bonaventure');

insert into PossibleAnswers values(13, 4, 0, NULL, 'Un frisbee');
insert into PossibleAnswers values(14, 4 , 200, NULL, 'Une startup');
insert into PossibleAnswers values(15, 4, 0, NULL, 'Une convention TinderForCode');
insert into PossibleAnswers values(16, 4 , 0, NULL, 'Des tests CUnit');

insert into PossibleAnswers values(17, 5, 0, NULL, 'le nombre de coeurs du pc x 2 ');
insert into PossibleAnswers values(18, 5 , 0, NULL, '42');
insert into PossibleAnswers values(19, 5, 200, NULL, 'personne ne sait');
insert into PossibleAnswers values(20, 5 , 0, NULL, "le nombre de sources différents d\'ou viennent les fichiers de lecture");

insert into PossibleAnswers values(21, 6, 0, NULL, 'Kim Mens');
insert into PossibleAnswers values(22, 6 , 0, NULL, 'Quider Ben Naoum');
insert into PossibleAnswers values(23, 6, 0, NULL, 'Miltiadis Papalexandris');
insert into PossibleAnswers values(24, 6 , 200, NULL, 'Joris Proost');