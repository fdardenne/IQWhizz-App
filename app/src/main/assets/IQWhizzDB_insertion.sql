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


insert into Tests values (1, 'court');
insert into Tests values (2, 'court');
insert into Tests values (3, 'standard');
insert into Tests values (4, 'court');
insert into Tests values (5, 'standard');
insert into Tests values (6, 'court');

insert into Questions values (1, 1, 'logique', 'img1.png', 'testez ...');
insert into Questions values (2, 1, 'logique', 'img2.png', 'trouvez ...');
insert into Questions values (3, 1, 'logique', 'img3.png', 'choisir ...');
insert into Questions values (4, 3, 'reflexion', 'img4.png', 'priez ...');
insert into Questions values (5, 2, 'reflexion', 'img5.png', 'trouvez ...');
insert into Questions values (6, 3, 'calcul mental', 'img6.png', 'choisir ...');
insert into Questions(difficulty, category, image, text) values (4,'reflexion','img7.png', 'bla bla bla');
insert into Questions(difficulty, category, image, text) values (2,'logique','img8.png', 'bla bla bla');
insert into Questions(difficulty, category, image, text) values (1,'calcul mental','img9.png', 'bla bla bla');
insert into Questions(difficulty, category, image, text) values (3,'logique','img10.png', 'bla bla bla');
insert into Questions(difficulty, category, image, text) values (2,'logique','img11.png', 'bla bla bla');
insert into Questions(difficulty, category, image, text) values (1,'reflexion','img12.png', 'bla bla bla');
insert into Questions(difficulty, category, image, text) values (3,'reflexion','img13.png', 'bla bla bla');


insert into PossibleAnswers values (1, 1, 100, 'img1.png', 'Rép a');
insert into PossibleAnswers values (2, 1, 0, 'img2.png', 'Rép b');
insert into PossibleAnswers values (3, 1, 0, 'img3.png', 'Rép c');
insert into PossibleAnswers values (4, 2, 0, 'img4.png', 'A');
insert into PossibleAnswers values (5, 2, 100, 'img5.png', 'B');
insert into PossibleAnswers values (6, 3, 0, NULL, '12');
insert into PossibleAnswers values (7, 5, 0, NULL, '12');

insert into PossibleAnswers values (8, 3, 0, NULL, '12');
insert into PossibleAnswers values (9, 4, 0, NULL, '12');


insert into TestQuestions values (1, 1);
insert into TestQuestions values (1, 2);
insert into TestQuestions values (1, 3);
insert into TestQuestions values (1, 4);
insert into TestQuestions values (1, 5);

insert into TestQuestions values (2, 1);
insert into TestQuestions values (3, 3);
insert into TestQuestions values (2, 3);
insert into TestQuestions values (4, 5);
insert into TestQuestions values (2, 5);

insert into TestExecutions values (1, 1, 'Hadrien', strftime('%s', '2019-02-28'));
insert into TestExecutions values (2, 1,'Florent', strftime('%s', '2019-02-28'));
insert into TestExecutions values (3, 2, 'Arthur', strftime('%s', '2019-02-18'));
insert into TestExecutions values (4, 3, 'Arthur', strftime('%s', '2019-02-18'));
insert into TestExecutions values (5, 4, 'Simon', strftime('%s', '2019-02-08'));
insert into TestExecutions values (6, 5, 'Hadrien', strftime('%s', '2019-03-01'));

insert into Challenges values ('Hadrien', 'Arthur', 1, 0);
insert into Challenges values ('Florent', 'Arthur', 3, 0);
insert into Challenges values ('Simon', 'Hadrien', 2, 0);
insert into Challenges values ('Hadrien', 'Simon', 6, 1);
insert into Challenges values ('Arnaud', 'Maxime', 5, 0);
insert into Challenges values ('Maxime', 'Simon', 1, 1);

insert into Friendship values ('Hadrien', 'Arthur', strftime('%s','now'));
insert into Friendship values ('Florent', 'Arthur', strftime('%s','now'));
insert into Friendship values ('Hadrien', 'Florent', strftime('%s','now'));
insert into Friendship values ('Simon', 'Arthur', strftime('%s','now'));
insert into Friendship values ('Hadrien', 'Arnaud', strftime('%s','now'));
insert into Friendship values ('Arnaud', 'Florent', strftime('%s','now'));

insert into SelectedAnswers values (1, 1, 1, 3, 120);
insert into SelectedAnswers values (1, 1, 2, 5, 60);
insert into SelectedAnswers values (1, 1, 3, 8, 120);
insert into SelectedAnswers values (1, 1, 4, 9, 60);

insert into SelectedAnswers values (2, 1, 2, 5, 30);
insert into SelectedAnswers values (4, 3, 3, 6, 20);
insert into SelectedAnswers values (5, 4, 5, 7, 20);
insert into SelectedAnswers values (3, 2, 1, 2, 5);
