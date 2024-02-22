package com.tunehub.project.services;

import java.util.List;

import com.tunehub.project.entity.Songs;

public interface SongServices {
   public String addSongs(Songs song);
   public boolean songExist(String name);
   public List<Songs>fetchAllSongs();
   public boolean findStatus();
   public String updateSong(Songs song);
   
}
