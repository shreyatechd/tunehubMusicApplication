package com.tunehub.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tunehub.project.entity.Playlists;
import com.tunehub.project.repository.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistServices{
       @Autowired
       PlaylistRepository repo;
	@Override
	public String addPlaylist(Playlists playlist) {
		// TODO Auto-generated method stub
		repo.save(playlist);
		return "playlist added";
	}

	@Override
	public List<Playlists> fetchAllPlaylist() {
		// TODO Auto-generated method stub
		List<Playlists>pl=repo.findAll();
		return pl;
	}
       
	

}
