package com.example.demo130.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo130.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class MemberRestController {
  @Autowired
  MemberService service;

  @GetMapping("/checkId/{inputIdValue}")
  public Map<String, Object> getMethodName(@PathVariable(name = "inputIdValue") String id) {
      Map<String, Object> map = new HashMap<>();

      int res = service.checkId(id);

      map.put("id_res",res);
      return map;
  }
  
}
