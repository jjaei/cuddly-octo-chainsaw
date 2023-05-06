package com.it.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.example.beans.dao.BoardDAO;
import com.it.example.beans.vo.BoardVO;
import com.it.example.beans.vo.Criteria;

@Service
public class BoardServiceImp implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void register(BoardVO board) {
		boardDAO.register(board);
	};
	@Override
	public BoardVO get(Long bno) {
		return boardDAO.get(bno);
	};
	@Override
	public boolean modify(BoardVO board) {
		return boardDAO.modify(board);
	};
	@Override
	public boolean remove(Long bno) {
		return boardDAO.remove(bno);
	};
	@Override
	public List<BoardVO> getList(){
		return boardDAO.getList();
	};
	
	@Override
	public List<BoardVO> getList(Criteria cri){
		return boardDAO.getList(cri);
	};
}
