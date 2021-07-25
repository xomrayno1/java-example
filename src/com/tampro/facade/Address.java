package com.tampro.facade;

public class Address {
	private String city;
	private String street;
	private String coutry;
	
	public Address(String city, String street, String coutry) {
		this.city = city;
		this.street = street;
		this.coutry = coutry;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCoutry() {
		return coutry;
	}
	public void setCoutry(String coutry) {
		this.coutry = coutry;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", coutry=" + coutry + "]";
	}
	
	

}
