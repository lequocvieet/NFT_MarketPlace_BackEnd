alter table collections add contract_address Text ;
alter table collections drop column contract_address;
GRANT USAGE ON SCHEMA public TO tsdbadmin;
