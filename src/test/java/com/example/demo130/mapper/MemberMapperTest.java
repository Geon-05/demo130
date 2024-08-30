package com.example.demo130.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo130.dto.BookDto;
import com.example.demo130.dto.MemberDto;
import com.example.demo130.dto.SelectDto;

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

  @Test
  void testSelectMemberListPageing() {
    SelectDto selectDto = new SelectDto();
    selectDto.setAmount(10);
    selectDto.setPageNo(1);

    List<BookDto> list = mapper.selectMemberListPageing(selectDto);

    assertEquals(10, list.size());
  }

  @Test
  void testSelectTotalCnt() {
    int res = mapper.selectTotalCnt();
    assertEquals(13, res);
  }
}
