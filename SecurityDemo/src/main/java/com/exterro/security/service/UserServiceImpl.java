package com.exterro.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exterro.security.dto.LoginDto;

import com.exterro.security.model.User;
import com.exterro.security.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User registerUser(User user) {
		String encrypted = passwordEncoder.encode(user.getPassword());
		user.setPassword(encrypted);
		user.setRoles("ROLE_USER");
		return userRepo.save(user);
	}
	
	@Override
	public User registerAdmin(User user) {
		String encrypted = passwordEncoder.encode(user.getPassword());
		user.setPassword(encrypted);
		user.setRoles("ROLE_ADMIN,ROLE_USER");
		return userRepo.save(user);
	}

	@Override
	public User loginUser(LoginDto login) {
//		Optional<User> user = userRepo.findByEmail(login.getEmail());
//		if(user.isPresent()) {
//			
//		}
		
		return null;
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
