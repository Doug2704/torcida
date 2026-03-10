package br.com.vascoparaiba.torcida.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class APIFootballService {
    private final HttpClient client = HttpClient.newHttpClient();

    @Value("${football.api.token}")
    private String token;

    @Cacheable("vascoMatches")
    public String getVascoMatches() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.football-data.org/v4/teams/1780/matches?status=SCHEDULED"))
                .header("X-Auth-Token", token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
        //TODO serializar dados caso a resposta seja objeto Java ao invés de String
        return response.body();
    }
}
