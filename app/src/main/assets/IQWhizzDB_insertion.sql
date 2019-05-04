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

insert into Questions values (1, 1, 'logique', 'img1.png', 'testez ...');
insert into Questions values (2, 1, 'logique', 'img2.png', 'trouvez ...');
insert into Questions values (3, 1, 'logique', 'img3.png', 'choisir ...');
insert into Questions values (4, 3, 'reflexion', 'img4.png', 'priez ...');
insert into Questions values (5, 2, 'reflexion', 'img5.png', 'trouvez ...');
insert into Questions values (6, 3, 'calcul mental', 'img6.png', 'choisir ...');
insert into Questions values (7,4,'reflexion','img7.png', 'bla bla bla');
insert into Questions values (8,2,'logique','img8.png', 'bla bla bla');
insert into Questions values (9,1,'calcul mental','img9.png', 'bla bla bla');
insert into Questions values (10,3,'logique','img10.png', 'bla bla bla');
insert into Questions values (11,2,'logique','img11.png', 'bla bla bla');
insert into Questions values (12,1,'reflexion','img12.png', 'bla bla bla');
insert into Questions values (13,3,'reflexion','img13.png', 'bla bla bla');

--INFO
insert into Questions values(14,1,'info',NULL,'Que signifient les initiales obo?');
insert into Questions values(15,2,'info',NULL,'Quel est le nom de notre assistant pour le cours de Systemes Informatiques');
insert into Questions values(16,2,'info',NULL,"De quel Professeur d\'info nous connaissons le mieux les gouts mousicaux ?");
insert into Questions values(17,4,'info',NULL,"Qu\'a lancé Mr Bonaventure récemment?");
insert into Questions values(18,1,'info',NULL,'Quel est le nombre de threads nécessaires a la lecture des fichiers pour le projet cracker');
insert into Questions values(19,3,'info',NULL,"Qui a l\'accent le plus sexy de l\'EPL ?");
--

insert into PossibleAnswers values (1, 1, 200, 'img1.png', 'Rép a');
insert into PossibleAnswers values (2, 1, 0, 'img2.png', 'Rép b');
insert into PossibleAnswers values (3, 1, 0, 'img3.png', 'Rép c');
insert into PossibleAnswers values (4, 2, 0, 'img4.png', 'A');
insert into PossibleAnswers values (5, 2, 200, 'img5.png', 'B');
insert into PossibleAnswers values (6, 3, 0, NULL, 'faux');
insert into PossibleAnswers values (7, 3, 200, NULL, 'vrai');
insert into PossibleAnswers values (8, 4, 200, NULL, 'vrai');
insert into PossibleAnswers values (9, 4, 0, NULL, 'faux');
insert into PossibleAnswers values (10, 5, 200, NULL, 'vrai');
insert into PossibleAnswers values (11, 5, 0, NULL, 'faux');
insert into PossibleAnswers values (12, 6, 200, NULL, 'vrai');
insert into PossibleAnswers values (13, 6, 0, NULL, 'faux');
insert into PossibleAnswers values (14, 7, 200, NULL, 'vrai');
insert into PossibleAnswers values (15, 7, 0, NULL, 'faux');
insert into PossibleAnswers values (16, 8, 200, NULL, 'vrai');
insert into PossibleAnswers values (17, 8, 0, NULL, 'faux');
insert into PossibleAnswers values (18, 9, 200, NULL, 'vrai');
insert into PossibleAnswers values (19, 9, 0, NULL, 'faux');
insert into PossibleAnswers values (20, 10, 200, NULL, 'vrai');
insert into PossibleAnswers values (21, 10, 0, NULL, 'faux');
insert into PossibleAnswers values (22, 11, 200, NULL, 'vrai');
insert into PossibleAnswers values (23, 11, 0, NULL, 'faux');
insert into PossibleAnswers values (24, 12, 200, NULL, 'vrai');
insert into PossibleAnswers values (25, 12, 0, NULL, 'faux');
insert into PossibleAnswers values (26, 13, 200, NULL, 'vrai');
insert into PossibleAnswers values (27, 13, 0, NULL, 'faux');

insert into PossibleAnswers values(28, 14, 0, NULL, 'object balanced organising');
insert into PossibleAnswers values(29, 14, 200, NULL, 'Olivier Bonaventure');
insert into PossibleAnswers values(30, 14, 0, NULL, 'owner buy-out');
insert into PossibleAnswers values(31, 14, 0, NULL, "le nom d\'une ville en centrafrique");

insert into PossibleAnswers values(32, 15, 0, NULL, 'Benjamin DeCeuninck');
insert into PossibleAnswers values(33, 15 , 0, NULL, 'Quentin deConinck');
insert into PossibleAnswers values(33, 15, 0, NULL, 'Quentin Plagiat');
insert into PossibleAnswers values(34, 15 , 200, NULL, 'Benjamin deConinck');

insert into PossibleAnswers values(32, 16, 200, NULL, 'Kim Mens');
insert into PossibleAnswers values(33, 16 , 0, NULL, 'Peter Van Roy');
insert into PossibleAnswers values(33, 16, 0, NULL, 'Charles Pêcheur');
insert into PossibleAnswers values(34, 16 , 0, NULL, 'Olivier Bonaventure');

insert into PossibleAnswers values(32, 17, 0, NULL, 'Un frisbee');
insert into PossibleAnswers values(33, 17 , 200, NULL, 'Une startup');
insert into PossibleAnswers values(33, 17, 0, NULL, 'Une convention TinderForCode');
insert into PossibleAnswers values(34, 17 , 0, NULL, 'Des tests CUnit');

insert into PossibleAnswers values(32, 18, 0, NULL, 'le nombre de coeurs du pc x 2 ');
insert into PossibleAnswers values(33, 18 , 0, NULL, '42');
insert into PossibleAnswers values(33, 18, 200, NULL, 'personne ne sait');
insert into PossibleAnswers values(34, 18 , 0, NULL, "le nombre de sources différents d\'ou viennent les fichiers de lecture");

insert into PossibleAnswers values(32, 19, 0, NULL, 'Kim Mens');
insert into PossibleAnswers values(33, 19 , 0, NULL, 'Quider Ben Naoum');
insert into PossibleAnswers values(33, 19, 0, NULL, 'Miltiadis Papalexandris');
insert into PossibleAnswers values(34, 19 , 200, NULL, 'Joris Proost');