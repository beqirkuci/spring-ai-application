package com.springai.app.springaiapplication.controller;

import com.springai.app.springaiapplication.services.AIServiceHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SpringAIController {
  private final AIServiceHelper aiService;
  @GetMapping("/chat")
  public String chat(@RequestParam String question) {
    return aiService.chat(question);
  }

  @GetMapping("/documents")
  public String document(@RequestParam String topic) {
    return aiService.generateDocument(topic);
  }

}