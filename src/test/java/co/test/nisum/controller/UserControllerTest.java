package co.test.nisum.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.test.nisum.dto.UserRequest;
import co.test.nisum.service.UserService;
import co.test.nisum.util.Generator;
import jakarta.servlet.http.HttpServletResponse;

@SpringBootTest
@WebAppConfiguration
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	public static final String URL = "http://localhost:8080";

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private UserService service;

	@BeforeEach
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void testPostUser_SUCCESS() throws Exception {
		when(this.service.addUser(Generator.genRequest())).thenReturn(Generator.genResponse());
		
		final MvcResult mvcResult = this.mvc.perform(post(URL + "/user").contentType("application/json").content(mapper.writeValueAsString(Generator.genRequest()))).andExpect(status().isCreated()).andReturn();
		
		assertNotNull(mvcResult.getResponse().getContentAsString());
		assertEquals(mvcResult.getResponse().getStatus(), HttpServletResponse.SC_CREATED);
	}

	@Test
	void testPostUser_FAIL() throws Exception {
		final MvcResult mvcResult = this.mvc
				.perform(post(URL + "/user").contentType("application/json")
						.content(mapper.writeValueAsString(Generator.genRequestFail())))
				.andExpect(status().isBadRequest()).andReturn();
		
	}

}
