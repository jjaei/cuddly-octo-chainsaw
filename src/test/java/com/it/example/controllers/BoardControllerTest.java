package com.it.example.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.it.example.ExampleApplication;

import lombok.extern.slf4j.Slf4j;

@RunWith( SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {ExampleApplication.class})
@Slf4j
public class BoardControllerTest {
	// 가짜 MVC
	// 마치 브라우저에서 URL을 요청한 것처럼 환경을 만들어 준다.
	private MockMvc mockMvc;
	
	// 요청을 처리해주는 WebApplicationContext를 불러온다.
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	// BeforeEach는 테스트 셋업의 5총사 중 하나
	// 각 테스트 유닛이 돌기 전 공통적으로 수행
	@Before
	public void setUp() {
		// 가짜 MVC에 WebApplicationContext를 
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	// 해당 경로의 응답 페이지가 없다면 오류 발생
	@Test
	public void testList( ) throws Exception {
		log.info( mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
						.andReturn().getModelAndView().getModelMap().toString());
	}
	
	@Test
	public void testRegister() throws Exception {
		String result = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
						.param("title", "테스트 제목")
						.param("content","테스트 내용")
						.param("writer", "J")).andReturn().getFlashMap().toString();
	}
}
