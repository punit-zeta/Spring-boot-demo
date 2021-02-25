package com.example.spring.webservices.rest.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

/*
 * Our Data structure which store and provide data
 */
@Component
public class UserDAOService {

	private static List<User> users = new ArrayList<>();
	private static int userCnt = 3;
	
	static {
		users.add(new User(1,"Punit",new Date()));
		users.add(new User(2,"Prem",new Date()));
		users.add(new User(3,"Shubham",new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User createUser(User user) {
		
		if(user.getId() == null) {
			user.setId(++userCnt);
		}
		if(user.getName() == null) {
			user.setName("user "+user.getId());
		}
		if(user.getDob() == null) {
			user.setDob(new Date());
		}
		users.add(user);
		return user;
	}
	
	public User find(int id) {
		for(User u : users) {
			if(u.getId() == id) {
				return u;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		User ret = null;
		for(int i=0;i<users.size();++i) {
			if(users.get(i).getId() == id) {
				ret = users.get(i);
				users.remove(i);
				break;
			}
		}
		return ret;
	}
}
