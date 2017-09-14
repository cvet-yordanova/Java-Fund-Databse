package softuni.validation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PhoneValidator implements ConstraintValidator<PhoneV, String> {
   public void initialize(PhoneV constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return obj.matches("[0-9]{8,10}");
   }
}
