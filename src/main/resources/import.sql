USE trak;

DELETE FROM shipment_movement;
DELETE FROM shipment;
DELETE FROM customer;
DELETE FROM gate;
DELETE FROM station;
DELETE FROM vehicle_location;
DELETE FROM vehicle;
DELETE FROM location;
DELETE FROM address;
DELETE FROM user;

ALTER TABLE shipment_movement AUTO_INCREMENT = 1;
ALTER TABLE shipment AUTO_INCREMENT = 1;
ALTER TABLE customer AUTO_INCREMENT = 1;
ALTER TABLE gate AUTO_INCREMENT = 1;
ALTER TABLE station AUTO_INCREMENT = 1;
ALTER TABLE vehicle_location AUTO_INCREMENT = 1;
ALTER TABLE vehicle AUTO_INCREMENT = 1;
ALTER TABLE location AUTO_INCREMENT = 1;
ALTER TABLE address AUTO_INCREMENT = 1;
ALTER TABLE user AUTO_INCREMENT = 1;

-- Station
INSERT INTO location VALUES (DEFAULT, 52.202710, 20.967802);
INSERT INTO address VALUES (DEFAULT, 'ul. Korotyńskiego', '17', null, '00-100', 'Warszawa', 'mazowieckie', 'Polska');
INSERT INTO station VALUES (DEFAULT, 'MAZ-1', 'Stacja przeładunkowa', 1, 1);
INSERT INTO location VALUES (DEFAULT, 50.025711, 19.979616);
INSERT INTO address VALUES (DEFAULT, 'ul. Braterska', '10', null, '00-100', 'Kraków', 'małopolskie', 'Polska');
INSERT INTO station VALUES (DEFAULT, 'MAL-1', 'Stacja przeładunkowa', 2, 2);
INSERT INTO location VALUES (DEFAULT, 52.164065, 22.276325);
INSERT INTO address VALUES (DEFAULT, 'ul. Jana Kilińskiego', '21', '3', '00-100', 'Siedlce', 'mazowieckie', 'Polska');
INSERT INTO station VALUES (DEFAULT, 'MAZ-2', 'Stacja przeładunkowa', 3, 3);
INSERT INTO location VALUES (DEFAULT, 52.403789, 16.922475);
INSERT INTO address VALUES (DEFAULT, 'ul. Powstańców Wielkopolskich', '5', '4', '00-100', 'Poznań', 'wielkopolskie', 'Polska');
INSERT INTO station VALUES (DEFAULT, 'WLK-1', 'Stacja przeładunkowa', 4, 4);
INSERT INTO location VALUES (DEFAULT, 51.113252, 17.011495);
INSERT INTO address VALUES (DEFAULT, 'ul. Kruszwicka', '2', '5', '00-100', 'Wrocław', 'dolnośląskie', 'Polska');
INSERT INTO station VALUES (DEFAULT, 'DLN-1', 'Stacja przeładunkowa', 5, 5);
INSERT INTO location VALUES (DEFAULT, 50.866750, 20.640581);
INSERT INTO address VALUES (DEFAULT, 'ul. Zagórska', '24', '6', '00-100', 'Kielce', 'świętokrzyskie', 'Polska');
INSERT INTO station VALUES (DEFAULT, 'SWT-1', 'Stacja przeładunkowa', 6, 6);
INSERT INTO location VALUES (DEFAULT, 51.408641, 21.146484);
INSERT INTO address VALUES (DEFAULT, 'ul. Stanisława Wernera', '10', '7', '00-100', 'Radom', 'mazowieckie', 'Polska');
INSERT INTO station VALUES (DEFAULT, 'MAZ-3', 'Stacja nadawcza', 7, 7);
INSERT INTO location VALUES (DEFAULT, 49.299063, 19.950048);
INSERT INTO address VALUES (DEFAULT, 'ul. Nowatorska', '10c', '8', '00-100', 'Zakopane', 'małopolskie', 'Polska');
INSERT INTO station VALUES (DEFAULT, 'MAL-2', 'Stacja nadawcza', 8, 8);
INSERT INTO location VALUES (DEFAULT, 53.132228, 23.150875);
INSERT INTO address VALUES (DEFAULT, 'ul. Grochowa', '4', '9', '00-100', 'Białystok', 'podlaskie', 'Polska');
INSERT INTO station VALUES (DEFAULT, 'PDL-1', 'Stacja nadawcza', 9, 9);
INSERT INTO location VALUES (DEFAULT, 54.350704, 18.648957);
INSERT INTO address VALUES (DEFAULT, 'ul. Targ Węglowy', '6', '10', '00-100', 'Gdańsk', 'pomorskie', 'Polska');
INSERT INTO station VALUES (DEFAULT, 'PMR-1', 'Stacja nadawcza', 10, 10);

