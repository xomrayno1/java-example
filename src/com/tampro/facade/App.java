package com.tampro.facade;
/*
 * Thay vì phải làm việc từng màn hình là Address hay Name hay PhoneNumber.
 * Thì chúng ta có thể dùng Facade Pattern
 * PersonFacade sẽ gộp các thông tin cần làm việc của một 1 Person vào 1 màn hình.
 */
public class App {
	public static void main(String[] args) {
		PersonFacade personFacade = new PersonFacade();
		personFacade.setAddress(new Address("Phú Yên", "Đông Hoà", "VN"));
		personFacade.setName(new Name("Nguyễn", "Chí", "Tâm"));
		personFacade.setPhoneNumber(new PhoneNumber("0332526746", "033"));
		
		System.out.println(personFacade);
	}

}
