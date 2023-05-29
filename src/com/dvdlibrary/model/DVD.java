package com.dvdlibrary.model;

import java.util.*;

public class DVD {
	private String title;
	private String releaseDate;
	private Double rating;
	private String director;
	private String studio;
	private String notes;
	
	public String JdbcTemplate() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String deleteDvd() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getDirector() {
		return this.director;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "DVD [title=" + title + ", releaseDate=" + releaseDate + ", rating=" + rating + ", director=" + director
				+ ", studio=" + studio + ", notes=" + notes + "]";
	}
	
	
}
