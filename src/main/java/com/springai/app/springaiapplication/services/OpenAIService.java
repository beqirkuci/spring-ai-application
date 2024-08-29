package com.springai.app.springaiapplication.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class OpenAIService {
  private final String apiKey = "YOUR_API_KEY"; // Replace with your actual API key
  private final String openAiApiUrl = "https://api.openai.com/v1/"; // Base URL for OpenAI API

  public String getOpenAIResponse(String endpoint, String requestBody) {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer " + apiKey);
    headers.set("Content-Type", "application/json");

    HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

    ResponseEntity<String> response = restTemplate.exchange(
        UriComponentsBuilder.fromHttpUrl(openAiApiUrl + endpoint).toUriString(),
        HttpMethod.POST,
        requestEntity,
        String.class
    );

    return response.getBody();
  }
}
