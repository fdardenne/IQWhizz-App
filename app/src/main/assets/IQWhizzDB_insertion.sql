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

--    questionID integer       primary key,
--    difficulty integer       not null,
--    category   text          not null,
--    image      blob,
--    text       text          not null

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

-- systinfo
insert into Questions values(14,1,'systinfo',null,'Que signifient les initiales obo?');


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

-- systinfo
insert into PossibleAnswers values(28, 14, 0, NULL, 'object balanced organising');
insert into PossibleAnswers values(29, 14, 200, NULL, 'Olivier Bonaventure');
insert into PossibleAnswers values(30, 14, 0, NULL, 'owner buy-out');
insert into PossibleAnswers values(31, 14, 0, NULL, 'le nom d\'une ville en centrafrique');

