package com.qa.SpringContactList.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.SpringContactList.domain.Friend;
import com.qa.SpringContactList.repo.FriendRepo;

@SpringBootTest
@ActiveProfiles("test") 
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
		// given (this piece of data)(new friend etc)

		// when (i call this method and parse this data in)
		Mockito.when(this.repo.save(newFriend)).thenReturn(savedFriend);

		// then (this is what i want it to do
		assertThat(this.service.addFriend(newFriend)).isEqualTo(savedFriend);

		// verify
		Mockito.verify(this.repo, Mockito.times(1)).save(newFriend);

	}

	@Test
	void testFindAllFriends() {
		List<Friend> list = new ArrayList<Friend>();
		Friend friendOne = new Friend("dan", "dan@dan.dan", "dandan", "123456789", null);
		Friend friendTwo = new Friend("stan", "stan@stan.stan", "stanstan", "1344566789", null);
		Friend friendThree = new Friend("ian", "ian@ian.ian", "ianian", "1987543456", null);

		list.add(friendOne);
		list.add(friendTwo);
		list.add(friendThree);

		Mockito.when(this.repo.findAll()).thenReturn(list);

		assertThat(this.service.findAllFriends()).isEqualTo(list);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();

	}

	@Test
	void testUpdateFriend() {
		// given an id and an object to update
		Long id = 1L;
		// new one to update
		Friend toUpdate = new Friend("Hubert", "HubbyHue@Hue.co.uk", "HuebertQuebert", "987654321", null);
		Optional<Friend> optFriend = Optional.of(new Friend(null, null, null, null, null, null));
		// update
		Friend updated = new Friend(id, toUpdate.getName(), toUpdate.getEmail(), toUpdate.getAlias(),
				toUpdate.getPhone(), null);
		// When
		Mockito.when(this.repo.findById(id)).thenReturn(optFriend);
		Mockito.when(this.repo.save(null)).thenReturn(updated);

	}

	@Test
	void testFindFriendById() throws Exception {
		Long id = 1L;
		Optional<Friend> optFriend = Optional.of(new Friend("Jon", "Jonshotmail", "Jono", "98764", null));
		Friend friend1 = new Friend(null, "Jon", "Jonshotmail", "Jono", "98764", null);
		
		Mockito.when(this.repo.findFriendById(id)).thenReturn(optFriend);
		
		assertThat(this.service.findFriendById(id)).isEqualTo(friend1);
		Mockito.verify(this.repo, Mockito.times(1)).findFriendById(id);
		
	}

    @Test 
    void testDeleteFriend() {
    	Long id = 1L;
    	Optional<Friend> optFriend = Optional.of(new Friend("Jon", "Jonshotmail", "Jono", "98764", null));
    	Friend deleted = optFriend.get();
    	Mockito.when(this.repo.findFriendById(id)).thenReturn(optFriend);
    	
    	assertThat(this.service.deleteFriend(id)).isEqualTo(deleted);
    	Mockito.verify(this.repo, Mockito.times(1)).deleteFriendById(id);
    	
    	
    }
	 
}
