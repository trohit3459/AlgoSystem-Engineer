public class PaymentProcessor {
public boolean processPayment(double amount) {
    System.out.println("Processing payment: " + amount);
    return true;
}

public void refund(double amount) {
    System.out.println("Refund issued: " + amount);
}
}
