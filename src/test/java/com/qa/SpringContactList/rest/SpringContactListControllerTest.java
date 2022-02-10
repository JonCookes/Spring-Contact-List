package com.qa.SpringContactList.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
	
	@Test
    void testUpdate() throws Exception {
        Friend updateFriend = new Friend("Jon", "Jonshotmail", "Jono", "98764", null);
        String updateFriendJSON = this.map.writeValueAsString(updateFriend);
        Long IdUpdate = 1L;
        RequestBuilder updateReq = put("/update/" + IdUpdate).contentType(MediaType.APPLICATION_JSON)
                .content(updateFriendJSON);
        Friend returnUpdatedFriend = new Friend("Jon", "Jonshotmail", "Jono", "98764", null);
        String returnUpdatedFriendJSON = this.map.writeValueAsString(returnUpdatedFriend);
        ResultMatcher retStatus = status().isOk();
        ResultMatcher retBody = content().json(returnUpdatedFriendJSON);
        this.mock.perform(updateReq).andExpect(retStatus).andExpect(retBody);
    }
	
	@Test
    void testDelete() throws Exception {
        Friend deleteFriend = new Friend("Jon", "Jonshotmail", "Jono", "98764", null);
        String deleteFriendJSON = this.map.writeValueAsString(deleteFriend);
       
        Long remId = 1L;
        RequestBuilder delRequest = delete("/delete/" + remId);
        ResultMatcher Status = status().isOk();
        ResultMatcher Body = content().json(deleteFriendJSON);
        this.mock.perform(delRequest).andExpect(Status).andExpect(Body);
}
}
