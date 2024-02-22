package com.tunehub.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.project.entity.Songs;
import com.tunehub.project.repository.SongRepository;
@Service
public class SongServicesImplementation implements SongServices{
         @Autowired
         SongRepository repo;
	@Override
	public String addSongs(Songs song) {
		// TODO Auto-generated method stub
		repo.save(song);
		return "object saved successfully";
	}
	@Override
	public boolean songExist(String name) {
		// TODO Auto-generated method stub
		
		if(repo.findByName(name)==null) {
			return false;
			}
			else {
				return true;
			}
	}
	@Override
	public List<Songs> fetchAllSongs() {
		// TODO Auto-generated method stub
		List<Songs>sarray=repo.findAll();
		return sarray;
	}
	@Override
	public boolean findStatus() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String updateSong(Songs song) {
		// TODO Auto-generated method stub
		repo.save(song);
		return null;
	}
	

}
