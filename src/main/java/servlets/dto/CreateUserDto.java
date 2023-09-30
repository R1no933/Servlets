package servlets.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDto {
    String username;
    String birthday;
    String email;
    String password;
    String role;
    String gender;
}
