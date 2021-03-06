-- clean the tables

DELETE FROM VOUCHER_PAYMENT;
DELETE FROM VOUCHER;
DELETE FROM PAYPAL_PAYMENT;
DELETE FROM DEBITCARD_PAYMENT;
DELETE FROM AMEXCARD_PAYMENT;
DELETE FROM VISACARD_PAYMENT;
DELETE FROM MASTERCARD_PAYMENT;
DELETE FROM PAYMENT_DETAIL;
DELETE FROM SHOPPING_CART_ITEM;
DELETE FROM WISHLIST_ITEM_LINK;
DELETE FROM WISHLIST;
DELETE FROM SOLD_ITEM;
DELETE FROM AUTHOR_BOOK_LINK;
DELETE FROM AUTHOR;
DELETE FROM INVOICE;
DELETE FROM CUSTOMER;
DELETE FROM PERSON_ADDRESS_LINK;
DELETE FROM PERSON_TELEPHONE_LINK;
DELETE FROM ITEM_CATEGORY_LINK;
DELETE FROM REVIEW;
DELETE FROM BOOK;
DELETE FROM ITEM_COMMON_DETAIL;
DELETE FROM REVIEWER;
DELETE FROM ADMINISTRATOR;
DELETE FROM EMAIL;
DELETE FROM PERSONAL_DETAIL;
DELETE FROM TELEPHONE;
DELETE FROM PUBLISHER;
DELETE FROM CATEGORY;
DELETE FROM ADDRESS;


-- Populate Tables
-- Populate the ADDRESS table.
 INSERT INTO ADDRESS (ADDRESS_ID, HOUSE, STREET,            ADDITIONAL,      CITY,         AREA,               POSTCODE,   COUNTRY) 
             VALUES  (1,          '62',  'Cotter Street',   'Poor location', 'Manchester', 'Great Manchester', 'M12 6EY',  'UK');
 INSERT INTO ADDRESS (ADDRESS_ID, HOUSE, STREET,            ADDITIONAL,      CITY,         AREA,               POSTCODE,   COUNTRY) 
             VALUES  (954,        '81',  'Caernarfon Road', 'fun home',      'Bangor',     'Gwynedd',          'LL57 4LN', 'UK');

-- Populate the CATEGORY table.
 INSERT INTO CATEGORY(CATEGORY_ID, CATEGORY_NAME) VALUES(1,    'Fiction');
 INSERT INTO CATEGORY(CATEGORY_ID, CATEGORY_NAME) VALUES(2590, 'Novel');

-- Populate the PUBLISHER table.
 INSERT INTO PUBLISHER(PUBLISHER_ID, ADDRESS_ID, PUBLISHER_NAME) VALUES(1,   1,   'Strange');
 INSERT INTO PUBLISHER(PUBLISHER_ID, ADDRESS_ID, PUBLISHER_NAME) VALUES(143, 954, 'Apress');

-- Populate the TELEPHONE table.
INSERT INTO TELEPHONE(TELEPHONE_ID, COUNTRY_CODE, AREA_CODE, TELEPHONE_TYPE, TELEPHONE_NUMBER)
              VALUES (1,            '44',        '01248',    'HOME',         '923891');

INSERT INTO TELEPHONE(TELEPHONE_ID, COUNTRY_CODE, AREA_CODE, TELEPHONE_TYPE, TELEPHONE_NUMBER)
              VALUES (93,           '44',            '0161', 'OFFICE',         '1410947190');

INSERT INTO TELEPHONE(TELEPHONE_ID, COUNTRY_CODE, AREA_CODE, TELEPHONE_TYPE, TELEPHONE_NUMBER)
              VALUES (8194,         '45',            '048',  'MOBILE',         '9312434');

-- Populate the PERSON table.
INSERT INTO PERSONAL_DETAIL(PERSONAL_DETAIL_ID, TITLE, GIVEN_NAME, FAMILY_NAME, DATE_OF_BIRTH,                       PROFILE) 
                     VALUES(1,                  'MR.', 'Tomy',     'Jones',     TO_DATE('1979/12/25', 'yyyy/mm/dd'), UTL_RAW.CAST_TO_RAW('aldknadkaahkd'));
INSERT INTO PERSONAL_DETAIL(PERSONAL_DETAIL_ID, TITLE, GIVEN_NAME, FAMILY_NAME, DATE_OF_BIRTH,                     PROFILE)  
                     VALUES(3493,               'Ms.', 'Kik',      'Tellers',   TO_DATE('1954/3/1', 'yyyy/mm/dd'), UTL_RAW.CAST_TO_RAW('dfjaakdhkd'));
