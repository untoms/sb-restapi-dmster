insert into user
(`id`,`user_name`,`first_name`,`last_name`,`email_address`,`role`,`ssn`,`address`,`password`)
values
(1001, "user1", "spring","boot","something@email.com","USER","SSN001","Jakarte",
"$2a$11$l5FXfI.mkrcL0au5cBNAqOqNzsxCirl7BQQALMeSSidi.j4GpP8dK"),
(1002, "user2", "spring","boot","something@email.com","USER","SSN002","Jakarte",
"$2a$11$l5FXfI.mkrcL0au5cBNAqOqNzsxCirl7BQQALMeSSidi.j4GpP8dK"),
(1003, "user3", "spring","boot","something@email.com","USER","SSN003","Jakarte",
"$2a$11$l5FXfI.mkrcL0au5cBNAqOqNzsxCirl7BQQALMeSSidi.j4GpP8dK");

insert into orders values( 2001, 'order11', 1001);
insert into orders values( 2002, 'order12', 1001);
insert into orders values( 2003, 'order13', 1001);
insert into orders values( 2004, 'order21', 1002);
insert into orders values( 2005, 'order22', 1002);
insert into orders values( 2006, 'order31', 1003);