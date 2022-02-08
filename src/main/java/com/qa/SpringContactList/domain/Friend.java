package com.qa.SpringContactList.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friend implements Serializable { //Helps transform the java class into different types of string
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String alias;
	
	@Column
	private String phone;
	
	@Column(nullable = false)
	private String friendCode;
	
	//Empty Constructor
	public Friend() {
		
	}
	//Full Constructor - id
	public Friend(String name, String email, String alias, String phone, String friendCode) {
		this.name = name;
		this.email = email;
		this.alias = alias;
		this.phone = phone;
		this.friendCode = friendCode;
	}
	//Full Constructor
	public Friend(Long id, String name, String email, String alias, String phone, String friendCode) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.alias = alias;
		this.phone = phone;
		this.friendCode = friendCode;
	}
	


}
