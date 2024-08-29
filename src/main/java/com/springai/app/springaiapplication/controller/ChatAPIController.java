package com.springai.app.springaiapplication.controller;

import com.springai.app.springaiapplication.model.Message;
import com.springai.app.springaiapplication.model.Request;
import com.springai.app.springaiapplication.model.Request.RequestBuilder;
import com.springai.app.springaiapplication.model.Response;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@RequiredArgsConstructor
public class ChatAPIController {

  private final RestTemplate restTemplate;

  @Value("${openai.model}")
  private String model;

  @Value("${openai.max-completions}")
  private int maxCompletions;

  @Value("${openai.temperature}")
  private double temperature;

  @Value("${openai.api.url}")
  private String apiUrl;

  @PostMapping("/chat")
  public Response chat(@RequestParam("prompt") String prompt) {
    Response chatResponse=null;
    List<Message> ChatMessages = new ArrayList<>();
    RequestBuilder request = Request.builder();
    try {
      ChatMessages.add(new Message("user", prompt));

      request
          .model(model)
          .messages(ChatMessages)
          .n(maxCompletions)
          .temperature(temperature);

      chatResponse = restTemplate.postForObject(apiUrl, request.build(), Response.class);
    }catch(Exception e) {
      log.error("error : "+e.getMessage());
    }
    return chatResponse;
  }

}