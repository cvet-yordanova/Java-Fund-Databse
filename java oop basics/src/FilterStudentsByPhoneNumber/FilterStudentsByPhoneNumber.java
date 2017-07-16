package FilterStudentsByPhoneNumber;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class FilterStudentsByPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        LinkedHashMap<String, String> people = new LinkedHashMap<>();

        while (!line.equals("END")) {
            String[] info = line.split(" ");

            people.put(info[0] + " " + info[1], info[2]);
            line = reader.readLine();
        }

        people
                .entrySet()
                .stream()
                .filter(a -> (a.getValue().substring(0,2).equals("02"))||(a.getValue().substring(0, 5).equals("+3592")))
                .forEach(a -> System.out.println(a.getKey()));
    }
}