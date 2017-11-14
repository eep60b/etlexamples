-- This script re-create all the tables for the bookshop demonstration.
-- The script can only be used for the Postgres SQL datbase.
-- The script is tested against Postgres SQL 9.4.
-- The tables will be dropped if they exist. A fresh set of tables then will be created with the constraint.
-- No data will be populated in this script.

-- author Zhipeng Chang
-- version 1.0.0 

-- Part one: Drop the tables if they exist.
DROP TABLE IF EXISTS voucher_payment;
DROP TABLE IF EXISTS voucher;
DROP TABLE IF EXISTS paypal_payment;
DROP TABLE IF EXISTS debitcard_payment;
DROP TABLE IF EXISTS amexcard_payment;
DROP TABLE IF EXISTS mastercard_payment;
DROP TABLE IF EXISTS visacard_payment;
DROP TABLE IF EXISTS payment_detail;
DROP TABLE IF EXISTS shopping_cart_item;
DROP TABLE IF EXISTS wishlist_item_link;
DROP TABLE IF EXISTS wishlist;
DROP TABLE IF EXISTS sold_item;
DROP TABLE IF EXISTS author_book_link;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS invoice CASCADE;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS person_address_link;
DROP TABLE IF EXISTS person_telephone_link;
DROP TABLE IF EXISTS item_category_link;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS book CASCADE;
DROP TABLE IF EXISTS item_common_detail;
DROP TABLE IF EXISTS reviewer;
DROP TABLE IF EXISTS administrator;
DROP TABLE IF EXISTS email;
DROP TABLE IF EXISTS personal_detail;
DROP TABLE IF EXISTS telephone;
DROP TABLE IF EXISTS publisher;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS address;
-- End of part one.


-- Part two: Create all Tables

-- Create the address table
CREATE TABLE address
(
   address_id integer check(address_id > 0), 
   house      character varying(100) NOT NULL, 
   street     character varying(400) NOT NULL, 
   additional character varying(400), 
   city       character varying(100), 
   area       character varying(100), 
   postcode   character varying(100), 
   country    character varying(200) NOT NULL, 
   PRIMARY KEY (address_id),
   CONSTRAINT unique_address UNIQUE(house, street, additional, city, area, postcode, country)   
) 
WITH (OIDS = FALSE);
ALTER TABLE public.address OWNER TO bookshop;
-- End of the creation of address table

-- Create the category table.
CREATE TABLE category
(
   category_id      integer check(category_id > 0), 
   category_name    character varying(100) NOT NULL UNIQUE,  
   PRIMARY KEY (category_id)
) 
WITH (OIDS = FALSE);
ALTER TABLE category OWNER TO bookshop;
-- End the creatiion of category table

-- Create the publisher table.
CREATE TABLE publisher
(
   publisher_id     integer check(publisher_id > 0), 
   address_id       integer,
   publisher_name   character varying(100) NOT NULL UNIQUE,  
   PRIMARY KEY (publisher_id), 
   FOREIGN KEY(address_id) REFERENCES address(address_id)
) 
WITH (OIDS = FALSE);
ALTER TABLE publisher OWNER TO bookshop;
-- End of the creation of publisher table.

--create the telephone table
CREATE TABLE telephone
(
    telephone_id     integer CHECK(telephone_id > 0),
    country_code     character varying(5)  NOT NULL,  
    area_code        character varying(10),             -- This column can be null since very small country should have no area code. 
    telephone_number character varying(15) NOT NULL,
    telephone_type   character varying(20) NOT NULL CHECK(telephone_type IN ('MOBILE', 'HOME', 'OFFICE')),
    PRIMARY KEY (telephone_id),
    CONSTRAINT unique_telephone UNIQUE(country_code, area_code, telephone_number, telephone_type)
)
WITH (OIDS = FALSE);
ALTER TABLE telephone OWNER TO bookshop;
-- End of the creation of telephone table.

