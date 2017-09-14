package softuni.validators;

import org.omg.SendingContext.RunTime;
import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Constraint(validatedBy = PasswordMatchingValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatcher {

    String message() default "Invalid password.";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
