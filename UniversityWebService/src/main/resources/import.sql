<<<<<<< HEAD
--insert into user (id, password, role, user_name) values (1, 'aleksa321', 1, 'aleksa123');
--insert into user (id, password, role, user_name) values (2, 'mica321', 1, 'mica123');
--insert into user (id, password, role, user_name) values (3, 'damir321', 1, 'damir123');
--
--insert into student (id, account_number, balance, card_number, first_name, last_name, user_id) values (1, 241245135, 15000, 'asd234tg5e3ghseth5e','Aleksa', 'Petrovic', 1);
--insert into student (id, account_number, balance, card_number, first_name, last_name, user_id) values (2, 241245135, 15000, 'asd234tg5e3ghseth5e','Milica', 'Pajic', 2);
--insert into student (id, account_number, balance, card_number, first_name, last_name, user_id) values (3, 241245135, 15000, 'asd234tg5e3ghseth5e','Damir', 'Tizmonar', 3);
=======
-- Admin acc user: mirko123 pass:mirko321
insert into user (id, password, role, user_name) values (5, "$2a$10$YNaqStb.elNncc8k51TrYud.25Rjpu1gGjwpNp/OrMskxs4KeVRSy", 0, 'mirko123');
>>>>>>> 405195e3c253905c934721309d6c5c9282bffa22

-- Student acc user:aleksa123 pass:aleksa321
insert into user (id, password, role, user_name) values (1, '$2a$10$pzhQj/9w.Fjp4AXxOWgUg.f4rvBPRpZGa9I1eyGn05VgFzdNV58cu', 2, 'aleksa123');
insert into user (id, password, role, user_name) values (2, 'mica321', 2, 'mica123');
insert into user (id, password, role, user_name) values (3, 'damir321', 2, 'damir123');
--Professor acc user:joka pass:joka
insert into user (id, password, role, user_name) values (4, '$2a$10$6qGF3lna.qPAQTgOn9IhzutR5y.qYIH5apJINHFYg3jCj.JKIeqDa', 1, 'joka');


insert into student (id, account_number, balance, card_number, first_name, last_name, user_id) values (1, 241245135, 15000, 'asd234tg5e3ghseth5e','Aleksa', 'Petrovic', 1);
insert into student (id, account_number, balance, card_number, first_name, last_name, user_id) values (2, 241245135, 15000, 'asd234tg5e3ghseth5e','Milica', 'Pajic', 2);
insert into student (id, account_number, balance, card_number, first_name, last_name, user_id) values (3, 241245135, 15000, 'asd234tg5e3ghseth5e','Damir', 'Tizmonar', 3);
insert into teacher (id, first_name, last_name, user_id) values (4, 'joka', 'janjic', 4);


insert into document_type values (1, "D", "Diploma");
insert into document_type values (2, "N", "Nesto");
insert into document_type values (3, "S", "Sluzba");

insert into transaction_type values (1, "Deposit");
insert into transaction_type values (2, "Withdrawal");

insert into transaction values (1, 1500,  1, 1);
insert into transaction values (2, 2500,  1, 1);
insert into transaction values (3, 3500,  1, 1);

insert into teaching_type values (1, "P", "professor");
insert into teaching_type values (2, "A", "assistant");

insert into course_specification (title, ects, code) values ("Mathematics", 8, "MATH");
insert into course_specification (title, ects, code) values ("Object oriented programming", 8, "OOP");
insert into course_specification (title, ects, code) values ("Embedded programming", 8, "EP");

insert into exam_part_type (name, code) values ("Homework", "H");
insert into exam_part_type (name, code) values ("Colloquium", "C");
insert into exam_part_type (name, code) values ("Final exam", "F");

insert into exam_part_status (name, code) values ("Passed", "P");
insert into exam_part_status (name, code) values ("Failed", "F");
insert into exam_part_status (name, code) values ("Registered", "R");
insert into exam_part_status (name, code) values ("Didn't come", "D");
insert into exam_part_status (name, code) values ("Not registered", "N");

insert into exam_period (name, exam_period_start_date, exam_period_end_date) values ("January", '2021-01-01 10:00:00', '2021-01-30 10:00:00');
insert into exam_period (name, exam_period_start_date, exam_period_end_date) values ("February", "2021-02-01 10:00:00", "2021-02-25 10:00:00");
insert into exam_period (name, exam_period_start_date, exam_period_end_date) values ("April", "2021-04-01 10:00:00", "2021-04-30 10:00:00");
insert into exam_period (name, exam_period_start_date, exam_period_end_date) values ("Jun", "2021-06-01 10:00:00", "2021-06-30 10:00:00");
insert into exam_period (name, exam_period_start_date, exam_period_end_date) values ("July", "2021-07-01 10:00:00", "2021-07-30 10:00:00");
insert into exam_period (name, exam_period_start_date, exam_period_end_date) values ("September", "2021-09-01 10:00:00", "2021-01-30 10:00:00");
--User
insert into user values (1, "papa", 0, "paki");
insert into user values (2, "pele", 1, "peki");
insert into user values (3, "pale", 2, "pal");
insert into user values (4, "neko", 2, "neko");


--Students
insert into student values (1, 374387438, 1000, "SF-9-2018", "Aleksa", "Petrovic", 1);
insert into student values (2, 327827387, 2000, "SF-11-2018", "Milica", "Pajic", 2);
insert into student values (3, 273283783, 1000, "SF-12-2018", "Damir", "Tizmonar", 3);
insert into student values (4, 545544545, 1000, "SF-2-2018", "Neko", "Nekic", 4);


--Professors
insert into teacher values (1, "Profa", "Profic", 1);
insert into teacher values (2, "Pera", "Peric", 2);
insert into teacher values (3, "Nikola", "Nikolic", 3);