package com.flight.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flight.entities.Users;

public interface UsersDAO extends JpaRepository<Users, Integer> {

	@Query("select u from Users u where username like 'N%'")
	List<Users> getName();
}
