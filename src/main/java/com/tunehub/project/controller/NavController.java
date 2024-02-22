package com.tunehub.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import com.tunehub.project.services.UsersService;

@Controller


public class NavController {
	@Autowired
	UsersService userv;
	
	@GetMapping("/map-register")
	public String registerMapping() {
		return "register";
	}
	
	@GetMapping("/map-login")
	public String loginMapping() {
		return "login";
	}
	
	 @GetMapping("/map-song")
	 public String addAdminSongs(){
		return "addsongs";
	}
	 @GetMapping("/sample")
	 public String sample(){
		return "pay";
	}
	 @GetMapping("/map-admin")
	 public String adminDisplay(){
		return "adminhome";
	}
	 @GetMapping("/map-customer")
	 public String customerDisplay(){
		return "customerhome";
	}
	 @GetMapping("/resetLogin")
	    public String resetLogin() {
	    	return "reset";
	    }
}
