package week4.class_problems;

public class PaymentBatchProcessor {
    static class FeeAccount {
        public void pay(double amount) {
            System.out.println("Paid in one go (day-scholar account): Rs " + amount);
        }
    }

    static class HostelFeeAccount extends FeeAccount {
        public void payInInstallments(double amount) {
            System.out.println("Paid in two installments (hostel account): Rs " + amount);
        }
    }

    private double totalCollected;
    private int hostelCount;
    private int dayScholarCount;

    void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            HostelFeeAccount hostel = (HostelFeeAccount) account;
            hostel.payInInstallments(amount);
            totalCollected += amount;
            hostelCount++;
        } else {
            account.pay(amount);
            totalCollected += amount;
            dayScholarCount++;
        }
    }

    public static void main(String[] args) {
        PaymentBatchProcessor processor = new PaymentBatchProcessor();
        FeeAccount[] accounts = {
            new HostelFeeAccount(), new HostelFeeAccount(),
            new FeeAccount(), new FeeAccount()
        };
        for (FeeAccount account : accounts) {
            processor.processPayment(account, 60000);
        }
        System.out.println("Hostel accounts processed: " + processor.hostelCount
                + " | Day-scholar accounts processed: " + processor.dayScholarCount);
    }
}
