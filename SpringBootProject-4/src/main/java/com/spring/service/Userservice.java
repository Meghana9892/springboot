package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Repository.UserRepository;
import com.spring.model.User;




@Service
public class Userservice {

	@Autowired
	private UserRepository urepo;
	
	public List<User> allUsers()
	{
		return urepo.findAll();
		
	}
	
	public boolean addUser(User user)
	{
		List<User> users = allUsers();
		boolean output=false;
		boolean result=true;
		for(User u :users)
		{
			if(u.getUsername().equalsIgnoreCase(user.getUsername()))
			{
				result = false;
			}
		}
		if(result)
		{
		urepo.save(user);
		output = true;
		}
		else
		{
			output = false;
		}
		return output;
	}
	
	public boolean validate(User user)
	{
		String username = user.getUsername();
		String password = user.getPassword();
		boolean output = false;
		
		List<User> users = urepo.findAll();
		
		for(User u : users)
		{
			if((u.getUsername().toLowerCase().equals(username))&&(u.getPassword().toLowerCase().equals(password)))
					{
						output=true;
					}

		}
		
		return output;
	} 
	
	public boolean uservalue(User user)
	{
		String username=user.getUsername();
		String password = user.getPassword();
		boolean output = false;
		
		List<User> users = urepo.findAll();
		
		for(User u:users)
		{
		if((username.equalsIgnoreCase(u.getUsername()))&&(password.equalsIgnoreCase(u.getPassword())))
					{
						output=true;
					}
		}
		return output;
	}
	
//	public String getUser(String username)
//	{
//		List<User> users = allUsers();
//		String u1 =username;
//		String user=null;
//		
//		for(User u:users)
//		{
//			if(u.getUsername().equalsIgnoreCase(u1))
//			{
//				user = "hi";
//				break;
//			}
//	}
//		return user;
//		
//	}
	
	public User getUserbyname(String username)
	{
		User user = urepo.findByUsername(username);
		
		return user;
	}
	
	public User getUserbyID(int id)
	{
		Optional<User> user = urepo.findById(id);
		User u = user.get();
		
		return u;
	}
	
	public void changepassword(String username, String password)
	{
		User user = getUserbyname(username);
		user.setPassword(password);
		urepo.save(user);
	}
	
}
