-- User table data
INSERT INTO Users (useridpk, firstname, lastname, age, gender, username, password)
VALUES ('7i9h2m8ut8iv7s8d', 'Aditya', 'Upadhyaya', 26, 'Male', 'aditya123', 'RunnerZ');

INSERT INTO Users (useridpk, firstname, lastname, age, gender, username, password)
VALUES ('8n7b1a0qw5sd9z6e', 'John', 'Wick', 32, 'Male', 'john567', 'runner');

-- Run data for each user
INSERT INTO Run (id, title, started_on, completed_on, miles, location, useridpk)
VALUES (1, 'Morning Run', '2017-01-01 06:00:00', '2017-01-01 07:00:00', 3, 'OUTDOOR', '7i9h2m8ut8iv7s8d');
INSERT INTO Run (id, title, started_on, completed_on, miles, location, useridpk)
VALUES (2, 'Evening Run', '2017-01-02 19:00:00', '2017-01-02 20:00:00', 2, 'INDOOR', '7i9h2m8ut8iv7s8d');
INSERT INTO Run (id, title, started_on, completed_on, miles, location, useridpk)
VALUES (3, 'Morning Run', '2017-01-04 19:00:00', '2017-01-04 20:30:00', 5, 'INDOOR', '7i9h2m8ut8iv7s8d');
INSERT INTO Run (id, title, started_on, completed_on, miles, location, useridpk)
VALUES (4, 'Morning Run', '2017-01-05 18:00:00', '2017-01-05 19:00:00', 3, 'INDOOR', '7i9h2m8ut8iv7s8d');
INSERT INTO Run (id, title, started_on, completed_on, miles, location, useridpk)
VALUES (5, 'Morning Run', '2017-01-06 06:00:00', '2017-01-06 07:00:00', 3, 'OUTDOOR', '7i9h2m8ut8iv7s8d');
INSERT INTO Run (id, title, started_on, completed_on, miles, location, useridpk)
VALUES (6, 'Morning Run', '2017-01-08 06:00:00', '2017-01-08 07:00:00', 3, 'OUTDOOR', '7i9h2m8ut8iv7s8d');
INSERT INTO Run (id, title, started_on, completed_on, miles, location, useridpk)
VALUES (7, 'Morning Run', '2017-01-10 06:00:00', '2017-01-10 06:30:00', 2, 'OUTDOOR', '7i9h2m8ut8iv7s8d');
INSERT INTO Run (id, title, started_on, completed_on, miles, location, useridpk)
VALUES (8, 'Morning Run', '2017-01-12 06:00:00', '2017-01-12 08:00:00', 5, 'OUTDOOR', '8n7b1a0qw5sd9z6e');
INSERT INTO Run (id, title, started_on, completed_on, miles, location, useridpk)
VALUES (9, 'Morning Run', '2017-01-15 06:00:00', '2017-01-15 07:30:00', 4, 'OUTDOOR', '8n7b1a0qw5sd9z6e');
INSERT INTO Run (id, title, started_on, completed_on, miles, location, useridpk)
VALUES (10, 'Morning Run', '2017-01-20 06:00:00', '2017-01-20 07:30:00', 4, 'OUTDOOR', '8n7b1a0qw5sd9z6e');