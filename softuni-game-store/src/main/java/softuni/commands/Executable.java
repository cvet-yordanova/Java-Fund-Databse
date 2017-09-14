package softuni.commands;


import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

public interface Executable {
    String execute(String... params) throws  ParseException;
}
