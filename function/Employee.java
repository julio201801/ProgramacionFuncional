

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {

    @EqualsAndHashCode.Include
    private Integer idEmployee;
    private String name;
    private String job;
    private LocalDate birthDate;
    private double salary;
    private String department;
}
