package az.rest.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;


@Entity
@Getter
@Setter
@ToString
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(generator = "students_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "students_seq",sequenceName = "seq_students",allocationSize = 1)
    private Integer id;

    private String name;

    private String surname;

    private Integer active=1;

    private String sector;
}
