# Consulta de Endereço via CEP

## Objetivo
Este projeto tem como objetivo consumir um web service para buscar informações de endereço a partir de um CEP informado pelo usuário. Além disso, o sistema armazena os resultados em um banco de dados, garantindo que consultas futuras ao mesmo CEP sejam feitas localmente, otimizando o tempo de resposta.

## Fluxo do Programa
1. O sistema solicita um CEP ao usuário.
2. Verifica no banco de dados se o CEP já foi consultado anteriormente.
3. Se o CEP existir no banco, exibe as informações para o usuário.
4. Se o CEP não existir no banco, busca os dados na API ViaCEP.
5. Os dados do endereço e a data/hora da consulta são salvos no banco.
6. O sistema informa ao usuário que a busca foi realizada via API e que os dados foram armazenados para futuras consultas.

## Tecnologias Utilizadas
- **Java** (versão 8 ou superior)
- **Maven** (para gerenciamento de dependências)
- **REST API - ViaCEP** (https://viacep.com.br/)

## Instalação e Execução
1. Clone este repositório:
   ```sh
   git clone https://github.com/seu-repositorio/consulta-cep.git
   ```
2. Acesse a pasta do projeto:
   ```sh
   cd consulta-cep
   ```
3. Compile e execute o projeto com Maven:
   ```sh
   mvn clean install
   mvn exec:java -Dexec.mainClass="com.exemplo.cep.Main"
   ```

