create table company_unit(
	id int8 not null,
	name_ru varchar(128),
	name_kz varchar(128),
	name_en varchar(128),
	parent_id int8 not null,
	year int4 not null,
	company_id int4 not null,
	code_index varchar(16),
	created_timestamp int8 not null,
	created_by int8 not null,
	updated_timestamp int8 not null,
	updated_by int8 not null,
	primary key(id)
);

create table search_key_routing(
	id int8 not null,
	search_key_id int8 not null,
	table_name varchar(128),
	table_id int8 not null,
	type varchar(128),
	primary key(id)
);

CREATE TABLE authorize(
    id int8 NOT NULL,
    username varchar(255) NOT NULL,
    email varchar(255),
    password varchar(128),
	role varchar(255),
	forgot_password_key varchar(128),
	forgot_password_key_timestamp int8 NOT NULL,
	company_unit_id int8 NOT NULL,
	PRIMARY KEY(id)
);
create table case_index(
	id int8 not null,
	case_index varchar(128),
	title_ru varchar(128),
	title_kz varchar(128),
	title_en varchar(128),
	storage_type int4 not null,
	storage_year int4 not null,
	note varchar(128),
	company_unit_id int8 not null,
	nomenclature_id int8 not null,
	created_timestamp int8 not null,
	created_by int8 not null,
	updated_timestamp int8 not null,
	updated_by int8 not null,
	primary key(id)
);
create table request(
    id int8 not null,
	request_user_id int8 not null,
	response_user_id int8 not null,
	case_id int8 not null,
	case_index_id int8 not null,
	created_type varchar(64),
	comment varchar(255),
	status varchar(64),
	timestamp int8 not null,
	sharestart int8 not null,
	sharefinish int8 not null,
	favorite bool not null,
	update_timestamp int8 not null,
	update_by int8 not null,
	declinenote varchar(255),
	company_unit_id int8 not null,
	from_request_id int8 not null,
	primary key(id)
);

CREATE TABLE share (
    id int8 not NULL,
    request_id int8 not NULL,
    note varchar(255),
    sender_id int8 not null,
	receiver_id int8 not null,
	share_timestamp int8 not null,
	PRIMARY KEY(id)
);

CREATE TABLE request_status_history (
    id int8 not NULL,
    request_id int8 not NULL,
    status varchar(64),
    created_timestamp int8 not null,
	created_by int8 not null,
	updated_timestamp int8 not null,
	updated_by int8 not null,
	PRIMARY KEY(id)
);

	CREATE TABLE catalog (
    id int8 not null,
	name_ru varchar(128),
	name_kz varchar(128),
	name_en varchar(128),
	parent_id int not null,
	company_unit_id int8 not null,
	created_timestamp int8 not null,
	created_by int8 not null,
	updated_timestamp int8 not null,
	updated_by int8 not null,
	primary key(id)
);

create table activity_journal(
    id int8 not null,
	event_type varchar(128),
	object_type varchar(255),
	object_id int8 not null,
	created_timestamp int8 not null,
	created_by int8 not null,
	message_level varchar(128),
	message varchar(255),
	primary key(id)
);
create table location(
	id int8 not null,
	row varchar(128),
	line varchar(128),
	columnn varchar(128),
	box varchar(128),
	company_unit_id int8 not null,
	created_timestamp int8 not null,
	created_by int8 not null,
	updated_timstamp int8 not null,
	updated_by int8 not null,
	primary key(id)
);
create table cases (
	id int8 not null,
	case_number varchar(128),
	tom_number varchar(128),
	case_header_ru varchar(128),
	case_header_kz varchar(128),
	case_header_en varchar(128),
	start_date int8 not null,
	end_date int8 not null,
	page_quantity int8 not null,
	ecp_sign_flag bool not null,
	ecp_sign text not null,
	naf_send_sign bool not null,
	delete_sign bool not null,
	restricted_access_flag bool not null,
	hash varchar(128),
	version int4 not null,
	version_id varchar(128),
	active_sign_version bool not null,
	note varchar(255),
	location_id int8 not null,
	case_index_id int8 not null,
	inventory_id int8 not null,
	destruction_act_id int8 not null,
	unit_structure_id int8 not null,
	blockchain_case_address varchar(128),
	blockchain_addition_date int8 not null,
	creation_date int8 not null,
	created_by int8 not null,
	changed_date int8 not null,
	changed_by int8 not null,
	primary key(id)
);
create table record(
	id int8 not null,
	number varchar(128),
	type varchar(128),
	company_unit_id int8 not null,
	created_timestamp int8 not null,
	created_by int8 not null,
	updated_timestamp int8 not null,
	updated_by int8 not null,
	primary key(id)
);
create table catalog_case(
	id int8 not null,
	case_id int8 not null,
	catalog_id int8 not null,
	company_unit_id int8 not null,
	created_timestamp int8 not null,
	created_by int8 not null,
	updated_timestamp int8 not null,
	updated_by int8 not null,
	primary key(id)
);

ALTER TABLE catalog_case
ADD FOREIGN KEY (catalog_id) REFERENCES catalog(id);
ALTER TABLE catalog_case
ADD FOREIGN KEY (case_id) REFERENCES cases(id);

create table notification (
	id int8 not null,
	object_type varchar(128),
	object_id int8 not null,
	company_unit_id int8 not null,
	user_id int8 not null,
	created_timestamp int8 not null,
	viewed_timestamp int8 not null,
	is_viewed bool not null,
	title varchar(255),
	text varchar(255),
	company_id int8 not null,
	primary key(id)
);

