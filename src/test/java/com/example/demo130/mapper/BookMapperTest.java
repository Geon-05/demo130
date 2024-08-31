package com.example.demo130.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo130.dto.BookDto;

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
  void testInsertBook() {
    BookDto book = new BookDto();
    book.setTitle("자바이너테스트1");
    book.setAuthor("자바이너테스트01");
    book.setPrice(123456);
    book.setPub_no("");

    int res = mapper.insertBook(book);
    assertEquals(1, res);
  }
}
