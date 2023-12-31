package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.Instant;
import java.time.LocalDate;

import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.next();
        System.out.print("Birthdate (DD/MM/YYYY): ");
        String clientBirthString = sc.next();
        LocalDate clientBirth = LocalDate.parse(clientBirthString,Order.fmt1);

        Client client = new Client(clientName,clientEmail,clientBirth);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String orderStatus = sc.next();

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        sc.nextLine();

        Order order = new Order(Instant.now(),client, OrderStatus.valueOf(orderStatus));



        for (int i = 0; i < n; i++) {
            System.out.println("Enter #" + (i+1) + " item data:");
            System.out.print("Product name: ");
            String productName = sc.next();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();

            Product product = new Product(productName,productPrice);
            OrderItem orderItem = new OrderItem(productQuantity,product);

            order.addItem(orderItem);

        }

        System.out.println("ORDER SUMMARY:");
        System.out.println(order);

        sc.close();
    }
}