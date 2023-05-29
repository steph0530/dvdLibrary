package com.dvdlibrary.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DvdMapper implements RowMapper<DVD>{

	@Override
	public DVD mapRow(ResultSet resultSet, int i) throws SQLException {
		if(!resultSet.next()) return null;
		DVD dvd = new DVD();
		
		dvd.setTitle(resultSet.getString("title"));
		dvd.setReleaseDate(resultSet.getString("release_date"));
		dvd.setRating(resultSet.getDouble("rating"));
		dvd.setDirector(resultSet.getString("director"));
		dvd.setStudio(resultSet.getString("studio"));
		dvd.setNotes(resultSet.getString("note"));
		
		return dvd;

	}

}
