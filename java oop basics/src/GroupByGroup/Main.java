package GroupByGroup;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> persons = new ArrayList<Person>();
        String line = reader.readLine();


        while(!line.equals("END")){
            String[] info = line.split(" ");
            persons.add(new Person(info[0]+" "+info[1],Integer.parseInt(info[2])));
            line = reader.readLine();
        }

        Map<Integer, List<String>> result =
                persons.stream()
                        .collect(
                        Collectors.groupingBy(Person::getGroup,
                                Collectors.mapping(Person::getName,Collectors.toList()))
                );

        result
                .entrySet()
                .stream()
               // .sorted(Comparator.comparing(a -> a.getKey()))
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
