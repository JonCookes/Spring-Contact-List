package com.qa.SpringContactList.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qa.SpringContactList.domain.Friend;
import com.qa.SpringContactList.service.FriendService;


@RestController
@RequestMapping("/friend")
public class FriendResource {
	private final FriendService friendService;
	
	public FriendResource(FriendService friendService) {
		this.friendService = friendService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Friend>> getAllFriends () {      //response entity is a generic, pass what kind of data (list)
		List<Friend> friends = friendService.findAllFriends();  // which is also a generic, so we specify a list of friends
		return new ResponseEntity<>(friends, HttpStatus.OK);	//returns http response, in the body of which has a list of friends	
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Friend> getFriendById (@PathVariable("id")Long id) {      
		Friend friend = friendService.findFriendById(id);  
		return new ResponseEntity<>(friend, HttpStatus.OK);	
	}
	
	@PostMapping("/add")
	public ResponseEntity<Friend> addFriend(@RequestBody Friend friend) {
		Friend newFriend = friendService.addFriend(friend);
		return new ResponseEntity<>(newFriend, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Friend> updateFriend(@PathVariable("id")Long id, @RequestBody Friend friend) {
		Friend updateFriend = friendService.updateFriend(id, friend);
		return new ResponseEntity<Friend>(updateFriend, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Friend> deleteFriend(@PathVariable Long id) {
		friendService.deleteFriend(id);
		return new ResponseEntity<Friend>(HttpStatus.OK);
	}
	 
}
	
