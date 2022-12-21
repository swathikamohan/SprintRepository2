package com.flight.entities;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@Column(name = "userid")
	private int userId;
	@Column(name = "username")
	private String userName;

	public Users() {
		super();
	}

	public Users(int userId, String userName) {
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
		return "Users [userId=" + userId + ", userName=" + userName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return userId == other.userId && Objects.equals(userName, other.userName);
	}

}