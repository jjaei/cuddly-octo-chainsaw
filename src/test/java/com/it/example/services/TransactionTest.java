package com.it.example.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@RunWith( SpringJUnit4ClassRunner.class )
public class TransactionTest {
	@Autowired
	private TransactionService transactionService;
	
	@Test
	public void testDoInsert() {
		// 두 개의 SQL문 중 하나만 성공하는 케이스 테스트
		transactionService.doInsert(null, "James");
	}
	
}
