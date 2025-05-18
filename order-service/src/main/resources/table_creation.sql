CREATE TABLE IF NOT EXISTS orders
(
    id          BIGSERIAL PRIMARY KEY,
    product_id  BIGINT  NOT NULL,
    quantity    INTEGER NOT NULL,
    total_price INTEGER NOT NULL
);