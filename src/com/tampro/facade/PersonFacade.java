package com.tampro.facade;

public class PersonFacade {
	private Name name;
	private Address address;
	private PhoneNumber phoneNumber;
	
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "PersonFacade [name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
