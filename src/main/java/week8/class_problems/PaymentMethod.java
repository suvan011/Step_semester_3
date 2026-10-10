import java.util.*;

interface PaymentMethod { boolean processPayment(double amount); }
class CreditCardPayment implements PaymentMethod {
    public boolean processPayment(double amount) { System.out.println("Credit Card payment successful."); return true; }
}
class PayPalPayment implements PaymentMethod {
    public boolean processPayment(double amount) { System.out.println("PayPal payment failed."); return false; }
}
class Product {
    String name; double price;
    Product(String n, double p) { name=n; price=p; }
}
class Order {
    String id; List<Product> items = new ArrayList<>(); String status = "Pending";
    Order(String id) { this.id=id; }
    void add(Product p) { items.add(p); }
    void pay(PaymentMethod method) {
        if (items.isEmpty()) { System.out.println("Cannot process payment for an empty order."); return; }
        System.out.println("Payment initiated for Order " + id + ".");
        double total=0; for(Product p:items) total+=p.price;
        if(method.processPayment(total)) status="Paid";
        System.out.println("Order status: " + status);
    }
}
class PaymentDemo {
    public static void main(String[] args) {
        Order x = new Order("X"); x.add(new Product("A",20)); x.add(new Product("B",30)); x.pay(new CreditCardPayment());
        new Order("Y").pay(new CreditCardPayment());
        Order z = new Order("Z"); z.add(new Product("C",10)); z.pay(new PayPalPayment());
    }
}