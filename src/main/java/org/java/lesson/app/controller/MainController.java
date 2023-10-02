package org.java.lesson.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.lesson.app.model.Movie;
import org.java.lesson.app.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		bestMovies.add(new Movie("Matrix"));
		bestMovies.add(new Movie("Joker"));
		bestMovies.add(new Movie("Arrival"));
		
		return bestMovies;

	}
	
	public List<Song> getBestSongs() {
		List<Song> bestSongs = new ArrayList<>();
		bestSongs.add(new Song("Yesterday"));
		bestSongs.add(new Song("Fuori dal tunnel"));
		bestSongs.add(new Song("Abnormalize"));
		
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

	
}
