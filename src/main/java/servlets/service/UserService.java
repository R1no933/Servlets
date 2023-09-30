package servlets.service;

import servlets.dao.UserDao;
import servlets.dto.CreateUserDto;
import servlets.entity.UserEntity;
import servlets.exception.ValidationException;
import servlets.mapper.CreateUserMapper;
import servlets.validator.CreateUserValidator;
import servlets.validator.ValidationResult;

public class UserService {
    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper userMapper = CreateUserMapper.getInstance();

    public Integer create(CreateUserDto createUserDto) {
        ValidationResult validResult = createUserValidator.isValid(createUserDto);

        if (!validResult.isValid()) {
            throw new ValidationException(validResult.getErrors());
        }

        UserEntity userEntity = userMapper.mapFrom(createUserDto);
        userDao.save(userEntity);
        return userEntity.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
