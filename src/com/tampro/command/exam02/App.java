package com.tampro.command.exam02;
/*
 * Bài toán order món ăn tại một nhà hàng
 * - Khách hàng (customer) sẽ order món ăn
 * - Với từng món (steak, pizza) thì người phục vụ (waiter) sẽ chuyển order cho đầu bếp (chef) chế biến món đó
 * Chi tiết : 
 *  + Order sẽ đóng vai trò Command.
 *  + Steak và Pizza chính là các Concrete Command.
 *  + Steak Chef và Pizza Chef đóng vai trò Receiver.
 *  + Customer đóng vai trò Client.
 *  + Waiter sẽ là cầu nối giữa Customer và Chef: Invoker.
 */
public class App {
	public static void main(String[] args) {
		Waiter waiter = new Waiter();
		Customer customer = new Customer(waiter);
		customer.request("pizza");
		customer.request("steak");
	}

}
