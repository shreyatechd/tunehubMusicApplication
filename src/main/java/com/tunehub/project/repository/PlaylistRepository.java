package com.tunehub.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tunehub.project.entity.Playlists;

public interface PlaylistRepository extends JpaRepository<Playlists,Integer> {

}
