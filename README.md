# Java Order Management System

## Overview
  This Java application serves as a basic Order Management System. It allows users to input client and order details, including multiple items per order.

## Usage
  1. Upon running the application, you'll be prompted to enter client information.
  2. Next, enter order details including order status and the number of items in the order.
  3. For each item, input product details such as name, price, and quantity.
  4. The application will generate an order summary at the end.

## Features
  - Client Management: Capture client information including name, email, and birthdate.
  - Order Creation: Specify the order status and add multiple items to the order.
  - Product Details: Input product name, price, and quantity for each order item.

## Code Structure

The project is organized into several Java classes, each serving a specific purpose in the Order Management System:

### `Order` Class

The `Order` class represents an order placed by a client. It includes the following key attributes and methods:

- **Attributes:**
  - `Instant moment`: Represents the timestamp of the order.
  - `OrderStatus status`: Represents the status of the order.
  - `Client client`: Represents the client who placed the order.
  - `List<OrderItem> list`: Represents the list of items included in the order.

- **Methods:**
  - `addItem(OrderItem item)`: Adds an item to the order.
  - `removeItem(OrderItem item)`: Removes an item from the order.
  - `Double total()`: Calculates the total value of the order.
  
- **Important Note:** The `toString()` method is implemented to provide a formatted summary of the order, including order details, client information, and a list of order items.

### `OrderItem` Class

The `OrderItem` class represents an individual item within an order. It includes the following attributes and methods:

- **Attributes:**
  - `Integer quantity`: Represents the quantity of the product in the order item.
  - `Double price`: Represents the price of the product.
  - `Product product`: Represents the product associated with the order item.

- **Methods:**
  - `Double subTotal()`: Calculates the subtotal value for the order item.

### `Product` Class

The `Product` class represents a product with a name and price. It includes the following attributes:

- **Attributes:**
  - `String name`: Represents the name of the product.
  - `Double price`: Represents the price of the product.

### Important Note

The `DateTimeFormatter fmt1` is used for formatting date and time in the `Order` class.

### File Organization

The project is organized into the following packages:
  - `entities`: Contains the main entities of the system (`Order`, `OrderItem`, and `Product`).
  - `entities.enums`: Contains the `OrderStatus` enumeration.

Feel free to explore each class to understand its role and the relationships between them. This organization promotes a modular and scalable structure for the Order Management System.

License
This project is licensed under the MIT License.
