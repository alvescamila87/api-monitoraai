# 🛡️ MonitoraAi Gestão de EPIs — Spring Boot + Thymeleaf

A empresa de construção civil local identificou a necessidade premente de aprimorar a gestão dos **Equipamentos de Proteção Individual (EPIs)** utilizados por seus colaboradores.

Muitos deles não estão utilizando os EPIs devido a esquecimentos, seja por não trazê-los consigo ou por não retirá-los do departamento de Saúde e Segurança do Trabalho.  
A última auditoria interna revelou uma **necessidade crítica de melhoria** na administração do uso dos EPIs.

## 📁 Estrutura de Diretórios

```
src
└── main
    ├── java
    │   └── br.com.empresa
    │       ├── controller
    │       │   ├── colaborador
    │       │   ├── equipamento
    │       │   ├── emprestimo
    │       │   └── usuario
    │       ├── dto
    │       │   ├── colaborador
    │       │   ├── equipamento
    │       │   ├── emprestimo
    │       │   └── usuario
    │       ├── entity
    │       │   ├── colaborador
    │       │   ├── equipamento
    │       │   ├── emprestimo
    │       │   └── usuario
    │       ├── repository
    │       │   ├── colaborador
    │       │   ├── equipamento
    │       │   ├── emprestimo
    │       │   └── usuario
    │       ├── service
    │       │   ├── colaborador
    │       │   ├── equipamento
    │       │   ├── emprestimo
    │       │   └── usuario
    │       └── exception
    └── resources
        ├── static
        ├── templates
        └── application.properties
```

---

## 🗺️ Modelo Entidade-Relacionamento (MER)

![MER](image.png)

## 🛠️ Tecnologias e Ferramentas Utilizadas

- ☕ Java JDK 17+
- 🌱 Spring Boot
- 🔒 Spring Security
- 🧾 Thymeleaf
- 🐬 MariaDB
- 🐿️ Lombok
- 📷 ZXing (QR Code)
- 💻 HTML, CSS e JavaScript
- 📦 GitHub
- 📦 GitHub Projects (Kanban)

## ▶️ Como Executar o Projeto

1. Clone o repositório:

   ```bash
   git clone git@github.com:alvescamila87/api-monitoraai.git
   ```

2. Configure o banco de dados em `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mariadb://localhost:3306/apimonitoraai
   spring.datasource.username=seu-usuario
   spring.datasource.password=sua-senha
   ```

3. Rode o projeto com sua IDE (Spring Tool Suite, IntelliJ, Eclipse, VS Code, etc.).

4. Acesse no navegador:
   ```
   http://localhost:8080
   ```

## 📡 Endpoints da API

### 🔐 Usuário (`/usuario`)

- `GET /usuario` – Listar todos
- `POST /usuario` – Criar novo
- `PUT /usuario/{id}` – Atualizar existente
- `DELETE /usuario/{id}` – Remover

### 👷 Colaborador (`/colaborador`)

- `GET /colaborador` - Listar todos
- `POST /colaborador` - Criar novo
- `PUT /colaborador/{id}` - Atualizar existente
- `DELETE /colaborador/{id}` - Remover

### 🦺 Equipamento (`/equipamento`)

- `GET /equipamento` - Listar todos
- `POST /equipamento` - Criar novo
- `PUT /equipamento/{id}` - Atualizar existente
- `DELETE /equipamento/{id}` - Remover

### 📦 Empréstimo (`/emprestimo`)

- `GET /emprestimo` – Visualizar
- `POST /emprestimo` – Emprestar equipamento
- `POST /emprestimo/devolucao` – Devolver equipamento
- `POST /emprestimo/devolucao-qrcode` – Devolução via QR Code

## 📋 Kanban do Projeto

> Link para o quadro no GitHub Projects:  
> [🔗 Acessar Kanban](https://github.com/users/alvescamila87/projects/5/views/1)
> ![kanban](image-1.png)

## 🖼️ Imagens da Aplicação

- Tela de login
![Login](image-2.png)

- Cadastro de usuário
![Cadastro usuario](image-6.png)

- Cadastro de colaborador
![Cadastro colaborador](image-7.png)

- Cadastro de equipamentos
![Cadastro Equipamento](image-3.png)

- Cadastro de empréstimo
![Lista Emprestimo](image-4.png)

- Leitura de QR Code
![Qr Code](image-5.png)

## 👥 Autores

- [Camila Alves](https://github.com/alvescamila87)
- [João Emidio](https://github.com/emidiojoao)

## 🤝 Contribuições

Contribuições são bem-vindas!  
Sinta-se à vontade para abrir uma _issue_ ou enviar um _pull request_ 🚀
