package org.java.lesson.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.lesson.app.model.Movie;
import org.java.lesson.app.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

	@GetMapping("/")
	public String home(Model model) {
		
		String myName = "Raffaele";
		model.addAttribute("myName", myName);
		
		String pageName = "Home";
		model.addAttribute("pageName", pageName);
		return "home";
	}
	
	public List<Movie> getBestMovies() {
		List<Movie> bestMovies = new ArrayList<>();
		bestMovies.add(new Movie("Matrix", 1));
		bestMovies.add(new Movie("Joker", 2));
		bestMovies.add(new Movie("Arrival", 3));
		
		return bestMovies;

	}
	
	public List<Song> getBestSongs() {
		List<Song> bestSongs = new ArrayList<>();
		bestSongs.add(new Song("Yesterday", 1));
		bestSongs.add(new Song("Fuori dal tunnel", 2));
		bestSongs.add(new Song("Abnormalize", 3));
		
		return bestSongs;

	}
	
	@GetMapping("/movies")
	public String getMovies(Model model) {
		List<Movie> bestMovies = getBestMovies();				
		model.addAttribute("bestMovies", bestMovies);
		
		String pageName = "Movies";
		model.addAttribute("pageName", pageName);
		return "movies";
	}
	
	@GetMapping("/songs")
	public String getSongs(Model model) {
		List<Song> bestSongs = getBestSongs();
		model.addAttribute("bestSongs", bestSongs);
			
		String pageName = "Songs";
		model.addAttribute("pageName", pageName);
		return "songs";
	}
	
	 @GetMapping("/songs/{id}")
	 public String getSong(@PathVariable("id") int itemId,  Model model) {
		 String type = "Song";
		 Song selectedItem = null;
		 boolean notFound = true;
		 List<Song> bestSongs = getBestSongs();
		 for (Song song: bestSongs) {
			 if (song.getId() == itemId) {
				 selectedItem = song;
				 notFound = false;
				 break;
			 }
		 }
		 model.addAttribute("selectedItem", selectedItem);
		 model.addAttribute("type", type);
		 
		 if (notFound) {
			 return "not-found";
		 }
		 
		 return "details";
	 }
	 
	 @GetMapping("/movies/{id}")
	 public String getMovie(@PathVariable("id") int itemId,  Model model) {
		 String type = "Movie";
		 Movie selectedItem = null;
		 boolean notFound = true;
		 List<Movie> bestMovies = getBestMovies();
		 for (Movie movie: bestMovies) {
			 if (movie.getId() == itemId) {
				 selectedItem = movie;
				 notFound = false;
				 break;
			 }	 
		 }
		 model.addAttribute("selectedItem", selectedItem);
		 model.addAttribute("type", type);
			System.out.println(notFound);

		 if (notFound) {
			 return "not-found";
		 }

		 
		 return "details";
	 }

	
	

	
}
