package com.flight.dto;

public class UsersDTO {

	private int userId;
	private String userName;

	public UsersDTO() {
		super();
	}

	public UsersDTO(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UsersDTO [userId=" + userId + ", userName=" + userName + "]";
	}

}
