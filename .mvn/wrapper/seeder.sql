TRUNCATE people;
TRUNCATE jobs;
INSERT INTO jobs(job_title, salary)
VALUES('Circus Clown', 35000),
('Doctor', 120000),
('Realtor', 62000),
('Professor', 50000)
INSERT INTO people(age, date_joined, date_updated, name, job_id) 
values(30, '2021-05-10', '2021-05-15', 'Bob Doe', 1),
(45, '2021-05-02', '2021-05-15', 'Sally Doe', 2),
(7, '2021-08-10', '2021-11-10', 'Billy Doe', 3), 
(22, '2020-02-10', '2021-12-25', 'Bertha Doe', 4);