-- Create the personal_detail table.
CREATE TABLE personal_detail
(
   personal_detail_id 	integer CHECK (personal_detail_id > 0),
   title 		character varying(40)  NOT NULL,
   given_name   	character varying(200) NOT NULL,
   family_name  	character varying(200) NOT NULL,
   date_of_birth	date NOT NULL,
   profile              bytea,    -- This profile column should be unique but it cannot be set since it is a bytea type.
   PRIMARY KEY (personal_detail_id)  
) 
WITH (OIDS = FALSE);
ALTER TABLE personal_detail OWNER TO bookshop;
-- End of the creation of personal_detail table.

-- Create the email table.
-- This table is needed because one person may have serveral emails.
CREATE TABLE email
(
    email_id           integer CHECK (email_id > 0),
    personal_detail_id integer,
    email_address      character varying(200) NOT NULL UNIQUE,
    PRIMARY KEY (email_id),
    FOREIGN KEY (personal_detail_id) REFERENCES personal_detail(personal_detail_id)
)
WITH (OIDS = FALSE);
ALTER TABLE email OWNER TO bookshop;
-- End of the creation of email table.

-- Create the adminstrator table.
CREATE TABLE administrator
(
   administrator_id   integer CHECK(administrator_id > 0),
   personal_detail_id integer UNIQUE,
   administrator_role character varying(10) NOT NULL CHECK(administrator_role IN ('OPERATOR', 'ADMIN', 'SYSTEM')),
   username           character varying(200) NOT NULL UNIQUE,
   password           character varying(200) NOT NULL,
   PRIMARY KEY (administrator_id), 
   FOREIGN KEY ( personal_detail_id) REFERENCES  personal_detail( personal_detail_id)
) 
WITH (OIDS = FALSE);
ALTER TABLE administrator OWNER TO bookshop;
-- End of the creation of adminstrator table.

-- Create the reviewer table.
CREATE TABLE reviewer
(
   reviewer_id        integer CHECK (reviewer_id > 0),
   personal_detail_id integer,                            -- This column can be set to null.
   image              bytea,
   username           character varying(200) NOT NULL UNIQUE,
   password           character varying(200) NOT NULL,
   PRIMARY KEY (reviewer_id),
   FOREIGN KEY (personal_detail_id) REFERENCES personal_detail(personal_detail_id) ON DELETE SET NULL  
) 
WITH (OIDS = FALSE);
ALTER TABLE reviewer OWNER TO bookshop;
-- End of the creation of reviewer table.

-- Create the item_common_detail table.
CREATE TABLE item_common_detail
(
   item_common_detail_id integer check(item_common_detail_id > 0),
   item_name             character varying(600) NOT NULL,  
   image                 bytea,
   list_price            numeric(10, 2) NOT NULL CHECK (list_price > 0),
   sale_price            numeric(10, 2) NOT NULL CHECK(sale_price > 0),
   currency_code         character varying(3) NOT NULL CHECK(currency_code IN ('USD', 'BRP', 'EUR', 'RMB', 'YEN', 'DMK', 'SWF')),
   ranking               integer NOT NULL DEFAULT 0 CHECK(ranking >= 0),  -- The zero is used for unranked item.
   description           character varying(4000),
   availability          character varying(20) NOT NULL CHECK (availability in ('YES', 'TO_BE_PRODUCED', 'OUT_OF_STOCK')),
   availability_number   integer CHECK (availability_number >= 0),
   barcode               character varying(100) NOT NULL UNIQUE,
   PRIMARY KEY (item_common_detail_id)
) 
WITH (OIDS = FALSE);
ALTER TABLE item_common_detail OWNER TO bookshop;
-- End of the creation of item_common_detail table

-- Create the book table.
CREATE TABLE book
(
   book_id               integer CHECK(book_id > 0),
   item_common_detail_id integer UNIQUE,               -- This column must be quique since each book is an unique item.
   publisher_id          integer, 
   book_isbn             character varying(13) NOT NULL UNIQUE,
   book_pdf_content      bytea,
   book_edition          integer check(book_edition > 0) NOT NULL DEFAULT 1,
   publish_date          date,
   book_width            numeric(4, 1)  check(book_width >= 0),      -- This column is nullable for the electronic version.
   book_length           numeric(4, 1)  check(book_length >= 0),     -- This column is nullable for the electronic version.
   book_thickness        numeric(4, 1)  check(book_thickness >= 0),  -- This column is nullable for the electronic version.
   uom                   character varying(10) NOT NULL CHECK (uom in ('IN', 'CM', 'ELECTRONIC')),  
   book_format           character varying(20) NOT NULL CHECK (book_format IN ('PAPERBACK', 'HARDCOVER', 'ELECTRONIC')),
   book_language         character varying(3) NOT NULL DEFAULT 'EN', 
   PRIMARY KEY (book_id), 
   FOREIGN KEY(item_common_detail_id) REFERENCES item_common_detail(item_common_detail_id),
   FOREIGN KEY(publisher_id) REFERENCES publisher(publisher_id)
) 
WITH (OIDS = FALSE);
ALTER TABLE book OWNER TO bookshop;
-- End of the creation of book table

