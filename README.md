# SportsManagementThesis
Thesis

CREATE DATABASE  IF NOT EXISTS `sports`;
USE `sports`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` varchar(50) NOT NULL ,
  `email` char(80) NOT NULL , 
  `last_name` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,

  PRIMARY KEY (`user_id`,`role_id`),

  KEY `FK_ROLE_idx` (`role_id`),

  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`user_id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `role` (`role_id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `tournament`;
CREATE TABLE `tournament` (
   `tournament_id` int NOT NULL AUTO_INCREMENT,
   `tournament_name` varchar(50) NOT NULL,
   `stadium_name` varchar(50) NOT NULL,
   `city` varchar(30) NOT NULL,
   `address` varchar(50) NOT NULL,
   `reward` varchar(20) NOT NULL,
   `date_start` date NOT NULL,
   `number_of_teams` int NOT NULL,
    PRIMARY KEY (`tournament_id`)
)   ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
	`team_id` int NOT NULL AUTO_INCREMENT,
	`team_name` varchar(40) NOT NULL,
  `number_of_players` int NOT NULL,
  `shirt_color` varchar(30) NOT NULL,
	`user_id` int NOT NULL,
	 PRIMARY KEY (`team_id`),
	 CONSTRAINT `FK_USER_TEAM` FOREIGN KEY (`user_id`) 
	 REFERENCES `user` (`user_id`) 
)    ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `tournament_teams` (
  `team_id` int(11) NOT NULL,
  `tournament_id` int(11) NOT NULL,

  PRIMARY KEY (`team_id`,`tournament_id`),

  KEY `FK_TEAM_idx` (`team_id`),

  CONSTRAINT `FK_TOURNAMENT` FOREIGN KEY (`tournament_id`) 
  REFERENCES `tournament` (`tournament_id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT `FK_TEAM` FOREIGN KEY (`team_id`) 
  REFERENCES `team` (`team_id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `role` (role_id, role)
Values 
(1, 'USER'),
(2, 'ADMIN');
