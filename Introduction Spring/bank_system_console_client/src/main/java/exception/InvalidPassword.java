package exception;


public class InvalidPassword extends CustomException{
    public InvalidPassword(String message) {
        super(message);
    }
}
