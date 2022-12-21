package com.flight.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flight.dao.UsersDAO;
import com.flight.dto.UsersDTO;
import com.flight.entities.Users;
import com.flight.exceptions.UsersAlreadyExistsException;
import com.flight.exceptions.UsersNotFoundException;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDAO usersDao;

	@Override
	public List<UsersDTO> getAllUsers() {
		Iterable<Users> users = usersDao.findAll();
		List<UsersDTO> usersList = new ArrayList<>();
		users.forEach(t -> {
			UsersDTO u = new UsersDTO();
			u.setUserId(t.getUserId());
			u.setUserName(t.getUserName());
			usersList.add(u);
		});
		return usersList;
	}

	@Override
	public void addUsers(UsersDTO users) throws UsersAlreadyExistsException {
		if (usersDao.findById(users.getUserId()).isEmpty()) {
			Users usersEntity = new Users();
			usersEntity.setUserId(users.getUserId());
			usersEntity.setUserName(users.getUserName());
			usersDao.save(usersEntity);
		} else {
			throw new UsersAlreadyExistsException();
		}

	}

	@Override
	public UsersDTO getUserById(int userId) throws UsersNotFoundException {
		Optional<Users> optional = usersDao.findById(userId);
		Users user = optional.orElseThrow(() -> new UsersNotFoundException("Service.USERS_NOT_FOUND"));
		UsersDTO user2 = new UsersDTO();
		user2.setUserId(user.getUserId());
		user2.setUserName(user.getUserName());
		return user2;
	}

	@Override
	public void updateUsers(Integer userId, String userName) throws UsersNotFoundException {
		Optional<Users> optional = usersDao.findById(userId);
		Users u = optional.orElseThrow(() -> new UsersNotFoundException("Service.USER_NOT_FOUND"));
		u.setUserId(userId);
		u.setUserName(userName);
		usersDao.save(u);
	}

	@Override
	public void deleteUser(int userId) {
		usersDao.deleteById(userId);
	}

	@Override
	public List<Users> getUserName() {
		return usersDao.getName();
	}

}
