INSERT INTO `microservices`.`user` (`email`, `first_name`, `last_name`) VALUES ('jn@wp.pl', 'Jan', 'Nowak');
INSERT INTO `microservices`.`user` (`email`, `first_name`, `last_name`) VALUES ('sk@gmail.com', 'Stefan', 'Kowalski');
INSERT INTO `microservices`.`task` (`completed`, `description`, `user_id`) VALUES (0, 'task1', 1);
INSERT INTO `microservices`.`task` (`completed`, `completion_percentage`, `description`, `user_id`) VALUES (0, 50, 'task1', 2);
INSERT INTO `microservices`.`task` (`completed`, `completion_percentage`, `user_id`) VALUES (0, 20, 'task3', 1);