



import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppStream {

    private void m1getDevelopers(List<Employee> list, String searchText){
        //Predicate<Employee> fx = e -> e.getJob().toLowerCase().contains(searchText);

        /*List<Employee> newList = list.stream()
                                    .filter(e -> e.getJob().toLowerCase().contains(searchText))
                                    .collect(Collectors.toList());*/

        list.stream() //List<Employee> -> Stream<Employee>
                .filter(e -> e.getJob().toLowerCase().contains(searchText))
                .forEach(System.out::println);


        //newList.forEach(System.out::println);
    }

    private void m2getInverse(List<Employee> list){
        Comparator<Employee> inverse =  (x1, x2) -> x2.getIdEmployee() - x1.getIdEmployee();

        list.stream()
                .sorted(inverse)
                .forEach(System.out::println);
    }

    public void m3getAdults(List<Employee> list){
        Predicate<Employee> isAdult = e -> Period.between(e.getBirthDate(), LocalDate.now()).getYears() >= 18;

        list.stream()
                .filter(isAdult)
                .forEach(System.out::println);
    }

    public void m4getOldestAdult(List<Employee> list){
        list.stream()
                .sorted(Comparator.comparing(Employee::getBirthDate)) //e -> e.getBirthDate()
                .limit(1)
                .forEach(System.out::println);
    }

    public void m5getMaxMinSalary(List<Employee> list){
        double max = list.stream()
                                .mapToDouble(Employee::getSalary)
                                .max()
                                .orElse(0);

        double min = list.stream()
                                .mapToDouble(Employee::getSalary)
                                .min()
                                .orElse(0);

        Employee emp = list.stream()
                            .max(Comparator.comparing(Employee::getSalary))
                            .orElse(new Employee());

        System.out.println("Max Salary: " + max);
        System.out.println("Min Salary: " + min);
        System.out.println("Employee Max Salary " + emp );
    }

    public static void main(String[] args) {
        AppStream app = new AppStream();

        Employee e1 = new Employee(1, "Mito1", "Developer", LocalDate.of(1991, 1, 1), 1000.00, "TI");
        Employee e2 = new Employee(2, "Mito2", "QA", LocalDate.of(1993, 2, 1), 2000.00, "TI");
        Employee e3 = new Employee(3, "Mito3", "Arhictect", LocalDate.of(1995, 3, 1), 3000.00, "TI");
        Employee e4 = new Employee(4, "Mito4", "Cloud Engenieer", LocalDate.of(1987, 4, 1), 4000.00, "TI");
        Employee e5 = new Employee(5, "Mito5", "DevOps Engenieer", LocalDate.of(1956, 1, 1), 5000.00, "TI");
        Employee e6 = new Employee(6, "Mito6", "Scrum Master", LocalDate.of(2002, 11, 1), 4500.00, "TI");
        Employee e7 = new Employee(7, "Mito7", "Leader Project", LocalDate.of(1998, 12, 1), 10000.00, "TI");
        Employee e8 = new Employee(8, "Mito8", "Senior Developer", LocalDate.of(1996, 7, 1), 7000.00, "TI");
        Employee e9 = new Employee(9, "Mito9", "Junior Developer", LocalDate.of(2005, 8, 1), 500.00, "TI");
        Employee e10 = new Employee(10, "Mito10", "Mobile Developer", LocalDate.of(1975, 9, 1), 3000.00, "TI");

        List<Employee> list = List.of(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10);
        //app.m1getDevelopers(list, "developer");
        app.m5getMaxMinSalary(list);
    }
}
