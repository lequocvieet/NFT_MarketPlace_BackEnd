ALTER table accounts drop column details;
alter table accounts
    add image_url TEXT;
alter table collections drop column  details;

alter table collections
add category_id BIGINT references categories(id),
add description Text,
add number_item int ,
add number_owner int ,
add floor_price double precision,
add total_volume double precision,
add buy_now boolean,
add created_id BIGINT references accounts(id);


alter table nft_sales
    drop column  time,
    drop column  auction_type,
    drop column quantity,
    drop column seller_account,
    drop column  from_account,
    drop column  to_account,
    drop column  winner_account;

alter table  nft_sales
add transaction_id BIGINT references transactions(id);


alter  table  assets drop column  details;
alter table collections drop column id;

Alter table nft_sales add primary key (id);


