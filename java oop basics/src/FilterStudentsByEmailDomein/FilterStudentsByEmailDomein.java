package FilterStudentsByEmailDomein;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;

public class FilterStudentsByEmailDomein {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line  = reader.readLine();

        LinkedHashMap<String, String> people = new LinkedHashMap<String, String>();

        while(!line.equals("END")){
            String[] info = line.split(" ");
            people.put(info[0]+" "+info[1],info[2]);
            line = reader.readLine();
        }

        people
                .entrySet()
                .stream()
                .filter(a -> a.getValue().substring(a.getValue().indexOf("@")).equals("@gmail.com"))
                .forEach(a -> System.out.println(a.getKey()));
 }
}