# backoffice
Backoffice de professores

Objetivo:

Desenvolvimento do Backoffice de seus professores. A aplicação deve ter uma experiência normal em situações de altademanda de uso.
Desenvolver uma API para suportar o Backoffice proposto, resolvendo as seguintes jornadas:

- Cadastro (deverá ficar pendente, aguardando aprovação)
- Login
- Lista de aulas (listar somente as aulas do professor relacionado ao token de acesso)
- Cadastro de novas aulas (criação e edição)

A aula é composta dos seguintes dados:

- Título
- Descrição
- Data prevista para aula.

Disponibilizar na API um recurso para aprovar o cadastro de um professor
.
Requisitos não funcionais:

- Utilizar conceito de JWT. O payload do JWT deve possuir o código e nome do professor.
- Utilize um banco de dados não relacional.
- Planeje uma solução para resolver a preocupação de situações de alta demanda.

Tecnologias utilizadas

- Java 17
- Spring 3.1.0
- Maven
- Lombok
- JPA
- Flyway
- MySQL
- Spring Security
- JWT
  
Utilizado BCrypt para criptografia das senhas.

Abaixo o payload para logar com o usuário admin (http://localhost:8080/login) para geração do token.

{

    "login": "admin",
    "password": "123456789"
}

  Exemplos de requisições e payload

  - Login: [POST] http://localhost:8080/login

    Payload exemplo:

 {
 
    "login": "silva@email.com",
    "password": "123456789"
 }

  - Cadastro de professor: [POST] http://localhost:8080/teacher
    
  Payload exemplo:
    
{

    "name": "Fulano",
    "login": "fulano@email.com"
    
}

- Listar todos os professores: [GET] http://localhost:8080/teacher
- Detalhar informações de um professor: [GET] http://localhost:8080/teacher/1
- Atualizar dados de um professor: [PUT] http://localhost:8080/teacher
 
  Payload exemplo:

{

    "id": 2,
    "name": "Teacher"
}

-Atualizar status professor: [PATCH] http://localhost:8080/teacher

Payload exemplo:

{

    "id": 2,
    "status": "APPROVED"
}
    
- Cadastro de aula: [POST] http://localhost:8080/class

  Payload exemplo:

  {
  
    "title": "Aula sobre Spring Boot",
    "descrition": "Veremos como validar campos",
    "expectedClassDate": "24/06/2023"
  }

- Listar aulas: [GET] http://localhost:8080/class
- Atualizar aula: [PUT] http://localhost:8080/class

  Payload exemplo:

  {
  
    "id": 1,
    "title": "Aula sobre Spring Framework",
    "expectedClassDate": "23/06/2023"
  }

- Vincular aula a um professor: [PATH] http://localhost:8080/class

  Payload exemplo:

  {
  
    "id": 2,
    "idTeacher": 1
  }










