import java.util.*;

public class BankAccountWithdrawalSystem {
    static class Account {
        String id, type; int balance;
        Account(String id, String type, int balance) { this.id=id; this.type=type; this.balance=balance; }
        void withdraw(int amount) {
            if (type.equals("Savings") && balance-amount < 1000)
                System.out.println(id + " rejected: minimum balance 1000");
            else if (type.equals("Current") && balance-amount < -5000)
                System.out.println(id + " rejected: overdraft limit 5000");
            else { balance -= amount; System.out.println(id + " balance " + balance); }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Account> accounts = new HashMap<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split("\\s+");
            if (p[0].equals("Savings") || p[0].equals("Current"))
                accounts.put(p[1], new Account(p[1], p[0], Integer.parseInt(p[2])));
            else if (p[0].equals("WITHDRAW")) {
                Account a = accounts.get(p[1]);
                if (a == null) System.out.println("Account not found");
                else a.withdraw(Integer.parseInt(p[2]));
            }
        }
    }
}