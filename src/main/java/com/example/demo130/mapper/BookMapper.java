package com.example.demo130.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo130.dto.BookDto;
import com.example.demo130.dto.SearchDto;

@Mapper
public interface BookMapper {
  public BookDto selectBook(String book_no);

  public List<BookDto> selectBookList(SearchDto searchDto);

  public int selectTotalCnt(SearchDto searchDto);

  public int insertBook(BookDto book);

}
