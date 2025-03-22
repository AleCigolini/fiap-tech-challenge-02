# Tech Challenge 02 - Autoatendimento de Fast Food
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

## Arquitetura
Utilizada a metodologia Clean Architecture.

## Execução em ambiente local
### Pré-requisitos
- Ter o Docker instalado e em execução. Para mais informações:
  - Windows: https://docs.docker.com/engine/install/ubuntu/
  - Linux: https://docs.docker.com/desktop/setup/install/windows-install/

### Execução
1. Clone o projeto para sua máquina:
```
git clone https://github.com/AleCigolini/fiap-tech-challenge-02.git
```
2. Acesse o diretório do projeto clonado e execute:
```
docker-compose up -d
```

Será inicializado 3 contêineres:
- Aplicação Java
- Flyway (Inicializar estrutura de banco de dados)
- PostgreSQL

Segue URL do banco de dados abaixo. Credenciais para acesso estão no arquivo .env do projeto.
```
jdbc:postgresql://localhost:5432/techchallenge
```

### Visualização do Swagger
Com a aplicação rodando, via navegador de sua preferência, acesse a URL:
```
http://localhost:8080
```

### Endpoints

#### Pedido

- Retornar todos os pedidos - GET
```
http://localhost:8080/pedidos
```

- Criar pedido com fake check-out - POST
```
http://localhost:8080/pedidos
```
- Corpo da requisição:
```
{
  "cliente": {
    "cpf": "12022425022",
    "email": "teste.usuario@email.com"
  },
  "observacao": "Tocar interfone",
  "produtos": [
    {
      "quantidade": 2,
      "idProduto": "e389406d-5531-4acf-a354-be5cc46a8ca1",
      "observacao": "Mal passado"
    },
    {
      "quantidade": 3,
      "idProduto": "e389406d-5531-4acf-a354-be5cc46a8ca2",
      "observacao": "Gelado"
    },
    {
      "quantidade": 1,
      "idProduto": "e389406d-5531-4acf-a354-be5cc46a8ca3"
    }
  ]
} 
```
<br/>

#### Produto

- Retornar todos os produtos - GET
```
http://localhost:8080/produtos
```

- Criar produto - POST
```
http://localhost:8080/produtos
```
- Corpo da requisição:
```
{
  "nome": "Exemplo produto",
  "descricao": "Exemplo descrição",
  "idCategoria": "4ce30a87-5654-486b-bed6-88c6f83f491a",
  "preco": 10
}
```

- Buscar produto por ID - GET
```
http://localhost:8080/produtos/d98620ab-094e-4702-a066-42c8f39caaaa
```

- Atualizar produto - PUT
```
http://localhost:8080/produtos/d98620ab-094e-4702-a066-42c8f39caaaa
```
- Corpo da requisição:
```
{
  "nome": "Nome produto atualizado",
  "descricao": "Descrição atualizada",
  "idCategoria": "2ae01e62-6805-4095-9bc3-9b9081517b87",
  "preco": 50
}
```

- Excluir produto - DELETE
```
http://localhost:8080/produtos/d98620ab-094e-4702-a066-42c8f39caaaa
```

- Buscar produtos por categoria - GET
```
http://localhost:8080/produtos/categoria/d5b5a378-3862-4436-bdcc-29d8c8a2ee65
```
<br/>

#### Cliente
- Criar cliente - POST
```
http://localhost:8080/clientes
```
Corpo da requisição. Cliente com e-mail e CPF:
```
{
  "nome": "Nome cliente",
  "email": "teste@gmail.com",
  "cpf": "13742443097"
}
```

Corpo da requisição. Cliente com e-mail:
```
{
  "nome": "Nome cliente",
  "email": "teste@gmail.com",
  "cpf": ""
}
```

Corpo da requisição. Cliente com CPF:
```
{
  "nome": "Nome cliente",
  "email": "",
  "cpf": "13742443097"
}
```
- Buscar cliente pelo CPF - GET
```
http://localhost:8080/clientes/cpf
```
Corpo da requisição:
```
{
  "cpf": "12022425022"
}
```

- Buscar cliente pelo E-mail - GET
```
http://localhost:8080/clientes/email
```
Corpo da requisição:
```
{
  "email": "teste.usuario@email.com"
}
```

- Buscar cliente pelo ID - GET
```
http://localhost:8080/clientes/id
```
Corpo da requisição:
```
{
  "id": "e389406d-5531-4acf-a354-be5cc46a8cd4"
}
```


<br/>

#### Categorias de Produto

- Buscar categorias de produto - GET
```
http://localhost:8080/categorias-produto
```

- Criar categoria de produto - POST
```
http://localhost:8080/categorias-produto
```
```
{
  "nome": "Nome do Acompanhamento"
}
```

- Buscar categoria de produto por ID - GET
```
http://localhost:8080/categorias-produto/e397f412-9c76-4fb5-b029-7c3a99b7e982
```

- Atualizar categoria de produto por ID - PUT
```
http://localhost:8080/categorias-produto/e397f412-9c76-4fb5-b029-7c3a99b7e982
```
```
{
  "nome": "Nome do Acompanhamento atualizado"
}
```

- Excluir categoria de produto por ID - DELETE
```
http://localhost:8080/categorias-produto/e397f412-9c76-4fb5-b029-7c3a99b7e982
```
![Infra.jpg](./assets/images/Infra.jpg)

![Pods_especificacoes.jpg](./assets/images/Pods_especificacoes.jpg)