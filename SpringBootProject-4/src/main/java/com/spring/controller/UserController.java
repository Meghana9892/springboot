package com.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.model.User;
import com.spring.service.Userservice;

@RestController
@CrossOrigin(origins="*")
public class UserController {

	
	@Autowired
	private Userservice uservice;
	
	
	@GetMapping("/users")
	public List<User> viewUserPage()
	{
		List<User> users = uservice.allUsers();
		
		
		return users;
		
	}
	
	@PostMapping("/adduser")
	public String addUserpage(@RequestBody User user)
	{
		String result="false";
		boolean output = uservice.addUser(user);
		if(output)
		{
		 result="true";
		}
		return result;
	}
	
	@PostMapping("/password")
	public String changePasswordpage(@RequestBody User user)
	{
		String uname = user.getUsername();
		String password = user.getPassword();
		uservice.changepassword(uname, password);
		return "Password changed";
		
	}
	
	@PostMapping("/login")
	public String loginpage(@RequestBody User user)
	{
		
		String message="false";
		
		
		boolean output = uservice.uservalue(user);
		if(output)
		{
			message= "true";
		}
		
		return message;
	}
	
}
