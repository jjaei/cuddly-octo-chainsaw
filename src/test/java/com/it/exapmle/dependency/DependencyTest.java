package com.it.exapmle.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.example.dependency.Coding;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@RunWith( SpringJUnit4ClassRunner.class )
public class DependencyTest {
//	Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@Autowired
	private Coding coding;
	
	@Test
	public void checkDI() {
		log.info("-----------------------------");
		log.info("coding : " + coding);

//		log.info("computer : " + coding.getComputer());
	}
}
