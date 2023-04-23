package com.it.example.mappers;

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
public class BoardMapperTest {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board.toString()));
		
	}
	
//	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성");
		board.setContent("새로 작성한 글의 내용");
		board.setWriter("user01");
		
		mapper.insert(board);
	}
	
//	@Test
	public void testInsertSelectKey_bno() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성");
		board.setContent("새로 작성한 글의 내용");
		board.setWriter("user02");
		
		mapper.insertSelectKey_bno(board);	
	}
	
//	@Test
	public void testRead() {
		long bno = 2L;
		log.info(mapper.read(bno).toString());
	}
	
//	@Test
	public void testDelete() {
		long bno = 3L;
		log.info("[Delete Count] " + mapper.delete(bno));
	}
	
	@Test
	public void testUpdate() {
		Long bno = 3L;
		if(mapper.read(bno) != null) {
			BoardVO board = new BoardVO();
			// 실행 전에 존재하는 데이터 확인
			board.setBno(1L);
			board.setTitle("수정된 제목");
			board.setContent("수정된 내용");
			board.setWriter("user00");
			
			log.info("[Update Count] " + mapper.update(board));
		} else {
			log.info("[update Count] No Such Board!!! ");
		}
	}
}
