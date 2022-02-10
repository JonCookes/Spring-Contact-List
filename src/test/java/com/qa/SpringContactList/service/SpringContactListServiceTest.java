package com.qa.SpringContactList.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
		savedFriend = new Friend(1L, "Bob", "bob@bob.com", "bobbybob", "123456789", null);
	}
	
	@Test
	void testAddFriend() {
		//given (this piece of data)(new friend etc)
				
		//when (i call this method and parse this data in)
		Mockito.when(this.repo.save(newFriend)).thenReturn(savedFriend);
		
		//then (this is what i want it to do
		assertThat(this.service.addFriend(newFriend)).isEqualTo(savedFriend);
		
		//verify
		Mockito.verify(this.repo, Mockito.times(1)).save(newFriend);
		
		
	}
	
	@Test
	void testUpdateFriend() {
		//given an id and an object to update
		Long id = 1L;
		//new one to update
		Friend toUpdate = new Friend("Hubert", "HubbyHue@Hue.co.uk", "HuebertQuebert", "987654321", null);
		Optional<Friend> optFriend = Optional.of(new Friend(null, null, null, null, null, null));
		//update
		Friend updated = new Friend(id, toUpdate.getName(), toUpdate.getEmail(), toUpdate.getAlias(), toUpdate.getPhone(), null );
		//When
		Mockito.when(this.repo.findById(id)).thenReturn(optFriend);
		Mockito.when(this.repo.save(null)).thenReturn(upated);
		
	}

}
