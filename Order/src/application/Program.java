package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email:");
		String email = sc.nextLine();
		System.out.print("Birth Date: (DD/MM/YYYY): ");
		Date dateBirth = sdf.parse(sc.next());
		
		Date moment = new Date();
		 
		System.out.println("Enter order status: ");
		System.out.print("Status: ");
		sc.nextLine();
		String orderLevel = sc.nextLine();
		System.out.print("How many items to this order?");
		int n = sc.nextInt();
		
		Order order = new Order(moment, OrderStatus.valueOf(orderLevel), new Client (clientName,email, dateBirth));
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			OrderItem items = new OrderItem (productQuantity, price, new Product (price,productName));
			order.addItem(items);
		}
		
		System.out.println("ORDER SUMMARY:");
		System.out.println("Order moment: " + sdf1.format(moment));
		System.out.println("Order Statud: " + orderLevel);
		System.out.println("Client: " + order.getClient());
		System.out.println("Order items:");
		
		System.out.println(order);
		
		sc.close();
	}
}
