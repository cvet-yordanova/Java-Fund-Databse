package spring.exercise.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator  implements ConstraintValidator<Email,String>{

    @Override
    public void initialize(Email email) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        if(!email.matches("[a-z0-9A-Z]+(?:[._-][a-z0-9A-Z]+)*@(?:[a-z]+([-][a-z]+)*)(?:\\.[a-z]+(?:[-][a-z]+)*)+")){
            return false;
        }
        return true;
    }
}
