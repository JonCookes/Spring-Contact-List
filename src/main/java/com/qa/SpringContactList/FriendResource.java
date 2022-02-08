package com.qa.SpringContactList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.SpringContactList.service.FriendService;



@RestController
@RequestMapping("/friend")
public class FriendResource {
	private final FriendService friendService;
	
	public FriendResource(FriendService friendService) {
		this.friendService = friendService;
	}
}