-- Create the review table
CREATE TABLE review
(
    review_id             integer CHECK (review_id > 0),
    reviewer_id           integer,
    item_common_detail_id integer,
    review_ranking        integer CHECK (review_ranking > 0),
    review_text           character varying(4000),
    PRIMARY KEY(review_id),
    FOREIGN KEY(reviewer_id) REFERENCES reviewer(reviewer_id),
    FOREIGN KEY(item_common_detail_id) REFERENCES item_common_detail(item_common_detail_id),
    CONSTRAINT UNIQUE_REVIEW UNIQUE(reviewer_id, item_common_detail_id)
) 
WITH (OIDS = FALSE);
ALTER TABLE review OWNER TO bookshop;
-- End of the creation of review table

-- Create the item_category_link table.
CREATE TABLE item_category_link
(
   item_common_detail_id integer,
   category_id           integer, 
   PRIMARY KEY (item_common_detail_id, category_id), 
   FOREIGN KEY(item_common_detail_id) REFERENCES item_common_detail(item_common_detail_id),
   FOREIGN KEY(category_id) REFERENCES category(category_id)   
) 
WITH (OIDS = FALSE);
ALTER TABLE item_category_link OWNER TO bookshop;
-- End of the creation of book_category_link table.

--Create the telephone_persion_link table
CREATE TABLE person_telephone_link 
(
    personal_detail_id integer,
    telephone_id       integer,
    PRIMARY KEY (personal_detail_id, telephone_id),
    FOREIGN KEY(personal_detail_id) REFERENCES personal_detail(personal_detail_id),
    FOREIGN KEY(telephone_id) REFERENCES telephone(telephone_id)
)
WITH (OIDS = FALSE);
ALTER TABLE person_telephone_link  OWNER TO bookshop;
-- End of the creation of telephone_pserson_link table.

-- Create the person_address_link Table
CREATE TABLE person_address_link
(   
    link_id            integer CHECK(link_id > 0),
    personal_detail_id integer,
    address_id         integer,
    address_type       character varying(10) NOT NULL CHECK(address_type IN('CONTACT', 'DELIVERY', 'OPTIONAL', 'NEXT_OF_KIN')), 
    PRIMARY KEY (link_id), 
    FOREIGN KEY(personal_detail_id) REFERENCES personal_detail(personal_detail_id),
    FOREIGN KEY(address_id) REFERENCES address(address_id),   
    CONSTRAINT unique_person_address_link UNIQUE (address_id, personal_detail_id, address_type)
)
WITH (OIDS = FALSE);
ALTER TABLE person_address_link OWNER TO bookshop;
-- End of the creation of person_address_link table.

-- Create the customer Table
CREATE TABLE customer
(    
    customer_id            integer CHECK(customer_id > 0),
    person_address_link_id integer UNIQUE,
    username               character varying(200) NOT NULL UNIQUE,
    password               character varying(200) NOT NULL,
    image                  bytea,
    PRIMARY KEY (customer_id),
    FOREIGN KEY(person_address_link_id) REFERENCES person_address_link(link_id) 	  
)
WITH (OIDS = FALSE);
ALTER TABLE customer OWNER TO bookshop;
-- End of the creation of customer table.

