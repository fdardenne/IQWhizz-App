insert into Users values ('Arthur', 'password', 'Français', strftime('%s','1999-01-01'),
'mail@mail.be',strftime('%s','2019-02-18'),strftime('%s','now'), 'image.png');

insert into Users values ('Arnaud', '1234', 'Français', strftime('%s','1998-01-01'),
'arnaudleheros@jesuisleplusfort.be',strftime('%s','2019-02-18'), strftime('%s','now'),'achanger.png');

insert into Users values ('Hadrien', 'lutinPlop', 'Français', strftime('%s','1999-08-16'),
'hl@uclouvain.be',strftime('%s','2019-02-25'), strftime('%s','now'),'hadrien.png');

insert into Users values ('Simon', 'machin3654', 'Français', strftime('%s','1999-05-03'),
'Simonleplusfort@gmail.be',strftime('%s','2019-02-25'), strftime('%s','now'),'simon.png');

insert into Users values ('Maxime', 'vache', 'Français', strftime('%s','1999-06-08'),
'maxime@hotmail.com',strftime('%s','2019-02-25'), strftime('%s','now'),'maxime.png');

insert into Users values ('Florent', 'Coucou', 'Français', strftime('%s','1999-01-01'),
'florent@telenet.be',strftime('%s','2019-02-25'), strftime('%s','now'),'florent.png');

insert into Friendships values ('Florent', 'Arthur', strftime('%s','now'), strftime('%s','now'), 1);


--INFO
insert into Questions values(1,1,'info',NULL,'Que signifient les initiales obo?');
insert into Questions values(2,2,'info',NULL,'Quel est le nom de notre assistant pour le cours de Systemes Informatiques');
insert into Questions values(3,2,'info',NULL,'De quel Professeur d info nous connaissons le mieux les gouts mousicaux ?');
insert into Questions values(4,4,'info',NULL,'Qu a lancé Mr Bonaventure récemment?');
insert into Questions values(5,1,'info',NULL,'Quel est le nombre de threads nécessaires a la lecture des fichiers pour le projet cracker');
insert into Questions values(6,3,'info',NULL,'Qui a l accent le plus sexy de l EPL ?');
-- grammaire
insert into Questions values(7,1,'grammaire',NULL,'Quel mot se rapproche le plus du sens du mot pacte');
insert into Questions values(8,2,'grammaire',NULL,'Quel mot se rapproche le plus du sens du mot analogie');
insert into Questions values(9,2,'grammaire',NULL,'Quel mot n a aucun rapport avec les autres (au niveau du sens des mots)');
insert into Questions values(10,4,'grammaire',NULL,'Quel mot n a aucun rapport avec les autres (au niveau du sens des mots)');
insert into Questions values(11,1,'grammaire',NULL,'Quel autre proverbe a le sens le plus proche de celui-ci : Faute de grives, on mange des merles');
insert into Questions values(12,3,'grammaire',NULL,'Quel autre proverbe a le sens le plus proche de celui-ci : l enfer est pavé de bonnes intentions');

--Calcul Mental
insert into Questions values(13,2,'Calcul Mental',NULL,'Quel est le nombre logique qui suit cette série: 4-6-9-6-14-6-... ?');
insert into Questions values(14,2,'Calcul Mental',NULL,'Résolvez cette équation: (((80-8)/3-4)x5)');
insert into Questions values(15,1,'Calcul Mental',NULL,'Combien vaut 4 litres de jus d orange à 3.5 euros le litre ?');
insert into Questions values(16,2,'Calcul Mental',NULL,'Quel est le résultat du calcul suivant: 9-3x2+1 ?');
insert into Questions values(17,2,'Calcul Mental',NULL,'Quel est le nombre logique qui suit cette série: 1-4-9-16-25-... ?');

insert into Questions values(18,1,'Calcul Mental',NULL,'256 * 3 = ?');
insert into Questions values(19,1,'Calcul Mental',NULL,'83 - 46 = ?');
insert into Questions values(20,1,'Calcul Mental',NULL,'24 x 6 = ?');
insert into Questions values(21,1,'Calcul Mental',NULL,'51 + 118 = ?');
insert into Questions values(22,1,'Calcul Mental',NULL,'135 / 9 = ?');

