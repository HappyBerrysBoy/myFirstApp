# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table bar (
  id                        varchar2(255) not null,
  name                      varchar2(255),
  constraint pk_bar primary key (id))
;

create sequence bar_seq;




# --- !Downs

drop table bar cascade constraints purge;

drop sequence bar_seq;

