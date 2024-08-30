package com.example.demo130.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo130.dto.SearchDto;
import com.example.demo130.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
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
  

}
