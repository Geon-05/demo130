package com.example.demo130.dto;

import lombok.Data;

@Data
public class SelectDto {
  private int pageNo = 1;
  private int amount = 10;
}
