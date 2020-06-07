package az.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @Email
    @NotNull
    private String email;
    @NotNull(message = "Password  cannot be null")
    @Size(max = 15, message = "Password is long")
    private String password;
}
