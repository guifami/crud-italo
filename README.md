# Guia de Execução

## 1. Clonar o Repositório

Dentro do diretório de sua preferência, rodar o comando:

`git clone <AQUI O HTTPS COPIADO>`

<b>Exemplo:</b>
<br>
![image](https://github.com/guifami/crud-italo/assets/93688391/0ff59ed2-c12c-4898-bb39-be042d047986)

![image](https://github.com/guifami/crud-italo/assets/93688391/9d0c5818-81ae-443d-8c3f-f0abf2b48f68)

## 2. Configurar Banco de Dados

O Projeto por padrão espera um banco de dados local na porta **3306 (que já vem por padrão do MySql)**
No arquivo **application.yaml** que se encontra no diretório **\crud-italo\backend\restfulapi\Java-Spring-Boot-RESTful-Api\src\main\resources** tem as informações do banco de dados que ele espera por padrão.

![image](https://github.com/guifami/crud-italo/assets/93688391/c0e2fa9d-5df3-4163-bd07-da56bf907268)

Sendo assim, pode ser necessário colocar as informações do seu servidor local, nesse caso, temos que:

**username:** root
<br>
**password:** Numsey#2023
<br>
**url:** url: jdbc:mysql://localhost:3306/**dbjsp**?useTimezone=true&serverTimezone=UTC

**ATENÇÃO!**
Caso não possua o banco de dados **dbjsp** criado na máquina local, é necessário criá-lo pelo **Mysql Workbench** rodando o comando:

`CREATE DATABASE DBJSP`

## 3. Instalar dependências Backend

Dentro do diretório **\crud-italo\backend\restfulapi\Java-Spring-Boot-RESTful-Api** rodar o comando:

`mvn clean install`

<b>Exemplo:</b>
<br>
![image](https://github.com/guifami/crud-italo/assets/93688391/4953dd38-8d19-493c-8c2d-c008624e7681)

Executar o Backend da Aplicação com o comando:

`mvn spring-boot:run`

O projeto utiliza o **Flyway** para provisionamento da infraestrutura do banco de dados, sendo assim, ao iniciar a aplicação backend após a conclusão dos passos anteriores, o banco de dados já será automaticamente populado com dados mockados para homologar o funcionamento do sistema.

## 4. Acessar o Swagger 

Depois de inicializar o Backend da aplicação, será possível acessar o **Swagger** para visualizar a documentação da API: http://localhost:8888/swagger-ui/index.html#/

![image](https://github.com/guifami/crud-italo/assets/93688391/fe6a2db0-9ca3-4626-925f-6bcc7e86b150)

## 5. Instalar dependências Frontend

Dentro do diretório **\crud-italo\frontend\frontend\src** rodar o comando:

`npm install`

<b>Exemplo:</b>
<br>
![image](https://github.com/guifami/crud-italo/assets/93688391/001e6837-b572-42eb-8572-a998be0fb63b)

Em seguida, para rodar a aplicação, basta no mesmo diretório rodar o comando:

`npm start`

E o projeto estará disponível no endereço http://localhost:4200/

## HOME
![image](https://github.com/guifami/crud-italo/assets/93688391/5fa7091c-61ce-448c-b13f-970d8b0ce31d)

## READ:
![image](https://github.com/guifami/crud-italo/assets/93688391/5dd98e41-989a-4bc6-8547-7eed53c1507a)

## CREATE:
![image](https://github.com/guifami/crud-italo/assets/93688391/84347c50-d203-4256-9e90-d778db401351)

## UPDATE:
![image](https://github.com/guifami/crud-italo/assets/93688391/2dff1b1e-cc5d-4845-9f9d-3d992baa55ae)

## DELETE:
![image](https://github.com/guifami/crud-italo/assets/93688391/73cba69a-3afb-4a69-9c52-a28ccb446cf0)
