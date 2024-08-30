package com.example.demo130.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo130.dto.SelectDto;
import com.example.demo130.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MemberController {
  @Autowired
  MemberService service;

  @GetMapping("/member/memberList")
  public String list(SelectDto selectDto, Model model) {
    Map<String, Object> map = service.selectMemberListPageing(selectDto);
    model.addAttribute("map", map);

      return "/member/list";
  }
  

  
}
