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
		String bestMoviesString = "";
		int i = 1;
		for (Movie movie: bestMovies ) {			
			bestMoviesString += movie.getTitle() + (i == bestMovies.size() ? ".":", ");
			i++;
		}
		
		model.addAttribute("bestMoviesString", bestMoviesString);
		
		return "movies";
	}
	
	@GetMapping("/songs")
	public String getSongs(Model model) {
		List<Song> bestSongs = getBestSongs();
		String bestSongsString = "";
		
		int i = 1;
		for (Song song: bestSongs ) {			
			bestSongsString += song.getTitle() + (i == bestSongs.size() ? ".":", ");
			i++;
		}
		
		model.addAttribute("bestSongsString", bestSongsString);
				
		return "songs";
	}
	
	 @GetMapping("/songs/{id}")
	 public String getSong(@PathVariable("id") int itemId,  Model model) {
		 String type = "Song";
		 String title = "";
		 List<Song> bestSongs = getBestSongs();
		 for (Song song: bestSongs) {
			 System.out.println(song.getId());
			 if (song.getId() == itemId) {
				 title = song.getTitle();
				 break;
			 }
			 else {
				 title = "Not founded";
			 }
			 
			 
			 
		 }
		 model.addAttribute("title", title);
		 model.addAttribute("type", type);
		 model.addAttribute("itemId", itemId);


		 return "details";
	 }
	 
	 @GetMapping("/movies/{id}")
	 public String getMovie(@PathVariable("id") int itemId,  Model model) {
		 String type = "Movie";
		 String title = "";
		 List<Movie> bestMovies = getBestMovies();
		 for (Movie movie: bestMovies) {
			 if (movie.getId() == itemId) {
				 title = movie.getTitle();
				 break;
			 }
			 else {
				 title = "Not founded";
			 }
			 
			 
			 
		 }
		 model.addAttribute("title", title);
		 model.addAttribute("type", type);
		 model.addAttribute("itemId", itemId);


		 return "details";
	 }

	
	

	
}
