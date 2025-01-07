class Employee {
    private static int counter = 1;
    private int id;
    private String name;
    private int department;
    private int salary;

    public Employee(String name, int department, int salary) {
        this.id = counter++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department=" + department + ", salary=" + salary + '}';
    }
}
