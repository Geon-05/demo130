package com.example.demo130.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo130.dto.PageDto;
import com.example.demo130.dto.SelectDto;
import com.example.demo130.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BookController {
  @Autowired
  BookService service;

  @GetMapping("/book/bookList")
  public String list(SelectDto selectDto, Model model) {
    Map<String, Object> map = service.selectBookListPageing(selectDto);
    model.addAttribute("map", map);

      return "/book/list";
  }
  
}