create table users (
	id int8 not null,
	auth_id int8 not null,
	name varchar(128),
	fullname varchar(128),
	surname varchar(128),
	secondname varchar(128),
	status varchar(128),
	company_unit_id int8 not null,
	password varchar(128),
	last_login_timestamp int8 not null,
	iin varchar(32),
	is_active bool not null,
	is_activated bool not null,
	created_timestamp int8 not null,
	created_by int8 not null,
	updated_timestamp int8 not null,
	updated_by int8 not null,
	primary key(id)
);

create table nomenclature(
	id int8 not null,
	nomenclature_number varchar(128),
	year int4 not null,
	nomenclature_summary_id int4 not null,
	company_unit_id int8 not null,
	created_timestamp int8 not null,
	created_by int8 not null,
	updated_timestamp int8 not null,
	updated_by int8 not null,
	primary key(id)
);
ALTER TABLE users
ADD FOREIGN KEY (auth_id) REFERENCES authorize(id);
ALTER TABLE users
ADD FOREIGN KEY (company_unit_id) REFERENCES company_unit(id);

ALTER TABLE cases
ADD FOREIGN KEY (location_id) REFERENCES location(id);
ALTER TABLE cases
ADD FOREIGN KEY (unit_structure_id) REFERENCES company_unit(id);
ALTER TABLE cases
ADD FOREIGN KEY (case_index_id) REFERENCES case_index(id);
ALTER TABLE cases
ADD FOREIGN KEY (inventory_id) REFERENCES record(id);
ALTER TABLE cases
ADD FOREIGN KEY (destruction_act_id) REFERENCES record(id);


ALTER TABLE nomenclature
ADD FOREIGN KEY (company_unit_id) REFERENCES company_unit(id);


create table nomenclature_summary(
	id int8 not null,
	number varchar(128),
	year int4 not null,
	company_unit_id int8 not null,
	created_timestamp int8 not null,
	created_by int8 not null,
	updated_timstamp int8 not null,
	updated_by int8 not null,
	primary key(id)
);
create table tempfiles(
	id int8 not null,
	file_binary text not null,
	file_binary_byte bytea not null,
	primary key(id)
);

create table file(
	id int8 not null,
	name varchar(128),
	type varchar(128),
	size int8 not null,
	page_count int4 not null,
	hash varchar(128),
	is_deleted bool not null,
	file_binary_id int8 not null,
	created_timestamp int8 not null,
	created_by int8 not null,
	updated_timestamp int8 not null,
	updated_by int8 not null,
	primary key(id)
);
ALTER TABLE file
ADD FOREIGN KEY (file_binary_id) REFERENCES tempfiles(id);

create table file_routing(
	id int8 not null,
	file_id int8 not null,
	table_name varchar(128),
	table_id int8 not null,
	type varchar(128),
	primary key(id)
);
ALTER TABLE file_routing
ADD FOREIGN KEY (file_id) REFERENCES file(id);
ALTER TABLE file_routing
ADD FOREIGN KEY (table_id) REFERENCES cases(id);

create table fond(
	id int8 not null,
	fond_number varchar(128),
	created_timestamp int8 not null,
	created_by int8 not null,
	updated_timestamp int8 not null,
	updated_by int8 not null,
	primary key(id)
);


create table company(
	id int8 not null,
	name_ru varchar(128),
	name_kz varchar(128),
	name_en varchar(128),
	bin varchar(128),
	parent_id int8 not null,
	fond_id int8 not null,
	created_timestamp int8 not null,
	created_by int8 not null,
	updated_timestamp int8 not null,
	updated_by int8 not null,
	primary key(id)
);
ALTER TABLE company
ADD FOREIGN KEY (fond_id) REFERENCES fond(id);

ALTER TABLE case_index
ADD FOREIGN KEY (company_unit_id) REFERENCES company_unit(id);

create table destruction_act(
	id int8 not null,
	act_number varchar(128),
	basis varchar(255),
	structure_unit_id int8 not null,
	creation_date int8 not null,
	created_by int8 not null,
	changed_date int8 not null,
	changed_by int8 not null,
	primary key(id)
);
ALTER TABLE destruction_act
ADD FOREIGN KEY (structure_unit_id) REFERENCES company_unit(id);


create table searchkey(
	id int8 not null,
	name varchar(128),
	company_unit_id int8 not null,
	created_timestamp int8 not null,
	created_by int8 not null,
	updated_timestamp int8 not null,
	updated_by int8 not null,
	primary key(id)
);
ALTER TABLE searchkey
ADD FOREIGN KEY (company_unit_id) REFERENCES company_unit(id);


ALTER TABLE record
ADD FOREIGN KEY (company_unit_id) REFERENCES company_unit(id);

ALTER TABLE request_status_history
ADD FOREIGN KEY (request_id) REFERENCES request(id);

ALTER TABLE share
ADD FOREIGN KEY (request_id) REFERENCES request(id);

ALTER TABLE search_key_routing
ADD FOREIGN KEY (search_key_id) REFERENCES searchkey(id);
ALTER TABLE search_key_routing
ADD FOREIGN KEY (table_id) REFERENCES cases(id);


ALTER TABLE catalog
ADD FOREIGN KEY (company_unit_id) REFERENCES company_unit(id);


ALTER TABLE catalog_case
ADD FOREIGN KEY (company_unit_id) REFERENCES company_unit(id);




