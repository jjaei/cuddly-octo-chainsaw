package com.it.example.mappers;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.example.beans.vo.ReplyVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
public class ReplyMapperTest {
	@Autowired
	private ReplyMapper mapper;

//	@Test
	public void testMapper() {
		log.info("----------------------Mapper Test----------------------");
		log.info(mapper.toString());
	}
	
	// 자기 게시판에서 5개의 board 글을 선택합니다.
	private Long[] arBno = {7L, 12L, 36L, 38L, 40L};
	
//	@Test
	public void testInsert() {
		// 5개의 게시글에 2개씩 댓글을 달아봅시다.
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO reply = new ReplyVO();
			
			reply.setBno(arBno[i%5]);
			reply.setReply("댓글 자동 생성" + i);
			reply.setReplier("Robot.A" + i);
			mapper.insert(reply);
		});
	}
	
	@Test
	public void testRead() {
		Long targetRno = 1L;
		ReplyVO reply = mapper.read(targetRno);
		log.info("---------reply ok----------");
		log.info(reply.toString());
	}
	
	@Test
	public void testDelete() {
		Long targetRno = 10L;
		int deleteCount = mapper.delete(targetRno);
		
		log.info("reply delete -----------------");
		log.info("delete count : " + deleteCount);
	}
	
	@Test
	public void testUpdate() {
		Long targetRno = 9L;
		ReplyVO reply = mapper.read(targetRno);
		reply.setReply("Update 완료");
		
		int updateCount = mapper.update(reply);
		
		log.info("reply update -----------------");
		log.info("update count : " + updateCount);
	}
}
