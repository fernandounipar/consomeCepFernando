package br.unipar.programacaoweb.service;

import br.unipar.programacaoweb.model.Endereco;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDateTime;

public class ViaCepService {
    private final OkHttpClient client;
    private final ObjectMapper objectMapper;

    public ViaCepService() {
        this.client = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public Endereco consultarCep(String cep) throws IOException {
        String url = String.format("https://viacep.com.br/ws/%s/json/", cep);
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Erro na consulta do CEP: " + response.code());
            }

            String jsonResponse = response.body().string();
            Endereco endereco = objectMapper.readValue(jsonResponse, Endereco.class);
            endereco.setDataConsulta(LocalDateTime.now());
            return endereco;
        }
    }
}