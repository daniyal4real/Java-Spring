CREATE TABLE room(
 room_id INT NOT NULL,
 room_seat_number INT,
 room_floor INT,
 PRIMARY KEY (room_id)
);

CREATE TABLE manager(
 manager_id INT NOT NULL,
 manager_first_name VARCHAR ,
 manager_last_name VARCHAR ,
 manager_phone_number VARCHAR,
 room_id INT,
 PRIMARY KEY (manager_id)
);
 ALTER TABLE manager ADD CONSTRAINT my_fk FOREIGN KEY (room_id) REFERENCES room(room_id) ;
              ALTER TABLE manager ALTER COLUMN manager_phone_number TYPE VARCHAR;

CREATE TABLE movie(
 movie_id INT NOT NULL,
movie_title VARCHAR ,
 movie_date VARCHAR,
 movie_rating VARCHAR ,
 movie_long VARCHAR ,
 movie_genre VARCHAR ,
PRIMARY KEY (movie_id));

CREATE TABLE customer(
 customer_id INT NOT NULL,
 customer_first_name VARCHAR ,
 customer_last_name VARCHAR ,
 customer_phone_number VARCHAR,
 customer_email VARCHAR ,
 PRIMARY KEY (customer_id)
);
ALTER TABLE customer ALTER COLUMN customer_phone_number TYPE VARCHAR;

CREATE TABLE seance(
 seance_id INT NOT NULL,
 seance_time VARCHAR,
 seance_date VARCHAR,
 seance_price INT,
 room_id INT,
 movie_id INT,
PRIMARY KEY (seance_id)
);
 ALTER TABLE seance ADD CONSTRAINT my_fk3 FOREIGN KEY (movie_id) REFERENCES movie(movie_id);
 ALTER TABLE seance ADD CONSTRAINT my_fk2 FOREIGN KEY (room_id) REFERENCES room(room_id);

CREATE TABLE booking(
 booking_id INT NOT NULL,
 booking_date VARCHAR,
 booking_time VARCHAR,
 ticket_number INT,
 seance_id INT,
 customer_id INT,
 PRIMARY KEY (booking_id)
);
 ALTER TABLE booking ADD CONSTRAINT my_fk4 FOREIGN KEY (seance_id) REFERENCES seance(seance_id);
 ALTER TABLE booking ADD CONSTRAINT my_fk5 FOREIGN KEY (customer_id) REFERENCES customer(customer_id);

CREATE TABLE ticket(
 ticket_id INT NOT NULL,
 ticket_type VARCHAR,
 booking_id INT,
 PRIMARY KEY (ticket_id)
);
ALTER TABLE ticket ADD CONSTRAINT my_fk6 FOREIGN KEY (booking_id) REFERENCES booking(booking_id);

CREATE TABLE employee(
 employee_id INT,
 employee_first_name VARCHAR,
 employee_last_name VARCHAR,
 manager_id INT,
 PRIMARY KEY (employee_id)
);
    ALTER TABLE employee ADD CONSTRAINT my_fk7 FOREIGN KEY (manager_id) REFERENCES manager(manager_id);
