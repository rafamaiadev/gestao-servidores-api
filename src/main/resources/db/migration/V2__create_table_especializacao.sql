CREATE TABLE especializacao (
    id BIGSERIAL PRIMARY KEY,
    area VARCHAR(255) NOT NULL,
    tipo_especializacao VARCHAR(50) NOT NULL,
    carga_horaria INTEGER NOT NULL,
    valor_total DECIMAL(10, 2) NOT NULL,
    servidor_id INTEGER NOT NULL,
    status VARCHAR(50),
    motivo_indeferimento VARCHAR(255),
    CONSTRAINT fk_especializacao__servidor FOREIGN KEY (servidor_id) REFERENCES servidor (id)
);
