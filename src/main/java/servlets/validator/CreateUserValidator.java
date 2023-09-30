package servlets.validator;

import servlets.dto.CreateUserDto;
import servlets.entity.Gender;
import servlets.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        ValidationResult validationResult = new ValidationResult();

        if (!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("Invalid.date", "Date is invalid"));
        }

        if (Gender.valueOf(object.getGender()) == null) {
            validationResult.add(Error.of("Invalid.gender", "Gender is invalid"));
        }

        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
