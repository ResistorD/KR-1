import java.util.Objects;

class Employee {
    private static int counter = 1; // Статический счетчик для уникальных идентификаторов
    private int id; // Уникальный идентификатор
    private String name; // Имя сотрудника
    private int department; // Отдел
    private int salary; // Зарплата

    public Employee(String name, int department, int salary) {
        this.id = counter++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name; // Геттер для имени
    }

    public int getDepartment() {
        return department; // Геттер для отдела
    }

    public void setDepartment(int department) {
        this.department = department; // Сеттер для отдела
    }

    public int getSalary() {
        return salary; // Геттер для зарплаты
    }

    public void setSalary(int salary) {
        this.salary = salary; // Сеттер для зарплаты
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department=" + department + ", salary=" + salary + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id; // Сравнение по уникальному идентификатору
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Генерация хэш-кода на основе идентификатора
    }
}