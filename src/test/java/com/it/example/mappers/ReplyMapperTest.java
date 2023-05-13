package com.it.example.mappers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
public class ReplyMapperTest {
	@Autowired
	private ReplyMapper mapper;

	@Test
	public void testMapper() {
		log.info("----------------------Mapper Test----------------------");
		log.info(mapper.toString());
	}
}
