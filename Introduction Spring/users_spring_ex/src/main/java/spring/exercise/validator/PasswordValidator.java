package spring.exercise.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private boolean containsLowercaseLetter;
    private boolean containsUppercaseLetter;
    private boolean containsDigit;
    private boolean containsSpecialCharacter;
    private int maxLength;
    private int minLength;


    @Override
    public void initialize(Password password) {
            this.containsLowercaseLetter = password.containsLowercase();
            this.containsUppercaseLetter = password.containsUppercase();
            this.containsDigit = password.containsDigit();
            this.containsSpecialCharacter = password.containsSpecialSymbol();
            this.minLength = password.minLength();
            this.maxLength = password.maxLength();

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        if(password.length() < this.minLength || password.length() > this.maxLength){
           return false;
        }
        else if(!password.matches(".*[a-z].*") && this.containsLowercaseLetter){
            return false;

        }
        else if(!password.matches(".*[A-Z].*") && this.containsUppercaseLetter){
            return false;

        }
        else if(!password.matches(".*[0-9].*") && this.containsDigit){
            return false;

        }
        else if(!password.matches(".*[!@#$%^&*()_+<>?].*") && this.containsSpecialCharacter){
            return false;
        }
        return true;
    }
}