-- Create the invoice table
CREATE TABLE invoice
(
    invoice_id          integer CHECK (invoice_id > 0),
    customer_id         integer,
    delivery_address_id integer,
    invoice_date        date DEFAULT now() NOT NULL,
    total               numeric(10, 2) CHECK (total > 0) NOT NULL,
    validity            character varying(3)  NOT NULL DEFAULT 'YES' CHECK(validity IN ('YES', 'NO')),
    reference_number    character varying(12) NOT NULL UNIQUE,
    PRIMARY KEY(invoice_id),
    FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY(delivery_address_id) REFERENCES address(address_id) ON DELETE SET NULL
)
WITH (OIDS = FALSE);
ALTER TABLE invoice OWNER TO bookshop;
-- End of the creation of invoice table.


-- Create the author table
CREATE TABLE author
(
    author_id          integer,
    personal_detail_id integer UNIQUE,
    image              bytea,
    biography          bytea,
    webpage_url        character varying(200),   -- change this name as webpage_url
    PRIMARY KEY(author_id),
    FOREIGN KEY(personal_detail_id) REFERENCES personal_detail(personal_detail_id)	   
)
WITH (OIDS = FALSE);
ALTER TABLE author OWNER TO bookshop;
-- End of the creation of author table

-- Create the author_book_link Table
CREATE TABLE author_book_link
(
    author_id integer,
    book_id   integer,
    PRIMARY KEY(author_id, book_id),  
    FOREIGN KEY(book_id) REFERENCES book(book_id),
    FOREIGN KEY(author_id) REFERENCES author(author_id)
)
WITH (OIDS = FALSE);
ALTER TABLE author_book_link OWNER TO bookshop;
-- End of the creation of author_book_link table.

-- Create the sold_item table
CREATE TABLE sold_item
(
    sold_item_id          integer CHECK(sold_item_id > 0),
    invoice_id            integer,
    item_common_detail_id integer,
    quantity              integer NOT NULL CHECK(quantity > 0),
    unit_price            numeric(10, 2) NOT NULL CHECK(unit_price > 0),
    PRIMARY KEY (sold_item_id),
    FOREIGN KEY(item_common_detail_id) REFERENCES item_common_detail(item_common_detail_id),
    FOREIGN KEY(invoice_id) REFERENCES invoice(invoice_id),
    CONSTRAINT unique_sold_item UNIQUE(invoice_id, item_common_detail_id)  
)
WITH (OIDS = FALSE);
ALTER TABLE sold_item OWNER TO bookshop;
-- End of the creation of sold_item table.

-- Create the wishlist Table
CREATE TABLE wishlist
(
    wishlist_id   integer CHECK(wishlist_id > 0),
    wishlist_name character varying(100) NOT NULL,
    customer_id   integer,
    PRIMARY KEY(wishlist_id),
    FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
    CONSTRAINT unique_name_customer_id UNIQUE (customer_id, wishlist_name)
)
WITH (OIDS = FALSE);
ALTER TABLE wishlist OWNER TO bookshop;
-- End of the creation of wishlist table.

-- Create the wishlist_item_link table
CREATE TABLE wishlist_item_link
(
    wishlist_id           integer,
    item_common_detail_id integer,
    PRIMARY KEY(wishlist_id, item_common_detail_id),
    FOREIGN KEY(item_common_detail_id) REFERENCES item_common_detail(item_common_detail_id),
    FOREIGN KEY(wishlist_id) REFERENCES wishlist(wishlist_id)    
)
WITH (OIDS = FALSE);
ALTER TABLE wishlist_item_link OWNER TO bookshop;
-- End of the creation of wishlist_book_link table

-- Create the shopping_cart_item table
CREATE TABLE shopping_cart_item
(
    shopping_cart_item_id integer CHECK (shopping_cart_item_id > 0),
    customer_id           integer,
    item_common_detail_id integer,
    unit_number           integer NOT NULL CHECK (unit_number > 0),  
    PRIMARY KEY(shopping_cart_item_id),
    FOREIGN KEY(item_common_detail_id) REFERENCES item_common_detail(item_common_detail_id),
    FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
    CONSTRAINT UNIQUE_SHOPPING_CART UNIQUE(customer_id, item_common_detail_id)      
)
WITH (OIDS = FALSE);
ALTER TABLE shopping_cart_item OWNER TO bookshop;
-- End of the creation of shopping_cart_item table.

