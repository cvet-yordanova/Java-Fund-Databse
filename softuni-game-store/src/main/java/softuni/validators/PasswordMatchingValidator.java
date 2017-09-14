package softuni.validators;

import org.springframework.stereotype.Component;
import softuni.models.bindingModels.user.RegisterUser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PasswordMatchingValidator implements ConstraintValidator<PasswordMatcher,Object> {

    @Override
    public void initialize(PasswordMatcher passwordMatcher) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        if(o instanceof RegisterUser){
            RegisterUser registerUser = (RegisterUser)o;
            return registerUser.getPassword().equals(registerUser.getConfirmPassword());
        }
        return false;
    }
}
