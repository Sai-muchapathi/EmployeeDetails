DROP TABLE IF EXISTS EMPLOYEE;
CREATE TABLE EMPLOYEE
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    first_name    VARCHAR(20) NOT NULL,
    last_name     VARCHAR(20) NOT NULL,
    email         VARCHAR(15) DEFAULT NULL,
    date_of_birth DATE        DEFAULT NULL
);


