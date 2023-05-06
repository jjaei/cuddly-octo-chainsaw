package com.it.example.beans.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.it.example.beans.vo.BoardVO;
import com.it.example.beans.vo.Criteria;
import com.it.example.mappers.BoardMapper;

import lombok.RequiredArgsConstructor;

@Repository  // Component의 자식 annotation
@RequiredArgsConstructor
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
	// 게시글 입력
	public void register(BoardVO board) {
		mapper.insertSelectKey_bno(board);
	}
	
	// 게시글 가져오기
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}
	
	// 게시글 삭제
	public boolean remove(Long bno) {
		return mapper.delete(bno) != 0;
	}
	
	// 게시글 수정
	public boolean modify(BoardVO board) {
		return mapper.update(board) != 0;
	}
	
	// 전체 게시글 가져오기
	public List<BoardVO> getList() {
		return mapper.getList();
	}
	
	// 전체 게시글 가져오기(페이징 처리)
	public List<BoardVO> getList(Criteria cri) {
		cri.setParam();
		return mapper.getListWithPaging(cri);
	}
	
	// 게시글 개수
	public int getTotal() {
		return mapper.getTotal();
	}
}
