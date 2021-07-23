/*
 * Engine: MySQL
 * Version: 0.0.1
 * Description: Sample Data
 */

--
-- Data for table `address`
--

INSERT INTO `address` (`city`,`zipcode`) VALUES ('Wisokyburghh','90565-7771');
INSERT INTO `address` (`city`,`zipcode`) VALUES ('Wisokyburgh','90565-777');

--
-- Data for table `person`
--

INSERT INTO `person` (`name`,`email`,`mobile_number`,`address_id`) VALUES ('John','example1@domain.com','1234567890',1);
INSERT INTO `person` (`name`,`email`,`mobile_number`,`address_id`) VALUES ('Jane','example2@domain.com','1234567891',2);

--
-- Data for table `books`
--

INSERT INTO `books` (`title`,`person_id`) VALUES ('book21',1);
INSERT INTO `books` (`title`,`person_id`) VALUES ('book11',1);

--
-- Data for table `orders`
--

INSERT INTO `movies` (`movie_details`,`person_id`) VALUES ('movie-1',1);
INSERT INTO `movies` (`movie_details`,`person_id`) VALUES ('movie-2',1);
