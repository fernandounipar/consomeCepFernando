package br.unipar.programacaoweb;

import br.unipar.programacaoweb.model.Endereco;
import br.unipar.programacaoweb.repository.EnderecoRepository;
import br.unipar.programacaoweb.service.ViaCepService;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EnderecoRepository repository = new EnderecoRepository();
        ViaCepService viaCepService = new ViaCepService();

        try {
            System.out.println("=== Consulta de CEP ===");
            System.out.print("Digite o CEP (apenas números): ");
            String cep = scanner.nextLine().replaceAll("\\D", "");

            if (cep.length() != 8) {
                System.out.println("CEP inválido! O CEP deve conter 8 dígitos.");
                return;
            }

            Optional<Endereco> enderecoOptional = repository.findByCep(cep);

            if (enderecoOptional.isPresent()) {
                Endereco endereco = enderecoOptional.get();
                System.out.println("\nEndereço encontrado no banco de dados:");
                exibirEndereco(endereco);
            } else {
                System.out.println("\nConsultando CEP na API ViaCEP...");
                try {
                    Endereco endereco = viaCepService.consultarCep(cep);
                    repository.save(endereco);
                    System.out.println("Endereço encontrado e salvo no banco de dados:");
                    exibirEndereco(endereco);
                } catch (IOException e) {
                    System.out.println("Erro ao consultar o CEP: " + e.getMessage());
                }
            }
        } finally {
            repository.close();
            scanner.close();
        }
    }

    private static void exibirEndereco(Endereco endereco) {
        System.out.println("CEP: " + endereco.getCep());
        System.out.println("Logradouro: " + endereco.getLogradouro());
        System.out.println("Complemento: " + 
            (endereco.getComplemento().isEmpty() ? "N/A" : endereco.getComplemento()));
        System.out.println("Bairro: " + endereco.getBairro());
        System.out.println("Cidade: " + endereco.getLocalidade());
        System.out.println("Estado: " + endereco.getUf());
        System.out.println("Data da consulta: " + endereco.getDataConsulta());
    }
}