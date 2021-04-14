package com.onemorecode.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ProducerControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectmapper;

	private static Logger logger = LoggerFactory.getLogger(ProducerControllerTests.class); 

	@Test
	void sendMessage() throws UnsupportedEncodingException, JsonProcessingException, Exception {
		
		String msg = "Primer mensaje";
		
		String response = mockMvc
				.perform(post("/producer/sendMessage")
						.content(objectmapper.writeValueAsString(msg)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(HttpStatus.ACCEPTED.value())).andReturn().getResponse()
				.getContentAsString();
		logger.info(response);
		
	}

}
