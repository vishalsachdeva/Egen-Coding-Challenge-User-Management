package io.egen.service;
import io.egen.entity.*;

import java.util.HashSet;
import java.util.List;



public interface UserService {
	public User createUser(String body);
	public HashSet<User> findAllUsers();
	public User updateUser(String body);
	

}