-- Gate
INSERT INTO gate VALUES (DEFAULT, 1, 'Bramka wejściowa nr 1', 'IN');
INSERT INTO gate VALUES (DEFAULT, 1, 'Bramka wejściowa nr 2', 'IN');
INSERT INTO gate VALUES (DEFAULT, 1, 'Bramka wejściowa nr 3', 'IN');
INSERT INTO gate VALUES (DEFAULT, 1, 'Bramka wyjściowa nr 1', 'OUT');
INSERT INTO gate VALUES (DEFAULT, 1, 'Bramka wyjściowa nr 2', 'OUT');
INSERT INTO gate VALUES (DEFAULT, 1, 'Bramka wyjściowa nr 3', 'OUT');

INSERT INTO gate VALUES (DEFAULT, 2, 'Bramka wejściowa nr 1', 'IN');
INSERT INTO gate VALUES (DEFAULT, 2, 'Bramka wejściowa nr 2', 'IN');
INSERT INTO gate VALUES (DEFAULT, 2, 'Bramka wejściowa nr 3', 'IN');
INSERT INTO gate VALUES (DEFAULT, 2, 'Bramka wyjściowa nr 1', 'OUT');
INSERT INTO gate VALUES (DEFAULT, 2, 'Bramka wyjściowa nr 2', 'OUT');
INSERT INTO gate VALUES (DEFAULT, 2, 'Bramka wyjściowa nr 3', 'OUT');

INSERT INTO gate VALUES (DEFAULT, 3, 'Bramka wejściowa nr 1', 'IN');
INSERT INTO gate VALUES (DEFAULT, 3, 'Bramka wejściowa nr 2', 'IN');
INSERT INTO gate VALUES (DEFAULT, 3, 'Bramka wejściowa nr 3', 'IN');
INSERT INTO gate VALUES (DEFAULT, 3, 'Bramka wyjściowa nr 1', 'OUT');
INSERT INTO gate VALUES (DEFAULT, 3, 'Bramka wyjściowa nr 2', 'OUT');
INSERT INTO gate VALUES (DEFAULT, 3, 'Bramka wyjściowa nr 3', 'OUT');

INSERT INTO gate VALUES (DEFAULT, 4, 'Bramka wejściowa nr 1', 'IN');
INSERT INTO gate VALUES (DEFAULT, 4, 'Bramka wejściowa nr 2', 'IN');
INSERT INTO gate VALUES (DEFAULT, 4, 'Bramka wejściowa nr 3', 'IN');
INSERT INTO gate VALUES (DEFAULT, 4, 'Bramka wyjściowa nr 1', 'OUT');
INSERT INTO gate VALUES (DEFAULT, 4, 'Bramka wyjściowa nr 2', 'OUT');
INSERT INTO gate VALUES (DEFAULT, 4, 'Bramka wyjściowa nr 3', 'OUT');

INSERT INTO gate VALUES (DEFAULT, 5, 'Bramka wejściowa nr 1', 'IN');
INSERT INTO gate VALUES (DEFAULT, 5, 'Bramka wejściowa nr 2', 'IN');
INSERT INTO gate VALUES (DEFAULT, 5, 'Bramka wejściowa nr 3', 'IN');
INSERT INTO gate VALUES (DEFAULT, 5, 'Bramka wyjściowa nr 1', 'OUT');
INSERT INTO gate VALUES (DEFAULT, 5, 'Bramka wyjściowa nr 2', 'OUT');
INSERT INTO gate VALUES (DEFAULT, 5, 'Bramka wyjściowa nr 3', 'OUT');

INSERT INTO gate VALUES (DEFAULT, 6, 'Bramka wejściowa nr 1', 'IN');
INSERT INTO gate VALUES (DEFAULT, 6, 'Bramka wejściowa nr 2', 'IN');
INSERT INTO gate VALUES (DEFAULT, 6, 'Bramka wejściowa nr 3', 'IN');
INSERT INTO gate VALUES (DEFAULT, 6, 'Bramka wyjściowa nr 1', 'OUT');
INSERT INTO gate VALUES (DEFAULT, 6, 'Bramka wyjściowa nr 2', 'OUT');
INSERT INTO gate VALUES (DEFAULT, 6, 'Bramka wyjściowa nr 3', 'OUT');

