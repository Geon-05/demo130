package com.example.demo130.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo130.dto.BookDto;
import com.example.demo130.dto.SearchDto;
import com.example.demo130.service.BookService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@Slf4j
public class BookController {
  @Autowired
  BookService service;

  @GetMapping("/book/bookList")
  public String list(SearchDto searchDto, Model model) {
    Map<String, Object> map = service.selectBookList(searchDto);
    model.addAttribute("map", map);

      return "/book/list";
  }
  
  @GetMapping("/book/bookInsert")
  public String getMethodName() {
      return "/book/insert";
  }

  @PostMapping("/book/bookInsertAction")
  public String postMethodName(BookDto book, Model model) {
    log.info("title : " + book.getTitle());
    
    int res = service.insertBook(book);

      if (res>0) {
        model.addAttribute("msg", "도서등록이 완료되었습니다.");
        model.addAttribute("url", "/book/bookInsert");
        return "/common/msg";
      } else {
        model.addAttribute("msg", "입력중 예외가 발생했습니다.");
        return "/common/msg";
      }
      
  }
  
  

}
