USE trak;

DELETE FROM shipment_movement;
DELETE FROM shipment;
DELETE FROM customer;
DELETE FROM vehicle_location;
DELETE FROM vehicle;
DELETE FROM gate;
DELETE FROM station;
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
INSERT INTO address VALUES (DEFAULT, 'Warszawa', 'Polska', '17', '10', '00-100', 'mazowieckie', 'ul. Korotyńskiego');
INSERT INTO station VALUES (DEFAULT, 'Stacja przeładunkowa', 'MAZ-1', 1, 1);
INSERT INTO location VALUES (DEFAULT, 50.025711, 19.979616);
INSERT INTO address VALUES (DEFAULT, 'Kraków', 'Polska', '10', '10', '00-100', 'małopolskie', 'ul. Braterska');
INSERT INTO station VALUES (DEFAULT, 'Stacja przeładunkowa', 'MAL-1', 2, 2);
INSERT INTO location VALUES (DEFAULT, 52.164065, 22.276325);
INSERT INTO address VALUES (DEFAULT, 'Siedlce', 'Polska', '21', '3', '00-100', 'mazowieckie', 'ul. Jana Kilińskiego');
INSERT INTO station VALUES (DEFAULT, 'Stacja przeładunkowa', 'MAZ-2', 3, 3);
INSERT INTO location VALUES (DEFAULT, 52.403789, 16.922475);
INSERT INTO address VALUES (DEFAULT, 'Poznań', 'Polska', '5', '4', '00-100', 'wielkopolskie', 'ul. Powstańców Wielkopolskich');
INSERT INTO station VALUES (DEFAULT, 'Stacja przeładunkowa', 'WLK-1', 4, 4);
INSERT INTO location VALUES (DEFAULT, 51.113252, 17.011495);
INSERT INTO address VALUES (DEFAULT, 'Wrocław', 'Polska', '2', '5', '00-100', 'dolnośląskie', 'ul. Kruszwicka');
INSERT INTO station VALUES (DEFAULT, 'Stacja przeładunkowa', 'DLN-1', 5, 5);
INSERT INTO location VALUES (DEFAULT, 50.866750, 20.640581);
INSERT INTO address VALUES (DEFAULT, 'Kielce', 'Polska', '24', '6', '00-100', 'dolnośląskie', 'ul. Zagórska');
INSERT INTO station VALUES (DEFAULT, 'Stacja przeładunkowa', 'SWT-1', 6, 6);
INSERT INTO location VALUES (DEFAULT, 51.408641, 21.146484);
INSERT INTO address VALUES (DEFAULT, 'Radom', 'Polska', '10', '7', '00-100', 'mazowieckie', 'ul. Stanisława Wernera');
INSERT INTO station VALUES (DEFAULT, 'Stacja nadawcza', 'MAZ-3', 7, 7);
INSERT INTO location VALUES (DEFAULT, 49.299063, 19.950048);
INSERT INTO address VALUES (DEFAULT, 'Zakopane', 'Polska', '10c', '8', '00-100', 'małopolskie', 'ul. Nowatorska');
INSERT INTO station VALUES (DEFAULT, 'Stacja nadawcza', 'MAL-2', 8, 8);
INSERT INTO location VALUES (DEFAULT, 53.132228, 23.150875);
INSERT INTO address VALUES (DEFAULT, 'Białystok', 'Polska', '4', '9', '00-100', 'podlaskie', 'ul. Grochowa');
INSERT INTO station VALUES (DEFAULT, 'Stacja nadawcza', 'PDL-1', 9, 9);
INSERT INTO location VALUES (DEFAULT, 54.350704, 18.648957);
INSERT INTO address VALUES (DEFAULT, 'Gdańsk', 'Polska', '6', '10', '00-100', 'pomorskie', 'ul. Targ Węglowy');
INSERT INTO station VALUES (DEFAULT, 'Stacja nadawcza', 'PMR-1', 10, 10);

-- Gate
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 1', 'STATION_IN', 1);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 2', 'STATION_IN', 1);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 3', 'STATION_IN', 1);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 1', 'STATION_OUT', 1);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 2', 'STATION_OUT', 1);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 3', 'STATION_OUT', 1);

INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 1', 'STATION_IN', 2);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 2', 'STATION_IN', 2);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 3', 'STATION_IN', 2);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 1', 'STATION_OUT', 2);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 2', 'STATION_OUT', 2);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 3', 'STATION_OUT', 2);

INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 1', 'STATION_IN', 3);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 2', 'STATION_IN', 3);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 3', 'STATION_IN', 3);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 1', 'STATION_OUT', 3);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 2', 'STATION_OUT', 3);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 3', 'STATION_OUT', 3);

INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 1', 'STATION_IN', 4);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 2', 'STATION_IN', 4);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 3', 'STATION_IN', 4);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 1', 'STATION_OUT', 4);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 2', 'STATION_OUT', 4);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 3', 'STATION_OUT', 4);

INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 1', 'STATION_IN', 5);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 2', 'STATION_IN', 5);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 3', 'STATION_IN', 5);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 1', 'STATION_OUT', 5);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 2', 'STATION_OUT', 5);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 3', 'STATION_OUT', 5);

INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 1', 'STATION_IN', 6);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 2', 'STATION_IN', 6);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 3', 'STATION_IN', 6);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 1', 'STATION_OUT', 6);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 2', 'STATION_OUT', 6);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 3', 'STATION_OUT', 6);

INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 1', 'STATION_IN', 7);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 1', 'STATION_OUT', 7);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 1', 'STATION_IN', 8);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 1', 'STATION_OUT', 8);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 1', 'STATION_IN', 9);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 1', 'STATION_OUT', 9);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wejściowa nr 1', 'STATION_IN', 10);
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 1', 'STATION_OUT', 10);

-- Customer
INSERT INTO address VALUES (DEFAULT, 'Lublin', 'Polska', '11', '11', '00-100', 'lubelskie', 'Al. Jerozolimskie');
INSERT INTO customer VALUES (DEFAULT, 'SEDKOMP Sp. Jawna Sawicki, Sikora', 'Ireneusz', '512-838-661', 'Sikora', 11);

INSERT INTO address VALUES (DEFAULT, 'Lublin', 'Polska', '12', '12', '00-100', 'lubelskie', 'ul. Jezuitów');
INSERT INTO customer VALUES (DEFAULT, 'ENIGMA', 'Zdzisław', '512-838-662', 'Sawicki', 12);

INSERT INTO address VALUES (DEFAULT, 'Lublin', 'Polska', '13', '13', '00-100', 'lubelskie', 'ul. Dworska');
INSERT INTO customer VALUES (DEFAULT, 'TRITON', 'Konrad', '512-838-663', 'Wysokiński', 13);

INSERT INTO address VALUES (DEFAULT, 'Lublin', 'Polska', '14', '14', '00-100', 'lubelskie', 'ul. Wawelska');
INSERT INTO customer VALUES (DEFAULT, 'DOLCAN', 'Jan', '512-838-664', 'Nowak', 14);

INSERT INTO address VALUES (DEFAULT, 'Lublin', 'Polska', '15', '15', '00-100', 'lubelskie', 'ul. Zawiszy Czarnego');
INSERT INTO customer VALUES (DEFAULT, 'NETIA S.A.', 'Eugeniusz', '512-838-665', 'Turski', 15);

INSERT INTO address VALUES (DEFAULT, 'Lublin', 'Polska', '16', '16', '00-100', 'lubelskie', 'ul. Bartnicka');
INSERT INTO customer VALUES (DEFAULT, null, 'Franciszek', '512-838-666', 'Jerzykowski', 16);

INSERT INTO address VALUES (DEFAULT, 'Lublin', 'Polska', '17', '17', '00-100', 'lubelskie', 'ul. Krzyżaków');
INSERT INTO customer VALUES (DEFAULT, null, 'Stanisław', '512-838-667', 'Jerzykowski', 17);

INSERT INTO address VALUES (DEFAULT, 'Lublin', 'Polska', '18', '18', '00-100', 'lubelskie', 'ul. gen. J. Sosnowskiego');
INSERT INTO customer VALUES (DEFAULT, 'Biedronka 1', 'Tadeusz', '512-838-668', 'Sznuk', 18);

INSERT INTO address VALUES (DEFAULT, 'Lublin', 'Polska', '19', '19', '00-100', 'lubelskie', 'ul. Jutrzenki');
INSERT INTO customer VALUES (DEFAULT, null, 'Adam', '512-838-669', 'Konewka', 19);

INSERT INTO address VALUES (DEFAULT, 'Lublin', 'Polska', '20', '20', '00-100', 'lubelskie', 'ul. Łopuszańska');
INSERT INTO customer VALUES (DEFAULT, 'COMP S.A.', 'Bartosz', '512-838-670', 'Sałata', 20);

-- User
INSERT INTO trak.user VALUES (DEFAULT, 'adam.turski1@gmail.com', TRUE, 'Adam', 'ADMINISTRATOR', 'Turski');
INSERT INTO trak.user VALUES (DEFAULT, 'sylwekqaz@gmail.com', TRUE, 'Sylwester', 'EMPLOYEE', 'Turski');
INSERT INTO trak.user VALUES (DEFAULT, 'sylwekqaz19@gmail.com', TRUE, 'Sylwester', 'USER', 'Turski');

-- Shipment
INSERT INTO shipment VALUES (DEFAULT, '2014-07-01 10:50:26', null, 'ACCEPTED', 2, null, 10, 1);
INSERT INTO shipment VALUES (DEFAULT, '2014-07-01 11:50:26', null, 'ACCEPTED', 2, null, 9, 2);
INSERT INTO shipment VALUES (DEFAULT, '2014-07-02 08:50:26', null, 'ACCEPTED', 2, null, 8, 3);
INSERT INTO shipment VALUES (DEFAULT, '2014-07-02 09:50:26', null, 'ACCEPTED', 2, null, 7, 4);

