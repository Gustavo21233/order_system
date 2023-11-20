package entities;

import entities.enums.OrderStatus;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {


    public static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private Instant moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> list = new ArrayList<>();

    public Order(){}

    public Order(Instant moment,Client client, OrderStatus status) {
        this.moment = moment;
        this.client = client;
        this.status = status;
    }

    public void addItem(OrderItem item){
        list.add(item);
    }

    public void removeItem(OrderItem item){
        list.remove(item);
    }

    public Double total(){
        double sum = 0;
        for (OrderItem c: list) {
            sum += c.subTotal();
        }
        return sum;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Order moment: " +fmt2.format(moment.atZone(ZoneId.systemDefault()))  + "\n");
        sb.append("Order status: " + status + "\n");
        sb.append("Client: " + client.getName() + " ");
        sb.append("(" + fmt1.format(client.getBirthDate()) + ") ");
        sb.append("- " + client.getEmail() + "\n");
        sb.append("Order Items: \n");
        for (OrderItem o : list) {
            sb.append(o.getProduct().getName() + ", ");
            sb.append(o.getQuantity() + ", ");
            sb.append("Subtotal: " + String.format("%.2f",o.subTotal()) + "\n");
        }
        sb.append(total());
        return sb.toString();
    }
}
