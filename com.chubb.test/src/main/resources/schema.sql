DROP TABLE IF EXISTS clients;

CREATE TABLE clients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255)  NOT NULL,
    surname VARCHAR(255)  NOT NULL,
    phone VARCHAR(255)  NOT NULL
);

INSERT INTO clients (first_name, last_name, surname, phone) 
VALUES ('Luis', 'Mendoza', 'Castro', '+525559876543');