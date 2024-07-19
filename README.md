# Gestao Servidores API

## Descrição

O projeto **Gestao Servidores API** é uma aplicação desenvolvida em Java com Spring Boot. A aplicação fornece uma API para a gestão de servidores públicos.

Este projeto utiliza Docker para facilitar o ambiente de desenvolvimento e a execução da aplicação.

## Requisitos

- Java 21
- Maven 3.9.5
- Docker

## Configuração do Projeto

### Variáveis de Ambiente

você precisa configurar 2 variáveis de ambiente para o serviço de envio de e-mail SMTP. Estas variáveis são necessárias para o funcionamento correto do serviço de e-mail.

Adicione um email e uma chave de acesso válidos nas seguintes variáveis presentes no application.properties:

- `USERNAME`
- `PASSWORD`
- Obs: para testar o envio de email rodando a aplicação no docker, é necessário definir essas variáveis no docker compose.
### Observação sobre os testes unitários

- Configurei o Dockerfile para pular os testes, pois ele estava dando um problema para buildar com os testes.
- Portanto, por enquanto, para executar os testes unitários é necessário executa-los manualmente na aplicação.

### Execução do Projeto

1. **Certifique-se de que o Docker está instalado em sua máquina.**

2. **Clone o repositório do projeto:**

3. **Abra o terminal na pasta raiz do projeto e execute o comando 'docker compose up' para subir a aplicação**