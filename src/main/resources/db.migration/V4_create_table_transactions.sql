Create table if not  exists transactions (
                                             id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                                             state TEXT,
                                             from_account_id BIGINT REFERENCES accounts(id),
                                             to_account_id BIGINT REFERENCES accounts(id),
                                             time  TIMESTAMP WITH TIME ZONE ,
                                             current_price DOUBLE PRECISION );

