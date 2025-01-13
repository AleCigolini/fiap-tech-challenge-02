# Tech Challenge 01 - Autoatendimento de Fast Food
## Colaboradores
- Alessandro Cigolini
- Carlos Ferreira
- Josinaldo Fontes
- Sandro Nascimento

## Objetivo
Desenvolvida para otimizar a experiência do cliente e a gestão da lanchonete, esta aplicação backend atua como o coração do sistema de autoatendimento. 
Responsável por administrar de forma eficiente e segura todas as operações, desde a criação e gestão de produtos até o processamento de pedidos e a manutenção de um banco de dados completo sobre os clientes. 
Através da integração com o sistema de frente de loja, a aplicação garante a disponibilidade de informações precisas e atualizadas, proporcionando ao cliente autonomia na escolha e personalização dos pedidos, 
e à lanchonete, uma ferramenta poderosa para aumentar a eficiência operacional, reduzir custos e elevar a satisfação do consumidor.

## Execução em ambiente local
### Pré-requisitos
- Ter o Docker instalado e em execução. Para mais informações:
  - Windows: https://docs.docker.com/engine/install/ubuntu/
  - Linux: https://docs.docker.com/desktop/setup/install/windows-install/

### Execução
1. Clone o projeto para sua máquina:
```
git clone https://github.com/AleCigolini/fiap-tech-challenge-01.git
```
2. Acesse o diretório do projeto clonado e execute:
```
docker-compose up -d
```

Será inicializado 3 contêineres:
- Aplicação Java
- Flyway (Inicializar estrutura de banco de dados)
- PostgreSQL

### Visualização do Swagger
Com a aplicação rodando, via navegador de sua preferência, acesse a URL:
```
http://localhost:8080
```
