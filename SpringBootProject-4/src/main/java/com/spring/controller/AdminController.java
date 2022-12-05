package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Admin;
import com.spring.model.User;
import com.spring.service.Adminservice;


@RestController
@CrossOrigin(origins="*")
public class AdminController {
	
	@Autowired
	private Adminservice adminservice;

	@PostMapping("/adminlogin")
	public String loginpage(@RequestBody Admin admin)
	{
		boolean output = adminservice.adminlogin(admin);
		
		if(output)	
				{
						return "true";
				}
		else
		{
			return "false";
		}
		
		
	}
	
	@PostMapping("/changepassword")
	public String changePasswordpage(@RequestBody String password)
	{
		adminservice.changepassword(password);
		return "Password changed";
		
	}
}