insert into Questions values(23,3,'Calcul Mental',NULL,'Quel est la valeur de Y dans cette équation: 9xY-12=96 ?');
insert into Questions values(24,2,'Calcul Mental',NULL,'Résolvez cette équation: 5+(3x14-7x3)');
insert into Questions values(25,4,'Calcul Mental',NULL,'Si 1 livre vaut 1.3 euros, et 1 euros vaut 2 dollars US, Que vaut 3 livres en Dollars US?');
insert into Questions values(26,3,'Calcul Mental',NULL,'Quel est le nombre logique qui suit cette série: (-1)-2-7-14-23-... ?');
insert into Questions values(27,2,'Calcul Mental',NULL,'Quel est la valeur de Y dans cette équation: 100-3*Y-12=70 ?');
--



-- réponses info
insert into PossibleAnswers values(1, 1, 0, NULL, 'object balanced organising');
insert into PossibleAnswers values(2, 1, 200, NULL, 'Olivier Bonaventure');
insert into PossibleAnswers values(3, 1, 0, NULL, 'owner buy-out');
insert into PossibleAnswers values(4, 1, 0, NULL, 'le nom d une ville en centrafrique');

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
insert into PossibleAnswers values(20, 5 , 0, NULL, 'le nombre de sources différents d ou viennent les fichiers de lecture');

insert into PossibleAnswers values(21, 6, 0, NULL, 'Kim Mens');
insert into PossibleAnswers values(22, 6 , 0, NULL, 'Quider Ben Naoum');
insert into PossibleAnswers values(23, 6, 0, NULL, 'Miltiadis Papalexandris');
insert into PossibleAnswers values(24, 6, 200, NULL, 'Joris Proost');

-- réponses grammaire

insert into PossibleAnswers values(25, 7, 200, NULL, 'traité');
insert into PossibleAnswers values(26, 7, 0, NULL, 'signature');
insert into PossibleAnswers values(27, 7, 0, NULL, 'protocole');
insert into PossibleAnswers values(28, 7, 0, NULL, 'impact');

insert into PossibleAnswers values(29, 8, 0, NULL, 'quiproquo');
insert into PossibleAnswers values(30, 8, 200, NULL, 'relation');
insert into PossibleAnswers values(31, 8, 0, NULL, 'différence');
insert into PossibleAnswers values(32, 8, 0, NULL, 'pénible');

insert into PossibleAnswers values(33, 9, 200, NULL, 'écraser');
insert into PossibleAnswers values(34, 9, 0, NULL, 'caresser');
insert into PossibleAnswers values(35, 9, 0, NULL, 'toucher');
insert into PossibleAnswers values(36, 9 , 0, NULL, 'tâter');

insert into PossibleAnswers values(37, 10, 0, NULL, 'crier');
insert into PossibleAnswers values(38, 10, 200, NULL, 'dresser');
insert into PossibleAnswers values(39, 10, 0, NULL, 'brailler');
insert into PossibleAnswers values(40, 10 , 0, NULL, 'hurler');

insert into PossibleAnswers values(41, 11, 0, NULL, 'l eau va a la riviere');
insert into PossibleAnswers values(42, 11, 0, NULL, 'tant va la cruche a l eau qu a la fin elle se brise');
insert into PossibleAnswers values(43, 11, 200, NULL, 'qui a des noix les casses qui n en a ne le peux');
insert into PossibleAnswers values(44, 11, 0, NULL, 'qui veut peut');

insert into PossibleAnswers values(45, 6, 0, NULL, 'il pleut des cordes');
insert into PossibleAnswers values(46, 6 , 0, NULL, 'qui casse paie');
insert into PossibleAnswers values(47, 6, 0, NULL, 'apres la pluie le beau temps');
insert into PossibleAnswers values(48, 6 , 200, NULL, 'Nul n est censé avoir voulu faire une betise');

-- réponse Calcul Mental

insert into PossibleAnswers values(65, 18, 0, NULL, '512');
insert into PossibleAnswers values(66, 18 , 0, NULL, '756');
insert into PossibleAnswers values(67, 18 , 200, NULL, '768');
insert into PossibleAnswers values(68, 18, 0, NULL, '812');

