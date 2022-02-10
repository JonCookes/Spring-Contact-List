package com.qa.SpringContactList.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.SpringContactList.domain.Friend;
import com.qa.SpringContactList.exception.FriendNotFoundException;
import com.qa.SpringContactList.repo.FriendRepo;

@Service
public class FriendService {
	private final FriendRepo friendRepo;  //repository here injected in the class

	@Autowired
	public FriendService(FriendRepo friendRepo) {  //now we can use friendRepo to do all of our CRUD operations
		this.friendRepo = friendRepo;
	}
	
	
	public Friend addFriend(Friend friend) {    //creating the friend in the actual database
		friend.setFriendCode(UUID.randomUUID().toString());   //but I want to generate the employee code
		return friendRepo.save(friend);
	}
	
	public List<Friend> findAllFriends() { //just returning a list of all users in the database
		return friendRepo.findAll();
	}
	
	public Friend updateFriend(Friend friend) { //updates
		return friendRepo.save(friend);
	}
	public Friend findFriendById(Long id) {
		return friendRepo.findFriendById(id).orElseThrow(() -> new FriendNotFoundException("Awww, this person isn't our friend! :("));
	} //try to find an employee, if you can't, throws exception.
	
	public boolean remove(Long id) {
		this.friendRepo.deleteById(id);;
		return !this.findFriendById(id);
		
	}
	public Friend deleteFriend(Long id) {  //deletes by id, but the friend repo doesn't have a delete by default so we create a method in repo.
		Optional<Friend> toDelete = this.friendRepo.findFriendById(id);
		this.friendRepo.deleteFriendById(id);
		return toDelete.orElse(null);
		
		//friendRepo.deleteFriendById(id);
	}
}