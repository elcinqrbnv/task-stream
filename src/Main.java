import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //1
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> result1 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println(result1);

        // 2
        List<String> words = List.of("salam", "sagol", "oldu", "helelik");

        List<String> result = words.stream()
                .filter(w -> w.length() > 3)
                .distinct()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(result);


        // 3

        class Employee {
            private String name;
            private String department;
            private double salary;
            private int age;

            public Employee(String name, String department, double salary, int age) {
                this.name = name;
                this.department = department;
                this.salary = salary;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public String getDepartment() {
                return department;
            }

            public double getSalary() {
                return salary;
            }

            public int getAge() {
                return age;
            }

            @Override
            public String toString() {
                return name + " (" + department + ", " + salary + ", " + age + ")";
            }
        }

        List<Employee> employees_3 = List.of(
                new Employee("Əli", "IT", 3500, 28),
                new Employee("Aysel", "HR", 2800, 34),
                new Employee("Rəşad", "IT", 4200, 41),
                new Employee("Leyla", "Finance", 3900, 31),
                new Employee("Orxan", "HR", 2500, 25)
        );

        Optional<Employee> topEarner_3 = employees_3.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        double averageSalary_3 = employees_3.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        double olderTotalSalary_3 = employees_3.stream()
                .filter(e -> e.getAge() > 30)
                .mapToDouble(Employee::getSalary)
                .sum();

        topEarner_3.ifPresent(System.out::println);
        System.out.println(averageSalary_3);
        System.out.println(olderTotalSalary_3);






    }
}