INSERT INTO shipment VALUES (DEFAULT, '2014-07-02 09:50:26', null, 'ON_THE_WAY', 2, null, 6, 5);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 10:00:26', 37, 5);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 11:01:00', 38, 5);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 12:00:00', 1, 5);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 13:00:00', 4, 5);

INSERT INTO shipment VALUES (DEFAULT, '2014-07-02 11:50:26', null, 'IN_STATION', 2, null, 5, 6);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 12:00:26', 39, 6);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 13:00:00', 40, 6);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 14:00:00', 8, 6);

INSERT INTO shipment VALUES (DEFAULT, '2014-07-02 11:50:26', null, 'IN_SERVICE', 2, null, 4, 7);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 12:00:26', 41, 7);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 13:00:00', 42, 7);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 14:00:00', 14, 7);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 15:00:00', 17, 7);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 16:00:00', 19, 7);

INSERT INTO shipment VALUES (DEFAULT, '2014-07-02 11:50:26', '2014-07-02 20:50:26', 'DELIVERED', 2, 2, 4, 7);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 12:00:26', 43, 8);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 13:00:00', 44, 8);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 14:00:00', 19, 8);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 15:00:00', 22, 8);
INSERT INTO shipment_movement VALUES (DEFAULT, '2014-07-02 16:00:00', 25, 8);

-- Vehicle
INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 1', 'VEHICLE', NULL);
INSERT INTO vehicle VALUES (DEFAULT, 'Flota 1 Samochód 1', 'FLT-1 (1)', 43);
INSERT INTO location VALUES (DEFAULT, 52.202710, 20.967802);
INSERT INTO vehicle_location VALUES (DEFAULT, CURRENT_TIMESTAMP, 11, 1);
INSERT INTO location VALUES (DEFAULT, 52.202710, 20.967812);
INSERT INTO vehicle_location VALUES (DEFAULT, CURRENT_TIMESTAMP, 12, 1);
INSERT INTO location VALUES (DEFAULT, 52.202710, 20.967822);
INSERT INTO vehicle_location VALUES (DEFAULT, CURRENT_TIMESTAMP, 13, 1);
INSERT INTO location VALUES (DEFAULT, 52.202710, 20.967832);
INSERT INTO vehicle_location VALUES (DEFAULT, CURRENT_TIMESTAMP, 14, 1);
INSERT INTO location VALUES (DEFAULT, 52.202710, 20.967842);
INSERT INTO vehicle_location VALUES (DEFAULT, CURRENT_TIMESTAMP, 15, 1);

INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 1', 'VEHICLE', NULL);
INSERT INTO vehicle VALUES (DEFAULT, 'Flota 1 Samochód 2', 'FLT-1 (2)', 44);
INSERT INTO location VALUES (DEFAULT, 52.201710, 20.967802);
INSERT INTO vehicle_location VALUES (DEFAULT, CURRENT_TIMESTAMP, 16, 2);
INSERT INTO location VALUES (DEFAULT, 52.202710, 20.967812);
INSERT INTO vehicle_location VALUES (DEFAULT, CURRENT_TIMESTAMP, 17, 2);
INSERT INTO location VALUES (DEFAULT, 52.203710, 20.967822);
INSERT INTO vehicle_location VALUES (DEFAULT, CURRENT_TIMESTAMP, 18, 2);
INSERT INTO location VALUES (DEFAULT, 52.204710, 20.967832);
INSERT INTO vehicle_location VALUES (DEFAULT, CURRENT_TIMESTAMP, 19, 2);
INSERT INTO location VALUES (DEFAULT, 52.205710, 20.967842);
INSERT INTO vehicle_location VALUES (DEFAULT, CURRENT_TIMESTAMP, 20, 2);

INSERT INTO gate VALUES (DEFAULT, 'Bramka wyjściowa nr 1', 'VEHICLE', NULL);
INSERT INTO vehicle VALUES (DEFAULT, 'Flota 1 Samochód 3', 'FLT-1 (3)', 45);
INSERT INTO location VALUES (DEFAULT, 52.201710, 20.967002);
INSERT INTO vehicle_location VALUES (DEFAULT, CURRENT_TIMESTAMP, 21, 3);
INSERT INTO location VALUES (DEFAULT, 52.202810, 20.967112);
INSERT INTO vehicle_location VALUES (DEFAULT, CURRENT_TIMESTAMP, 22, 3);
INSERT INTO location VALUES (DEFAULT, 52.203910, 20.967222);
INSERT INTO vehicle_location VALUES (DEFAULT, CURRENT_TIMESTAMP, 23, 3);
INSERT INTO location VALUES (DEFAULT, 52.204010, 20.967332);
INSERT INTO vehicle_location VALUES (DEFAULT, CURRENT_TIMESTAMP, 24, 3);
INSERT INTO location VALUES (DEFAULT, 52.205110, 20.967442);
INSERT INTO vehicle_location VALUES (DEFAULT, CURRENT_TIMESTAMP, 25, 3);

