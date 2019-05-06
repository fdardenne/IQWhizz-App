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
insert into Questions values(14,2,'Calcul Mental',NULL,'Que vaut:  (((80-8)/3-4)x5)');
insert into Questions values(15,1,'Calcul Mental',NULL,'Combien vaut 4 litres de jus d orange à 3.5 euros le litre ?');
insert into Questions values(16,2,'Calcul Mental',NULL,'Quel est le résultat du calcul suivant: 9-3x2+1 ?');
insert into Questions values(17,2,'Calcul Mental',NULL,'Quel est le nombre logique qui suit cette série: 1-4-9-16-25-... ?');

insert into Questions values(18,1,'Calcul Mental',NULL,'Que vaut: 256 x 3 = ?');
insert into Questions values(19,1,'Calcul Mental',NULL,'Que vaut: 83 - 46 = ?');
insert into Questions values(20,1,'Calcul Mental',NULL,'Que vaut: 24 x 6 = ?');
insert into Questions values(21,1,'Calcul Mental',NULL,'Que vaut: 51 + 118 = ?');
insert into Questions values(22,1,'Calcul Mental',NULL,'Que vaut: 135 / 9 = ?');

insert into Questions values(23,3,'Calcul Mental',NULL,'Quel est la valeur de Y dans cette équation: 9xY-12=96 ?');
insert into Questions values(24,2,'Calcul Mental',NULL,'Que vaut:  5+(3x14-7x3)');
insert into Questions values(25,4,'Calcul Mental',NULL,'Si 1 livre vaut 1.3 euros, et 1 euros vaut 2 dollars US, Que vaut 3 livres en Dollars US?');
insert into Questions values(26,3,'Calcul Mental',NULL,'Quel est le nombre logique qui suit cette série: (-1)-2-7-14-23-... ?');
insert into Questions values(27,2,'Calcul Mental',NULL,'Quel est la valeur de Y dans cette équation: 100-3*Y=82 ?');

insert into Questions values(28,2,'Calcul Mental',NULL,'Que vaut: 58 x 12 = ?');
insert into Questions values(29,1,'Calcul Mental',NULL,'Que vaut: 146 - 78 = ?');
insert into Questions values(30,1,'Calcul Mental',NULL,'Que vaut: 136 / 34 = ?');
insert into Questions values(31,1,'Calcul Mental',NULL,'Que vaut: 97 + 168 = ?');
insert into Questions values(32,2,'Calcul Mental',NULL,'Que vaut: 198 / 11 = ?');

insert into Questions values(33,2,'Calcul Mental',NULL,'Quel est le nombre logique qui suit cette série: 1-2-3-5-8-13-... ?');
insert into Questions values(34,1,'Calcul Mental',NULL,'Résolvez cette équation: 6+(52-37)x2');
insert into Questions values(35,1,'Calcul Mental',NULL,'Combien vaut 12 bouteilles de Bière à 5.5 euros pièce ?');
insert into Questions values(36,2,'Calcul Mental',NULL,'Quel est le résultat du calcul suivant: 156-48+5x7 ?');
insert into Questions values(37,2,'Calcul Mental',NULL,'Quel est le nombre logique qui suit cette série: 1-4-7-10-13-... ?');

insert into Questions values(38,3,'Calcul Mental',NULL,'Quel est la valeur de Y dans cette équation: 10xY-12= ?'); //188
insert into Questions values(39,2,'Calcul Mental',NULL,'Que vaut:  7+(3x14)'); //49
insert into Questions values(40,4,'Calcul Mental',NULL,'Si 1 livre vaut 2 euros, et 1 euros vaut 1.5 dollars US, Que vaut 3 livres en Dollars US?'); //9
insert into Questions values(41,3,'Calcul Mental',NULL,'Quel est le nombre logique qui suit cette série: 6-7-9-12-16-... ?'); //21
insert into Questions values(42,2,'Calcul Mental',NULL,'Quel est la valeur de Y dans cette équation: 100-3*Y=67 ?'); //11

insert into Questions values(43,1,'Calcul Mental',NULL,'Quel est le nombre logique qui suit cette série: 10-6-16-12-22-18-... ?');
insert into Questions values(44,1,'Calcul Mental',NULL,'Que vaut: 15x6-7');
insert into Questions values(45,1,'Calcul Mental',NULL,'Combien il y a-t-il de pépins dans une pèche?');
insert into Questions values(46,2,'Calcul Mental',NULL,'Quel est le résultat du calcul suivant: 2.5*7 ?');
insert into Questions values(47,2,'Calcul Mental',NULL,'Quel est la valeur de Y dans cette équation: 57-4*Y=25 ?');

