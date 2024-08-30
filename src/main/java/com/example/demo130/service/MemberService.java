package com.example.demo130.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo130.dto.BookDto;
import com.example.demo130.dto.MemberDto;
import com.example.demo130.dto.PageDto;
import com.example.demo130.dto.SearchDto;
import com.example.demo130.mapper.MemberMapper;

@Service
public class MemberService {
  @Autowired
  MemberMapper mapper;

  @Autowired
  BCryptPasswordEncoder encoder;


  public MemberDto memberLogin(MemberDto member) {
    MemberDto loginMember = mapper.memberLogin(member);
    if(encoder.matches(member.getPw(),loginMember.getPw())){
      return loginMember;
    } else {
      return null;
    }
  }

  public int checkId(String id) {
    return mapper.checkId(id);
  }

  public int insertMember(MemberDto member){
    String encodePw = encoder.encode(member.getPw());
    member.setPw(encodePw);
    return mapper.insertMember(member);
  }

  public Map<String, Object> selectMemberList(SearchDto searchDto) {
    Map<String, Object> map = new HashMap<>();

    List<BookDto> list = mapper.selectMemberList(searchDto);

    int totalCnt = mapper.selectTotalCnt();

    PageDto pageDto = new PageDto(searchDto, totalCnt);
    map.put("list", list);
    map.put("pageDto",pageDto);

    return map;
  }
}
