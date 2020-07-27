package com.tts.WeatherApp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeRepository extends CrudRepository<Request, Long>{

	List<Request> findAll(); 
	
	Request findById(String zipCode);
	

}