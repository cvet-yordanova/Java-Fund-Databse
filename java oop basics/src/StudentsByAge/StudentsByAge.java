package StudentsByAge;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        LinkedHashMap<String, Integer> students = new LinkedHashMap<>();

        while(!line.equals("END")){
            String[] info = line.split(" ");
            students.put(info[0]+" "+info[1], Integer.parseInt(info[2]));
            line = reader.readLine();
        }

        students
                .entrySet()
                .stream()
                .filter(a -> a.getValue() >= 18 && a.getValue() <= 24)
                .forEach(a -> System.out.println(a.getKey()+" "+a.getValue()));
    }
}
