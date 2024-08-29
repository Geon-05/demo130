package com.example.demo130.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo130.dto.MemberDto;
import com.example.demo130.service.MemberService;

import jakarta.servlet.http.Cookie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class LoginController {
  @Autowired
  MemberService service;

  @GetMapping("/login/login")
  public String login() {
      return "/login/login";
  }
  
  // @PostMapping("/loginAction")
  // public String postMethodName(Model model
  //   , @RequestParam(name = "chkIdSave", required = false) String chkIdSave) {
      
  //     Cookie
  //     return entity;
  // }
  
  @GetMapping("/login/register")
  public String register() {
      return "login/register";
  }

  @PostMapping("/login/registerAction")
  public String postMethodName(MemberDto member
  , Model model) {
      int res = service.insertMember(member);
      if(res > 0){
        // 입력성공 메세지 출력 후 로그인 페이지로
        model.addAttribute("msg", "로그인 후 이용이 가능합니다.");
        model.addAttribute("url", "/login/login");

    } else {
        // 입력실패 메세지 출력 후 뒤로가기
        model.addAttribute("msg", "입력중 예외가 발생했습니다.\n관리자에게 문의하세요.");
    }
    return "/common/msg";
  }
  
  
}
