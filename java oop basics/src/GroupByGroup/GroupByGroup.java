package GroupByGroup;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GroupByGroup {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        HashMap<Integer,Set<String>> persons = new HashMap<>();

        while(!line.equals("END")){
            String[] info  = line.split(" ");
            String currentName = info[0]+" "+info[1];
            Integer currentKey = Integer.parseInt(info[2]);
            if(persons.containsKey(currentKey)){
                persons.get(currentKey).add(currentName);
            }
            else{
                Set<String> set = new HashSet<>();
                set.add(currentName);
                persons.put(currentKey,set);
            }
            line = reader
                    .readLine();
        }

        persons
                .entrySet()
                .stream()
                .forEach(a -> System.out.println(a.getKey()+" - "+String.join(", ",a.getValue())));

    }

    public static class Person {
        private Integer group;
        private String name;

        public Integer getGroup() {
            return group;
        }

        public void setGroup(Integer group) {
            this.group = group;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Person(String name, Integer group) {
            this.group = group;
            this.name = name;
        }
    }
}