-- Create the payment_detail table
CREATE TABLE payment_detail
(
    payment_detail_id integer CHECK(payment_detail_id > 0) UNIQUE,
    invoice_id        integer,
    payment_type      character varying(11) NOT NULL CHECK(payment_type IN ('VISA_CARD', 'MASTER_CARD', 'DEBIT_CARD', 'AMEX_CARD', 'PAYPAL', 'VOUCHER')),
    subtotal          numeric(10, 2) NOT NULL CHECK(subtotal > 0),
    currency_code     character varying(3) NOT NULL CHECK(currency_code IN ('USD', 'BRP', 'EUR', 'RMB', 'YEN', 'DMK', 'SWF')),
    PRIMARY KEY(payment_detail_id, payment_type),             --This has to match the foreign key to let Hibernate work. Postgres itself can work without the payment_type information.
    FOREIGN KEY(invoice_id) REFERENCES invoice(invoice_id),
    CONSTRAINT id_type_key UNIQUE (payment_detail_id, payment_type)
)
WITH (OIDS = FALSE);
ALTER TABLE payment_detail OWNER TO bookshop;

-- End of the creatiion of payment_detail table.

-- Create the visacard_payment table
CREATE TABLE visacard_payment
(
    payment_id             integer CHECK(payment_id > 0),
    payment_detail_id      integer UNIQUE,
    person_address_link_id integer,
    payment_type           character varying(11) CHECK(payment_type IN ('VISA_CARD')) DEFAULT 'VISA_CARD',
    card_number            character varying(16) NOT NULL,   -- The card number cannot be set unique since this table is for the payment, not for the card.
    security_code          character varying(3) NOT NULL,
    start_date             date NOT NULL,
    expire_date            date NOT NULL,
    PRIMARY KEY(payment_id),
    FOREIGN KEY(payment_detail_id, payment_type) REFERENCES payment_detail(payment_detail_id, payment_type),
    FOREIGN KEY(person_address_link_id) REFERENCES person_address_link(link_id) 
)
WITH (OIDS = FALSE);
ALTER TABLE visacard_payment OWNER TO bookshop;
-- End of the creation of visacard_payment table.

-- Create the mastercard_payment Table
CREATE TABLE mastercard_payment
(
    payment_id             integer CHECK(payment_id > 0),
    payment_detail_id      integer UNIQUE,
    person_address_link_id integer,
    payment_type           character varying(11) CHECK(payment_type IN ('MASTER_CARD')) DEFAULT 'MASTER_CARD',
    card_number            character varying(16) NOT NULL,   -- The card number cannot be set unique since this table is for the payment, not for the card.
    security_code          character varying(3) NOT NULL,
    start_date             date NOT NULL,
    expire_date            date NOT NULL,
    PRIMARY KEY(payment_id),
    FOREIGN KEY(payment_detail_id, payment_type) REFERENCES payment_detail(payment_detail_id, payment_type),
    FOREIGN KEY(person_address_link_id) REFERENCES person_address_link(link_id) 
)
WITH (OIDS = FALSE);
ALTER TABLE mastercard_payment OWNER TO bookshop;
-- End of the creation of mastercard_payment table.

-- Create the amexcard_payment table
CREATE TABLE amexcard_payment
(
    payment_id             integer CHECK(payment_id > 0),
    payment_detail_id      integer UNIQUE,
    person_address_link_id integer,
    payment_type           character varying(11) CHECK(payment_type IN ('AMEX_CARD')) DEFAULT 'AMEX_CARD',
    card_number            character varying(15) NOT NULL,   -- The card number cannot be set unique since this table is for the payment, not for the card.
    security_code          character varying(4) NOT NULL,
    expire_date            date NOT NULL,
    PRIMARY KEY(payment_id),
    FOREIGN KEY(payment_detail_id, payment_type) REFERENCES payment_detail(payment_detail_id, payment_type),
    FOREIGN KEY(person_address_link_id) REFERENCES person_address_link(link_id) 
)
WITH (OIDS = FALSE);
ALTER TABLE amexcard_payment OWNER TO bookshop;
-- End of the creation of amexcard_payment table.

