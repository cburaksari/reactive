CREATE TABLE IF NOT EXISTS product (
                                       id SERIAL PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
    price INTEGER NOT NULL,
    quantity INTEGER NOT NULL
    );