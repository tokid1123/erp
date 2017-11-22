CREATE TABLE `user` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`code` varchar(255) NULL,
`state` int(11) NULL,
`name` varchar(255) NULL,
`create_by` bigint(20) NULL,
`update_by` bigint(20) NULL,
`create_time` date NULL,
`update_time` date NULL,
`password` varchar(255) NULL,
`username` varchar(255) NULL,
`email` varchar(255) NULL,
`mobile` varchar(255) NULL,
`image` varchar(255) NULL,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8
AUTO_INCREMENT=1;

CREATE TABLE `user_property` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`code` varchar(255) NULL,
`state` int(11) NULL,
`name` varchar(255) NULL,
`create_by` bigint(20) NULL,
`update_by` bigint(20) NULL,
`create_time` date NULL,
`update_time` date NULL,
`user_id` bigint(20) NULL,
`property_id` bigint(20) NULL,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8
AUTO_INCREMENT=1;

CREATE TABLE `property` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`code` varchar(255) NULL,
`state` int(11) NULL,
`name` varchar(255) NULL,
`create_by` bigint(20) NULL,
`update_by` bigint(20) NULL,
`create_time` date NULL,
`update_time` date NULL,
`description` varchar(255) NULL,
`role` varchar(255) NULL,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8
AUTO_INCREMENT=1;

CREATE TABLE `permission` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`code` varchar(255) NULL,
`state` int(11) NULL,
`name` varchar(255) NULL,
`create_by` bigint(20) NULL,
`update_by` bigint(20) NULL,
`create_time` date NULL,
`update_time` date NULL,
`url` varchar(255) NULL,
`resourc_type` varchar(255) NULL,
`permission` varchar(255) NULL,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8
AUTO_INCREMENT=1;

CREATE TABLE `property_permission` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`code` varchar(255) NULL,
`state` int(11) NULL,
`name` varchar(255) NULL,
`create_by` bigint(20) NULL,
`update_by` bigint(20) NULL,
`create_time` date NULL,
`update_time` date NULL,
`permission_id` bigint(20) NULL,
`property_id` bigint(20) NULL,
PRIMARY KEY (`id`) 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8
AUTO_INCREMENT=1;


ALTER TABLE `user` ADD CONSTRAINT `fk_user_user Copy 1_1` FOREIGN KEY (`id`) REFERENCES `user_property` (`user_id`);
ALTER TABLE `property` ADD CONSTRAINT `fk_property_user_property_1` FOREIGN KEY (`id`) REFERENCES `user_property` (`property_id`);
ALTER TABLE `property` ADD CONSTRAINT `fk_property_property_permission_1` FOREIGN KEY (`id`) REFERENCES `property_permission` (`property_id`);
ALTER TABLE `permission` ADD CONSTRAINT `fk_permission_property_permission_1` FOREIGN KEY (`id`) REFERENCES `property_permission` (`permission_id`);

