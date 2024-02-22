package com.tunehub.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.project.entity.Songs;
import com.tunehub.project.entity.Users;
import com.tunehub.project.services.SongServices;
import com.tunehub.project.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	@Autowired
	UsersService userv;
	@Autowired 
	SongServices sr;
	
    @PostMapping("/register")
    public String addUser(@ModelAttribute Users user) {
    	if(userv.emailExists(user.getEmail())==false) {
    	userv.addUser(user);
    	return "registersucess";
    	
    	}
    	else {
    		return "registerfail";
    		
    	}
    	
    }
    @PostMapping("/login")
    public String validateUser(@RequestParam String email,@RequestParam String password,HttpSession session) {
    	if(userv.validateUser(email, password)==true) {
    		session.setAttribute("email",email);
    		String rol=userv.knowRole(email);
    		if(rol.equals("admin")) {
    			return "adminhome";
    		}
    		else {
    			return "customerhome";
    		}
    		
    	}
    	else {
    		return "loginfail";
    	}
    }
    @GetMapping("/exploresongs")
    public String customerAllSongs(HttpSession session,Model model) {
    String email=(String) session.getAttribute("email");
      Users user=userv.getUser(email);
  	  boolean primeStatus=user.isPremium();
  	  if(primeStatus==true) {
  		  
  		List<Songs>songlist=sr.fetchAllSongs();
 	   System.out.println(songlist);
 	   model.addAttribute("songlist",songlist);
 	   return "viewplaylist";
  	  }
  	  else {
  		  return "pay";
  	  }
     }
      @PostMapping("/reset")
      public String resetPassword(@RequestParam String email,@RequestParam String password,@RequestParam String confirmPassword)
       {
    	   Users user= userv.getUser(email);
    	   if(password.equals(confirmPassword)) {
    		   user.setPassword(password);
    		   userv.updateUser(user);
    		   return "login";
    	   }
    	   else
    	   {
    		   return "reset";
    	   }
    	  
       }
      @GetMapping("/logout")
      public String logoutUser(HttpSession session) {
    	  session.invalidate();
    	  return "index";
      }
}
      
