DECLARE
     u_count INTEGER := 0;
 
 BEGIN
     SELECT COUNT (1) INTO u_count FROM dba_users WHERE username = 'BOOKSHOP';
     IF u_count != 0
     THEN
         EXECUTE IMMEDIATE ('DROP USER BOOKSHOP CASCADE');
     END IF;
 END;
 /

CREATE USER BOOKSHOP IDENTIFIED BY BOOKSHOP
/

GRANT connect, resource, dba TO BOOKSHOP
/