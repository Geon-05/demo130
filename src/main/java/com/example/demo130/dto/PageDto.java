package com.example.demo130.dto;

import lombok.Data;

@Data
public class PageDto {
  private int startPage;
  private int endPage;
  private boolean prev;
  private boolean next;

  private SelectDto selectDto;
  private int totalCnt;

  public PageDto(SelectDto selectDto, int totalCnt){
    this.selectDto = selectDto;

    int pageBlockAmount = 5;
    endPage = (int) Math.ceil(selectDto.getPageNo() * 1.0 / pageBlockAmount) * pageBlockAmount;
    startPage = endPage - (pageBlockAmount - 1);

    int realEndPage = (int) Math.ceil(totalCnt * 1.0 / selectDto.getAmount());
    if (endPage > realEndPage) {
      endPage = realEndPage;
    }

    prev = startPage == 1 ? false : true ;
    next = realEndPage > endPage ? true : false;
  }
}
