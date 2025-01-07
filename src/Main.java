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

    private final static Employee[] EMPLOYEES = new Employee[10];
    private static int employeeCount = 0;

    public static void main(String[] args) {
        initEmployees();
    }

    private static void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String name = SURNAMES[RANDOM.nextInt(SURNAMES.length)] + " " +
                    NAMES[RANDOM.nextInt(NAMES.length)] + " " +
                    PATRONIMIC_NAMES[RANDOM.nextInt(PATRONIMIC_NAMES.length)];
            int salary = RANDOM.nextInt(50000, 100000);
            EMPLOYEES[i] = new Employee(name, RANDOM.nextInt(1, 6), salary);
            employeeCount++;
        }

        printAllEmployees();
        System.out.println("Сумма затрат на ЗП: " + calculateTotalSalary());
        System.out.println("Сотрудник с минимальной ЗП: " + findEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной ЗП: " + findEmployeeWithMaxSalary());
        System.out.println("Среднее значение зарплат: " + calculateAverageSalary());
        printEmployeeNames();
    }

    private static void printAllEmployees() {
        System.out.println("Список всех сотрудников:");
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(EMPLOYEES[i]);
        }
    }

    private static double calculateTotalSalary() {
        double total = 0;
        for (int i = 0; i < employeeCount; i++) {
            total += EMPLOYEES[i].getSalary();
        }
        return total;
    }

    private static Employee findEmployeeWithMinSalary() {
        if (employeeCount == 0) return null;

        Employee minSalaryEmployee = EMPLOYEES[0];
        for (int i = 1; i < employeeCount; i++) {
            if (EMPLOYEES[i].getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = EMPLOYEES[i];
            }
        }
        return minSalaryEmployee;
    }

    private static Employee findEmployeeWithMaxSalary() {
        if (employeeCount == 0) return null;

        Employee maxSalaryEmployee = EMPLOYEES[0];
        for (int i = 1; i < employeeCount; i++) {
            if (EMPLOYEES[i].getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = EMPLOYEES[i];
            }
        }
        return maxSalaryEmployee;
    }

    private static double calculateAverageSalary() {
        if (employeeCount == 0) return 0;
        return (double) calculateTotalSalary() / employeeCount;
    }

    private static void printEmployeeNames() {
        System.out.println("ФИО всех сотрудников:");
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(EMPLOYEES[i].getName());
        }
    }
}