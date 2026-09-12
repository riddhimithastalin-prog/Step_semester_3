package oop.assigment_problems;

public class q5_EmployeeStaticDemo {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    q5_EmployeeStaticDemo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        q5_EmployeeStaticDemo e1 = new q5_EmployeeStaticDemo("Divya", 65000);
        q5_EmployeeStaticDemo e2 = new q5_EmployeeStaticDemo("Arjun", 45000);
        q5_EmployeeStaticDemo e3 = new q5_EmployeeStaticDemo("Priya", 55000);

        q5_EmployeeStaticDemo.printCompanyInfo();
    }
}