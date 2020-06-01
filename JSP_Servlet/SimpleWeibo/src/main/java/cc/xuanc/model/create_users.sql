# CREATE DATABASE IF NOT EXISTS `SimpleWeibo`;
# USE `SimpleWeibo`;
CREATE TABLE IF NOT EXISTS `user_data`
(
	`user_id`  INT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(16) NOT NULL UNIQUE ,
	`password` VARCHAR(16) NOT NULL,
	`email`    VARCHAR(16) NOT NULL,
	PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE IF NOT EXISTS `message`
(
	`message_id` INT NOT NULL AUTO_INCREMENT,
	`author_id` INT NOT NULL,
	`message_context` VARCHAR(234) NOT NULL,
	`message_time`INT NOT NULL,
	PRIMARY KEY (`message_id`),
	FOREIGN KEY (`author_id`) REFERENCES `user_data`(`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