INSERT INTO PERSONAL_DETAIL(PERSONAL_DETAIL_ID, TITLE, GIVEN_NAME, FAMILY_NAME, DATE_OF_BIRTH,                     PROFILE)  
                     VALUES(19721,              'Dr.', 'Tuna',     'Tricks',    TO_DATE('1966/6/7', 'yyyy/mm/dd'), UTL_RAW.CAST_TO_RAW('dfjaadafadhkd'));

-- Populate the EMAIL table.
INSERT INTO EMAIL(EMAIL_ID, PERSONAL_DETAIL_ID, EMAIL_ADDRESS) VALUES(1,   1, 'tj201@kmail.com');
INSERT INTO EMAIL(EMAIL_ID, PERSONAL_DETAIL_ID, EMAIL_ADDRESS) VALUES(43,  1, 'ppx0038@gotmail.com');
INSERT INTO EMAIL(EMAIL_ID, PERSONAL_DETAIL_ID, EMAIL_ADDRESS) VALUES(172, 3493, 'sunk@bpress.com');
INSERT INTO EMAIL(EMAIL_ID, PERSONAL_DETAIL_ID, EMAIL_ADDRESS) VALUES(5903, 1, 'eek38f@hmail.com');

-- Populate the ADMINISTRATOR table.
INSERT INTO ADMINISTRATOR(ADMINISTRATOR_ID, PERSONAL_DETAIL_ID, ADMINISTRATOR_ROLE, USERNAME, PASSWORD)
                   VALUES(1,                1,                  'SYSTEM',           'admin',  'admiammdnn');

-- Populate the REVIEWER table.
INSERT INTO REVIEWER(REVIEWER_ID, PERSONAL_DETAIL_ID, IMAGE,          USERNAME, PASSWORD)
              VALUES(1,           1,                  empty_blob(),   'alndim', 'oaaonv');
INSERT INTO REVIEWER(REVIEWER_ID, PERSONAL_DETAIL_ID, IMAGE,          USERNAME, PASSWORD)
              VALUES(1931,        null,               null,           'anomor', 'oaaonv');

-- Populate the ITEM table.
INSERT INTO ITEM_COMMON_DETAIL(ITEM_COMMON_DETAIL_ID, ITEM_NAME,           IMAGE,        LIST_PRICE, SALE_PRICE, CURRENCY_CODE, RANKING, DESCRIPTION,        AVAILABILITY,    AVAILABILITY_NUMBER, BARCODE)
                        VALUES(1,                     'The fantasy world', empty_blob(), 45.75,      25.99,      'BRP',         321,     'BOOK_DESCRIPTION', 'YES',           25,                  '183187190371034');
INSERT INTO ITEM_COMMON_DETAIL(ITEM_COMMON_DETAIL_ID, ITEM_NAME,                IMAGE,   LIST_PRICE, SALE_PRICE, CURRENCY_CODE, RANKING, DESCRIPTION,         AVAILABILITY,   AVAILABILITY_NUMBER, BARCODE)
                        VALUES(66906,                 'The tale of two cities', null,    28.87,      26.35,      'USD',         39134,   'A very good book.', 'OUT_OF_STOCK', 0,                   '119021931289879');

-- Populate the BOOK table.
INSERT INTO BOOK(BOOK_ID, ITEM_COMMON_DETAIL_ID, PUBLISHER_ID, BOOK_ISBN,       BOOK_PDF_CONTENT, BOOK_EDITION, PUBLISH_DATE,                        BOOK_WIDTH, BOOK_LENGTH, BOOK_THICKNESS, UOM,  BOOK_FORMAT,  BOOK_LANGUAGE)
          VALUES(1,       1,                     1,            '1234567890123', empty_blob(),     1,            TO_DATE('1989/12/31', 'yyyy/mm/dd'), 19,         29,          4,              'IN', 'PAPERBACK',   'EN');
INSERT INTO BOOK(BOOK_ID, ITEM_COMMON_DETAIL_ID, PUBLISHER_ID, BOOK_ISBN,       BOOK_PDF_CONTENT, BOOK_EDITION, PUBLISH_DATE,                        BOOK_WIDTH, BOOK_LENGTH, BOOK_THICKNESS, UOM,  BOOK_FORMAT,    BOOK_LANGUAGE) 
          VALUES(2317,    66906,                 143,          '3125341313131', null,             3,            TO_DATE('2013/1/14', 'yyyy/mm/dd'),  54,         69,          12,             'CM', 'ELECTRONIC',   'GE');

