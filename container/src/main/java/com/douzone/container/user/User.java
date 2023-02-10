package com.douzone.container.user;


import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class User {
	private String name ="둘리";
	private Long no = 0L;
	
	private Friend friend;
	private List<String> friends;
	
	public User() {
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public User(Long no, String name) {
		this.name = name;
		this.no = no;
	}
	
	public String getName() {
		return name;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", no=" + no + ", friend=" + friend + ", friends=" + friends + "]";
	}
	
	
	
}