-- Create the debitcard_payment table
CREATE TABLE debitcard_payment
(
    payment_id             integer CHECK(payment_id > 0),
    payment_detail_id      integer UNIQUE,
    person_address_link_id integer,
    payment_type           character varying(11) CHECK(payment_type IN ('DEBIT_CARD')) DEFAULT 'DEBIT_CARD',
    card_number            character varying(16) NOT NULL,   -- The card number cannot be set unique since this table is for the payment, not for the card.
    security_code          character varying(3) NOT NULL,
    issue_number           integer,
    start_date             date NOT NULL,
    expire_date            date NOT NULL,
    PRIMARY KEY (payment_id),
    FOREIGN KEY(payment_detail_id, payment_type) REFERENCES payment_detail(payment_detail_id, payment_type),
    FOREIGN KEY(person_address_link_id) REFERENCES person_address_link(link_id) 
)
WITH (OIDS = FALSE);
ALTER TABLE debitcard_payment OWNER TO bookshop;
-- End of the creation of debitcard_payment table.

-- Create the paypal_payment table
CREATE TABLE paypal_payment
(
    payment_id            integer CHECK(payment_id > 0),
    payment_detail_id     integer UNIQUE,
    paypal_account_id     character varying(100) NOT NULL,
    payment_type          character varying(11) CHECK(payment_type IN ('PAYPAL')) DEFAULT 'PAYPAL',
    paypal_identity_token character varying(100) NOT NULL,   -- The identity token cannot be set unique since this table is for the payment, not for the paypal account.
    PRIMARY KEY(payment_id),
    FOREIGN KEY(payment_detail_id, payment_type) REFERENCES payment_detail(payment_detail_id, payment_type)
)
WITH (OIDS = FALSE);
ALTER TABLE paypal_payment OWNER TO bookshop;
-- End of the creation of paypal_payment table.

-- Create the voucher table
CREATE TABLE voucher
(
    voucher_id    integer CHECK(voucher_id > 0),
    customer_id   integer,
    voucher_token character varying(19) NOT NULL UNIQUE,
    total         numeric(10, 2) NOT NULL,
    expire_date   date NOT NULL,
    PRIMARY KEY(voucher_id),
    FOREIGN KEY(customer_id) REFERENCES customer(customer_id) 
)
WITH (OIDS = FALSE);
ALTER TABLE voucher OWNER TO bookshop;
-- End of the creation of voucher table.

-- Create the voucher_payment table
CREATE TABLE voucher_payment
( 
    payment_detail_id integer UNIQUE,
    voucher_id        integer,
    payment_type      character varying(11) CHECK(payment_type IN ('VOUCHER')) DEFAULT 'VOUCHER',
    PRIMARY KEY (payment_detail_id, payment_type, voucher_id),
    FOREIGN KEY(payment_detail_id, payment_type) REFERENCES payment_detail(payment_detail_id, payment_type),
    FOREIGN KEY(voucher_id) REFERENCES voucher(voucher_id)
)
WITH (OIDS = FALSE);
ALTER TABLE voucher OWNER TO bookshop;
-- End of the creation of voucher_payment table.

-- End of part two.

-- Add extra constraints.


--CREATE TABLE emp (
 --   empname text,
--    salary integer,
--    last_date timestamp,
--    last_user text
--);

-- CREATE FUNCTION customer_address() RETURNS trigger AS $customer_address$
--     BEGIN
--         -- Check that empname and salary are given
--         IF NEW.empname IS NULL THEN
--             RAISE EXCEPTION 'empname cannot be null';
--         END IF;
--         IF NEW.salary IS NULL THEN
--             RAISE EXCEPTION '% cannot have null salary', NEW.empname;
--         END IF;
-- 
--         -- Who works for us when she must pay for it?
--         IF NEW.salary < 0 THEN
--             RAISE EXCEPTION '% cannot have a negative salary', NEW.empname;
--         END IF;
-- 
--         -- Remember who changed the payroll when
--         NEW.last_date := current_timestamp;
--         NEW.last_user := current_user;
--         RETURN NEW;
--     END;
-- $customer_address$ LANGUAGE plpgsql;
-- 
-- CREATE TRIGGER customer_address BEFORE INSERT OR UPDATE ON customer
--     FOR EACH ROW EXECUTE PROCEDURE customer_address();