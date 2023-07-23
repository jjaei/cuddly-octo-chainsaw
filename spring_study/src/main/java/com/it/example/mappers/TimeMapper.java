package com.it.example.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service  // 스프링에서 관리하는 Bean에 등록
@Mapper // 마이배티스 연결
public interface TimeMapper {
//	@Select("select sysdate() from dual")
	public String getTime();
}
