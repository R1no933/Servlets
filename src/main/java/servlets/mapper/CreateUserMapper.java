package servlets.mapper;

import servlets.dto.CreateUserDto;
import servlets.entity.Gender;
import servlets.entity.Role;
import servlets.entity.UserEntity;
import servlets.util.LocalDateFormatter;

import java.time.format.DateTimeFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, UserEntity> {

    private static final CreateUserMapper INStANCE = new CreateUserMapper();

    @Override
    public UserEntity mapFrom(CreateUserDto object) {
        return UserEntity.builder()
                .username(object.getUsername())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .role(Role.valueOf(object.getRole()))
                .gender(Gender.valueOf(object.getGender()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INStANCE;
    }
}
