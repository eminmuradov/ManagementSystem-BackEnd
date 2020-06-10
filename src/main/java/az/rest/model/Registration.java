package az.rest.model;

import az.rest.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;


@Entity
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "registration")
public class Registration {
    @Id
    @GeneratedValue(generator = "register_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "register_seq",sequenceName = "seq_register",allocationSize = 1)
    private Integer id;

    private String name;

    private String surname;

    private String email;

    private String  password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
}
