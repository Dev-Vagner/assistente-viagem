# Assistente de Viagens
Este repositório contém os componentes da API Rest de assistência de viagens, projetada para auxiliar no planejamento de viagens do usuário. 
A API fornece endpoints com conexão com a inteligência artificial da OpenAI para sugerir locais para hospedagem, principais pontos turísticos 
para visitar, formas de chegar até a localidade desejada, etc.

## Visão Geral
Ao cogitar viajar para algum lugar diversas dúvidas surgem, como por exemplo:
- Qual a distância para chegar até este lugar?
- Qual o melhor meio de transporte para chegar até lá? E quais os valores médios destes meios de transporte?
- Quais são as principais opções de hospedagem neste lugar?
- Quais os principais pontos turísticos deste lugar?

Então, buscando auxiliar nestas e em mais algumas questões que esta API foi desenvolvida.

## Ferramentas utilizadas
- **Java 17 / Spring Boot**: Para o desenvolvimento da API Rest;
- **Spring AI**: Para conexão com a API da OpenAI;
- **Docker / Docker Compose**: Para containerização e gerenciamento de ambientes;
- **Swagger**: Para a documentação da API;

## Funcionalidades
- `GET /travel-assistant/arrive-place`: Mostra informações de como chegar ao destino;
- `GET /travel-assistant/tourist-attractions`: Lista os 5 principais pontos turísticos da localidade desejada;
- `GET /travel-assistant/hosting`: Lista 5 locais para se hospedar na localidade desejada;
- `GET /travel-assistant/tourist-tours`: Lista as 3 principais empresas de passeios turísticos da localidade desejada;
- `GET /travel-assistant/clothes-take`: Dá sugestões de roupas para levar para a localidade desejada nas datas informadas;

## Configuração e Execução
- ### Dependências:
    - Docker / Docker Compose
- ### Passo-a-passo:
    1. Clone o repositório:
        ```bash
        git clone https://github.com/Dev-Vagner/assistente-viagem.git
        ```
    2. Navegue até o diretório do projeto:
        ```bash
        cd assistente-viagem
        ```
    3. Insira a variável de ambiente do arquivo .env
    4. No diretório raiz do projeto, execute o comando:
    ```bash
      docker-compose up -d
    ```
    5. Acesse os dados da aplicação:
        - Acesse a API em: `http://localhost:8080`
        - Acesse a documentação Swagger da API em: `http://localhost:8080/docs`

---

**Autor:** Vagner Bruno

**Data:** Setembro de 2024