-- Populate the REVIEW table.
INSERT INTO REVIEW(REVIEW_ID, REVIEWER_ID, ITEM_COMMON_DETAIL_ID, REVIEW_RANKING, REVIEW_TEXT) 
            VALUES(1,         1,           1,       3421,           'REVIEW_TEXT');
INSERT INTO REVIEW(REVIEW_ID, REVIEWER_ID, ITEM_COMMON_DETAIL_ID, REVIEW_RANKING, REVIEW_TEXT) 
            VALUES(3138,      1931,        66906,   414,            'A very good book for reviewer.');

-- Populate the ITEM_CATEGORY_LINK table.
 INSERT INTO ITEM_CATEGORY_LINK(ITEM_COMMON_DETAIL_ID, CATEGORY_ID) VALUES(1, 1);
 INSERT INTO ITEM_CATEGORY_LINK(ITEM_COMMON_DETAIL_ID, CATEGORY_ID) VALUES(66906, 2590);

-- Populate the TELEPHONE table.
INSERT INTO PERSON_TELEPHONE_LINK(PERSONAL_DETAIL_ID, TELEPHONE_ID) VALUES (1, 1);
INSERT INTO PERSON_TELEPHONE_LINK(PERSONAL_DETAIL_ID, TELEPHONE_ID) VALUES (1, 93);
INSERT INTO PERSON_TELEPHONE_LINK(PERSONAL_DETAIL_ID, TELEPHONE_ID) VALUES (3493, 1);
INSERT INTO PERSON_TELEPHONE_LINK(PERSONAL_DETAIL_ID, TELEPHONE_ID) VALUES (19721, 8194);


-- Populate the PERSON_ADDRESS_LINK table.
 INSERT INTO PERSON_ADDRESS_LINK(LINK_ID, ADDRESS_ID, PERSONAL_DETAIL_ID, ADDRESS_TYPE) VALUES(1, 1, 1, 'CONTACT');
 INSERT INTO PERSON_ADDRESS_LINK(LINK_ID, ADDRESS_ID, PERSONAL_DETAIL_ID, ADDRESS_TYPE) VALUES(83843, 954, 19721, 'DELIVERY');

-- Populate the CUSTOMER table.
 INSERT INTO CUSTOMER(CUSTOMER_ID, PERSON_ADDRESS_LINK_ID, USERNAME, PASSWORD, IMAGE) VALUES(1,    1,     'username', 'password',   empty_blob());
 INSERT INTO CUSTOMER(CUSTOMER_ID, PERSON_ADDRESS_LINK_ID, USERNAME, PASSWORD, IMAGE) VALUES(1216, 83843, 'oerl',     'lafd_i$143', null);

-- Populate the INVOICE table.
INSERT INTO INVOICE(INVOICE_ID, CUSTOMER_ID, DELIVERY_ADDRESS_ID, INVOICE_DATE, TOTAL, VALIDITY, REFERENCE_NUMBER) VALUES(1,     1,     1, TO_DATE('2015/11/19 08:04:25', 'yyyy/mm/dd hh24:mi:ss'), 58.99,   'YES', 'relfsiejlan');
INSERT INTO INVOICE(INVOICE_ID, CUSTOMER_ID, DELIVERY_ADDRESS_ID, INVOICE_DATE, TOTAL, VALIDITY, REFERENCE_NUMBER) VALUES(2,     1,     954, TO_DATE('2015/10/3 01:59:00',  'yyyy/mm/dd hh24:mi:ss'), 45,      'NO', 'lafdalkakll');
INSERT INTO INVOICE(INVOICE_ID, CUSTOMER_ID, DELIVERY_ADDRESS_ID, INVOICE_DATE, TOTAL, VALIDITY, REFERENCE_NUMBER) VALUES(3,     1,     1, TO_DATE('2013/1/1 00:00:00',   'yyyy/mm/dd hh24:mi:ss'), 2394.99, 'YES', 'afda3134');
INSERT INTO INVOICE(INVOICE_ID, CUSTOMER_ID, DELIVERY_ADDRESS_ID, INVOICE_DATE, TOTAL, VALIDITY, REFERENCE_NUMBER) VALUES(4,     1,     954, TO_DATE('2012/06/30 21:5:59',  'yyyy/mm/dd hh24:mi:ss'), 41.00,   'NO', '1341ddfadaa');
INSERT INTO INVOICE(INVOICE_ID, CUSTOMER_ID, INVOICE_DATE, TOTAL, VALIDITY, REFERENCE_NUMBER) VALUES(5,     1,     TO_DATE('2008/12/31 22:00:17', 'yyyy/mm/dd hh24:mi:ss'), 184,     'YES', 'adfasqevcz23');
INSERT INTO INVOICE(INVOICE_ID, CUSTOMER_ID, INVOICE_DATE, TOTAL, VALIDITY, REFERENCE_NUMBER) VALUES(6,     1,     TO_DATE('2015/11/19 08:04:25', 'yyyy/mm/dd hh24:mi:ss'), 0.01,    'NO',  'afa134adfasf');
INSERT INTO INVOICE(INVOICE_ID, CUSTOMER_ID, INVOICE_DATE, TOTAL, VALIDITY, REFERENCE_NUMBER) VALUES(35287, 1216,  TO_DATE('2013/06/04 22:03:14', 'yyyy/mm/dd hh24:mi:ss'), 26.58,   'YES', 'afad3434zdaf');

