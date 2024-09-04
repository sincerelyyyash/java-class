abstract class Employee {
    protected String name;
    protected int id;
    protected double baseSalary;

    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    public abstract double calculatePay();
}

class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, int id, double baseSalary) {
        super(name, id, baseSalary);
    }

    @Override
    public double calculatePay() {
        return baseSalary;
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyWage;  
    private int hoursWorked;

    public PartTimeEmployee(String name, int id, double hourlyWage, int hoursWorked) {
        super(name, id, hourlyWage * hoursWorked);
        this.hourlyWage = hourlyWage;  
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        return hourlyWage * hoursWorked;  
    }
}


class Contractor extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public Contractor(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id, hourlyRate * hoursWorked);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }
}

public class EmpPayroll {
    public static void main(String[] args) {
        Employee ftEmployee = new FullTimeEmployee("Tanishka", 1, 5000);
        Employee ptEmployee = new PartTimeEmployee("Shivam", 2, 20, 80); 
        Employee contractor = new Contractor("Yash", 3, 30, 100); 

        System.out.println("Full-Time Employee Pay: Rs." + ftEmployee.calculatePay());

        System.out.println("Part-Time Employee Pay: Rs." + ptEmployee.calculatePay());

        System.out.println("Contractor Pay: Rs." + contractor.calculatePay());
    }
}