insert into PossibleAnswers values(49, 19, 0, NULL, '38');
insert into PossibleAnswers values(50, 19 , 200, NULL, '37');
insert into PossibleAnswers values(51, 19 , 0, NULL, '36');
insert into PossibleAnswers values(52, 19, 0, NULL, '35');

insert into PossibleAnswers values(53, 20, 200, NULL, '144');
insert into PossibleAnswers values(54, 20 , 0, NULL, '152');
insert into PossibleAnswers values(55, 20 , 0, NULL, '160');
insert into PossibleAnswers values(56, 20, 0, NULL, '148');

insert into PossibleAnswers values(57, 21, 0, NULL, '170');
insert into PossibleAnswers values(58, 21 , 0, NULL, '167');
insert into PossibleAnswers values(59, 21 , 0, NULL, '168');
insert into PossibleAnswers values(60, 21, 200, NULL, '169');

insert into PossibleAnswers values(61, 22, 200, NULL, '15');
insert into PossibleAnswers values(62, 22 , 0, NULL, '16');
insert into PossibleAnswers values(63, 22 , 0, NULL, '14');
insert into PossibleAnswers values(64, 22, 0, NULL, '17');

insert into PossibleAnswers values(70, 13, 0, NULL, '6');
insert into PossibleAnswers values(71, 13 , 0, NULL, '12');
insert into PossibleAnswers values(72, 13, 200, NULL, '19');
insert into PossibleAnswers values(73, 13 , 0, NULL, '25');

insert into PossibleAnswers values(74, 14, 0, NULL, '0');
insert into PossibleAnswers values(75, 14 , 0, NULL, '45');
insert into PossibleAnswers values(76, 14 , 200, NULL, '100');
insert into PossibleAnswers values(77, 14, 0, NULL, '150');

insert into PossibleAnswers values(78, 15, 0, NULL, '3.5');
insert into PossibleAnswers values(79, 15 , 0, NULL, '12');
insert into PossibleAnswers values(80, 15 , 200, NULL, '14');
insert into PossibleAnswers values(81, 15, 0, NULL, '15');

insert into PossibleAnswers values(82, 16, 0, NULL, '1');
insert into PossibleAnswers values(83, 16 , 200, NULL, '4');
insert into PossibleAnswers values(84, 16 , 0, NULL, '5');
insert into PossibleAnswers values(85, 16, 0, NULL, '6');

insert into PossibleAnswers values(86, 17, 0, NULL, '33');
insert into PossibleAnswers values(87, 17 , 0, NULL, '34');
insert into PossibleAnswers values(88, 17 , 0, NULL, '35');
insert into PossibleAnswers values(89, 17, 200, NULL, '36');

insert into PossibleAnswers values(90, 23, 0, NULL, '10');
insert into PossibleAnswers values(91, 23 , 200, NULL, '12');
insert into PossibleAnswers values(92, 23 , 0, NULL, '14');
insert into PossibleAnswers values(93, 23, 0, NULL, '15');

insert into PossibleAnswers values(94, 24, 0, NULL, '15');
insert into PossibleAnswers values(95, 24 , 0, NULL, '19');
insert into PossibleAnswers values(96, 24 , 0, NULL, '24');
insert into PossibleAnswers values(97, 24, 200, NULL, '26');

insert into PossibleAnswers values(98, 25, 0, NULL, '3.9');
insert into PossibleAnswers values(99, 25 , 0, NULL, '5.85');
insert into PossibleAnswers values(100, 25 , 200, NULL, '7.8');
insert into PossibleAnswers values(101, 25, 0, NULL, '7.9');

insert into PossibleAnswers values(102, 26, 0, NULL, '32');
insert into PossibleAnswers values(103, 26 , 200, NULL, '33');
insert into PossibleAnswers values(104, 26 , 0, NULL, '34');
insert into PossibleAnswers values(105, 26, 0, NULL, '35');

insert into PossibleAnswers values(106, 27, 0, NULL, '3');
insert into PossibleAnswers values(107, 27 , 0, NULL, '4');
insert into PossibleAnswers values(108, 27 , 0, NULL, '5');
insert into PossibleAnswers values(69, 27, 200, NULL, '6');