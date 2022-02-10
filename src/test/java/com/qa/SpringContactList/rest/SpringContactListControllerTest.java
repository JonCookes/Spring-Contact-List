package com.qa.SpringContactList.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.SpringContactList.domain.Friend;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:friend-schema.sql","classpath:friend-data.sql" },executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
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
		RequestBuilder mockRequest = post("/friend/add").contentType(MediaType.APPLICATION_JSON).content(newFJSON);
		//response
		Friend savedF = new Friend(2L,"Jon", "Jonshotmail", "Jono", "98764", "xoxoxxo!");
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
        Friend updateFriend = new Friend("Jon", "Jonshotmail", "Jono", "98764", "xoxoxxo!");
        String updateFriendJSON = this.map.writeValueAsString(updateFriend);
        Long IdUpdate = 1L;
        RequestBuilder updateReq = put("/friend/update/" + IdUpdate).contentType(MediaType.APPLICATION_JSON)
                .content(updateFriendJSON);
        Friend returnUpdatedFriend = new Friend(1L,"Jon", "Jonshotmail", "Jono", "98764", "xoxoxxo!");
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
        RequestBuilder delRequest = delete("/friend/delete/1");
        ResultMatcher Status = status().isOk();
        ResultMatcher Body = content().json(deleteFriendJSON);
        this.mock.perform(delRequest).andExpect(Status)/*.andExpect(Body)*/;
}
}

/*@Test
void testFindAll() throws Exception {
	List<Friend> list = new ArrayList<Friend>();
	Friend friendOne = new Friend("dan", "dan@dan.dan", "dandan", "123456789", null);
	Friend friendTwo = new Friend("stan", "stan@stan.stan", "stanstan", "1344566789", null);
	Friend friendThree = new Friend("ian", "ian@ian.ian", "ianian", "1987543456", null);
	list.add(friendOne);
	list.add(friendTwo);
	list.add(friendThree);
	String listJSON = this.map.writeValueAsString(list);*/
	
//}
