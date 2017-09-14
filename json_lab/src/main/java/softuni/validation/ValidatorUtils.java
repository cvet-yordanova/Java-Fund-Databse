package softuni.validation;

import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;


@Component
public class ValidatorUtils {

    private Validator validator;

    public ValidatorUtils(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    //greshki
    public <T> boolean isValid(T t){
        return validator.validate(t).size() == 0;
    }
}
