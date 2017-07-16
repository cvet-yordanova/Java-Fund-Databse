package ExcellentStudents;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class ExcellentsStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String,List<Integer>> students = new LinkedHashMap<>();
        String line  = reader.readLine();
        
        while(!line.equals("END")){
            String[] info = line.split(" " );
            List<Integer> grades = new LinkedList<>();

            for (int i = 2; i < info.length; i++) {
                grades.add(Integer.parseInt(info[i]));
            }

            students.put(info[0]+" "+info[1],grades);
            line = reader.readLine();
        }

        students
                .entrySet()
                .stream()
                .filter(a  -> a.getValue().contains(6))
                .forEach(a -> System.out.println(a.getKey()));
    }
}
