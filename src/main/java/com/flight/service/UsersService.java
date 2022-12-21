package com.flight.service;

import java.util.List;
import com.flight.dto.UsersDTO;
import com.flight.entities.Users;
import com.flight.exceptions.UsersAlreadyExistsException;
import com.flight.exceptions.UsersNotFoundException;

public interface UsersService {

	public List<UsersDTO> getAllUsers();

	public void addUsers(UsersDTO users) throws UsersAlreadyExistsException;

	public void updateUsers(Integer userId, String userName) throws UsersNotFoundException;

	public UsersDTO getUserById(int userId) throws UsersNotFoundException;

	public void deleteUser(int userId);

	List<Users> getUserName();
}
