package com.it.example.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.example.beans.vo.BoardVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@RunWith( SpringJUnit4ClassRunner.class )
public class BoardServiceTest {

	@Autowired
	BoardServiceImp boardService;
	
//	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("서비스에서 작성");
		board.setContent("진짜 서비스에서 작성");
		board.setWriter("진짜");
		
		boardService.register(board);
		log.info("[testRegister] " + board.getBno());
	}
	
	@Test
	public void testGet() {
		log.info("[testGet] " + boardService.get(2L).toString());
	}
	
	@Test
	public void testGetList() {
		boardService.getList().forEach(board -> log.info(board.toString()));
	}
	
//	@Test
	public void testModify() {
		BoardVO board = boardService.get(2L);
		if(board == null ) return;
		board.setTitle("Test Modi~");
		log.info("[testModify] " + boardService.modify(board));
	}
	
	@Test
	public void testRemove() {
		Long bno = 6L;
		BoardVO board = boardService.get(bno);
		if(board == null ) return;
		log.info("[testRemove] " + boardService.remove(bno));
	}
}
