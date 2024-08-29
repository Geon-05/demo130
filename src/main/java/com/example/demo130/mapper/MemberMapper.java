package com.example.demo130.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo130.dto.MemberDto;

@Mapper
public interface MemberMapper {
  public MemberDto memberLogin(MemberDto member);

  public int checkId(String id);

  public int insertMember(MemberDto member);
}
