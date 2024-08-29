package com.example.demo130.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo130.dto.MemberDto;

@SpringBootTest
public class MemberMapperTest {
  @Autowired
  MemberMapper mapper;

  @Test
  void testMemberLogin() {
    MemberDto member = new MemberDto();
    member.setId("ID01");
    member.setPw("PW01");
    MemberDto login = mapper.memberLogin(member);
    assertNotNull(login);
  }
}
