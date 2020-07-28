package com.tts.WeatherApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
	@Value("${api_key}") 
	private String apiKey;
	
//	@Autowired
	private ZipCodeRepository zipCodeRepository;
	
	//new
	@Autowired
    public WeatherService(ZipCodeRepository zipCodeRepository) {
        this.zipCodeRepository = zipCodeRepository;
    }
	
	public Response getForecast(String zipCode) {
		String url = "http://api.openweathermap.org/data/2.5/weather?zip="+zipCode+",us&appid="
				+apiKey;
		
		RestTemplate restTemplate = new RestTemplate();
		
		saveNewZipCode(zipCode);
//		zipCodeRepository.save(new Request(zipCode));
		
		try {
			return restTemplate.getForObject(url, Response.class);
		}
		catch(HttpClientErrorException ex) {
			Response response = new Response();
			response.setName("error");
			return response;
		}
		
//		return zipCodeRepository.getForecast(zipCode);
		
	}
	
	//new
	public Request findByZipCode(String zipCode) {
        return zipCodeRepository.findById(zipCode);
    }

    public List<Request> findAll() {
        return (List<Request>) zipCodeRepository.findAll();
    }

    public void save(Request zipCode) {
        zipCodeRepository.save(zipCode);
    }

    public String saveNewZipCode(String zipCode) {
        Request zip = new Request();
        zip.setZipCode(zipCode);
        zipCodeRepository.save(zip);
        return "index";
    }
	
}
