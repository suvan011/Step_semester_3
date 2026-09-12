package week3.assigment_problems;

public class EmployeeStaticDemo {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeStaticDemo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        EmployeeStaticDemo employee1 = new EmployeeStaticDemo("Divya", 65000);
        EmployeeStaticDemo employee2 = new EmployeeStaticDemo("Arjun", 0);
        EmployeeStaticDemo employee3 = new EmployeeStaticDemo("Priya", 70000);

        System.out.println("3 Employee objects created");
        EmployeeStaticDemo.printCompanyInfo();
    }
}