insert into Questions values(48,2,'Calcul Mental',NULL,'Que vaut: 120 x 15 = ?');
insert into Questions values(49,2,'Calcul Mental',NULL,'Que vaut: 356 - 159 = ?');
insert into Questions values(50,1,'Calcul Mental',NULL,'Que vaut: 176 / 8 = ?');
insert into Questions values(51,1,'Calcul Mental',NULL,'Que vaut: 1846 + 256 = ?');
insert into Questions values(52,2,'Calcul Mental',NULL,'Que vaut: 18 / 4 = ?');

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

insert into PossibleAnswers values(45, 12, 0, NULL, 'il pleut des cordes');
insert into PossibleAnswers values(46, 12 , 0, NULL, 'qui casse paie');
insert into PossibleAnswers values(47, 12, 0, NULL, 'apres la pluie le beau temps');
insert into PossibleAnswers values(48, 12 , 200, NULL, 'Nul n est censé avoir voulu faire une betise');

-- réponse Calcul Mental



insert into PossibleAnswers values(49, 13, 0, NULL, '6');
insert into PossibleAnswers values(50, 13 , 0, NULL, '12');
insert into PossibleAnswers values(51, 13, 200, NULL, '19');
insert into PossibleAnswers values(52, 13 , 0, NULL, '25');

insert into PossibleAnswers values(53, 14, 0, NULL, '0');
insert into PossibleAnswers values(54, 14 , 0, NULL, '45');
insert into PossibleAnswers values(55, 14 , 200, NULL, '100');
insert into PossibleAnswers values(56, 14, 0, NULL, '150');

insert into PossibleAnswers values(57, 15, 0, NULL, '3.5');
insert into PossibleAnswers values(58, 15 , 0, NULL, '12');
insert into PossibleAnswers values(59, 15 , 200, NULL, '14');
insert into PossibleAnswers values(60, 15, 0, NULL, '15');

insert into PossibleAnswers values(61, 16, 0, NULL, '1');
insert into PossibleAnswers values(62, 16 , 200, NULL, '4');
insert into PossibleAnswers values(63, 16 , 0, NULL, '5');
insert into PossibleAnswers values(64, 16, 0, NULL, '6');

insert into PossibleAnswers values(65, 17, 0, NULL, '33');
insert into PossibleAnswers values(66, 17 , 0, NULL, '34');
insert into PossibleAnswers values(67, 17 , 0, NULL, '35');
insert into PossibleAnswers values(68, 17, 200, NULL, '36');

insert into PossibleAnswers values(69, 18, 0, NULL, '512');
insert into PossibleAnswers values(70, 18 , 0, NULL, '756');
insert into PossibleAnswers values(71, 18 , 200, NULL, '768');
insert into PossibleAnswers values(72, 18, 0, NULL, '812');

insert into PossibleAnswers values(73, 19, 0, NULL, '38');
insert into PossibleAnswers values(74, 19 , 200, NULL, '37');
insert into PossibleAnswers values(75, 19 , 0, NULL, '36');
insert into PossibleAnswers values(76, 19, 0, NULL, '35');

insert into PossibleAnswers values(77, 20, 200, NULL, '144');
insert into PossibleAnswers values(78, 20 , 0, NULL, '152');
insert into PossibleAnswers values(79, 20 , 0, NULL, '160');
insert into PossibleAnswers values(80, 20, 0, NULL, '148');

insert into PossibleAnswers values(81, 21, 0, NULL, '170');
insert into PossibleAnswers values(82, 21 , 0, NULL, '167');
insert into PossibleAnswers values(83, 21 , 0, NULL, '168');
insert into PossibleAnswers values(84, 21, 200, NULL, '169');

insert into PossibleAnswers values(85, 22, 200, NULL, '15');
insert into PossibleAnswers values(86, 22 , 0, NULL, '16');
insert into PossibleAnswers values(87, 22 , 0, NULL, '14');
insert into PossibleAnswers values(88, 22, 0, NULL, '17');

insert into PossibleAnswers values(89, 23, 0, NULL, '10');
insert into PossibleAnswers values(90, 23 , 200, NULL, '12');
insert into PossibleAnswers values(91, 23 , 0, NULL, '14');
insert into PossibleAnswers values(92, 23, 0, NULL, '15');

