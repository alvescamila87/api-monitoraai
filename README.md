# 🛡️ MonitoraAi: Gestão de EPIs
![img_1.png](img_1.png)

### Problema
A empresa de construção civil local identificou a necessidade premente de aprimorar a gestão dos **Equipamentos de Proteção Individual (EPIs)** utilizados por seus colaboradores.

Muitos deles não estão utilizando os EPIs devido a esquecimentos, seja por não trazê-los consigo ou por não retirá-los do departamento de Saúde e Segurança do Trabalho.  
A última auditoria interna revelou uma **necessidade crítica de melhoria** na administração do uso dos EPIs.

### Resolução
Desenvolvemos um sistema simples, mas que resolve um problema real dentro de uma empresa de construção civil.
Eles estavam enfrentando dificuldades com o uso dos Equipamentos de Proteção Individual, os famosos EPIs. Muitos colaboradores esqueciam de levar ou não passavam no setor de segurança para retirar os equipamentos. Isso gerava riscos e foi apontado numa auditoria interna como um problema sério.
A empresa precisava saber quem pegou, qual equipamento, quando devolveu.
Então, a gente criou um sistema web pensando em três pilares: controle, segurança e usabilidade.


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
- ☕ Java Doc
- 🌱 Spring Boot
- 🔒 Spring Security
- 🧾 Thymeleaf
- 🐬 MariaDB
- 🐿️ Lombok
- 📷 ZXing (QR Code)
- 🧾 Bootstrap
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

- `GET /lista-usuario` – Listar todos
- `POST /cadastro-usuario` – Criar novo
- `PUT /atualizar-usuario/{id}` – Atualizar existente
- `DELETE /usuario/{id}` – Remover

### 👷 Colaborador (`/colaborador`)

- `GET /lista-colaborador` - Listar todos
- `POST /cadastro-colaborador` - Criar novo
- `PUT /atualizar-colaborador/{id}` - Atualizar existente
- `DELETE /colaborador/{id}` - Remover

### 🦺 Equipamento (`/equipamento`)

- `GET /lista-equipamento` - Listar todos
- `POST /cadastro-equipamento` - Criar novo
- `PUT /atualizar-equipamento/{id}` - Atualizar existente
- `DELETE /equipamento/{id}` - Remover

### 📦 Empréstimo (`/emprestimo`)

- `GET /visualizar-historico` – Visualizar
- `POST /cadastro-emprestimo` – Emprestar equipamento
- `POST /devolver-equipamento` – Devolver equipamento
- `POST /emprestimo/qrcode` – Devolução via QR Code

### ⚙️ Fluxo Devolução de equipamento por QRCode
![img.png](img.png)

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

- Leitura de QR Code para devolução
![Qr Code](image-5.png)

## 👥 Autores

- [Camila Alves](https://github.com/alvescamila87)
- [João Emidio](https://github.com/emidiojoao)

