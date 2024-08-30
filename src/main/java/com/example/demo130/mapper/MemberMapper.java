package com.example.demo130.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo130.dto.BookDto;
import com.example.demo130.dto.MemberDto;
import com.example.demo130.dto.SelectDto;

@Mapper
public interface MemberMapper {
  public MemberDto memberLogin(MemberDto member);

  public int checkId(String id);

  public int insertMember(MemberDto member);

  public List<BookDto> selectMemberListPageing(SelectDto selectDto);

  public int selectTotalCnt();
}
