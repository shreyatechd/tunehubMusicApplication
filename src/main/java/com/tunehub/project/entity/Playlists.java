package com.tunehub.project.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


	@Entity
	public class Playlists {
	   @Id
	   @GeneratedValue(strategy=GenerationType.AUTO)
	   int id;
	   String name;
	   @ManyToMany
	   List<Songs>song;
	public Playlists() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Playlists(int id, String name, List<Songs> song) {
		super();
		this.id = id;
		this.name = name;
		this.song = song;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Songs> getSong() {
		return song;
	}
	public void setSong(List<Songs> song) {
		this.song = song;
	}
	@Override
	public String toString() {
		return "Playlists [id=" + id + ", name=" + name + ", song=" + song + "]";
	}
	
	   
}
