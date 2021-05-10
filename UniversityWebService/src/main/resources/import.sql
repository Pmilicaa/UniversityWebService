insert into user (id, password, role, user_name) values (1, 'aleksa321', 1, 'aleksa123');
insert into user (id, password, role, user_name) values (2, 'mica321', 1, 'mica123');
insert into user (id, password, role, user_name) values (3, 'damir321', 1, 'damir123');

insert into student (id, account_number, balance, card_number, first_name, last_name, user_id) values (1, 241245135, 15000, 'asd234tg5e3ghseth5e','Aleksa', 'Petrovic', 1);
insert into student (id, account_number, balance, card_number, first_name, last_name, user_id) values (2, 241245135, 15000, 'asd234tg5e3ghseth5e','Milica', 'Pajic', 2);
insert into student (id, account_number, balance, card_number, first_name, last_name, user_id) values (3, 241245135, 15000, 'asd234tg5e3ghseth5e','Damir', 'Tizmonar', 3);

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