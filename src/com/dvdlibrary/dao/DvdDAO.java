package com.dvdlibrary.dao;

import com.dvdlibrary.model.DVD;
import java.util.*;

public interface DvdDAO {
	DVD getDvdById(int id);
	List<DVD> getDvdByName(String name);
	List<DVD> getAllDvds();
	Boolean deleteDvd(int id);
	Boolean updateDvd(int id, String field, Object value);
	Boolean createDvd(DVD dvd);
	
}
