package com.tunehub.project.services;

import java.util.List;


import com.tunehub.project.entity.Playlists;

public interface PlaylistServices {
  public String addPlaylist(Playlists playlist);
  public List<Playlists> fetchAllPlaylist();
}
