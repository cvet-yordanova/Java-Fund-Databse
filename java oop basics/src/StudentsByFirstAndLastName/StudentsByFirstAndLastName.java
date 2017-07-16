package StudentsByFirstAndLastName;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashSet<String> names = new LinkedHashSet<>();

        String line = reader.readLine();

        while (!line.equals("END")){
            String name = line;
            names.add(name);
            line = reader.readLine();
        }

        names
                .stream()
                .filter(a -> {
                    String[] name = a.split(" ");
                    return name[0].compareTo(name[1]) < 0;
                })
                .forEach(System.out::println);

    }
}
