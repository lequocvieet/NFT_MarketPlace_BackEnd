CREATE TABLE collections (
                             id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                             slug TEXT UNIQUE,
                             name TEXT,
                             url TEXT,
                             details JSONB
);

CREATE TABLE accounts (
                          id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                          user_name TEXT,
                          address TEXT UNIQUE NOT NULL,
                          details JSONB
);

CREATE TABLE assets (
                        id BIGINT PRIMARY KEY,
                        name TEXT,
                        collection_id BIGINT REFERENCES collections (id), -- collection
                        description TEXT,
                        contract_date TIMESTAMP WITH TIME ZONE,
                        url TEXT UNIQUE,
                        img_url TEXT,
                        owner_id BIGINT REFERENCES accounts (id), -- account
                        details JSONB
);

CREATE TYPE auction AS ENUM ('dutch', 'english', 'min_price');
CREATE TABLE nft_sales (
                           id BIGINT PRIMARY KEY,
                           "time" TIMESTAMP WITH TIME ZONE,
                           asset_id BIGINT REFERENCES assets (id), -- asset
                           collection_id BIGINT REFERENCES collections (id), -- collection
                           auction_type auction,
                           contract_address TEXT,
                           quantity NUMERIC,
                           payment_symbol TEXT,
                           total_price DOUBLE PRECISION,
                           seller_account BIGINT REFERENCES accounts (id), -- account
                           from_account BIGINT REFERENCES accounts (id), -- account
                           to_account BIGINT REFERENCES accounts (id), -- account
                           winner_account BIGINT REFERENCES accounts (id), -- account
                           CONSTRAINT id_time_unique UNIQUE (id, time)
);

