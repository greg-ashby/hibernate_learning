CREATE TABLE `Department` (
  `departmentId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

CREATE TABLE `Employee` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `department_ID` int(11) unsigned,
  PRIMARY KEY (`id`),
  FOREIGN KEY (department_ID) REFERENCES Department(departmentId)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;