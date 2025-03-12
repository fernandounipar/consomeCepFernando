# Consulta de Endereço via CEP

## Objetivo
Este projeto tem como objetivo desenvolver um sistema de consulta de endereços através de CEP, utilizando a API ViaCEP. O sistema oferece uma interface de linha de comando que permite aos usuários consultarem informações detalhadas de endereços a partir de um CEP. Para otimizar o desempenho e reduzir o número de requisições à API externa, o sistema implementa um mecanismo de cache local utilizando banco de dados, armazenando os resultados de consultas anteriores.

## Tecnologias Utilizadas
- **Java** (versão 8 ou superior)
- **Maven** (para gerenciamento de dependências)
- **PostgreSQL** (banco de dados para armazenamento local)
- **OkHttp** (cliente HTTP para consumo da API)
- **Jackson** (para serialização/deserialização de JSON)
- **REST API - ViaCEP** (https://viacep.com.br/)

## Como Executar o Projeto

### Pré-requisitos
- JDK 8 ou superior instalado
- Maven instalado
- PostgreSQL instalado e configurado

### Passo a Passo

1. Clone este repositório:
   ```sh
   git clone https://github.com/seu-usuario/consomeCepFernando.git
   ```

2. Acesse a pasta do projeto:
   ```sh
   cd consomeCepFernando
   ```

3. Configure o banco de dados:
   - Crie um banco de dados PostgreSQL
   - Atualize as configurações de conexão no arquivo `application.properties`

4. Compile o projeto:
   ```sh
   mvn clean install
   ```

5. Execute o programa:
   ```sh
   mvn exec:java -Dexec.mainClass="br.unipar.programacaoweb.Main"
   ```

### Funcionalidades
- Consulta de endereços por CEP
- Armazenamento automático dos resultados em banco de dados
- Validação de formato do CEP
- Exibição formatada das informações do endereço
- Cache local para consultas repetidas

### Observações
- O sistema aceita apenas CEPs no formato de 8 dígitos
- Consultas a CEPs já pesquisados são respondidas instantaneamente através do banco de dados local
- Novas consultas são realizadas através da API ViaCEP e automaticamente armazenadas

