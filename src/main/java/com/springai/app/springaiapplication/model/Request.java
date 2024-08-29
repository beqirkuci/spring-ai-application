package com.springai.app.springaiapplication.model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
  private String model;
  private List<Message> messages;
  private int n;
  private double temperature;
}
