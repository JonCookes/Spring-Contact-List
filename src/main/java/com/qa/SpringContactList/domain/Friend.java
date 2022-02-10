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
	
	@Column
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
	
	//Getters & Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFriendCode() {
		return friendCode;
	}
	public void setFriendCode(String friendCode) {
		this.friendCode = friendCode;
	}
	
	//Hash & Equals
	@Override
	public int hashCode() {
		return Objects.hash(alias, email, friendCode, id, name, phone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Friend other = (Friend) obj;
		return Objects.equals(alias, other.alias) && Objects.equals(email, other.email)
				&& Objects.equals(friendCode, other.friendCode) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
	}
	
	//toString
	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", email=" + email + ", alias=" + alias + ", phone=" + phone
				+ ", friendCode=" + friendCode + "]";
	}
	 
	

}
