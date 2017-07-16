import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrintAllMinionNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {

        List<String> minionsNames = new ArrayList<>();

        String selectMinionsQuery = "SELECT m.name FROM minions as m";

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            Statement selectMinionsStatement = connection.createStatement();
            ResultSet result = selectMinionsStatement.executeQuery(selectMinionsQuery);

            while(result.next()){
                minionsNames.add(result.getString("name"));
            }

            System.out.println(String.join(", ",minionsNames));

            for (int i = 0; i < minionsNames.size()/2; i++) {
                System.out.println(minionsNames.get(i));
                System.out.println(minionsNames.get(minionsNames.size()-1-i));
            }
            if(minionsNames.size()%2!=0){
                System.out.println(minionsNames.get(minionsNames.size()/2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
