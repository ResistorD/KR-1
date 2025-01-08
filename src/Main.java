import java.util.Random;

public class Main {

    private final static Random RANDOM = new Random();
    private final static String[] NAMES = {
            "Андрей", "Борис", "Виктор", "Григорий", "Дмитрий", "Евгений", "Игорь"
    };
    private final static String[] SURNAMES = {
            "Андреев", "Борисов", "Викторов", "Григорьев", "Дмитриев", "Евгеньев", "Игорев"
    };
    private final static String[] PATRONIMIC_NAMES = {
            "Андреевич", "Борисович", "Викторович", "Григорьевич", "Дмитриевич", "Евгеньевич", "Игоревич"
    };

    // Поле типа Employee[], служащее хранилищем для записей о сотрудниках
    private Employee[] employees;
    private int employeeCount;

    public Main() {
        this.employees = new Employee[10]; // Инициализируем массив в конструкторе
        this.employeeCount = 0;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.initEmployees();
    }

    private void initEmployees() {
        for (int i = 0; i < employees.length; i++) {
            String name = SURNAMES[RANDOM.nextInt(SURNAMES.length)] + " " +
                    NAMES[RANDOM.nextInt(NAMES.length)] + " " +
                    PATRONIMIC_NAMES[RANDOM.nextInt(PATRONIMIC_NAMES.length)];
            int salary = RANDOM.nextInt(50000, 100000);
            employees[i] = new Employee(name, RANDOM.nextInt(1, 6), salary);
            employeeCount++;
        }

        printAllEmployees();
        System.out.println("Сумма затрат на ЗП: " + calculateTotalSalary());
        System.out.println("Сотрудник с минимальной ЗП: " + findEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной ЗП: " + findEmployeeWithMaxSalary());
        System.out.println("Среднее значение зарплат: " + calculateAverageSalary());
        printEmployeeNames();
    }

    private void printAllEmployees() {
        System.out.println("Список всех сотрудников:");
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(employees[i]);
        }
    }

    private double calculateTotalSalary() {
        double total = 0;
        for (int i = 0; i < employeeCount; i++) {
            total += employees[i].getSalary();
        }
        return total;
    }

    private Employee findEmployeeWithMinSalary() {
        if (employeeCount == 0) return null;

        Employee minSalaryEmployee = employees[0];
        for (int i = 1; i < employeeCount; i++) {
            if (employees[i].getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employees[i];
            }
        }
        return minSalaryEmployee;
    }

    private Employee findEmployeeWithMaxSalary() {
        if (employeeCount == 0) return null;

        Employee maxSalaryEmployee = employees[0];
        for (int i = 1; i < employeeCount; i++) {
            if (employees[i].getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employees[i];
            }
        }
        return maxSalaryEmployee;
    }

    private double calculateAverageSalary() {
        if (employeeCount == 0) return 0;
        return calculateTotalSalary() / employeeCount;
    }

    private void printEmployeeNames() {
        System.out.println("ФИО всех сотрудников:");
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(employees[i].getName());
        }
    }
}