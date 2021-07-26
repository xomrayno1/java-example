package com.tampro.command.exam01;
/*
 * 
 * https://gpcoder.com/4686-huong-dan-java-design-pattern-command/
 * 
 * Mô tả : Đóng mở tài khoản , Module click đóng và module click mở
 */
public class App {
	public static void main(String[] args) {
		Account account = new Account("nctCoder"); //Request
		
		Command open = new OpenAccount(account);
		Command close = new CloseAccount(account);
		
		BankApp bankApp = new BankApp(open, close);
		
		bankApp.clickOpenAccount();
		bankApp.clickCloseAccount();
	}
	
	/* Command: execute();
	 * ConcreateCommand: implementation command, Mỗi 1 ConcreteCommand sẽ phục vụ cho một case request riêng.
	 * 				   : Tiếp nhận Receiver và gọi method xử lý case từ Receiver vào execute()
	 * Receiver: Xử lý cái case của ConcreateCommand
	 * 
	 * Invoker: tiếp nhận ConcreteCommand từ Client và gọi execute() của ConcreateCommand để thực thi request.
	 * 		Invoker Notice: ConcreteCommand gọi execute() 
	 */		

}
