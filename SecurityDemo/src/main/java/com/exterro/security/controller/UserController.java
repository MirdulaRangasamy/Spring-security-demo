package com.exterro.security.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exterro.CarManagement.entity.Car;
import com.exterro.CarManagement.service.CarService;
import com.exterro.security.model.User;
import com.exterro.security.service.UserService;


@RestController
@CrossOrigin("http://localhost:9090/")
public class UserController {
	
	private static final Logger logger=LogManager.getLogger(UserController.class);
	@Autowired
	private UserService userSvc;
	
	@Autowired
	private CarService carSvc;
	
	@GetMapping("home")
	public String getHome() {
		return "Hello User";
	}
	
	@GetMapping("greet")
	public String getGreet() {
		logger.info("INFO");
		logger.debug("DEBUG");
		logger.error("Error");
		logger.trace("Trace");
		return "Greetings All";
	}
	
	@GetMapping("admin/home")
//	@RolesAllowed("ROLE_ADMIN")
	public String getAdminHome() {
		return "Hello Admin";
	}
	
	@PostMapping("register")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		return ResponseEntity.ok(userSvc.registerUser(user));
	}
	
	
	@PostMapping("registerAdmin")
	public ResponseEntity<User> registerAdmin(@RequestBody User user){
		return ResponseEntity.ok(userSvc.registerAdmin(user));
	}
	
	@GetMapping("general")
	public ResponseEntity<List<Car>> getCar(){
		return ResponseEntity.ok(carSvc.viewAllCars());
	}
}
