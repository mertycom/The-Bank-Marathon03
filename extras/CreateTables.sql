-- Database: Marathon03_Group03

-- DROP DATABASE IF EXISTS "Marathon03_Group03";

CREATE DATABASE "Marathon03_Group03"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Turkish_Turkey.utf8'
    LC_CTYPE = 'Turkish_Turkey.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Table: public.account_types

-- DROP TABLE IF EXISTS public.account_types;

CREATE TABLE IF NOT EXISTS public.account_types
(
    account_type_oid bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    account_type_number integer NOT NULL,
    account_type_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT account_types_pkey PRIMARY KEY (account_type_oid),
    CONSTRAINT unique_account_type_name_number UNIQUE (account_type_name, account_type_number)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.account_types
    OWNER to postgres;

-- Table: public.accounts

-- DROP TABLE IF EXISTS public.accounts;

CREATE TABLE IF NOT EXISTS public.accounts
(
    account_oid bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    customer_oid bigint NOT NULL,
    account_number bigint NOT NULL,
    account_type_oid bigint NOT NULL,
    bank_branch_oid bigint NOT NULL,
    CONSTRAINT account_numbers_pkey PRIMARY KEY (account_oid),
    CONSTRAINT unique_account_number UNIQUE (account_number),
    CONSTRAINT accounttype_oid FOREIGN KEY (account_type_oid)
        REFERENCES public.account_types (account_type_oid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT branch_oid FOREIGN KEY (bank_branch_oid)
        REFERENCES public.bank_branches (bank_branch_oid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT customer_oid FOREIGN KEY (customer_oid)
        REFERENCES public.customers (customer_oid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.accounts
    OWNER to postgres;

-- Table: public.bank_branches

-- DROP TABLE IF EXISTS public.bank_branches;

CREATE TABLE IF NOT EXISTS public.bank_branches
(
    bank_branch_oid bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    branch_number bigint NOT NULL,
    branch_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT bank_branches_pkey PRIMARY KEY (bank_branch_oid),
    CONSTRAINT unique_brach_name UNIQUE (branch_number)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.bank_branches
    OWNER to postgres;

-- Table: public.customers

-- DROP TABLE IF EXISTS public.customers;

CREATE TABLE IF NOT EXISTS public.customers
(
    customer_oid bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    customer_number bigint NOT NULL,
    customer__name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    customer_surname character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT customers_oid PRIMARY KEY (customer_oid)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customers
    OWNER to postgres;

-- Table: public.transaction_platforms

-- DROP TABLE IF EXISTS public.transaction_platforms;

CREATE TABLE IF NOT EXISTS public.transaction_platforms
(
    transaction_platform_oid bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    platform_name character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT transaction_platforms_pkey PRIMARY KEY (transaction_platform_oid),
    CONSTRAINT uniq_platform_name UNIQUE (platform_name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.transaction_platforms
    OWNER to postgres;

-- Table: public.transaction_code

-- DROP TABLE IF EXISTS public.transaction_code;

CREATE TABLE IF NOT EXISTS public.transaction_code
(
    transaction_code_oid bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    transaction_code_name character varying COLLATE pg_catalog."default",
    CONSTRAINT transaction_code_pkey PRIMARY KEY (transaction_code_oid),
    CONSTRAINT transaction_code_name UNIQUE (transaction_code_name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.transaction_code
    OWNER to postgres;

-- Table: public.transaction_types

-- DROP TABLE IF EXISTS public.transaction_types;

CREATE TABLE IF NOT EXISTS public.transaction_types
(
    transaction_type_oid bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    type_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    transaction_code_oid bigint NOT NULL,
    CONSTRAINT processes_pkey PRIMARY KEY (transaction_type_oid),
    CONSTRAINT unique_process_type UNIQUE (type_name),
    CONSTRAINT transaction_code_oid FOREIGN KEY (transaction_code_oid)
        REFERENCES public.transaction_code (transaction_code_oid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.transaction_types
    OWNER to postgres;

-- Table: public.transactions

-- DROP TABLE IF EXISTS public.transactions;

CREATE TABLE IF NOT EXISTS public.transactions
(
    transaction_oid bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    account_oid bigint NOT NULL,
    transaction_number bigint NOT NULL,
    transaction_type_oid bigint NOT NULL,
    transaction_amount double precision NOT NULL,
    date date NOT NULL,
    transaction_platform_oid bigint NOT NULL,
    CONSTRAINT transactions_pkey PRIMARY KEY (transaction_oid),
    CONSTRAINT unique_transaction_number UNIQUE (transaction_number),
    CONSTRAINT account_oid FOREIGN KEY (account_oid)
        REFERENCES public.accounts (account_oid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT transaction_platform_oid FOREIGN KEY (transaction_platform_oid)
        REFERENCES public.transaction_platforms (transaction_platform_oid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT transaction_type_oid FOREIGN KEY (transaction_type_oid)
        REFERENCES public.transaction_types (transaction_type_oid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.transactions
    OWNER to postgres;

INSERT INTO public.transaction_code(
	transaction_code_name)
	VALUES ('Girdi');

INSERT INTO public.transaction_code(
	transaction_code_name)
	VALUES ('????kt??');

INSERT INTO public.account_types(
	account_type_number, account_type_name)
	VALUES (10, 'TL');
	
INSERT INTO public.account_types(
	account_type_number, account_type_name)
	VALUES (11, 'EURO');

INSERT INTO public.account_types(
	account_type_number, account_type_name)
	VALUES (12, 'USD');

INSERT INTO public.customers(
	customer_number, customer__name, customer_surname)
	VALUES ( 100, 'Ali, 'Kara');
			
INSERT INTO public.customers(
	customer_number, customer__name, customer_surname)
	VALUES ( 100, 'Ay??e, 'Sar??');

INSERT INTO public.bank_branches(
	branch_number, branch_name)
	VALUES (67, 'Zonguldak');

INSERT INTO public.bank_branches(
	branch_number, branch_name)
	VALUES (74, 'Bart??n');
	
INSERT INTO public.bank_branches(
	branch_number, branch_name)
	VALUES (78, 'Karab??k');

INSERT INTO public.transaction_types(
	type_name,transaction_code_oid)
	VALUES ('Para Yat??rma',1);
	
INSERT INTO public.transaction_types(
	type_name,transaction_code_oid)
	VALUES ('Para ??ekme',2);
	
INSERT INTO public.transaction_types(
	type_name,transaction_code_oid)
	VALUES ('Fatura ??deme',2);

INSERT INTO public.transaction_platforms(
	platform_name)
	VALUES ('??ube');
	
INSERT INTO public.transaction_platforms(
	platform_name)
	VALUES ('ATM');
	
INSERT INTO public.transaction_platforms(
	platform_name)
	VALUES ('Internet');

INSERT INTO public.accounts(
	customer_oid, account_number, account_type_oid, bank_branch_oid)
	VALUES (1, 7410010, 1, 2);
	
INSERT INTO public.accounts(
	customer_oid, account_number, account_type_oid, bank_branch_oid)
	VALUES (1, 6710011, 2, 1);

INSERT INTO public.accounts(
	customer_oid, account_number, account_type_oid, bank_branch_oid)
	VALUES (1, 7810112, 3, 1);
	
INSERT INTO public.accounts(
	customer_oid, account_number, account_type_oid, bank_branch_oid)
	VALUES (1, 7410110, 1, 2);

INSERT INTO public.transactions(
	account_oid, transaction_number, transaction_type_oid, transaction_amount, date, transaction_platform_oid)
	VALUES (1, 100001, 1, 400, '2022-1-2', 2);
	
INSERT INTO public.transactions(
	account_oid, transaction_number, transaction_type_oid, transaction_amount, date, transaction_platform_oid)
	VALUES (1, 100002, 2, 200, '2022-1-25', 2);
	
INSERT INTO public.transactions(
	account_oid, transaction_number, transaction_type_oid, transaction_amount, date, transaction_platform_oid)
	VALUES (1, 100003, 3, 89, '2022-1-20', 3);

INSERT INTO public.transactions(
	account_oid, transaction_number, transaction_type_oid, transaction_amount, date, transaction_platform_oid)
	VALUES (2, 100025, 1, 200, '2022-1-15', 1);
	
INSERT INTO public.transactions(
	account_oid, transaction_number, transaction_type_oid, transaction_amount, date, transaction_platform_oid)
	VALUES (3, 100058, 2, 100, '2022-2-2', 2);
	
INSERT INTO public.transactions(
	account_oid, transaction_number, transaction_type_oid, transaction_amount, date, transaction_platform_oid)
	VALUES (4, 101005, 1, 200, '2022-1-20', 1);
	
INSERT INTO public.transactions(
	account_oid, transaction_number, transaction_type_oid, transaction_amount, date, transaction_platform_oid)
	VALUES (4, 101048, 2, 115, '2022-1-20', 3);