INSERT INTO gate VALUES (DEFAULT, 7, 'Bramka wejściowa nr 1', 'IN');
INSERT INTO gate VALUES (DEFAULT, 7, 'Bramka wyjściowa nr 1', 'OUT');
INSERT INTO gate VALUES (DEFAULT, 8, 'Bramka wejściowa nr 1', 'IN');
INSERT INTO gate VALUES (DEFAULT, 8, 'Bramka wyjściowa nr 1', 'OUT');
INSERT INTO gate VALUES (DEFAULT, 9, 'Bramka wejściowa nr 1', 'IN');
INSERT INTO gate VALUES (DEFAULT, 9, 'Bramka wyjściowa nr 1', 'OUT');
INSERT INTO gate VALUES (DEFAULT, 10, 'Bramka wejściowa nr 1', 'IN');
INSERT INTO gate VALUES (DEFAULT, 10, 'Bramka wyjściowa nr 1', 'OUT');

-- Customer
INSERT INTO address VALUES (DEFAULT, 'Al. Jerozolimskie', '11', '11', '00-100', 'Lublin', 'lubelskie', 'Polska');
INSERT INTO customer VALUES (DEFAULT, 'Ireneusz', 'Sikora', '512-838-661', 11, 'SEDKOMP Sp. Jawna Sawicki, Sikora');

INSERT INTO address VALUES (DEFAULT, 'ul. Jezuitów', '12', '12', '00-100', 'Lublin', 'lubelskie', 'Polska');
INSERT INTO customer VALUES (DEFAULT, 'Zdzisław', 'Sawicki', '512-838-662', 12, 'ENIGMA');

INSERT INTO address VALUES (DEFAULT, 'ul. Dworska', '13', '13', '00-100', 'Lublin', 'lubelskie', 'Polska');
INSERT INTO customer VALUES (DEFAULT, 'Konrad', 'Wysokiński', '512-838-663', 13, 'TRITON');

INSERT INTO address VALUES (DEFAULT, 'ul. Wawelska', '14', '14', '00-100', 'Lublin', 'lubelskie', 'Polska');
INSERT INTO customer VALUES (DEFAULT, 'Jan', 'Nowak', '512-838-664', 14, 'DOLCAN');

INSERT INTO address VALUES (DEFAULT, 'ul. Zawiszy Czarnego', '15', '15', '00-100', 'Lublin', 'lubelskie', 'Polska');
INSERT INTO customer VALUES (DEFAULT, 'Eugeniusz', 'Turski', '512-838-665', 15, 'NETIA S.A.');

INSERT INTO address VALUES (DEFAULT, 'ul. Bartnicka', '16', '16', '00-100', 'Lublin', 'lubelskie', 'Polska');
INSERT INTO customer VALUES (DEFAULT, 'Franciszek', 'Jerzykowski', '512-838-666', 16, null);

INSERT INTO address VALUES (DEFAULT, 'ul. Krzyżaków', '17', '17', '00-100', 'Lublin', 'lubelskie', 'Polska');
INSERT INTO customer VALUES (DEFAULT, 'Stanisław', 'Jerzykowski', '512-838-667', 17, null);

INSERT INTO address VALUES (DEFAULT, 'ul. gen. J. Sosnowskiego', '18', '18', '00-100', 'Lublin', 'lubelskie', 'Polska');
INSERT INTO customer VALUES (DEFAULT, 'Tadeusz', 'Sznuk', '512-838-668', 18, 'Biedronka 1');

INSERT INTO address VALUES (DEFAULT, 'ul. Jutrzenki', '19', '19', '00-100', 'Lublin', 'lubelskie', 'Polska');
INSERT INTO customer VALUES (DEFAULT, 'Adam', 'Konewka', '512-838-669', 19, null);

INSERT INTO address VALUES (DEFAULT, 'ul. Łopuszańska', '20', '20', '00-100', 'Lublin', 'lubelskie', 'Polska');
INSERT INTO customer VALUES (DEFAULT, 'Bartosz', 'Sałata', '512-838-670', 20, 'COMP S.A.');

-- User
INSERT INTO user VALUES (DEFAULT, 'adam.turski1@gmail.com', TRUE, 'ADMINISTRATOR', 'Adam', 'Turski');
INSERT INTO user VALUES (DEFAULT, 'sylwekqaz@gmail.com', TRUE, 'EMPLOYEE', 'Sylwester', 'Turski');
INSERT INTO user VALUES (DEFAULT, 'sylwekqaz19@gmail.com', TRUE, 'USER', 'Sylwester', 'Turski');

-- Shipment
INSERT INTO shipment VALUES (DEFAULT, 10, 1, 2, null, '2014-07-01 10:50:26', null, 'ACCEPTED');
INSERT INTO shipment VALUES (DEFAULT, 9, 2, 2, null, '2014-07-01 11:50:26', null, 'ACCEPTED');
INSERT INTO shipment VALUES (DEFAULT, 8, 3, 2, null, '2014-07-02 08:50:26', null, 'ACCEPTED');
INSERT INTO shipment VALUES (DEFAULT, 7, 4, 2, null, '2014-07-02 09:50:26', null, 'ACCEPTED');

