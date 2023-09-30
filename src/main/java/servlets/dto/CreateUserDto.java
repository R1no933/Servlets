package servlets.dto;

import jakarta.servlet.http.Part;
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
    Part image;
}
