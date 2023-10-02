package org.java.lesson.app.model;

public class Movie {
	
    private int id = 0;
	private String title;
	
	public Movie(String title, int id) {
		setId(id);
		setTitle(title);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
