package com.tts.WeatherApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	
	@GetMapping(value="/")
	public String getIndex(Model model) {
		
		//new
		List<Request> allZipCodes = weatherService.findAll();
//		weatherService.getRequests();
		model.addAttribute("request", new Request());
//		model.addAttribute("zipCode", new Request()); //added request
		model.addAttribute("searchedzips", allZipCodes);
		return "index";
	}
	
	@PostMapping
	public String postIndex(Request request, Model model) {
		//new
		List<Request> allZipCodes = weatherService.findAll();
//		weatherService.getRequests();
		
		Response data = weatherService.getForecast(request.getZipCode());
		
		model.addAttribute("data", data);
		model.addAttribute("postzips", allZipCodes);
		//NEWWWWWW
//		model.addAttribute("postzips", ((Response) allZipCodes).getName());
		return "index";
	}
	
	
}




