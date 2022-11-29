package JavaCore.Comparable_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee employee1 = new Employee(200, "Ivan", "Top", 9234);
        Employee employee2 = new Employee(100, "Ivan", "Az", 4321);
        Employee employee3 = new Employee(300, "Roma", "Petrov", 1234);

        list.add(employee1);
        list.add(employee2);
        list.add(employee3);

        list = list.stream().sorted((x,y) -> x.id - y.id).collect(Collectors.toList());
        System.out.println(list);
    }
}

class Employee {
    int id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary + "\n";
    }


}

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.name.compareTo(emp2.name);
    }
}