-- Populate the AUTHOR table.
INSERT INTO AUTHOR(AUTHOR_ID, PERSONAL_DETAIL_ID, IMAGE, BIOGRAPHY, WEBPAGE_URL) VALUES(1,    1,    empty_blob(), empty_clob(), 'WEBPAGE_URL');
INSERT INTO AUTHOR(AUTHOR_ID, PERSONAL_DETAIL_ID, IMAGE, BIOGRAPHY, WEBPAGE_URL) VALUES(2319, 3493, null,         null,         'www.org.kun.funpage');

-- Populate the AUTHOR_BOOK_LINK table.
INSERT INTO AUTHOR_BOOK_LINK(AUTHOR_ID, BOOK_ID) VALUES(1, 1);
INSERT INTO AUTHOR_BOOK_LINK(AUTHOR_ID, BOOK_ID) VALUES(2319, 2317);

-- Populate the SOLD_ITEM table.
 INSERT INTO SOLD_ITEM(SOLD_ITEM_ID, INVOICE_ID, ITEM_COMMON_DETAIL_ID, QUANTITY, UNIT_PRICE) 
                VALUES(1,            1,          1,                     5,        15.95);
 INSERT INTO SOLD_ITEM(SOLD_ITEM_ID, INVOICE_ID, ITEM_COMMON_DETAIL_ID, QUANTITY, UNIT_PRICE) 
                VALUES(43298,        35287,      66906,                 26,       26.58);

-- Populate the WISHLIST table.
INSERT INTO WISHLIST(WISHLIST_ID, WISHLIST_NAME, CUSTOMER_ID) VALUES(1,    'WISHLIST_NAME',    1);
INSERT INTO WISHLIST(WISHLIST_ID, WISHLIST_NAME, CUSTOMER_ID) VALUES(1348, 'Default Wishlist', 1216);

-- Populate the WISHLIST_ITEM_LINK table.
INSERT INTO WISHLIST_ITEM_LINK(WISHLIST_ID, ITEM_COMMON_DETAIL_ID) VALUES(1,    1);
INSERT INTO WISHLIST_ITEM_LINK(WISHLIST_ID, ITEM_COMMON_DETAIL_ID) VALUES(1348, 66906);

-- Populate the SHOPPING_CART table.
INSERT INTO SHOPPING_CART_ITEM(SHOPPING_CART_ITEM_ID, CUSTOMER_ID, ITEM_COMMON_DETAIL_ID, UNIT_NUMBER) VALUES(1,    1,     1,     1);
INSERT INTO SHOPPING_CART_ITEM(SHOPPING_CART_ITEM_ID, CUSTOMER_ID, ITEM_COMMON_DETAIL_ID, UNIT_NUMBER) VALUES(1461, 1216,  66906, 2);

