package softuni.serialize;


public class SerializeExc extends RuntimeException{

    public SerializeExc(String message, Throwable cause) {super (message, cause);}
    public SerializeExc(String message){
        super(message);
    }

}
