package com.it.example.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.it.example.beans.vo.ReplyVO;

@Mapper
public interface ReplyMapper {
	// 댓글 등록
	public int insert(ReplyVO reply);
}
