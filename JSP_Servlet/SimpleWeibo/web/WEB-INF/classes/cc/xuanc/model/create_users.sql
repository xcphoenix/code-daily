CREATE TABLE IF NOT EXISTS `users` (
                                     `username` VARCHAR(16) NOT NULL,
                                     `password` VARCHAR(16) NOT NULL,
                                     `email` VARCHAR(16) NOT NULL,
                                     PRIMARY KEY (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
