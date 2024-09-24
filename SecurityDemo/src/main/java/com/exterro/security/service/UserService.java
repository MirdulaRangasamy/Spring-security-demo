package com.exterro.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exterro.security.dto.LoginDto;
import com.exterro.security.model.User;

@Service
public interface UserService {
	User registerUser(User user);
	User registerAdmin(User user);
	User loginUser(LoginDto login);
	User getUser(String email);
	List<User> getAllUser();
	User updateUser(User user);
	String deleteUser(String email);
}
