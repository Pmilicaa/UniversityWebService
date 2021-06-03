insert into user (id, password, role, user_name) values (1, '$2a$10$pzhQj/9w.Fjp4AXxOWgUg.f4rvBPRpZGa9I1eyGn05VgFzdNV58cu', 2, 'aleksa123');
insert into user (id, password, role, user_name) values (2, 'mica321', 2, 'mica123');
insert into user (id, password, role, user_name) values (3, 'damir321', 2, 'damir123');
insert into user (id, password, role, user_name) values (4, '$2a$10$6qGF3lna.qPAQTgOn9IhzutR5y.qYIH5apJINHFYg3jCj.JKIeqDa', 1, 'joka');


insert into student (id, account_number, balance, card_number, first_name, last_name, user_id) values (1, 241245135, 15000, 'asd234tg5e3ghseth5e','Aleksa', 'Petrovic', 1);
insert into student (id, account_number, balance, card_number, first_name, last_name, user_id) values (2, 241245135, 15000, 'asd234tg5e3ghseth5e','Milica', 'Pajic', 2);
insert into student (id, account_number, balance, card_number, first_name, last_name, user_id) values (3, 241245135, 15000, 'asd234tg5e3ghseth5e','Damir', 'Tizmonar', 3);
insert into teacher (id, firstName, lastName, user_id) values (4, 'joka', 'janjic', 4);

insert into document_type values (1, "D", "Diploma");
insert into document_type values (2, "N", "Nesto");
insert into document_type values (3, "S", "Sluzba");

insert into document values (1, "Diploma", "asdasdasd", 1);
insert into document values (2, "Diploma", "asdasdasd", 2);
insert into document values (3, "Diploma", "asdasdasd", 2);
insert into document values (4, "Diploma", "asdasdasd", 1);

insert into transaction_type values (1, "Deposit");
insert into transaction_type values (2, "Withdrawal");

insert into transaction values (1, 1500,  1, 1);
insert into transaction values (2, 2500,  1, 1);
insert into transaction values (3, 3500,  1, 1);

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
