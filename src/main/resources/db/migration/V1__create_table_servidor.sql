CREATE TABLE servidor (
    id BIGSERIAL PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL,
    email VARCHAR(255) NOT NULL,
    matricula VARCHAR(50) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    tipo_servidor VARCHAR(50) NOT NULL
);
