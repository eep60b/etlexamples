-- Part 1: delete all the data.

DELETE FROM voucher_payment;
DELETE FROM voucher;
DELETE FROM paypal_payment;
DELETE FROM debitcard_payment;
DELETE FROM amexcard_payment;
DELETE FROM mastercard_payment;
DELETE FROM visacard_payment;
DELETE FROM payment_detail;
DELETE FROM shopping_cart_item;
DELETE FROM sold_item;
DELETE FROM wishlist_item_link;
DELETE FROM wishlist;
DELETE FROM author_book_link;
DELETE FROM author;
DELETE FROM invoice;
DELETE FROM customer;
DELETE FROM person_address_link;
DELETE FROM person_telephone_link;
DELETE FROM item_category_link;
DELETE FROM review;
DELETE FROM book;
DELETE FROM item_common_detail;
DELETE FROM reviewer;
DELETE FROM administrator;
DELETE FROM email;
DELETE FROM personal_detail;
DELETE FROM telephone;
DELETE FROM publisher;
DELETE FROM category;
DELETE FROM address;

-- Part 2: Add data to tables. 

INSERT INTO address(address_id, house, street,            additional,  city,       area,       postcode,   country) 
             VALUES(1,          '81',  'Caernarfon Road', null,        'Bangor',   'Gwynedd',  'LL57 4LN', 'UK');
INSERT INTO address(address_id, house, street,          additional,  city,       area,       postcode,   country) 
             VALUES(2,          '233',  'Spring Street', '6th floor', 'New York', 'New York', 'NY 11973', 'US');
INSERT INTO address(address_id, house,                                    street,              additional,       city,      area,                postcode,  country) 
             VALUES(5,          'First Floor, Block D, North Star House', 'North Star Avenue', null,             'Swindon', 'Greate Manchester', 'SN2 1FA', 'UK');

INSERT INTO category(category_id, category_name) VALUES(1,  'Computer Science');
INSERT INTO category(category_id, category_name) VALUES(15, 'Fiction');

INSERT INTO publisher(publisher_id, address_id, publisher_name) VALUES(1, 2, 'Apress');
INSERT INTO publisher(publisher_id, address_id, publisher_name) VALUES(5, 2, 'BCS The Chartered Institute for IT');

INSERT INTO telephone(telephone_id, country_code, area_code, telephone_number, telephone_type) 
               VALUES(1,            '44',         '1248',    '644515',         'HOME');
INSERT INTO telephone(telephone_id, country_code, area_code, telephone_number, telephone_type) 
               VALUES(2,            '44',         null,      '785534123',      'MOBILE');
INSERT INTO telephone(telephone_id, country_code, area_code, telephone_number, telephone_type) 
               VALUES(8,            '1',          '631',     '71205420',       'OFFICE');
INSERT INTO telephone(telephone_id, country_code, area_code, telephone_number, telephone_type) 
               VALUES(19,           '878',        null,      '37534123',       'MOBILE');

INSERT INTO personal_detail(personal_detail_id, title, given_name,   family_name, date_of_birth,        profile)
                     VALUES(1,                  'MR',  'William J.', 'Jones',     '12-5-1967 21:6:4',   'laflkafdkalfjalfja;');
INSERT INTO personal_detail(personal_detail_id, title, given_name,   family_name, date_of_birth,        profile)
                     VALUES(5,                  'MRS', 'Kate',       'Miller',    '1-31-1979 23:56:40', 'alfajlfalajdlsafas;lfa');
INSERT INTO personal_detail(personal_detail_id, title, given_name,   family_name, date_of_birth,        profile)
                     VALUES(60,                 'MR',  'Ted',        'Smith',     '1-1-1970 13:00:07',  'alfdalfjlafkalfjdal394');
INSERT INTO personal_detail(personal_detail_id, title, given_name,   family_name, date_of_birth,        profile)
                     VALUES(123,                'DR',  'Tom',        'Roberts',   '11-10-1982 1:2:00',  'lnnc,c,qk32l3325234232');

INSERT INTO email(email_id, personal_detail_id, email_address) 
           VALUES(1,        1,                  'wjj2205@gmail.com');
INSERT INTO email(email_id, personal_detail_id, email_address) 
           VALUES(2,        1,                  'wjj1111@hotmail.com');
INSERT INTO email(email_id, personal_detail_id, email_address) 
           VALUES(6,        5,                  'KM@kmail.com');