-- Populate the PAYMENT table.
INSERT INTO PAYMENT_DETAIL(PAYMENT_DETAIL_ID, INVOICE_ID, PAYMENT_TYPE, SUBTOTAL, CURRENCY_CODE) VALUES(1,    1,     'VISA_CARD',   26.69, 'BRP');
INSERT INTO PAYMENT_DETAIL(PAYMENT_DETAIL_ID, INVOICE_ID, PAYMENT_TYPE, SUBTOTAL, CURRENCY_CODE) VALUES(2,    2,     'MASTER_CARD', 631.1, 'USD');
INSERT INTO PAYMENT_DETAIL(PAYMENT_DETAIL_ID, INVOICE_ID, PAYMENT_TYPE, SUBTOTAL, CURRENCY_CODE) VALUES(4,    4,     'DEBIT_CARD',  549,   'EUR');
INSERT INTO PAYMENT_DETAIL(PAYMENT_DETAIL_ID, INVOICE_ID, PAYMENT_TYPE, SUBTOTAL, CURRENCY_CODE) VALUES(3,    3,     'AMEX_CARD',   32.00, 'RMB');
INSERT INTO PAYMENT_DETAIL(PAYMENT_DETAIL_ID, INVOICE_ID, PAYMENT_TYPE, SUBTOTAL, CURRENCY_CODE) VALUES(5,    5,     'PAYPAL',      24.6,  'YEN');
INSERT INTO PAYMENT_DETAIL(PAYMENT_DETAIL_ID, INVOICE_ID, PAYMENT_TYPE, SUBTOTAL, CURRENCY_CODE) VALUES(6,    6,     'VOUCHER',     9.0,   'BRP');
INSERT INTO PAYMENT_DETAIL(PAYMENT_DETAIL_ID, INVOICE_ID, PAYMENT_TYPE, SUBTOTAL, CURRENCY_CODE) VALUES(9524, 35287, 'VISA_CARD',   2.00,  'USD');
INSERT INTO PAYMENT_DETAIL(PAYMENT_DETAIL_ID, INVOICE_ID, PAYMENT_TYPE, SUBTOTAL, CURRENCY_CODE) VALUES(5678, 35287, 'MASTER_CARD', 4.00,  'EUR');
INSERT INTO PAYMENT_DETAIL(PAYMENT_DETAIL_ID, INVOICE_ID, PAYMENT_TYPE, SUBTOTAL, CURRENCY_CODE) VALUES(1473, 35287, 'DEBIT_CARD',  6.00,  'RMB');
INSERT INTO PAYMENT_DETAIL(PAYMENT_DETAIL_ID, INVOICE_ID, PAYMENT_TYPE, SUBTOTAL, CURRENCY_CODE) VALUES(9473, 35287, 'AMEX_CARD',   8.00,  'YEN');
INSERT INTO PAYMENT_DETAIL(PAYMENT_DETAIL_ID, INVOICE_ID, PAYMENT_TYPE, SUBTOTAL, CURRENCY_CODE) VALUES(3498, 35287, 'PAYPAL',      1.00,  'DMK');
INSERT INTO PAYMENT_DETAIL(PAYMENT_DETAIL_ID, INVOICE_ID, PAYMENT_TYPE, SUBTOTAL, CURRENCY_CODE) VALUES(5738, 35287, 'VOUCHER',     2.58,  'SWF');

-- Populate the VISACARD_PAYMENT table.
 INSERT INTO VISACARD_PAYMENT(PAYMENT_ID, PAYMENT_DETAIL_ID, PERSON_ADDRESS_LINK_ID, PAYMENT_TYPE, CARD_NUMBER,        SECURITY_CODE,    START_DATE,                    EXPIRE_DATE) 
                       VALUES(1,          1,                 1,                      'VISA_CARD',  '1234567890123456', '123',            TO_DATE('2014/11', 'yyyy/mm'), TO_DATE('2018/3', 'yyyy/mm'));

 INSERT INTO VISACARD_PAYMENT(PAYMENT_ID, PAYMENT_DETAIL_ID, PERSON_ADDRESS_LINK_ID, CARD_NUMBER,        SECURITY_CODE,    START_DATE,                    EXPIRE_DATE) 
                       VALUES(4474,       9524,              83843,                  '2485020245919721', '105',            TO_DATE('2015/08', 'yyyy/mm'), TO_DATE('2019/12', 'yyyy/mm'));

