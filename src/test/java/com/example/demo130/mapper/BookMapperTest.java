package com.example.demo130.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo130.dto.BookDto;
import com.example.demo130.dto.SelectDto;

@SpringBootTest
public class BookMapperTest {
  @Autowired
  BookMapper mapper;

  @Test
  void testSelectBook() {
    BookDto book = mapper.selectBook("B00002");
    assertNotNull(book);
  }

  @Test
  void testSelectBookList() {
    List<BookDto> list = mapper.selectBookList();
    assertEquals(11, list.size());
  }

  @Test
  void testSelectBookListPageing() {
    List<BookDto> list = mapper.selectBookListPageing(new SelectDto());
    assertEquals(10, list.size());
  }

  @Test
  void testSelectTotalCnt() {
    int res = mapper.selectTotalCnt();
    assertNotNull(res);
  }
}
