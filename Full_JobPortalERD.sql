


CREATE TABLE app_menu
(
	id integer NOT NULL,
	code varchar(15) NOT NULL,
	level integer NOT NULL,
	desc varchar(250),
	PRIMARY KEY (id)
);


CREATE TABLE business_stream
(
	id integer NOT NULL,
	code varchar(100) NOT NULL,
	description varchar(250) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE company
(
	id integer NOT NULL,
	business_stream_id integer NOT NULL,
	company_name varchar(150) NOT NULL,
	profile_description varchar(150) NOT NULL,
	establishment_date date,
	company_url varchar(1000),
	PRIMARY KEY (id)
);


CREATE TABLE company_details
(
	id integer NOT NULL,
	company_id integer NOT NULL,
	logo clob NOT NULL,
	company_url varchar(1000),
	PRIMARY KEY (id)
);


CREATE TABLE job_opening
(
	id integer NOT NULL,
	company_id integer NOT NULL,
	-- posted by
	usr_acc_id integer NOT NULL,
	job_title varchar(30) NOT NULL,
	job_desc varchar(2980),
	is_display_company boolean,
	is_active boolean NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE job_opening_details
(
	id integer NOT NULL,
	job_post_id integer NOT NULL,
	job_address1 varchar(250),
	job_address2 varchar(250),
	job_city varchar(15),
	job_state varchar(15),
	job_country varchar(15),
	zip_code integer,
	is_active boolean NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE Job_opening_questions
(
	id integer NOT NULL,
	job_opening_id integer NOT NULL,
	code varchar(100) NOT NULL,
	description varchar(250) NOT NULL,
	answer varchar(250),
	PRIMARY KEY (id)
);


CREATE TABLE job_post_activity
(
	id integer NOT NULL,
	usr_acc_id integer NOT NULL,
	job_opening_id integer NOT NULL,
	posted_date date,
	is_active boolean,
	comments varchar(2800),
	PRIMARY KEY (id)
);


CREATE TABLE job_post_skills
(
	id integer NOT NULL,
	job_post_id integer NOT NULL,
	skill integer,
	PRIMARY KEY (id)
);


CREATE TABLE Job_Seeker_Education_Detail
(
	id integer NOT NULL,
	usr_acc_id integer NOT NULL,
	certificate_degree_name varchar(150) NOT NULL,
	institute_university_name varchar(50) NOT NULL,
	start_date varchar(15) NOT NULL,
	completion_date date,
	percentage_cpga varchar(3),
	is_current_job boolean,
	PRIMARY KEY (id)
);


CREATE TABLE Job_Seeker_Eperience_Detail
(
	id integer NOT NULL,
	usr_acc_id integer NOT NULL,
	is_current_job boolean,
	start_date date NOT NULL,
	end_date date,
	job_title varchar(30) NOT NULL,
	company_name varchar(30) NOT NULL,
	job_city varchar(15),
	job_state varchar(15),
	job_country varchar(15),
	PRIMARY KEY (id)
);


CREATE TABLE job_seeker_skills
(
	id integer NOT NULL,
	usr_acc_id integer NOT NULL,
	skills_id integer NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE job_seeker_skills_Other
(
	id integer NOT NULL,
	usr_acc_id integer NOT NULL,
	skill integer NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE menu_role
(
	id integer NOT NULL,
	app_menu_id integer NOT NULL,
	sys_role_id integer NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE profile_details
(
	id integer NOT NULL,
	usr_acc_id integer NOT NULL,
	profile_type varchar(15),
	profile blob NOT NULL,
	active boolean NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE skills
(
	id integer NOT NULL,
	code varchar(100) NOT NULL,
	description varchar(250) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE system_roles
(
	id integer NOT NULL,
	code varchar(15) NOT NULL UNIQUE,
	desc varchar(250),
	creation_date timestamp,
	last_updated_date timestamp,
	updated_by varchar(15),
	PRIMARY KEY (id)
);


CREATE TABLE user_account
(
	id integer NOT NULL,
	usr_type integer NOT NULL,
	userid varchar(25) NOT NULL UNIQUE,
	-- Password
	password nvarchar(25) NOT NULL,
	-- First Name
	first_name nvarchar(25) NOT NULL,
	-- middle_name
	middle_name nvarchar(25),
	last_name varchar(25),
	date_of_birth date NOT NULL,
	registration_date date NOT NULL,
	gender varchar(1),
	is_active boolean NOT NULL,
	creation_date timestamp,
	updated_by varchar(15),
	PRIMARY KEY (id)
);


CREATE TABLE user_address_details
(
	id integer NOT NULL,
	usr_acc_id integer NOT NULL,
	address varchar(250),
	city varchar(10),
	state varchar(10),
	zipcode varchar(10),
	country varchar(10),
	PRIMARY KEY (id)
);


CREATE TABLE user_contact
(
	id integer NOT NULL,
	usr_acc_id integer NOT NULL,
	contact_no varchar(10) NOT NULL,
	device_type varchar(10) NOT NULL,
	sms_active boolean NOT NULL,
	contact_active boolean NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE user_log
(
	id integer NOT NULL,
	usr_acc_id integer NOT NULL,
	last_login_date date,
	last_job_applied_date date,
	PRIMARY KEY (id)
);


CREATE TABLE user_roles
(
	id integer NOT NULL,
	usr_acc_id integer NOT NULL,
	sysroles_id integer NOT NULL,
	creation_date timestamp,
	last_updated_date timestamp,
	updated_by varchar(15),
	PRIMARY KEY (id)
);


CREATE TABLE user_type
(
	id integer NOT NULL,
	code varchar(15) NOT NULL UNIQUE,
	desc varchar(250),
	PRIMARY KEY (id)
);



/* Create Foreign Keys */

ALTER TABLE menu_role
	ADD FOREIGN KEY (app_menu_id)
	REFERENCES app_menu (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE company
	ADD FOREIGN KEY (business_stream_id)
	REFERENCES business_stream (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE company_details
	ADD FOREIGN KEY (company_id)
	REFERENCES company (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE job_opening
	ADD FOREIGN KEY (company_id)
	REFERENCES company (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE job_opening_details
	ADD FOREIGN KEY (job_post_id)
	REFERENCES job_opening (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Job_opening_questions
	ADD FOREIGN KEY (job_opening_id)
	REFERENCES job_opening (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE job_post_activity
	ADD FOREIGN KEY (job_opening_id)
	REFERENCES job_opening (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE job_post_skills
	ADD FOREIGN KEY (job_post_id)
	REFERENCES job_opening (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE job_seeker_skills_Other
	ADD FOREIGN KEY (usr_acc_id)
	REFERENCES Job_Seeker_Eperience_Detail (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE job_seeker_skills
	ADD FOREIGN KEY (usr_acc_id)
	REFERENCES skills (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE menu_role
	ADD FOREIGN KEY (sys_role_id)
	REFERENCES system_roles (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user_roles
	ADD FOREIGN KEY (sysroles_id)
	REFERENCES system_roles (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE job_post_activity
	ADD FOREIGN KEY (usr_acc_id)
	REFERENCES user_account (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Job_Seeker_Education_Detail
	ADD FOREIGN KEY (usr_acc_id)
	REFERENCES user_account (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Job_Seeker_Eperience_Detail
	ADD FOREIGN KEY (usr_acc_id)
	REFERENCES user_account (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE job_seeker_skills
	ADD FOREIGN KEY (skills_id)
	REFERENCES user_account (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE profile_details
	ADD FOREIGN KEY (usr_acc_id)
	REFERENCES user_account (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user_address_details
	ADD FOREIGN KEY (usr_acc_id)
	REFERENCES user_account (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user_contact
	ADD FOREIGN KEY (usr_acc_id)
	REFERENCES user_account (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user_log
	ADD FOREIGN KEY (usr_acc_id)
	REFERENCES user_account (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user_roles
	ADD FOREIGN KEY (usr_acc_id)
	REFERENCES user_account (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user_account
	ADD FOREIGN KEY (usr_type)
	REFERENCES user_type (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



