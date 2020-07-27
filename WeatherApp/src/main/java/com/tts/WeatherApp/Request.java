package com.tts.WeatherApp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zipcode")
public class Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//new
	@Column(name="zipcode_id")
	private Long id; 
	private String zipCode;
	
//	public static List<Request> allZipCodes() {
//		return allZipCodes(); 
//	}
	
	public Request() {
		
	}
	
	//change later?
//	public Request(String zipCode) {
//		this.zipCode = zipCode;
//		
//	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "Request [id=" + id + ", zipCode=" + zipCode + "]";
	}
	
	

	
}