INSERT INTO shipment VALUES (DEFAULT, 6, 5, 2, null, '2014-07-02 09:50:26', null, 'ON_THE_WAY');
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 10:00:26', 5, 37);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 11:01:00', 5, 38);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 12:00:00', 5, 1);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 13:00:00', 5, 4);

INSERT INTO shipment VALUES (DEFAULT, 5, 6, 2, null, '2014-07-02 11:50:26', null, 'IN_STATION');
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 12:00:26', 6, 39);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 13:00:00', 6, 40);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 14:00:00', 6, 8);

INSERT INTO shipment VALUES (DEFAULT, 4, 7, 2, 2, '2014-07-02 11:50:26', null, 'IN_SERVICE');
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 12:00:26', 7, 41);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 13:00:00', 7, 42);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 14:00:00', 7, 14);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 15:00:00', 7, 17);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 16:00:00', 7, 19);

INSERT INTO shipment VALUES (DEFAULT, 3, 8, 2, 2, '2014-07-02 11:50:26', '2014-07-02 20:50:26', 'DELIVERED');
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 12:00:26', 8, 43);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 13:00:00', 8, 44);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 14:00:00', 8, 19);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 15:00:00', 8, 22);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 16:00:00', 8, 25);

INSERT INTO vehicle VALUES (DEFAULT, 'FLT-1 (1)', 'Flota 1 Samochód 1');
INSERT INTO location VALUES (DEFAULT, 52.202710, 20.967802);
INSERT INTO vehicle_location VALUES (DEFAULT, 1, 11, CURRENT_TIMESTAMP);
INSERT INTO location VALUES (DEFAULT, 52.202710, 20.967812);
INSERT INTO vehicle_location VALUES (DEFAULT, 1, 12, CURRENT_TIMESTAMP);
INSERT INTO location VALUES (DEFAULT, 52.202710, 20.967822);
INSERT INTO vehicle_location VALUES (DEFAULT, 1, 13, CURRENT_TIMESTAMP);
INSERT INTO location VALUES (DEFAULT, 52.202710, 20.967832);
INSERT INTO vehicle_location VALUES (DEFAULT, 1, 14, CURRENT_TIMESTAMP);
INSERT INTO location VALUES (DEFAULT, 52.202710, 20.967842);
INSERT INTO vehicle_location VALUES (DEFAULT, 1, 15, CURRENT_TIMESTAMP);

INSERT INTO vehicle VALUES (DEFAULT, 'FLT-1 (2)', 'Flota 1 Samochód 2');
INSERT INTO location VALUES (DEFAULT, 52.201710, 20.967802);
INSERT INTO vehicle_location VALUES (DEFAULT, 2, 16, CURRENT_TIMESTAMP);
INSERT INTO location VALUES (DEFAULT, 52.202710, 20.967812);
INSERT INTO vehicle_location VALUES (DEFAULT, 2, 17, CURRENT_TIMESTAMP);
INSERT INTO location VALUES (DEFAULT, 52.203710, 20.967822);
INSERT INTO vehicle_location VALUES (DEFAULT, 2, 18, CURRENT_TIMESTAMP);
INSERT INTO location VALUES (DEFAULT, 52.204710, 20.967832);
INSERT INTO vehicle_location VALUES (DEFAULT, 2, 19, CURRENT_TIMESTAMP);
INSERT INTO location VALUES (DEFAULT, 52.205710, 20.967842);
INSERT INTO vehicle_location VALUES (DEFAULT, 2, 20, CURRENT_TIMESTAMP);

INSERT INTO vehicle VALUES (DEFAULT, 'FLT-1 (3)', 'Flota 1 Samochód 3');
INSERT INTO location VALUES (DEFAULT, 52.201710, 20.967002);
INSERT INTO vehicle_location VALUES (DEFAULT, 3, 21, CURRENT_TIMESTAMP);
INSERT INTO location VALUES (DEFAULT, 52.202810, 20.967112);
INSERT INTO vehicle_location VALUES (DEFAULT, 3, 22, CURRENT_TIMESTAMP);
INSERT INTO location VALUES (DEFAULT, 52.203910, 20.967222);
INSERT INTO vehicle_location VALUES (DEFAULT, 3, 23, CURRENT_TIMESTAMP);
INSERT INTO location VALUES (DEFAULT, 52.204010, 20.967332);
INSERT INTO vehicle_location VALUES (DEFAULT, 3, 24, CURRENT_TIMESTAMP);
INSERT INTO location VALUES (DEFAULT, 52.205110, 20.967442);
INSERT INTO vehicle_location VALUES (DEFAULT, 3, 25, CURRENT_TIMESTAMP);

