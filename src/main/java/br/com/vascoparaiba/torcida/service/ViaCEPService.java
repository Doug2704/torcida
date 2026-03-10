package br.com.vascoparaiba.torcida.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCEPService {
    private final HttpClient client = HttpClient.newHttpClient();

    public String getAddressByCEP(String cep) throws Exception {
        if (!cep.matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP inválido");
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                .GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
