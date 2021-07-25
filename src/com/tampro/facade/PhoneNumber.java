package com.tampro.facade;

public class PhoneNumber {
	private String phoneNumber;
	private String postalCode;
	
	public PhoneNumber(String phoneNumber, String postalCode) {
		this.phoneNumber = phoneNumber;
		this.postalCode = postalCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	@Override
	public String toString() {
		return "PhoneNumber [phoneNumber=" + phoneNumber + ", postalCode=" + postalCode + "]";
	}
	
	

}
