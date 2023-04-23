package com.it.example.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.it.example.beans.vo.BoardVO;

@Mapper
public interface BoardMapper {
	// 게시글 목록
	public List<BoardVO> getList();
	
	// 게시물 등록
	public void insert(BoardVO board);
}
