create schema task_svc;

CREATE sequence task_svc.task_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
create table task_svc.task(
id int8 not null primary key,
title varchar(20) not null,
description text,
status varchar(20)
);