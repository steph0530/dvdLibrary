package com.dvdlibrary.dao;

import com.dvdlibrary.model.DVD;
import com.dvdlibrary.model.DvdMapper;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DvdDAOImpl implements DvdDAO {
	private JdbcTemplate jdbcTemplate;
	
	private final String SQL_FIND_DVD_ID = "SELECT * FROM dvd_record WHERE id=?";
	private final String SQL_FIND_DVD_NAME = "SELECT * FROM dvd_record WHERE title=?";
	private final String SQL_CREATE_DVD = "INSERT INTO dvd_record (title,release_date,rating,director,studio,note) VALUES (?,?,?,?,?,?)";
	private final String SQL_DELETE_DVD = "DELETE FROM dvd_record WHERE id=?";
	//private final String SQL_UPDATE_DVD = "UPDATE dvd_record SET "+field+\" = ? WHERE id=?";
	private final String SQL_GET_ALL = "SELECT * FROM dvd_record";
	
	public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Boolean createDvd(DVD dvd) {
		Object[] params = {dvd.getTitle(), dvd.getReleaseDate(), dvd.getRating(), dvd.getDirector(), dvd.getStudio(), dvd.getNotes()};
		return jdbcTemplate.update(SQL_CREATE_DVD, params) > 0;
	}
	
	@Override
	public Boolean deleteDvd(int id) {
		return jdbcTemplate.update(SQL_DELETE_DVD, id) > 0;
	}

	@Override
	public Boolean updateDvd(int id, String field, Object value) {
		String stmt = "UPDATE dvd_record SET "+field+" = ? WHERE id=?";
		
		Object[] params = {value, id};
		return jdbcTemplate.update(stmt, params)>0;		
	}

	@Override
	public List<DVD> getAllDvds() {
		return jdbcTemplate.query(SQL_GET_ALL, new DvdMapper());
		
	}

	@Override
	public DVD getDvdById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_DVD_ID, new Object[] {id}, new DvdMapper());
		
	}

	@Override
	public List<DVD> getDvdByName(String title) {
		return jdbcTemplate.query(SQL_FIND_DVD_NAME, new Object[] {title}, new DvdMapper());
		
	}

}
