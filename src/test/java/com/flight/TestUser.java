package com.flight;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.flight.dao.UsersDAO;
import com.flight.dto.UsersDTO;
import com.flight.entities.Users;
import com.flight.exceptions.UsersAlreadyExistsException;
import com.flight.service.UsersServiceImpl;

class TestUser {

	@InjectMocks
	UsersServiceImpl usersServiceImpl;

	@Mock
	UsersDAO dao;
	@Mock
	UsersDTO dto;

	@SuppressWarnings("deprecation")
	@Test
	void createUsersTest() throws UsersAlreadyExistsException {
		MockitoAnnotations.initMocks(this);
		// UsersDTO users = new UsersDTO();
		dto.setUserId(101);
		dto.setUserName("Arun");
		Users usersEntity = new Users();
		usersEntity.setUserId(dto.getUserId());
		usersEntity.setUserName(dto.getUserName());

		usersServiceImpl.addUsers(dto);
		verify(dao, times(1)).save(usersEntity);
	}

}
