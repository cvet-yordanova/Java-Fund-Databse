import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

      // generateClass(reader);

    //   generateRepositories(reader);

        generateServices(reader);

    }

    private static void generateServices(BufferedReader reader) throws IOException {
        String path1 = "src/main/resources/service/api/";
        String path2 = "src/main/resources/service/impl/";

        List<String> serviceNames = new ArrayList<>();

        System.out.println("Service names");
        String line = reader.readLine();

        while(!line.equals("END")){
            serviceNames.add(line);
            line = reader.readLine();
        }

        for (String n : serviceNames) {
            String serviceName = n+"Service";
            path1 +=serviceName+".java";

            System.out.println(String.format("    @Autowired\n" +
                    "    private final %s %s;\n",serviceName,serviceName.substring(0,1).toLowerCase()+serviceName.substring(1)));

            File f = new File(path1);

            if(!f.exists()){
                f.getParentFile().mkdirs();
                f.createNewFile();
            }

            OutputStream os = new FileOutputStream(path1);
            BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os));

            bfw.write(String.format("import java.util.List;\n" +
                    "\n" +
                    "public interface %s {\n" +
                    "\n" +
                    "    List<%s> findAll();\n" +
                    "    %s findOne(Long aLong);\n" +
                    "    void delete(Long aLong);\n" +
                    "    void delete(%s car);\n" +
                    "}",n+"Service", n, n, n));
            bfw.flush();
            path1 = "src/main/resources/service/api/";
        }

        for (String n : serviceNames) {

            String serviceName = n+"ServiceImpl";
            String serviceImpl = n+"Service";
            String repositoryClass = n+"Repository";
            String repositoryName = n.substring(0,1).toLowerCase()+n.substring(1)+"Repository";
            path2 +=serviceName+".java";

            File f = new File(path2);

            if(!f.exists()){
                f.getParentFile().mkdirs();
                f.createNewFile();
            }

            OutputStream os = new FileOutputStream(path2);
            BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os));

            bfw.write(String.format("import org.springframework.stereotype.Service;\n" +
                            "\n" +
                            "import javax.transaction.Transactional; import java.util.List;\n" +
                    "\n" +
                    "@Service\n" +
                    "@Transactional\n" +
                    "public class %s implements %s {\n" +
                    "\n" +
                    "    @Autowired\n" +
                    "    private final %s %s;\n" +
                    "\n" +
                    "    public %s(%s %s) {\n" +
                    "        this.%s = %s;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public List<%s> findAll() {\n" +
                    "        return this.%s.findAll();\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public %s findOne(Long aLong) {\n" +
                    "        return this.%s.findOne(aLong);\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void delete(Long aLong) {\n" +
                    "            this.%s.delete(aLong);\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void delete(%s entity) {\n" +
                    "            this.%s.delete(entity);\n" +
                    "    }\n" +
                    "\n" +
                    "    //--------------------------------------------------------------------\n" +
                    "}",serviceName,serviceImpl, repositoryClass, repositoryName,
                    serviceName,repositoryClass,repositoryName,repositoryName,repositoryName,
                    n,repositoryName,
                    n,repositoryName,
                    repositoryName,
                    n,repositoryName
                    ));
            bfw.flush();

            path2 = "src/main/resources/service/impl/";

        }
    }

    private static void generateRepositories(BufferedReader reader) throws IOException {
        String path = "src/main/resources/repositories/";

        System.out.println("repository names");
        List<String> repositoriesNames = new ArrayList<>();
        String line = reader.readLine();

        while(!line.equals("END")){
            repositoriesNames.add(line);
            line = reader.readLine();
        }

        for (String n : repositoriesNames) {
            String repositoryName = n+"Repository";
            path +=repositoryName+".java";

            File f = new File(path);

            if(!f.exists()){
                f.getParentFile().mkdirs();
                f.createNewFile();
            }

            OutputStream os = new FileOutputStream(path);
            BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os));

            bfw.write("import org.springframework.data.jpa.repository.JpaRepository;\n" +
                    "import org.springframework.stereotype.Repository;\n @Repository\npublic interface "+repositoryName+
                    " extends JpaRepository<"+n+",Long"+">{\n}");
            bfw.flush();
            path = "src/main/resources/repositories/";
        }
    }

    private static void generateClass(BufferedReader reader) throws IOException {
        System.out.println("Class name: ");
        String className = reader.readLine();
        System.out.println("Table name:");
        String tableName = reader.readLine();

        System.out.println("!!!! --ID--  field name type, columnName zad");

        Boolean isId = false;

        List<String> fields = new ArrayList<>();
        List<String> getNdSet = new ArrayList<>();
        String line = reader.readLine();

        while(!line .equals("END")){
            String[] data = line.split(", ");
            String[] data1 = data[0].split("\\s");
            String fieldName = data1[0];
            String fieldType = "";
            if(fieldName.equals("id")){
                isId = true;
            }

            switch(data1[1].trim()){
                case "bd":fieldType = "BigDecimal";break;
                case "str":fieldType = "String";break;
                case "fl":fieldType = "Float";break;
                case "db":fieldType = "Double";break;
                case "lo":fieldType = "Long";break;
                case "int":fieldType = "Integer";break;
                case "bo":fieldType = "Boolean";break;
                case "da":fieldType = "Date";break;
                default:fieldType = data1[1].trim();

            }
            String annotations = "";

            if(!isId){

                List<String> data2 = Arrays.asList( data[1].split(" "));
                String columnName = data2.get(0);
                annotations = "@Column("+"name = \""+columnName+"\"";

                if(data2.contains("zad")){
                    annotations+=", nullable = false)\n";
                }
                else {
                    annotations+=")\n";
                }
            }
            else {
                annotations = "@Id\n@GeneratedValue(strategy = GenerationType.IDENTITY)\n";
            }

            fields.add("private "+ fieldType+" "+fieldName+";\n");

            getNdSet.add(String.format(annotations+"public %s %s() {\n" +
                    "        return %s;\n" +
                    "    }\n",fieldType,"get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1),fieldName));

            getNdSet.add(String.format("public void %s(%s %s) {\n" +
                    "        this.%s = %s;\n" +
                    "    }\n","set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1),fieldType,fieldName,fieldName,fieldName));

            isId = false;
            line = reader.readLine();
        }

        System.out.println("import javax.persistence.*;\n");
        System.out.println("@Entity\n"+"@Table(name = "+"\""+tableName+"\""+")");
        System.out.println("public class "+className+" {");

        for (String field : fields) {
            System.out.println(field);
        }

        for (String s : getNdSet) {
            System.out.println(s);
        }

        System.out.println("}");
    }




}
