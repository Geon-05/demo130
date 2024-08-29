package com.example.demo130.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo130.dto.BookDto;
import com.example.demo130.dto.SelectDto;

@Mapper
public interface BookMapper {
  public List<BookDto> selectBookList();

  public BookDto selectBook(String book_no);

  public List<BookDto> selectBookListPageing(SelectDto selectDto);

  public int selectTotalCnt();

}
