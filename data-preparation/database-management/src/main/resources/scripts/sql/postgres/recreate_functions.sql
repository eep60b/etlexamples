-- This script re-create all the functions for the bookshop database.
-- The script can only be used for the Postgres SQL datbase.
-- The script is tested against Postgres SQL 9.4.
-- The functions will be dropped if they exist. A fresh set of tables then will be created with the constraint.
-- No data will be populated in this script.

-- author Zhipeng Chang
-- version 1.0.0 

-- Part one: Create Language if it does not exist.
CREATE OR REPLACE LANGUAGE plpgsql; 
-- End of part one.


-- Part two: Create all functions
-- Create the f_calculate_payment_subtotal function.
CREATE OR REPLACE FUNCTION f_calculate_payment_subtotal() RETURNS numeric AS '
	SELECT SUM(subtotal) FROM payment_detail WHERE subtotal > 0;
	' LANGUAGE SQL;
-- End of the creation of f_calculate_payment_subtotal function.

-- Create the f_generate_token function.
CREATE OR REPLACE FUNCTION f_generate_token() RETURNS CHARACTER VARYING AS 
'
    BEGIN
    RETURN "a";
    END;
'
LANGUAGE plpgsql VOLATILE
COST 100;
-- End of the creation of f_generate_token function.
-- End of part two.