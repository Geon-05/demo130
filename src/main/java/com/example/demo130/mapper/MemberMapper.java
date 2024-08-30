package com.example.demo130.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo130.dto.BookDto;
import com.example.demo130.dto.MemberDto;
import com.example.demo130.dto.SearchDto;

@Mapper
public interface MemberMapper {
  public MemberDto memberLogin(MemberDto member);

  public int checkId(String id);

  public int insertMember(MemberDto member);

  public List<BookDto> selectMemberList(SearchDto searchDto);

  public int selectTotalCnt();
}