INSERT INTO email(email_id, personal_detail_id, email_address) 
           VALUES(17,       60,                 'ts@kun.com');
INSERT INTO email(email_id, personal_detail_id, email_address) 
           VALUES(22,       5,                  'diaaleala@gmail.com');
INSERT INTO email(email_id, personal_detail_id, email_address) 
           VALUES(584,      5,                  'aldkalaf@rokd.dla.ac.uk');

INSERT INTO administrator(administrator_id, personal_detail_id, administrator_role, username,  password)
                   VALUES(1,                1,                  'SYSTEM',           'wjjones', 'lafalfalfaoqew');
INSERT INTO administrator(administrator_id, personal_detail_id, administrator_role, username,  password)
                   VALUES(37,               60,                 'ADMIN',            'km12304', 'alfjaloea093f');

INSERT INTO reviewer(reviewer_id, personal_detail_id, image, username,   password) 
              VALUES(1,           1,                  null,  'wjjones',  'lafalfalfaoqew');
INSERT INTO reviewer(reviewer_id, personal_detail_id, image, username,   password) 
              VALUES(18,          null,               null, 'anonomose', '4j9kq4rqkl4');

INSERT INTO item_common_detail(item_common_detail_id, item_name,              image, list_price, sale_price, currency_code, ranking, description,          availability,   availability_number, barcode)
                        VALUES(1,                     'Practical API Design', null,  36.99,      23.95,      'BRP',         472,     'A very good guide.', 'YES',          14,                  '119347194031');
INSERT INTO item_common_detail(item_common_detail_id, item_name,              image, list_price, sale_price, currency_code, ranking, description,          availability,   availability_number, barcode)
                        VALUES(10,                    'Master JSF',           null,  24.10,      17,         'USD',         3231,    'JSF in details.',    'OUT_OF_STOCK', 0,                   '347181843719');
INSERT INTO item_common_detail(item_common_detail_id, item_name,              image, list_price, sale_price, currency_code, ranking, description,          availability, availability_number,   barcode)
                        VALUES(134,                   'Quick Book',           null,  36.99,      23.95,      'BRP',         472,     'A very good guide.', 'YES',        8,                     '683452345232');

INSERT INTO book(book_id, item_common_detail_id, publisher_id, book_isbn,       book_pdf_content, book_edition, publish_date,          book_width, book_length, book_thickness, uom,  book_format,  book_language)
          VALUES(1,       1,                     1,            '9781430209737', null,             1,            '2006-12-01 11:23:57', 12,         30,          4,              'CM', 'PAPERBACK',  'EN');
INSERT INTO book(book_id, item_common_detail_id, publisher_id, book_isbn,       book_pdf_content, book_edition, publish_date,          book_width, book_length, book_thickness, uom,  book_format,  book_language)
          VALUES(44,      10,                    1,            '7505675867474', null,             1,            '2006-1-31 1:4:9',     6.8,        22.4,        1.5,            'IN', 'ELECTRONIC', 'FR');
INSERT INTO book(book_id, item_common_detail_id, publisher_id, book_isbn,       book_pdf_content, book_edition, publish_date,          book_width, book_length, book_thickness, uom,          book_format,  book_language)
          VALUES(321,     134,                   5,            '0924502350453', null,             1,            '2006-10-30 23:00:00', null,       null,        null,           'ELECTRONIC', 'HARDCOVER',  'ZH');

INSERT INTO review(review_id, reviewer_id, item_common_detail_id, review_ranking, review_text) 
            VALUES(1,         1,           1,                     10,             'Exceptionally good.');

INSERT INTO item_category_link(item_common_detail_id, category_id) VALUES(1, 1);

INSERT INTO person_telephone_link(personal_detail_id, telephone_id) VALUES(1,  1);
INSERT INTO person_telephone_link(personal_detail_id, telephone_id) VALUES(60, 8);

INSERT INTO person_address_link(link_id, address_id, personal_detail_id, address_type) VALUES(1,  1, 1,  'CONTACT');
INSERT INTO person_address_link(link_id, address_id, personal_detail_id, address_type) VALUES(26, 5, 60, 'OPTIONAL');

INSERT INTO customer(customer_id, person_address_link_id, username, password,   image) 
              VALUES(1,           1,                      'wjj',    'wjj00000', 'imangemiangekl');

