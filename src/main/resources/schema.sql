-- Items we need in our schema. bigint is used when we want to store a long datatype.
--id
--name
--author

create table course
(
	id bigint not null,
	name varchar(255) not null,
	author varchar(255) not null,
	primary key (id)

);

