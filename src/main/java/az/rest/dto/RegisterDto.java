package az.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
   @NotEmpty
   private String name;
   private String surname;
   private String email;
   private String password;
}
