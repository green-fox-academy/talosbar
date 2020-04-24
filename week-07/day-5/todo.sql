-- SHOW databases;

-- CREATE DATABASE IF NOT EXISTS todoLists;
-- USE todoLists;

-- CREATE TABLE Todo(
-- task_name VARCHAR(15) NOT NULL,
-- short_description VARCHAR(30) NOT NULL,
-- deadline DATE NOT NULL,
-- how_important_is ENUM('VERY', 'NOT SO') NOT NULL,
-- task_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY);

-- DESCRIBE Todo;

-- CREATE TABLE Doing(
-- task_name VARCHAR(15) NOT NULL,
-- short_description VARCHAR(30) NOT NULL,
-- deadline DATE NOT NULL,
-- how_important_is ENUM('VERY', 'NOT SO') NOT NULL,
-- task_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY);

-- DESCRIBE Doing;

-- CREATE TABLE Review(
-- task_name VARCHAR(15) NOT NULL,
-- short_description VARCHAR(30) NOT NULL,
-- deadline DATE NOT NULL,
-- how_important_is ENUM('VERY', 'NOT SO') NOT NULL,
-- task_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY); 

-- DESCRIBE Review;

-- CREATE TABLE Done(
-- task_name VARCHAR(15) NOT NULL,
-- short_description VARCHAR(30) NOT NULL,
-- deadline DATE NOT NULL,
-- how_important_is ENUM('VERY', 'NOT SO') NOT NULL,
-- task_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY);

-- DESCRIBE Done;

-- CREATE TABLE whoShouldMakeTheseTasks(
-- first_name VARCHAR(30) NOT NULL,
-- last_name VARCHAR(30) NOT NULL,
-- username VARCHAR(30) NOT NULL,
-- email VARCHAR(60) NULL,
-- person_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY);

-- DESCRIBE Done;

-- INSERT INTO Todo values
-- ('Make SQL task', 'Create tables in Workbench', '2020-04-24', 'VERY', NULL),
-- ('Rewatch videos', 'Watching videos second time', '2020-04-26', 'NOT SO', NULL),
-- ('Dependencies', 'Making exercises in theme', '2020-04-25', 'VERY', NULL);

-- SELECT * FROM Todo;

-- ALTER TABLE Todo DROP COLUMN task_id;
-- ALTER TABLE Todo ADD COLUMN task_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;

-- ALTER TABLE Doing DROP COLUMN task_id;
-- ALTER TABLE Review DROP COLUMN task_id;
-- ALTER TABLE Done DROP COLUMN task_id;

-- ALTER TABLE Doing ADD COLUMN task_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;
-- ALTER TABLE Review ADD COLUMN task_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;
-- ALTER TABLE Done ADD COLUMN task_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;

-- ALTER TABLE Done CHANGE deadline how_many_minutes_was_to_make INT UNSIGNED NOT NULL; 
-- ALTER TABLE Done CHANGE how_important_is completed_before_deadline ENUM('NO', 'YES') NOT NULL;

-- DESCRIBE Done;

-- INSERT INTO Doing values
-- (NULL, 'Spring Webshop', 'Practice Spring Framework', '2020-04-24', 'VERY');

-- SELECT * FROM Doing;

-- INSERT INTO Review values
-- (NULL, 'Table form', 'Waiting for CR', '2020-04-24', 'NOT SO');

-- SELECT * FROM Review;

-- INSERT INTO Done values
-- (NULL, 'Streams', 'Exercises with streams', 300, 'YES'),
-- (NULL, 'Nested loops', 'Topic of foundation', 200, 'YES'),
-- (NULL, 'Shortcuts', 'IntelliJ shortcuts', 30, 'NO');

-- SELECT * From Done;

-- ALTER TABLE Done ADD COLUMN username_of_the_fastest_person VARCHAR(30) NOT NULL AFTER completed_before_deadline;

-- ALTER TABLE Done CHANGE task_name task_name
-- VARCHAR(15) NOT NULL DEFAULT 'task';  

-- ALTER TABLE Done CHANGE short_description short_description
-- VARCHAR(30) NOT NULL DEFAULT 'description';

-- ALTER TABLE Done CHANGE how_many_minutes_was_to_make how_many_minutes_was_to_make
-- INT UNSIGNED DEFAULT NULL;

-- ALTER TABLE Done CHANGE completed_before_deadline completed_before_deadline 
-- ENUM('NO', 'YES') DEFAULT 'YES';

-- INSERT INTO Done (username_of_the_fastest_person) VALUES 
-- ('kisgomb'),
-- ('fastestrabbit'),
-- ('kisgomb');

-- DELETE FROM Done WHERE task_id < 7;

-- INSERT INTO Done values
-- (NULL, 'Streams', 'Exercises with streams', 300, 'YES', 'kisgomb'),
-- (NULL, 'Nested loops', 'Topic of foundation', 200, 'YES', 'fastesetrabbit'),
-- (NULL, 'Shortcuts', 'IntelliJ shortcuts', 30, 'NO', 'kisgomb');

-- ALTER TABLE Done AUTO_INCREMENT = 1;

-- ALTER TABLE Done DROP COLUMN task_id;

-- DESCRIBE Done;

-- ALTER TABLE Doing ADD COLUMN task_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;

-- SELECT * FROM Done;

-- ALTER TABLE whoShouldMakeTheseTasks 
-- RENAME TO students;

-- SHOW TABLES;

-- DESCRIBE students;

-- ALTER TABLE students DROP COLUMN person_id;

-- ALTER TABLE students ADD COLUMN person_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;

-- INSERT INTO students VALUES
-- (NULL, 'Kate', 'Winslet', 'kitty', 'kitty@gmail.com'),
-- (NULL, 'Jack', 'ThePirate', 'kisgomb', 'kisg@yahoo.com'),
-- (NULL, 'Eva', 'Apple', 'fastestrabbit', 'romlott@citromail.hu');

-- DESCRIBE Done;

-- SET SQL_SAFE_UPDATES = 0;

-- UPDATE Done 
-- SET username_of_the_fastest_person='fastestrabbit'
-- WHERE task_name='Nested loops';

-- SHOW TABLES;

-- SELECT * FROM Done;
-- SELECT * FROM Doing;
-- SELECT * FROM Review;
-- SELECT * FROM students;
-- SELECT * FROM Todo;

-- SELECT DISTINCT email FROM students;

-- SELECT DISTINCT CONCAT(first_name, " ", last_name) AS 'Name' FROM students WHERE username LIKE 'k%';

-- SELECT 
-- AVG(how_many_minutes_was_to_make) AS 'Average time (in minutes) to make an exercise'
-- FROM Done;

-- SELECT task_name FROM Todo 
-- WHERE DAY(deadline) < 25 || how_important_is = 'VERY';

-- SELECT COUNT(*) AS 'Count of tasks' FROM Done;

-- SELECT DISTINCT email FROM students, Done WHERE students.username = Done.username_of_the_fastest_person;

-- SELECT DISTINCT students.email
-- FROM students
-- RIGHT JOIN Done ON Done.username_of_the_fastest_person = students.username;
