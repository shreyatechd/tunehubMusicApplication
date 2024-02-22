package com.tunehub.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.tunehub.project.entity.Playlists;
import com.tunehub.project.entity.Songs;
import com.tunehub.project.repository.PlaylistRepository;
import com.tunehub.project.repository.SongRepository;
import com.tunehub.project.services.PlaylistServices;
import com.tunehub.project.services.SongServices;

@Controller
public class PlaylistController {
	@Autowired
	   SongServices sr;
	@Autowired
	 PlaylistServices pl;
   @GetMapping("/map-playlist")
   public String createPlaylist(Model model) {
	   List<Songs>songlist=sr.fetchAllSongs();
	   System.out.println(songlist);
	   model.addAttribute("songlist",songlist);
	   return "createPlaylist";
   }
   @PostMapping("/addPlaylist")
   
   public String addPlaylist(@ModelAttribute Playlists playlist) {
	   pl.addPlaylist(playlist);
	   List<Songs>slist=playlist.getSong();
       for(Songs song:slist)	{
    	  song.getPls().add(playlist);
    	  sr.updateSong(song);
       }
	   
	   return "login";
   }
   @GetMapping("/view-playlist")
   public String viewPlaylist(Model model) {
	   List<Playlists>plist=pl.fetchAllPlaylist();
	   System.out.println(plist);
	   model.addAttribute("plist",plist);
	   return "viewPlaylist";
   }
   
}
