package StudentsEnrolled2014Or2015;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StidentsEnrolled2014OR2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, List<Integer>> students = new LinkedHashMap<>();
        String line  = reader.readLine();

        while(!line.equals("END")){
            String[] info = line.split(" ");
            List<Integer> grades = new ArrayList<>();

            for (int i = 1; i < info.length; i++) {
                grades.add(Integer.parseInt(info[i]));
            }

            students.put(info[0],grades);
            line = reader.readLine();
        }

        for (Map.Entry<String, List<Integer>> entry : students.entrySet()) {

            String key = entry.getKey();

            if((key.substring(key.length()-2).equals("14"))||(key.substring(key.length()-2).equals("15"))){
                for (int i = 0; i < entry.getValue().size(); i++) {
                    System.out.print(entry.getValue().get(i)+" ");
                }

                System.out.println();
            }
        }

    }
}
