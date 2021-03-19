INSERT INTO room
VALUES(1, 90, 1),
(2,85,2),
(3,105,3),
(4,102,2);

INSERT INTO manager VALUES
(1, 'James', 'Harden', 87477474774, 1),
(2, 'Chris', 'Paul', 87778777898, 2),
(3, 'Stephen', 'Curry', 87777777777, 3);

INSERT INTO  customer VALUES (1, 'Tony', 'Stark', 87471963399, 'genius.tony@marvel.com'),
(2, 'Peter', 'Parker', 87011962155, 'spiderman@marvel.com'),
(3, 'Natasha', 'Romonoff', 87771964522, 'natasha.romonoff@marvel.com'),
(4, 'Matt', 'Murdock', 87011964011, 'matt.murdock@marvel.com'),
(5, 'Gennie', 'Camire', 87475699878, 'camire@gmail.com'),
(6, 'Chad', 'Van', 87781234565, 'varchar@gmail.com'),
(7, 'Mei', 'Devore', 87471562348, 'mei@gmail.com'),
(8, 'Chin', 'Beier', 87784567898, 'beier@gmail.com'),
(9, 'Russ', 'Viger', 87771569895, 'viger@gmail.com'),
(10, 'Clint', 'Carlile', 87475551245, 'clint@gmail.com');



INSERT INTO movie VALUES (1, 'Frozen 2', '08/12/2019', 'PG', '1h 43min', 'cartoon'),
(2, 'Little Joe', '11/12/2019', 'PG-13', '1h 45min', 'drama'),
(3, 'Psycho', '12/12/2019', 'PG-13', '1h 38min', 'horror'),
(4, 'Ford v Ferrari', '05/12/2019', 'PG-13', '2h 32min', 'biography'),
(5, 'The Shawshank Redemption', '18/12/2019', 'G', '1h 40min', 'military drama'),
(6, 'Forrest Gump', '07/12/2019', 'G', '2h 10min', 'drama'),
(7, 'Goodfellas', '21/12/2019', 'PG', '2h 15min', 'comedy'),
(8, 'City of God', '12/12/2019', 'R', '2h 30min', 'action'),
(9, 'Seven Samurai', '16/12/2019', 'NC-17', '2h 40min', 'adventure'),
(10, 'Casablanca', '15/12/2019', 'PG-13', '2h 55min', 'western');


INSERT INTO seance
VALUES(1, '10:00', '22/12/2019', 800, 1, 1),
(2, '10:00', '22/12/2019', 800, 2, 2),
(3, '10:00', '22/12/2019', 800, 3, 3),
(4, '13:00', '22/12/2019', 1300, 1, 4),
(5, '13:10', '22/12/2019', 1000, 2, 5),
(6, '12:50', '22/12/2019', 1300, 3, 6),
(7, '15:10', '22/12/2019', 1000, 1, 7),
(8, '14:45', '22/12/2019', 1600, 2, 8),
(9, '14:55', '22/12/2019',1200,3,9),
(10,'17:00', '22/12/2019',1200,1,10);


INSERT INTO booking
VALUES(111,'21/12/2019','18:58',1,10,1),
(112,'19/12/2019','12:02',2,9,2),
(113,'18/12/2019','13:12',3,8,3),
(114,'21/12/2019','16:25',4,7,4),
(115,'19/12/2019','14:32',5,6,5),
(116,'21/12/2019','10:41',6,5,6),
(117,'21/12/2019','19:59',7,4,7),
(118,'20/12/2019','18:06',8,3,8),
(119,'17/12/2019','14:20',9,2,9),
(110,'19/12/2019','22:19',10,1,10);

INSERT INTO ticket
VALUES(1111,'VIP', 111),
(1112, 'LUX', 112),
(1113, 'LUX', 112),
(1114, 'VIP', 113),
(1115, 'Ordinary', 114),
(1116, 'Ordinary', 115),
(1117, 'Ordinary', 115),
(1118, 'VIP', 116),
(1119, 'LUX', 117),
(1120, 'Ordinary', 118),
(1121, 'Ordinary', 118),
(1122, 'Ordinary', 119),
(1123, 'VIP', 110),
(1124, 'VIP', 110),
(1125, 'VIP', 110);

INSERT INTO employee
VALUES(101,'Venice','Paramore',1),
(102,'Dianna','Catt',2),
(103,'Exie','Mirsky',3),
(104,'Racheal','Westley',1),
(105,'Edda','Swader',2),
(106,'Marry','Barraza',2),
(107,'Pauletta','Brookover',1),
(108,'George','Kennett',3),
(109,'Hue','Gandhi',3);
