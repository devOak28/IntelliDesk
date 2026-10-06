# 🤖 IntelliDesk — AI-Powered Support Platform

> **An intelligent Help Desk platform built with Java, Spring Boot, Spring AI, LLMs, AI Tool Calling, Chat Memory, and PostgreSQL.**

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Spring AI](https://img.shields.io/badge/Spring%20AI-Enabled-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Ollama](https://img.shields.io/badge/Ollama-Local%20LLM-black)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-red)
![Status](https://img.shields.io/badge/Status-Under%20Development-yellow)

---

## 📌 Project Overview

**IntelliDesk** is an AI-powered Help Desk and Support Platform built using the Java and Spring ecosystem.

The project demonstrates how **Generative AI can be integrated with a traditional Spring Boot backend application** to create an intelligent support system.

Instead of forcing users to navigate through multiple screens, search manually, or interact with predefined menus, IntelliDesk allows users to communicate with the support system using **natural language**.

The AI assistant can:

- Understand user requests
- Generate natural-language responses
- Maintain conversation context
- Work with backend application services
- Retrieve support ticket information
- Create and manage support tickets
- Use AI Tool Calling to interact with backend functionality
- Store application data in PostgreSQL

The long-term goal is to evolve IntelliDesk into a complete **AI-powered enterprise support platform** with RAG, vector search, knowledge-base integration, authentication, analytics, and automated support workflows.

---

# 🎯 Problem Statement

Traditional Help Desk applications generally require users to navigate through multiple screens.

A typical workflow looks like:

```text
User
   ↓
Open Help Desk
   ↓
Search / Navigate
   ↓
Create Ticket
   ↓
Wait for Support
   ↓
Check Ticket Status Manually
```

This approach can become inefficient when users have many questions or need quick access to support information.

IntelliDesk introduces an AI layer into this workflow.

Instead of navigating through the application, users can simply communicate with the system using natural language.

For example:

```text
User:
I cannot connect to the company VPN.
```

The AI can understand the problem and guide the user through the support process.

---

# 💡 IntelliDesk Approach

The traditional architecture:

```text
User
  ↓
REST API
  ↓
Service
  ↓
Database
  ↓
Response
```

IntelliDesk introduces an intelligent AI layer:

```text
User
  ↓
Natural Language
  ↓
LLM
  ↓
Understand User Intent
  ↓
Select Required Tool
  ↓
Spring Boot Backend
  ↓
Business Logic
  ↓
Database
  ↓
Tool Result
  ↓
LLM
  ↓
Natural Language Response
  ↓
User
```

This allows the LLM to act as an intelligent interface over the existing backend application.

---

# ✨ Key Features

## 🤖 1. AI-Powered Support Assistant

Users can interact with the support system using natural language.

Example:

```text
User:
I have a problem with my VPN.

AI:
I can help you with that. Would you like me to create a support ticket?
```

The AI can understand the user's request and respond conversationally.

---

# 🎫 2. Support Ticket Management

IntelliDesk maintains support ticket information using PostgreSQL.

A ticket can contain information such as:

```text
Ticket ID
Title
Description
Priority
Status
Created Date
Updated Date
```

Example:

```text
Ticket ID: 1025
Title: VPN Connection Issue
Description: Unable to connect to company VPN
Priority: HIGH
Status: OPEN
```

---

# 🧠 3. AI Tool Calling

AI Tool Calling is one of the core concepts of IntelliDesk.

Instead of allowing the LLM to directly access the database, the application exposes controlled backend operations as tools.

Examples:

```text
createTicket()
getTicket()
getUserTickets()
updateTicket()
```

The LLM decides when a particular tool is required.

Example:

```text
User:
What is the status of ticket 1025?
```

The LLM can determine that it needs ticket information and request:

```text
getTicket(1025)
```

The Spring Boot application executes the operation.

The result is then returned to the LLM.

The LLM generates a natural-language response:

```text
Ticket 1025 is currently OPEN with HIGH priority.
```

---

# 🔄 AI Tool Calling Flow

```text
                    User
                      │
                      ▼
               Natural Language
                      │
                      ▼
                    LLM
                      │
                      │ Tool Request
                      ▼
              Spring AI Tool
                      │
                      ▼
              Spring Boot Service
                      │
                      ▼
                Repository
                      │
                      ▼
                 PostgreSQL
                      │
                      ▼
                Tool Result
                      │
                      ▼
                    LLM
                      │
                      ▼
             Natural Language
                Response
```

---

# 💬 4. Chat Memory

IntelliDesk supports conversation memory so that the AI can maintain context across multiple messages.

Example:

```text
User:
I have a VPN problem.

AI:
Would you like me to create a support ticket?

User:
Yes, create one.

AI:
Sure. What device are you using?

User:
My company laptop.
```

The AI can use the previous conversation to understand the context.

Without memory:

```text
User:
Yes, create one.
```

The AI may not know what "one" refers to.

With Chat Memory:

```text
VPN problem
      ↓
Create ticket
      ↓
Company laptop
```

The conversation becomes contextual and natural.

---

# 🗄️ 5. Database Integration

PostgreSQL is used as the relational database.

The application follows a standard Spring Boot layered architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
JPA / Hibernate
    ↓
PostgreSQL
```

This keeps the application modular and maintainable.

---

# 🤖 6. LLM Integration

IntelliDesk uses **Spring AI** to integrate Large Language Models into the Spring Boot application.

The current development setup uses:

```text
Ollama
```

This allows the LLM to run locally.

The project architecture can also be extended to support:

- OpenAI
- Anthropic
- Google Gemini
- Azure OpenAI
- Other supported LLM providers

The application logic is designed to remain largely independent of the underlying LLM provider.

---

# 🛠️ Technology Stack

## Backend

| Technology | Purpose |
|---|---|
| Java 17+ | Core programming language |
| Spring Boot | Backend application framework |
| Spring Web | REST API development |
| Spring Data JPA | Database persistence |
| Hibernate | ORM |
| PostgreSQL | Relational database |
| Maven | Build and dependency management |
| Lombok | Reduce Java boilerplate |

## Artificial Intelligence

| Technology | Purpose |
|---|---|
| Spring AI | LLM integration |
| Ollama | Local LLM execution |
| LLM | Natural language understanding and generation |
| AI Tool Calling | Allows AI to interact with backend tools |
| Chat Memory | Maintains conversation context |

## Development Tools

| Tool | Purpose |
|---|---|
| IntelliJ IDEA | Development |
| Git | Version control |
| GitHub | Source code management |
| Postman | API testing |
| Docker | Optional containerization |

---

# 🧩 Spring AI Concepts Demonstrated

## ChatClient

The application uses Spring AI to communicate with the configured LLM.

```text
Application
    ↓
Spring AI ChatClient
    ↓
LLM
    ↓
AI Response
```

## Tool Calling

Tool Calling allows the LLM to request execution of application-defined operations.

```text
LLM
 ↓
Tool Request
 ↓
Spring AI Tool
 ↓
Service
 ↓
Repository
 ↓
Database
 ↓
Tool Result
 ↓
LLM
```

## Chat Memory

Chat Memory maintains previous conversation messages.

```text
User Messages
      ↓
Chat Memory
      ↓
Conversation Context
      ↓
LLM
```

## Prompt-Based Interaction

The LLM receives user requests and application context to generate appropriate responses.

The application can control AI behavior using system instructions and prompts.

---

# 🏗️ High-Level Architecture

```text
                         ┌───────────────────┐
                         │       USER        │
                         └─────────┬─────────┘
                                   │
                                   ▼
                         ┌───────────────────┐
                         │     REST API      │
                         │   Spring Web      │
                         └─────────┬─────────┘
                                   │
                                   ▼
                         ┌───────────────────┐
                         │    AI Service     │
                         │    Spring AI      │
                         └─────────┬─────────┘
                                   │
                                   ▼
                         ┌───────────────────┐
                         │       LLM         │
                         │ Ollama / OpenAI   │
                         └─────────┬─────────┘
                                   │
                    ┌──────────────┴──────────────┐
                    │                             │
                    ▼                             ▼
             ┌───────────────┐             ┌───────────────┐
             │ Tool Calling  │             │  Chat Memory  │
             └───────┬───────┘             └───────────────┘
                     │
                     ▼
             ┌───────────────┐
             │ Service Layer │
             └───────┬───────┘
                     │
                     ▼
             ┌───────────────┐
             │ JPA Repository│
             └───────┬───────┘
                     │
                     ▼
             ┌───────────────┐
             │  PostgreSQL   │
             └───────────────┘
```

---

# 🔄 Example End-to-End Flow

Consider the following request:

```text
Create a ticket because I cannot access the company VPN.
```

### Step 1 — User Request

```text
User
 ↓
"I cannot access the company VPN."
```

### Step 2 — REST API

Spring Boot receives the request through:

```text
POST /api/chat
```

### Step 3 — Spring AI

Spring AI sends the request to the configured LLM.

### Step 4 — Intent Understanding

The LLM determines that the user wants to create a support ticket.

### Step 5 — Tool Selection

The LLM determines that the ticket creation tool is required.

```text
createTicket()
```

### Step 6 — Backend Execution

The Spring Boot service executes the required business logic.

### Step 7 — Database

The ticket is stored in PostgreSQL.

Example:

```text
Ticket ID: 1025
Title: VPN Connection Issue
Priority: HIGH
Status: OPEN
```

### Step 8 — Tool Result

The backend returns the result to the AI.

### Step 9 — AI Response

The LLM converts the result into a natural-language response.

```text
Your support ticket has been created successfully.

Ticket ID: 1025
Priority: HIGH
Status: OPEN
```

---

# 📁 Project Structure

```text
IntelliDesk/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.intellidesk/
│   │   │
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── entity/
│   │   │       ├── dto/
│   │   │       ├── config/
│   │   │       ├── tools/
│   │   │       └── exception/
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── ...
│
├── pom.xml
├── README.md
└── .gitignore
```

The exact package structure may evolve as the project grows.

---

# 🗃️ Database Model

The primary database is PostgreSQL.

## Ticket

Example structure:

```text
Ticket
────────────────────────
id
title
description
priority
status
createdAt
updatedAt
```

Future entities may include:

```text
User
Ticket
TicketComment
Conversation
KnowledgeDocument
```

---

# 📡 API

Example AI endpoint:

```http
POST /api/chat
```

### Request

```json
{
  "message": "I cannot connect to the VPN"
}
```

### Response

```json
{
  "response": "I can help you with that. Would you like me to create a support ticket?"
}
```

> API endpoints may change as the project evolves.

---

# 🧪 Testing

The APIs can be tested using:

- Postman
- cURL
- IntelliJ HTTP Client
- Automated Spring Boot tests

Example:

```bash
curl -X POST http://localhost:8080/api/chat \
-H "Content-Type: application/json" \
-d "{\"message\":\"Show my open tickets\"}"
```

---

# 🔐 Security & Configuration

Sensitive information should **never be committed to GitHub**.

The application uses environment variables for sensitive configuration.

Example:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.ai.ollama.base-url=${OLLAMA_BASE_URL}
spring.ai.ollama.chat.options.model=${OLLAMA_MODEL}
```

Environment variables:

```text
DB_URL=jdbc:postgresql://localhost:5432/intellidesk
DB_USERNAME=postgres
DB_PASSWORD=your_password

OLLAMA_BASE_URL=http://localhost:11434
OLLAMA_MODEL=your-model
```

### Security Rules

Never commit:

```text
❌ Database passwords
❌ API keys
❌ Access tokens
❌ Private credentials
❌ Secret keys
```

Use:

```text
✅ Environment variables
✅ IntelliJ Run Configuration
✅ .env files where appropriate
✅ Secret management in production
```

---

# 🚀 Getting Started

## Prerequisites

Install the following:

- Java 17+
- Maven
- PostgreSQL
- Ollama
- Git
- IntelliJ IDEA

---

## 1. Clone the Repository

```bash
git clone https://github.com/<your-username>/IntelliDesk.git
```

Navigate into the project:

```bash
cd IntelliDesk
```

---

## 2. Create PostgreSQL Database

Create the database:

```sql
CREATE DATABASE intellidesk;
```

Configure the required database environment variables.

---

## 3. Install Ollama

Install Ollama and download the required model.

Example:

```bash
ollama pull <model-name>
```

Start Ollama:

```bash
ollama serve
```

Verify that Ollama is running before starting IntelliDesk.

---

## 4. Configure Environment Variables

Configure:

```text
DB_URL
DB_USERNAME
DB_PASSWORD
OLLAMA_BASE_URL
OLLAMA_MODEL
```

Example:

```text
DB_URL=jdbc:postgresql://localhost:5432/intellidesk
DB_USERNAME=postgres
DB_PASSWORD=your_password
OLLAMA_BASE_URL=http://localhost:11434
OLLAMA_MODEL=your-model
```

---

## 5. Run the Application

Using Maven:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

Or run the application directly from IntelliJ IDEA.

---

# 🔮 Future Enhancements

IntelliDesk is designed to evolve into a more complete AI-powered enterprise support platform.

## 🧠 RAG — Retrieval Augmented Generation

Connect the AI assistant to a company knowledge base.

```text
Documents
    ↓
Embedding Model
    ↓
Vector Database
    ↓
Similarity Search
    ↓
Relevant Context
    ↓
LLM
    ↓
Answer
```

Potential knowledge sources:

- Company policies
- IT documentation
- Product documentation
- FAQs
- Troubleshooting guides
- Internal support documents

---

## 📚 Knowledge Base

Allow users to ask questions about company and product documentation using natural language.

---

## 🔐 Authentication & Authorization

Planned capabilities:

- User login
- Role-based access control
- Admin users
- Support-agent roles
- Secure API access

---

## 🎫 Advanced Ticket Management

Future capabilities:

- Ticket assignment
- Automatic ticket categorization
- Priority prediction
- Ticket summarization
- SLA tracking
- Ticket escalation
- Automatic resolution suggestions

---

## 📧 Notifications

Potential integrations:

- Email notifications
- Ticket status updates
- Assignment notifications
- SLA alerts

---

## 📊 Admin Dashboard

Possible dashboard metrics:

- Open tickets
- Closed tickets
- Ticket priority
- Average resolution time
- AI interactions
- Support workload
- Ticket trends

---

## 🐳 Dockerization

Containerize the application infrastructure:

```text
Spring Boot
PostgreSQL
Ollama
```

This will make local setup and deployment easier.

---

## ☁️ Cloud Deployment

Potential deployment platforms:

- AWS
- Azure
- Google Cloud
- Docker-based environments

---

# 🎯 Learning Objectives

This project is being developed to gain practical experience in:

- Java backend development
- Spring Boot
- REST API development
- Spring Data JPA
- Hibernate
- PostgreSQL
- Generative AI
- Spring AI
- LLM integration
- Ollama
- AI Tool Calling
- Chat Memory
- Prompt engineering
- AI + database integration
- RAG
- Vector databases
- AI application architecture
- Enterprise AI application design

---

# 💡 What Makes IntelliDesk Different?

IntelliDesk is not intended to be just another CRUD application.

A traditional application might look like:

```text
User
 ↓
REST API
 ↓
Service
 ↓
Database
 ↓
Response
```

IntelliDesk introduces an intelligent layer:

```text
User
 ↓
Natural Language
 ↓
LLM
 ↓
Understand Intent
 ↓
Select Tool
 ↓
Spring Boot Backend
 ↓
Database / Business Logic
 ↓
Tool Result
 ↓
LLM
 ↓
Natural Language Response
 ↓
User
```

The project demonstrates how **Generative AI can work together with traditional enterprise Java architecture**.

---

# 📈 Project Roadmap

```text
[x] Spring Boot project setup
[x] PostgreSQL integration
[x] Ticket entity
[x] Ticket APIs
[x] Basic LLM integration

[ ] AI Tool Calling
[ ] Chat Memory
[ ] Advanced ticket operations
[ ] RAG integration
[ ] Vector Database
[ ] Knowledge Base
[ ] Authentication
[ ] Admin Dashboard
[ ] Dockerization
[ ] Cloud Deployment
```

> 🚧 **Project Status: Under Active Development**

The roadmap will be updated as new functionality is implemented.

---

# 🧪 Current Development Environment

The current development environment uses:

```text
Java
Spring Boot
Spring AI
Ollama
PostgreSQL
Maven
IntelliJ IDEA
Git / GitHub
```

The project is being developed incrementally, starting with the core Help Desk functionality and gradually introducing more advanced AI capabilities.

---

# 🧠 AI Architecture — Planned Evolution

The planned architecture will evolve from a simple LLM integration:

```text
User
 ↓
Spring Boot
 ↓
Spring AI
 ↓
LLM
 ↓
Response
```

to an AI-enabled enterprise architecture:

```text
                         ┌────────────────────┐
                         │       User         │
                         └─────────┬──────────┘
                                   │
                                   ▼
                         ┌────────────────────┐
                         │    Spring Boot     │
                         └─────────┬──────────┘
                                   │
                                   ▼
                         ┌────────────────────┐
                         │     Spring AI      │
                         └─────────┬──────────┘
                                   │
                    ┌──────────────┼──────────────┐
                    │              │              │
                    ▼              ▼              ▼
               Tool Calling    Chat Memory       RAG
                    │              │              │
                    │              │              ▼
                    │              │        Vector Database
                    │              │
                    ▼              ▼
              Backend APIs     Conversation
                    │
                    ▼
               PostgreSQL
```

---

# 🔍 Example Future RAG Workflow

A future version of IntelliDesk may support:

```text
User:
What is the company's VPN troubleshooting procedure?
```

The system could:

```text
User Question
     ↓
Query Transformation
     ↓
Embedding
     ↓
Vector Search
     ↓
Retrieve Relevant Documents
     ↓
Build Context
     ↓
LLM
     ↓
Grounded Response
```

This will allow IntelliDesk to answer questions based on an organization's actual documentation rather than relying only on the LLM's general knowledge.

---

# 🏢 Enterprise Use Cases

IntelliDesk can potentially be adapted for:

### IT Help Desk

- VPN issues
- Laptop problems
- Password-related requests
- Software installation
- Network issues

### Internal Employee Support

- HR policies
- Leave policies
- Company procedures
- Internal FAQs

### Product Support

- Product troubleshooting
- Product documentation
- Technical questions
- Customer support

### Service Desk

- Ticket creation
- Ticket tracking
- Ticket updates
- Automated support responses

---

# 📌 Project Philosophy

The goal of IntelliDesk is not simply to demonstrate that an LLM can generate text.

The goal is to demonstrate how an LLM can be integrated into a **real backend application** and interact safely with application services and business data.

The architecture therefore focuses on:

```text
LLM
+
Backend Services
+
Business Logic
+
Database
+
Tools
+
Memory
+
Knowledge
```

This approach makes the project closer to a practical enterprise AI application than a simple chatbot.

---

# 👨‍💻 Author

## Nidhi Singh

**Java | Spring Boot | Spring AI | Generative AI**

This project is being developed as a practical exploration of building modern AI-powered backend applications using the Java and Spring ecosystem.

---

# ⭐ Contributions

Suggestions, improvements, and ideas are welcome.

If you find this project useful:

⭐ Star the repository  
🍴 Fork the repository  
🐛 Open an issue  
💡 Suggest an enhancement  
🤝 Contribute

---

# 📜 License

This project is currently intended for learning, experimentation, and portfolio purposes.

Add an appropriate open-source license before distributing the project publicly.

---

# 📌 Project Summary

**IntelliDesk** is an AI-powered Help Desk platform that combines:

```text
☕ Java
+
🌱 Spring Boot
+
🧠 Spring AI
+
🤖 LLM
+
🔧 AI Tool Calling
+
💬 Chat Memory
+
🐘 PostgreSQL
+
🦙 Ollama
```

to create an intelligent support system capable of understanding natural-language requests and interacting with real backend services.

> **From a traditional Help Desk to an AI-powered Support Assistant. 🚀**
