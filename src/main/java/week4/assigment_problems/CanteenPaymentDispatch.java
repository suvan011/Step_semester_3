package week4.assigment_problems;

public class CanteenPaymentDispatch {
    static class Payment {
        public double pay(double amount) {
            System.out.println("Paid (cash): Rs " + amount);
            return amount;
        }
    }

    static class CardPayment extends Payment {
        public double payWithProcessingFee(double amount) {
            double total = amount * 1.02;
            System.out.println("Charged (card, incl. fee): Rs " + total);
            return total;
        }
    }

    private double totalCollected;

    void processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment cardPayment = (CardPayment) payment;
            totalCollected += cardPayment.payWithProcessingFee(amount);
        } else {
            totalCollected += payment.pay(amount);
        }
    }

    public static void main(String[] args) {
        CanteenPaymentDispatch processor = new CanteenPaymentDispatch();
        Payment[] payments = {
            new CardPayment(), new Payment(), new CardPayment(), new Payment(), new CardPayment()
        };
        double[] amounts = {100, 50, 200, 75, 120};

        for (int i = 0; i < payments.length; i++) {
            processor.processTransaction(payments[i], amounts[i]);
        }
        System.out.println("Total Collected: Rs " + processor.totalCollected);
    }
}
