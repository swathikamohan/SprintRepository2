package com.flight.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.flight.dto.UsersDTO;
import com.flight.entities.Users;
import com.flight.exceptions.UsersAlreadyExistsException;
import com.flight.exceptions.UsersNotFoundException;
import com.flight.service.UsersService;

@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;

	@GetMapping(value = "/Users")
	public ResponseEntity<List<UsersDTO>> getAllUsers() {
		List<UsersDTO> userList = usersService.getAllUsers();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	@GetMapping(value = "/Users/{userId}")
	public ResponseEntity<UsersDTO> getUserById(@PathVariable Integer userId) throws UsersNotFoundException {
		UsersDTO user1 = usersService.getUserById(userId);
		return new ResponseEntity<>(user1, HttpStatus.OK);
	}

	@PostMapping(value = "/Users")
	public ResponseEntity<String> addUsers(@RequestBody UsersDTO user) throws UsersAlreadyExistsException {
		usersService.addUsers(user);
		return new ResponseEntity<>("User Added Successfully", HttpStatus.CREATED);
	}

	@PutMapping(value = "/Users/{userId}")
	public ResponseEntity<String> updateUsers(@PathVariable Integer userId, @RequestBody UsersDTO user)
			throws UsersNotFoundException {
		usersService.updateUsers(userId, user.getUserName());
		return new ResponseEntity<>("User Updated Successfully", HttpStatus.OK);
	}

	@DeleteMapping(value = "/Users/{userId}")
	public ResponseEntity<String> deleteUsers(@PathVariable Integer userId) {
		usersService.deleteUser(userId);
		return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
	}

	@GetMapping("Users/Nname")
	public List<Users> getUserName() {
		return this.usersService.getUserName();
	}

}
