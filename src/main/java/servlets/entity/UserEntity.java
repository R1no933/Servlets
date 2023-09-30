package servlets.entity;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    private Integer id;
    private String username;
    private LocalDate birthday;
    private String email;
    private String password;
    private Role role;
    private Gender gender;
}
