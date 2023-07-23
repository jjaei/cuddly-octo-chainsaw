package com.it.example.beans.dao;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.example.beans.vo.Criteria;
import com.it.example.beans.vo.ReplyVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@RunWith( SpringJUnit4ClassRunner.class )

public class ReplyDAOTest {
	@Autowired
	private ReplyDAO replyDAO;
	
	private Long[] arBno = {7L, 12L, 36L, 38L, 40L};
	
	@Test
	public void testRegister() {
		// 5개의 게시글에 2개씩 댓글을 달아봅시다.
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO reply = new ReplyVO();
			
			reply.setBno(arBno[i%5]);
			reply.setReply("댓글 자동 생성" + i);
			reply.setReplier("Robot.DAO" + i);
			
			replyDAO.register(reply);
		});
	}
	
	@Test
	public void testRead() {
		Long targetRno = 2L;
		ReplyVO reply = replyDAO.get(targetRno);
		
		log.info("replyDAO - get ------------------");
		log.info(reply.toString());
	}
	
	@Test
	public void testDelete() {
		Long targetRno = 10000L;
		int deleteCount = replyDAO.remove(targetRno);
		log.info("replyDAO - delete -----------------------");
		log.info("delete Count: " + deleteCount);
	}
	
	@Test
	public void testUpdate() {
		Long targetRno = 9L;
		ReplyVO reply = replyDAO.get(targetRno);
		reply.setReply("업데이트 두 번째");
		int updateCount = replyDAO.modify(reply);
		log.info("replyDAO - update -----------------------");
		log.info("update Count: " + updateCount);
	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		
		List<ReplyVO> replies = replyDAO.getList(cri, arBno[1]);
		log.info("replyDAO - letList ---------------");
		replies.forEach(reply -> log.info(reply.toString()));
	}
}
