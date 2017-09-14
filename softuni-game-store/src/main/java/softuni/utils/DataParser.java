package softuni.utils;


import softuni.models.bindingModels.user.RegisterUser;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class DataParser {
    public static <T> String getInvalidParameterMessage(T target){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraints = validatorFactory.getValidator().validate(target);

        for (ConstraintViolation<T> constraint : constraints) {
            return constraint.getMessage();
        }

        return null;
    }

    public static <T> boolean checkIsValid(T target){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraints = validatorFactory.getValidator().validate(target);

        for (ConstraintViolation<T> constraint : constraints) {
            return false;
        }

        return true;
    }


}
