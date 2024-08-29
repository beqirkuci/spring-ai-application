package com.springai.app.springaiapplication.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.client.AiClient;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AIServiceHelper {

  private final AiClient aiClient;

  @Value("${spring.ai.openai.api-key}")
  private String apiKey;

  public String chat(String question){
    PromptTemplate promptTemplate = null;
    try {
      promptTemplate = new PromptTemplate(question);
    }catch(Exception e) {
      log.error("error : "+e.getMessage());

    }
    return this.aiClient.generate(promptTemplate.create()).getGeneration().getText();
  }
  public String generateDocument(String topic) {
    PromptTemplate promptTemplate =null;
    try {
      promptTemplate = new PromptTemplate("""
					Generate document content for a {topic}. 
					It should be at least two pages long and include comprehensive information covering all aspects of the topic, 
					including background information, current trends or developments, relevant statistics or data, key concepts or 
					theories, potential challenges, and future outlook. The document should be well-structured with clear headings
					and sub-headings, and it should provide an in-depth analysis that offers insights and engages the reader effectively.
					      """);
      promptTemplate.add("topic", topic);
    }catch(Exception e) {
      log.error("error : "+e.getMessage());
    }
    return this.aiClient.generate(promptTemplate.create()).getGeneration().getText();
  }

}