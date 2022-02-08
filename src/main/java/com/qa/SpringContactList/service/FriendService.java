package com.qa.SpringContactList.service;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.SpringContactList.repo.FriendRepo;



@Service
public class FriendService {
	private final FriendRepo friendRepo;  //repository here injected in the class

	@Autowired
	public FriendService(FriendRepo friendRepo) {  //now we can use friendRepo to do all of our CRUD operations
		this.friendRepo = friendRepo;
	}