insert into PossibleAnswers values(93, 24, 0, NULL, '15');
insert into PossibleAnswers values(94, 24 , 0, NULL, '19');
insert into PossibleAnswers values(95, 24 , 0, NULL, '24');
insert into PossibleAnswers values(96, 24, 200, NULL, '26');

insert into PossibleAnswers values(97, 25, 0, NULL, '3.9');
insert into PossibleAnswers values(98, 25 , 0, NULL, '5.85');
insert into PossibleAnswers values(99, 25 , 200, NULL, '7.8');
insert into PossibleAnswers values(100, 25, 0, NULL, '7.9');

insert into PossibleAnswers values(101, 26, 0, NULL, '32');
insert into PossibleAnswers values(102, 26 , 200, NULL, '33');
insert into PossibleAnswers values(103, 26 , 0, NULL, '34');
insert into PossibleAnswers values(104, 26, 0, NULL, '35');

insert into PossibleAnswers values(105, 27, 0, NULL, '3');
insert into PossibleAnswers values(106, 27 , 0, NULL, '4');
insert into PossibleAnswers values(107, 27 , 0, NULL, '5');
insert into PossibleAnswers values(108, 27, 200, NULL, '6');

insert into PossibleAnswers values(109, 28, 0, NULL, '658');
insert into PossibleAnswers values(110, 28 , 0, NULL, '669');
insert into PossibleAnswers values(111, 28 , 200, NULL, '696');
insert into PossibleAnswers values(112, 28, 0, NULL, '724');

insert into PossibleAnswers values(113, 29, 0, NULL, '64');
insert into PossibleAnswers values(114, 29 , 0, NULL, '66');
insert into PossibleAnswers values(115, 29 , 200, NULL, '68');
insert into PossibleAnswers values(116, 29, 0, NULL, '72');

insert into PossibleAnswers values(117, 30, 200, NULL, '4');
insert into PossibleAnswers values(118, 30 , 0, NULL, '4.5');
insert into PossibleAnswers values(119, 30 , 0, NULL, '5');
insert into PossibleAnswers values(120, 30, 0, NULL, '5.5');

insert into PossibleAnswers values(121, 31, 0, NULL, '246');
insert into PossibleAnswers values(122, 31 , 200, NULL, '256');
insert into PossibleAnswers values(123, 31 , 0, NULL, '260');
insert into PossibleAnswers values(124, 31, 0, NULL, '262');

insert into PossibleAnswers values(125, 32, 200, NULL, '18');
insert into PossibleAnswers values(126, 32 , 0, NULL, '16');
insert into PossibleAnswers values(127, 32 , 0, NULL, '14');
insert into PossibleAnswers values(128, 32, 0, NULL, '17');

insert into PossibleAnswers values(129, 33, 0, NULL, '19');
insert into PossibleAnswers values(130, 33 , 0, NULL, '20');
insert into PossibleAnswers values(131, 33, 200, NULL, '21');
insert into PossibleAnswers values(132, 33 , 0, NULL, '22');

insert into PossibleAnswers values(133, 34, 0, NULL, '25');
insert into PossibleAnswers values(134, 34 , 200, NULL, '30');
insert into PossibleAnswers values(135, 34 , 0, NULL, '17');
insert into PossibleAnswers values(136, 34, 0, NULL, '15');

insert into PossibleAnswers values(137, 35, 0, NULL, '56');
insert into PossibleAnswers values(138, 35 , 0, NULL, '62');
insert into PossibleAnswers values(139, 35 , 0, NULL, '64');
insert into PossibleAnswers values(140, 35, 200, NULL, '66');

insert into PossibleAnswers values(141, 36, 0, NULL, '127');
insert into PossibleAnswers values(142, 36 , 200, NULL, '143');
insert into PossibleAnswers values(143, 36 , 0, NULL, '155');
insert into PossibleAnswers values(144, 36, 0, NULL, '118');

insert into PossibleAnswers values(145, 37, 0, NULL, '15');
insert into PossibleAnswers values(146, 37 , 200, NULL, '16');
insert into PossibleAnswers values(147, 37 , 0, NULL, '18');
insert into PossibleAnswers values(148, 37, 0, NULL, '20');

