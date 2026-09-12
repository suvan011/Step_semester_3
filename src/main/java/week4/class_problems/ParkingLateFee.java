package week4.class_problems;

public class ParkingLateFee {
    static class ParkingAccount {
        private String regNo;
        private double totalFee;

        ParkingAccount(String regNo, double totalFee) {
            this.regNo = regNo;
            this.totalFee = totalFee;
        }

        final double calculateLateFee(int daysLate) {
            return daysLate * 0.01 * totalFee;
        }

        final void printSummary(int daysLate) {
            if (daysLate <= 0) {
                System.out.println(regNo + " - On time, no late fee");
            } else {
                System.out.println(regNo + " | Total Fee: Rs " + totalFee
                        + " | Late Fee: Rs " + calculateLateFee(daysLate));
            }
        }
    }

    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};

        for (int i = 0; i < regNos.length; i++) {
            ParkingAccount account = new ParkingAccount(regNos[i], totalFees[i]);
            if (daysLate[i] > 0) {
                account.printSummary(daysLate[i]);
            } else {
                account.printSummary(daysLate[i]);
            }
        }
    }
}
