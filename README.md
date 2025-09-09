# 📧 Projeto de Notificações por E-mail

[![Java](https://img.shields.io/badge/Java-11+-orange?logo=openjdk)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.7.13-green?logo=spring)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14-blue?logo=postgresql)](https://www.postgresql.org/)
[![RabbitMQ](https://img.shields.io/badge/RabbitMQ-3.8+-yellow?logo=rabbitmq)](https://www.rabbitmq.com/)

## 📋 Índice

- [Tecnologias](#tecnologias)
- [Instalação](#instalação)
- [Configuração](#configuração)

---

## 🛠 Tecnologias

- **Java 11** - Linguagem principal
- **Spring Boot** 2.7.13 - Framework backend
- **Spring Data JPA**
- **RabbitMQ** - Mensageria
- **PostgreSQL** - Banco de dados
- **JWT**
- **Lombok**

---

## 🔨 Instalação

### Pré-requisitos

- **Java** 11 ou superior instalado
- **RabbitMQ** em execução
- **PostgreSQL** configurado e rodando
- **Maven** para gerenciar as dependências do projeto

## ⚙️ Configuração

### Passos para rodar o projeto localmente

1. Clone o repositório:

   SSH
    ```
    git@github.com:alexandrehh/expenses-control.git
    ```
   Http
    ```
    https://github.com/alexandrehh/expenses-control.git
    ```

2. Configurar o arquivo `application.properties`

### PostgreSQL

   ```
     spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
     spring.datasource.username=seu_usuario
     spring.datasource.password=sua_senha
   ```

### RabbitMQ

   ```
      spring.rabbitmq.addresses=seu_rabbitmq_host
      spring.rabbitmq.exchange=sua_exchange
      spring.rabbitmq.queue=sua_queue
      spring.rabbitmq.routingkey=sua_routing_key
   ```

## 🔑 Autenticação

### Endpoints Públicos

- `/auth/login` (POST)
- `/auth/saveUserAuth` (POST)
- `/auth/sendForgotPasswordEmail` (POST)

- Você precisará se autenticar no endpoint `/auth/login`,
- Para cadastrar um novo usuário utilizar o endpoint `/auth/saveUserAuth`. 
- Para recuperar sua credencial utilizar o endpoint `/auth/sendForgotPasswordEmail`.

- Login

   ```
      {
        "email": "seuemail@email",
        "password": "minhasenha"
      }
   ```

- Novo Usuário

   ```
      {
        "id": null,
        "nome": "meunome" 
        "email": "seuemail@email",
        "password": "minhasenha"
      }
   ```

- Recuerar Credencial

   ```
      {
        "email": "seuemail@email"
      }
   ```
