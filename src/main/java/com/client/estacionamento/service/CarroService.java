package com.client.estacionamento.service;

import com.client.estacionamento.model.Carro;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class CarroService {

    private static final String API_URL = "http://localhost:8080/carro";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Carro> getAllCarro(Long id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return Collections.singletonList(objectMapper.readValue(response.body(), Carro.class));
        } else {
            throw new RuntimeException("Failed to get Carro: " + response.statusCode());
        }
    }

    public Carro createCarro(Carro carro) throws IOException, InterruptedException {
        String json = objectMapper.writeValueAsString(carro);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), Carro.class);
        } else {
            throw new RuntimeException("Failed to create Carro: " + response.statusCode());
        }
    }
}
