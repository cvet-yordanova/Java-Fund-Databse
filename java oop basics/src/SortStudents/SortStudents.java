package SortStudents;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<>();

        String line = reader.readLine();

        while(!line.equals("END")){
            String info = line;
            names.add(info);
            line = reader.readLine();
        }

        names
                .stream()
                .sorted(Comparator.comparing(a -> a.toString().substring(a.toString().indexOf(" ")))
                        .thenComparing(Comparator.comparing(a -> a.toString().substring(0,a.toString().indexOf(" "))).reversed()))
                .forEach( System.out::println);


    }
}

