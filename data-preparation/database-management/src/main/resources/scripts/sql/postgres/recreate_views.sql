-- This script re-create all the views for the bookshop database.
-- The script can only be used for the Postgres SQL datbase.
-- The script is tested against Postgres SQL 9.4.
-- The views will be dropped if they exist. A fresh set of tables then will be created with the constraint.
-- No data will be populated in this script.

-- author Zhipeng Chang
-- version 1.0.0 

-- Part one: Create all views

-- Create the view_invoice function.
CREATE OR REPLACE VIEW view_invoice AS

SELECT inc.invoice_id FROM invoice inc WHERE inc.validity = 'YES';
 
-- End of the creation of view_invoice view.
-- End of part one.