-- Populate the MASTERCARD_PAYMENT table.
 INSERT INTO MASTERCARD_PAYMENT(PAYMENT_ID, PAYMENT_DETAIL_ID, PERSON_ADDRESS_LINK_ID, PAYMENT_TYPE,   CARD_NUMBER,        SECURITY_CODE,  START_DATE,                    EXPIRE_DATE) 
                         VALUES(1,          2,                 1,                      'MASTER_CARD',  '1234567890123456', '111',            TO_DATE('2010/05', 'yyyy/mm'), TO_DATE('2016/1', 'yyyy/mm'));


 INSERT INTO MASTERCARD_PAYMENT(PAYMENT_ID, PAYMENT_DETAIL_ID, PERSON_ADDRESS_LINK_ID, CARD_NUMBER,        SECURITY_CODE,   START_DATE,                    EXPIRE_DATE) 
                         VALUES(979,        5678,              83843,                  '8914379341941393', '123',           TO_DATE('2013/03', 'yyyy/mm'), TO_DATE('2017/01', 'yyyy/mm'));

-- Populate the AMEXCARD_PAYMENT table.
 INSERT INTO AMEXCARD_PAYMENT(PAYMENT_ID, PAYMENT_DETAIL_ID, PERSON_ADDRESS_LINK_ID, PAYMENT_TYPE, CARD_NUMBER,        SECURITY_CODE,    EXPIRE_DATE) 
                       VALUES(1,          3,                 1,                      'AMEX_CARD',  '123456789012345',  '1234',           TO_DATE('2020/12', 'yyyy/mm'));

INSERT INTO AMEXCARD_PAYMENT(PAYMENT_ID, PAYMENT_DETAIL_ID, PERSON_ADDRESS_LINK_ID, CARD_NUMBER,       SECURITY_CODE,   EXPIRE_DATE) 
                      VALUES(746,        9473,              83843,                  '194393419138919', '4484',          TO_DATE('2020/11', 'yyyy/mm'));

-- Populate the DEBITCARD_PAYMENT table.
INSERT INTO DEBITCARD_PAYMENT(PAYMENT_ID, PAYMENT_DETAIL_ID, PERSON_ADDRESS_LINK_ID, PAYMENT_TYPE, CARD_NUMBER,         SECURITY_CODE,    START_DATE,                    EXPIRE_DATE) 
                       VALUES(1,          4,                 1,                      'DEBIT_CARD',  '1234567890123456',  '222',            TO_DATE('2015/5', 'yyyy/mm'), TO_DATE('2017/06', 'yyyy/mm'));

INSERT INTO DEBITCARD_PAYMENT(PAYMENT_ID, PAYMENT_DETAIL_ID, PERSON_ADDRESS_LINK_ID, CARD_NUMBER,        SECURITY_CODE,   ISSUE_NUMBER , START_DATE,                          EXPIRE_DATE) 
                       VALUES(9271,       1473,              83843,                  '9034719471941911', '826',           3,             TO_DATE('2015/12/1', 'yyyy/mm/dd'),   TO_DATE('2018/7', 'yyyy/mm'));

-- Populate the PAYPAL_PAYMENT table.
INSERT INTO PAYPAL_PAYMENT(PAYMENT_ID, PAYMENT_DETAIL_ID, PAYPAL_ACCOUNT_ID, PAYMENT_TYPE, PAYPAL_IDENTITY_TOKEN) VALUES(1, 5, 'PAYPAL_ACCOUNT_ID', 'PAYPAL', 'PAYPAL_IDENTITY_TOKEN');
INSERT INTO PAYPAL_PAYMENT(PAYMENT_ID, PAYMENT_DETAIL_ID, PAYPAL_ACCOUNT_ID, PAYPAL_IDENTITY_TOKEN) VALUES(231, 3498, 'InqsIFI_SQ', 'lafAFdAa');

-- Populate the VOUCHER table.
INSERT INTO VOUCHER(VOUCHER_ID, CUSTOMER_ID, VOUCHER_TOKEN, TOTAL, EXPIRE_DATE) VALUES(1,   1, 'AAAA-BBBB-CCCC-DDDD', 100, TO_DATE('2017/06', 'yyyy/mm'));
INSERT INTO VOUCHER(VOUCHER_ID, CUSTOMER_ID, VOUCHER_TOKEN, TOTAL, EXPIRE_DATE) VALUES(5619, 1216, 'KKYG-XFA2-8DAF-J59A', 50, TO_DATE('2018/12', 'yyyy/mm'));

-- Populate the VOUCHER_PAYMENT table.
 INSERT INTO VOUCHER_PAYMENT(PAYMENT_DETAIL_ID, VOUCHER_ID, PAYMENT_TYPE) VALUES(6, 1, 'VOUCHER');
 INSERT INTO VOUCHER_PAYMENT(PAYMENT_DETAIL_ID, VOUCHER_ID) VALUES(5738, 5619);