INSERT INTO invoice(invoice_id, customer_id, delivery_address_id, invoice_date,         total, validity, reference_number) 
             VALUES(1,          1,           1,                   now(),                15.84, 'YES',    'afdaadefa3');
INSERT INTO invoice(invoice_id, customer_id, delivery_address_id, invoice_date,         total, validity, reference_number) 
             VALUES(2,          1,           5,                   '10-4-2015 12:59:00', 2.84,  'NO',     'a245fjd30jd');

INSERT INTO author(author_id, personal_detail_id, image, biography, webpage_url)
            VALUES(1,         1,                  null,  null,      'www.org.valid.author.link');

INSERT INTO author_book_link(author_id, book_id) VALUES(1, 1);

INSERT INTO sold_item(sold_item_id, invoice_id, item_common_detail_id, quantity, unit_price) VALUES(1, 1, 1, 5, 25.66);


INSERT INTO wishlist(wishlist_id, wishlist_name, customer_id) VALUES(1, 'Default wishlist', 1);

INSERT INTO wishlist_item_link(wishlist_id, item_common_detail_id) VALUES(1, 1);

INSERT INTO shopping_cart_item(shopping_cart_item_id, customer_id, item_common_detail_id, unit_number) VALUES(1, 1, 1, 3);

INSERT INTO payment_detail(payment_detail_id, invoice_id, payment_type,  subtotal, currency_code) 
                    VALUES(1,                 1,          'VISA_CARD',   87.65,    'BRP');
INSERT INTO payment_detail(payment_detail_id, invoice_id, payment_type,  subtotal, currency_code) 
                    VALUES(2,                 1,          'MASTER_CARD', 6.19,     'BRP');
INSERT INTO payment_detail(payment_detail_id, invoice_id, payment_type,  subtotal, currency_code) 
                    VALUES(3,                 1,          'AMEX_CARD',   2.26,     'BRP');
INSERT INTO payment_detail(payment_detail_id, invoice_id, payment_type,  subtotal, currency_code) 
                    VALUES(4,                 1,          'DEBIT_CARD',  7.00,     'BRP');
INSERT INTO payment_detail(payment_detail_id, invoice_id, payment_type,  subtotal, currency_code) 
                    VALUES(5,                 1,          'PAYPAL',      16.11,    'BRP');
INSERT INTO payment_detail(payment_detail_id, invoice_id, payment_type,  subtotal, currency_code) 
                    VALUES(6,                 1,          'VOUCHER',     0.53,     'BRP');

INSERT INTO visacard_payment(payment_id, payment_detail_id, person_address_link_id, payment_type, card_number,        security_code, start_date,            expire_date)
                      VALUES(1,          1,                 1,                      'VISA_CARD',  '1234567890123456', '999',         '12-14-2013 12:59:00', now());


INSERT INTO mastercard_payment(payment_id, payment_detail_id, person_address_link_id, payment_type,  card_number,        security_code, start_date,           expire_date)
                        VALUES(1,          2,                 1,                      'MASTER_CARD', '9999999999999999', '999',         '7-30-2013 21:47:52', '2-19-2018 12:33:11');


INSERT INTO amexcard_payment(payment_id, payment_detail_id, person_address_link_id, payment_type, card_number,        security_code, expire_date)
                      VALUES(1,          3,                 1,                      'AMEX_CARD',  '999999999999999',   '9999',       '1-29-20018 17:33:56');

INSERT INTO debitcard_payment(payment_id, payment_detail_id, person_address_link_id, payment_type, card_number,        security_code, issue_number, start_date,            expire_date)
                       VALUES(1,          4,                 1,                      'DEBIT_CARD', '9999999999999999', '999',         3,            '09-23-2012 12:59:00', '5-14-2018 17:32:12');


INSERT INTO paypal_payment(payment_id, payment_detail_id, paypal_account_id, payment_type, paypal_identity_token) 
                    VALUES(1,          5,                 '3021099013',      'PAYPAL',     'akui3kk13k');

INSERT INTO voucher(voucher_id, customer_id, voucher_token,      total, expire_date) 
             VALUES(1,          1,           'KDYAIRN33FDK7482', 50.47, '5-14-2018 17:32:12');

INSERT INTO voucher_payment(payment_detail_id, voucher_id, payment_type) 
                     VALUES(6,                 1,          'VOUCHER');
