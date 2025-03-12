package br.unipar.programacaoweb;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsomeCEP {

    //TODO
    // 1. solicite um cep ao usuário (pode ser joptionpane)
    // 2. verifique se existe o cep na base de dados
    // 3. se não existir, consulte o cep na api do viacep
    // 4. salve o novo cep na base de dados com data e hora da consulta

    public static void main(String[] args) {
        try {
            //bloco para consultar via cep
//            String cep = "85904180"; // CEP que queremos consultar
//            String url = "https://viacep.com.br/ws/" + cep + "/json/"; // URL que pegamos no site do ViaCEP
//
//            URL urlViaCEP = new URL(url); // objeto URL com a instancia do VIA CEP
//            HttpURLConnection conexao = (HttpURLConnection) urlViaCEP.openConnection(); // objeto para abrir a conexão
//            conexao.setRequestMethod("GET"); // método GET (vamos só pegar informações)
//
//            BufferedReader leitor = // objeto para ler a resposta
//                    new BufferedReader(new InputStreamReader(conexao.getInputStream())); // rio de informações que está vindo da conexão
//
//            String linha; // variável para armazenar a linha que estamos lendo
//            StringBuilder resposta = new StringBuilder(); // variável para construir e armazenar a resposta completa
//
//            while ((linha = leitor.readLine()) != null) { // enquanto tivermos linhas para ler
//                resposta.append(linha + "\n"); // adicionamos a linha na resposta
//            }

            //System.out.println(resposta.toString()); // exibimos a resposta completa

//            ObjectMapper mapper = new ObjectMapper(); // objeto para mapear o JSON para um objeto Java
//            Endereco endereco = mapper.readValue(resposta.toString(), Endereco.class); // mapeamos o JSON para um objeto Endereco
//--------------------------------------------------------------------------------
            //bloco para inserir manualmente
            Endereco enderecoManual = new Endereco();

            enderecoManual.setCep("85904180");
            enderecoManual.setLogradouro("Rua das Flores");
            enderecoManual.setBairro("Centro");
            enderecoManual.setLocalidade("Toledo");
            enderecoManual.setUf("PR");
            enderecoManual.setIbge("4127709");
            enderecoManual.setComplemento("Casa");


            EnderecoDAO dao = new EnderecoDAO();
            dao.salvar(enderecoManual);
//--------------------------------------------------------------------------------

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}