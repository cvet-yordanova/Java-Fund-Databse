package softuni.validators;


import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PasswordValidator implements ConstraintValidator<Password, String>{
    @Override
    public void initialize(Password password) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        boolean lowerCase = s.matches(".*[a-z].*");
        boolean upperCase = s.matches(".*[A-Z].*");
        boolean digit = s.matches(".*[0-9].*");
        boolean length = s.length() >= 1;

        if(lowerCase && upperCase && digit && length){
            return true;
        }
        else return false;
    }
}
