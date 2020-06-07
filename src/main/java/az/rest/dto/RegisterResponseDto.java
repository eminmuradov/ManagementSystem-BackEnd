package az.rest.dto;

import az.rest.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterResponseDto {
    private String name;
    private Role role;

    public RegisterResponseDto(String firstName, String lastName, Role role) {
        this.name = String.format("%s %s", firstName, lastName);
        this.role = role;
    }
}
