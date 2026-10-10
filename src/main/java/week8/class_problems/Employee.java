import java.util.*;

abstract class Employee {
    String name;
    Employee(String name) { this.name = name; }
    abstract boolean canTakeLeave(int days);
}
class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name) { super(name); }
    boolean canTakeLeave(int days) { return days > 0 && days <= 30; }
}
class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name) { super(name); }
    boolean canTakeLeave(int days) { return days > 0 && days <= 10; }
}
class LeaveRequest {
    private final Employee employee;
    private final String dates;
    private String status = "Pending";
    LeaveRequest(Employee employee, String dates) { this.employee = employee; this.dates = dates; }
    void review(boolean approve, String reviewer) {
        if (!status.equals("Pending")) { System.out.println("Cannot change leave request status from " + status + "."); return; }
        status = approve && employee.canTakeLeave(5) ? "Approved" : "Rejected";
        System.out.println(reviewer + " reviewed " + employee.name + "'s request (" + dates + "): " + status);
    }
    void setStatus(String newStatus) {
        if (!status.equals("Pending") || newStatus.equals("Pending")) {
            System.out.println("Cannot change leave request status from " + status + " to " + newStatus + ".");
            return;
        }
        status = newStatus;
    }
    String getStatus() { return status; }
}
class EmployeeDemo {
    public static void main(String[] args) {
        Employee john = new FullTimeEmployee("John");
        LeaveRequest r = new LeaveRequest(john, "Jan 1-5");
        System.out.println("Leave request submitted for John (Jan 1-5). Status: " + r.getStatus());
        r.review(true, "Manager Alice");
        r.setStatus("Pending");
    }
}