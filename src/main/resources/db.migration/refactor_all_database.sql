CREATE TABLE accounts (
                          id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                          user_name TEXT,
                          address TEXT UNIQUE NOT NULL
);

CREATE TABLE item (
                           id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                           contract_address TEXT,
                           payment_symbol TEXT,
                           total_price DOUBLE PRECISION,
                           owner_id BIGINT REFERENCES accounts (id), -- account
                           transaction_id BIGINT REFERENCES transactions (id) -- transaction

);
Create Table transactions (
                                             id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                                             event TEXT,
                                             from_account_id BIGINT REFERENCES accounts(id),
                                             to_account_id BIGINT REFERENCES accounts(id),
                                             time  TIMESTAMP WITH TIME ZONE ,
                                             current_price DOUBLE PRECISION
                          );

alter table item add name Text ;
alter table item add description Text ;
alter table item add img_uri Text ;
alter table transactions drop column time;
alter table transactions add time Text ;
alter table item drop column id;
alter table item add id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY ;
alter table item drop column transaction_id;
alter table transactions add item_id BIGINT REFERENCES item(id); -- item;
alter table item drop column total_price;
alter table transactions drop column item_id;
alter table item drop column id;
alter table item add id BIGINT PRIMARY KEY  ;
alter table transactions add item_id BIGINT REFERENCES item(id); -- item;

