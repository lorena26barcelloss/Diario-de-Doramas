CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE if NOT EXISTS doramas (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    release_date DATE,
    rating DECIMAL(2, 1),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE doramas
    RENAME COLUMN title TO nome;

ALTER TABLE doramas
    RENAME COLUMN description TO anotacao;

ALTER TABLE doramas
    RENAME COLUMN rating TO nota;

ALTER TABLE doramas
    ALTER COLUMN nota TYPE INTEGER USING nota::INTEGER;

ALTER TABLE doramas
    DROP COLUMN release_date;

ALTER TABLE doramas
    ADD COLUMN IF NOT EXISTS status VARCHAR(30) DEFAULT 'desejado';

ALTER TABLE doramas
    ADD COLUMN IF NOT EXISTS user_id INTEGER;

ALTER TABLE doramas
    ADD CONSTRAINT fk_dorama_user
    FOREIGN KEY (user_id)
    REFERENCES users(id)
    ON DELETE CASCADE;