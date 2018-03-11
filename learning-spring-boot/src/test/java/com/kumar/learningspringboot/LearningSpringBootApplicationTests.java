package com.kumar.learningspringboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
//@ContextConfiguration(classes = MyWebConfig.class)
public class LearningSpringBootApplicationTests
{
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Test
	public void contextLoads()
	{
	}

	@Before
	public void setup()
	{
		final DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		this.mockMvc = builder.build();
	}

	@Test
	public void testGet() throws Exception
	{
		final ResultMatcher viewMatcher = MockMvcResultMatchers.view().name("Get Request Handled");
		final MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/test");
		this.mockMvc.perform(builder).andExpect(viewMatcher).andExpect(MockMvcResultMatchers.status().isOk());
	}
}