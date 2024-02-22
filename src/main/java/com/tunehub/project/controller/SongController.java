package com.tunehub.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;
import com.tunehub.project.entity.Songs;
import com.tunehub.project.entity.Users;
import com.tunehub.project.services.SongServices;





@Controller
public class SongController {
   @Autowired
   SongServices sr ;
   
   @PostMapping("/song")
   public String addSongs(@ModelAttribute Songs song) {
	   if(sr.songExist(song.getName())==false) {
	   sr.addSongs(song);
	   return "adminhome";
	   }
	   else {
		   return "songfail";
	   }
   }
   @GetMapping("/map-view")
   public String fetchAllSongs(Model model) {
	   List<Songs>songlist=sr.fetchAllSongs();
	   System.out.println(songlist);
	   model.addAttribute("songlist",songlist);
	   return "displaysongs";
   }
  
  
   
}