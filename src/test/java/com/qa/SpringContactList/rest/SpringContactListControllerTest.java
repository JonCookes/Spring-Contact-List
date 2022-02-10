package com.qa.SpringContactList.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.SpringContactList.domain.Friend;

@SpringBootTest
class SpringContactListControllerTest {

	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper map;
	
	@Test
	void testAdd() throws Exception {
		//create a friend
		Friend newF = new Friend("Jon", "Jonshotmail", "Jono", "98764", null);
		//convert into JSON string
		String newFJSON = this.map.writeValueAsString(newF);
		//build the mock request
		RequestBuilder mockRequest = post("/add").contentType(MediaType.APPLICATION_JSON).content(newFJSON);
		//response
		Friend savedF = new Friend("Jon", "Jonshotmail", "Jono", "98764", null);
		//convert to JSON
		String savedFJSON = this.map.writeValueAsString(savedF);
		//test status(201-created)
		ResultMatcher matchStatus = status().isCreated();
		//test response body
		ResultMatcher matchBody = content().json(savedFJSON);
		//perform the test
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
		
		


}
}
