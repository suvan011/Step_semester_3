import java.util.*;

interface PaymentMethod { boolean processPayment(double amount); }
class CreditCardPayment implements PaymentMethod {
    public boolean processPayment(double amount) { return true; }
}
class PayPalPayment implements PaymentMethod {
    public boolean processPayment(double amount) { return false; }
}
class Product {
    String name; double price;
    Product(String name, double price) { this.name=name; this.price=price; }
}
class Order {
    String id, customer; List<Product> items=new ArrayList<>(); String status="Pending";
    Order(String id, String customer) { this.id=id; this.customer=customer; }
    void add(Product p) { items.add(p); }
    void pay(PaymentMethod method) {
        if (items.isEmpty()) { System.out.println("Cannot process payment for an empty order."); return; }
        double total=0; for(Product p:items) total+=p.price;
        System.out.println("Payment initiated for Order " + id);
        if(method.processPayment(total)) { status="Paid"; System.out.println("Payment for Order " + id + " successful. Order status: " + status); }
        else System.out.println("Payment for Order " + id + " failed. Order status: " + status);
    }
}
class PaymentDemo {
    public static void main(String[] args) {
        Order a=new Order("X","Customer X"); a.add(new Product("A",10)); a.add(new Product("B",20)); a.pay(new CreditCardPayment());
        new Order("Y","Customer Y").pay(new CreditCardPayment());
        Order z=new Order("Z","Customer Z"); z.add(new Product("C",5)); z.pay(new PayPalPayment());
    }
}