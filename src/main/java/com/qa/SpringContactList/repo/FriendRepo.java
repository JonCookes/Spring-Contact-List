package com.qa.SpringContactList.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.SpringContactList.domain.Friend;


public interface FriendRepo extends JpaRepository<Friend, Long>{  //specifying primary key from Friend

	//Optional<Friend> deleteFriendById(Long id); //query method we have defined

	Optional<Friend> findFriendById(Long id); //going to select employee by id, make it rteturn an optional in case i do not have that friend

}