insert into PossibleAnswers values(149, 38, 200, NULL, '188');
insert into PossibleAnswers values(150, 38 , 0, NULL, '189');
insert into PossibleAnswers values(151, 38 , 0, NULL, '190');
insert into PossibleAnswers values(152, 38, 0, NULL, '191');

insert into PossibleAnswers values(153, 39, 0, NULL, '45');
insert into PossibleAnswers values(154, 39 , 0, NULL, '47');
insert into PossibleAnswers values(155, 39, 0, NULL, '48');
insert into PossibleAnswers values(156, 39, 200, NULL, '49');

insert into PossibleAnswers values(157, 40, 0, NULL, '7');
insert into PossibleAnswers values(158, 40 , 0, NULL, '8');
insert into PossibleAnswers values(159, 40, 200, NULL, '9');
insert into PossibleAnswers values(160, 40, 0, NULL, '10');

insert into PossibleAnswers values(161, 41, 0, NULL, '23');
insert into PossibleAnswers values(162, 41 , 0, NULL, '15');
insert into PossibleAnswers values(163, 41, 200, NULL, '21');
insert into PossibleAnswers values(164, 41, 0, NULL, '17');

insert into PossibleAnswers values(165, 42, 0, NULL, '23');
insert into PossibleAnswers values(166, 42 , 0, NULL, '15');
insert into PossibleAnswers values(167, 42, 200, NULL, '21');
insert into PossibleAnswers values(168, 42, 0, NULL, '17');

insert into PossibleAnswers values(169, 43, 0, NULL, '22');
insert into PossibleAnswers values(170, 43 , 0, NULL, '24');
insert into PossibleAnswers values(171, 43, 0, NULL, '26');
insert into PossibleAnswers values(172, 43 , 200, NULL, '28');

insert into PossibleAnswers values(173, 44, 0, NULL, '90');
insert into PossibleAnswers values(174, 44 , 0, NULL, '97');
insert into PossibleAnswers values(175, 44 , 0, NULL, '87');
insert into PossibleAnswers values(176, 44, 200, NULL, '83');

insert into PossibleAnswers values(177, 45, 0, NULL, '2');
insert into PossibleAnswers values(178, 45 , 0, NULL, '1');
insert into PossibleAnswers values(179, 45 , 200, NULL, '0');
insert into PossibleAnswers values(180, 45, 0, NULL, '12');

insert into PossibleAnswers values(181, 46, 0, NULL, '12.7');
insert into PossibleAnswers values(182, 46 , 200, NULL, '17.5');
insert into PossibleAnswers values(183, 46 , 0, NULL, '15');
insert into PossibleAnswers values(184, 46, 0, NULL, '11.8');

insert into PossibleAnswers values(185, 47, 200, NULL, '8');
insert into PossibleAnswers values(186, 47 , 0, NULL, '6');
insert into PossibleAnswers values(187, 47 , 0, NULL, '7');
insert into PossibleAnswers values(188, 47, 0, NULL, '9');

insert into PossibleAnswers values(189, 48, 0, NULL, '1620');
insert into PossibleAnswers values(190, 48 , 0, NULL, '1820');
insert into PossibleAnswers values(191, 48, 0, NULL, '1850');
insert into PossibleAnswers values(192, 48 , 200, NULL, '1800');

insert into PossibleAnswers values(193, 49, 0, NULL, '196');
insert into PossibleAnswers values(194, 49 , 200, NULL, '197');
insert into PossibleAnswers values(195, 49 , 0, NULL, '198');
insert into PossibleAnswers values(196, 49, 0, NULL, '195');

insert into PossibleAnswers values(197, 50, 0, NULL, '20');
insert into PossibleAnswers values(198, 50 , 0, NULL, '17');
insert into PossibleAnswers values(199, 50 , 200, NULL, '22');
insert into PossibleAnswers values(200, 50, 0, NULL, '24');

insert into PossibleAnswers values(201, 51, 200, NULL, '2102');
insert into PossibleAnswers values(202, 51 , 0, NULL, '2103');
insert into PossibleAnswers values(203, 51 , 0, NULL, '2002');
insert into PossibleAnswers values(204, 51, 0, NULL, '2003');

insert into PossibleAnswers values(205, 52, 200, NULL, '4');
insert into PossibleAnswers values(206, 52 , 0, NULL, '4.5');
insert into PossibleAnswers values(207, 52 , 0, NULL, '5');
insert into PossibleAnswers values(208, 52, 0, NULL, '5.5');