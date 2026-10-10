import java.util.*;

abstract class Employee {
    String name;
    Employee(String name) { this.name = name; }
    abstract boolean canTakeLeave(int days);
}
class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name) { super(name); }
    boolean canTakeLeave(int days) { return days > 0 && days <= 20; }
}
class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name) { super(name); }
    boolean canTakeLeave(int days) { return days > 0 && days <= 5; }
}
class LeaveRequest {
    private final Employee employee;
    private final String dates;
    private String status = "Pending";
    LeaveRequest(Employee e, String dates) { employee = e; this.dates = dates; }
    void review(boolean approve) {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status from " + status + ".");
            return;
        }
        status = approve ? "Approved" : "Rejected";
        System.out.println(employee.name + "'s leave request (" + dates + ") "
                + status.toLowerCase() + ". Status: " + status);
    }
    void setStatus(String newStatus) {
        if (status.equals("Pending") && !newStatus.equals("Pending")) status = newStatus;
        else System.out.println("Cannot change leave request status from " + status + " to " + newStatus + ".");
    }
}
class LeaveDemo {
    public static void main(String[] args) {
        Employee john = new FullTimeEmployee("John"), jane = new PartTimeEmployee("Jane");
        LeaveRequest a = new LeaveRequest(john, "Jan 1-5"), b = new LeaveRequest(jane, "Feb 10-11");
        System.out.println("Leave request submitted for John (Jan 1-5). Status: Pending.");
        a.review(true);
        System.out.println("Leave request submitted for Jane (Feb 10-11). Status: Pending.");
        b.review(false);
        a.setStatus("Pending");
    }
}