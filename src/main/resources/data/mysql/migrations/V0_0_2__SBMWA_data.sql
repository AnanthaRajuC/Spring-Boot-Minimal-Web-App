/*
 * Engine: MySQL
 * Version: 0.0.1
 * Description: Sample Data
 */

--
-- Data for table `address`
--

INSERT INTO `address` (`city`,`zipcode`) VALUES ('address one','101-101');
INSERT INTO `address` (`city`,`zipcode`) VALUES ('address two','102-102');
INSERT INTO `address` (`city`,`zipcode`) VALUES ('address three','103-103');

--
-- Data for table `person`
--

INSERT INTO `person` (`name`,`email`,`mobile_number`,`address_id`) VALUES ('John','example1@domain.com','111',1);
INSERT INTO `person` (`name`,`email`,`mobile_number`,`address_id`) VALUES ('Jane','example2@domain.com','111',2);
INSERT INTO `person` (`name`,`email`,`mobile_number`,`address_id`) VALUES ('Johnny','example3@domain.com','3333333333',3);

--
-- Data for table `books`
--

INSERT INTO `books` (`title`,`person_id`) VALUES ('user1-book1',1);
INSERT INTO `books` (`title`,`person_id`) VALUES ('user1-book2',1);
INSERT INTO `books` (`title`,`person_id`) VALUES ('user2-book1',2);
--
-- Data for table `orders`
--

INSERT INTO `movies` (`movie_details`,`person_id`) VALUES ('user1-movie-1',1);
INSERT INTO `movies` (`movie_details`,`person_id`) VALUES ('user2-movie-2',2);
