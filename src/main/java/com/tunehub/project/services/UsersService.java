package com.tunehub.project.services;

import com.tunehub.project.entity.Users;

public interface UsersService {
	public String addUser(Users user);
	public boolean emailExists(String email);
	public boolean validateUser(String email,String password);
	public String knowRole(String email);
	public Users getUser(String email);
	public void updateUser(Users user);
}
