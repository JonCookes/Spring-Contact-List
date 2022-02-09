package com.qa.SpringContactList.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.SpringContactList.domain.Friend;
import com.qa.SpringContactList.repo.FriendRepo;

@SpringBootTest
public class SpringContactListServiceTest {
	
	private Friend newFriend;
	private Friend savedFriend;
	
	@Autowired
	private FriendService service;
	
	@MockBean
	private FriendRepo repo;
	
	@BeforeEach
	void setUp() {
		newFriend = new Friend("Bob", "bob@bob.com", "bobbybob", "123456789", null);
		savedFriend = new Friend(4, "Bob", "bob@bob.com", "bobbybob", "123456789", null);
	}
	
	@Test
	void testAddFriend() {
	
	}
	@Test
	void testUpdateFriend() {
		
	}

}
