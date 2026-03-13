USE spring_study_1;
DROP TABLE users;
DROP DATABASE spring_study_1;
DROP USER 'spring_study_1'@'localhost';

CREATE DATABASE spring_study_1 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'spring_study_1'@'localhost' IDENTIFIED BY 'spring_study_1';
GRANT ALL PRIVILEGES ON spring_study_1.* TO 'spring_study_1'@'localhost';

SHOW DATABASES;
USE spring_study_1;
SHOW TABLES;

-- 기본 테이블 생성
CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    joined_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

SHOW TABLES;
INSERT INTO users(name, email) VALUES('yegang', 'yegang@yegangs.com');
INSERT INTO users(name, email) VALUES('james', 'james@example.com');
INSERT INTO users(name, email) VALUES('peter', 'peter@example.com');
INSERT INTO users(name, email) VALUES('john', 'john@example.com');
INSERT INTO users(name, email) VALUES('donald', 'donald@example.com');
INSERT INTO users(name, email) VALUES('kim', 'kim@example.com');
INSERT INTO users(name, email) VALUES('jackson', 'jackson@example.com');

SELECT * FROM users;
