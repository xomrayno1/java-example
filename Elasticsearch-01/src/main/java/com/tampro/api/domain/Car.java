package com.tampro.api.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "practical-java", indexStoreType = "car")
public class Car {
	@Id
	private String id;
	private String brand;
	private String color;
	private String type;
	private int price;
	private boolean available;
	private Date firstReleaseDate;
	private List<String> additionalFeatures;

	public List<String> getAdditionalFeatures() {
		return additionalFeatures;
	}

	public void setAdditionalFeatures(List<String> additionalFeatures) {
		this.additionalFeatures = additionalFeatures;
	}

	public Car() {
		 
	}
	
	public Car(String brand, String color, String type, int price, boolean available, Date firstReleaseDate) {
		this.brand = brand;
		this.color = color;
		this.type = type;
		this.price = price;
		this.available = available;
		this.firstReleaseDate = firstReleaseDate;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Date getFirstReleaseDate() {
		return firstReleaseDate;
	}

	public void setFirstReleaseDate(Date firstReleaseDate) {
		this.firstReleaseDate = firstReleaseDate;
	}

	public Car(String brand, String color, String type) {
		this.brand = brand;
		this.color = color;
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + ", type=" + type + "]";
	}

 

}
