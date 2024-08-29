package com.springai.app.springaiapplication.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author madhankumar
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

  private String role;
  private String content;

}