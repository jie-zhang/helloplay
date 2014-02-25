# Tasks schema

# --- !Ups
CREATE SEQUENCE task_id_seq;
CREATE TABLE task (
    id integer NOT NULL DEFAULT nextval('task_id_seq'),
    label varchar(255)
);

CREATE SEQUENCE salon_id_seq;
CREATE TABLE salon (
    id integer NOT NULL DEFAULT nextval('salon_id_seq'),
    label varchar(255)
);

CREATE SEQUENCE stylist_id_seq;
CREATE TABLE stylist (
    id integer NOT NULL DEFAULT nextval('stylist_id_seq'),
	salonId integer,
    label varchar(255)
);


CREATE SEQUENCE style_id_seq;
CREATE TABLE style (
    id integer NOT NULL DEFAULT nextval('style_id_seq'),
    salonId integer,
    stylistId integer,
    label varchar(255)
);

# --- !Downs
DROP TABLE task;
DROP SEQUENCE task_id_seq;

DROP TABLE style;
DROP SEQUENCE style_id_seq;

DROP TABLE stylist;
DROP SEQUENCE stylist_id_seq;

DROP TABLE salon;
DROP SEQUENCE salon_id_seq;
