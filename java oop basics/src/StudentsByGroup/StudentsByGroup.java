package StudentsByGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> students = new LinkedHashMap<>();

        String line = reader.readLine();

        while(!line.equals("END")){
            String[] info = line.split(" ");
            students.put(info[0]+" "+info[1], Integer.parseInt(info[2]));
            line = reader.readLine();
        }

        students
                .entrySet()
                .stream()
                .filter(a -> a.getValue() == 2)
                .sorted((a,b) -> {
                    String[] firstName = a.getKey().split(" ");
                    String[] secondName = b.getKey().split(" ");

                    return firstName[0].compareTo(secondName[0]);
                })
                .forEach(a -> System.out.println(a.getKey()));

    }

}
