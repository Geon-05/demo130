package com.example.demo130.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo130.dto.BookDto;
import com.example.demo130.dto.PageDto;
import com.example.demo130.dto.SearchDto;
import com.example.demo130.mapper.BookMapper;

@Service
public class BookService {
  @Autowired
  BookMapper mapper;

  public BookDto selectBook(String Book_no){
    return mapper.selectBook(Book_no);
  }

  public Map<String, Object> selectBookList(SearchDto searchDto){
    Map<String, Object> map = new HashMap<>();

    List<BookDto> list = mapper.selectBookList(searchDto);

    int totalCnt = mapper.selectTotalCnt(searchDto);

    PageDto pageDto = new PageDto(searchDto, totalCnt);
    map.put("list", list);
    map.put("pageDto",pageDto);

    return map;
  }
}
