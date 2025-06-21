DROP SCHEMA IF EXISTS `todo_app`;
CREATE SCHEMA `todo_app`;

USE `todo_app`;

CREATE TABLE `task` (
  `id` int NOT NULL AUTO_INCREMENT,
  `completed` bit(1) NOT NULL,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `task` VALUES 
	(1,0,'Task 1'),
	(2,0,'Task 2'),
    (3,0,'Task 3');