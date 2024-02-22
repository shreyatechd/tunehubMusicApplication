package com.tunehub.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.project.entity.Users;
import com.tunehub.project.repository.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService {
       @Autowired
	UsersRepository repo;
	
	
	@Override
	public String addUser(Users user) {
		// TODO Auto-generated method stub
		repo.save(user);
		return "Object created and saved";
	}


	@Override
	public boolean emailExists(String email) {
		// TODO Auto-generated method stub
		if(repo.findByEmail(email)==null) {
		return false;
		}
		else {
			return true;
		}
	}


	@Override
	public boolean validateUser(String email, String password) {
		// TODO Auto-generated method stub
		Users user=repo.findByEmail(email);
		String db_password=user.getPassword();
		if(db_password.equals(password)) {
			return true;
		}
		else {
		return false;
		}
	}


	@Override
	public String knowRole(String email) {
		// TODO Auto-generated method stub
		Users user=repo.findByEmail(email);
		String db_role=user.getRole();
		return db_role;
	}


	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
	}


	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		repo.save(user);
		
	}


	


	

}
