import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class GetMinionsNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int villain_id = Integer.parseInt(reader.readLine());

        String selectVillainQuery = "SELECT * FROM villains\n" +
                "WHERE villain_id = ?;";
        String selectMinionsServingGivenVillain = "SELECT m.name, m.age\n" +
                "  FROM minions as m\n" +
                "WHERE m.minion_id in\t\t\n" +
                "\t\t\t\t(SELECT minion_id\n" +
                "\t\t\t\t   FROM  villains_minions AS v\n" +
                "\t\t\t\t  WHERE v.villain_id = ?);";


        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        ) {
            PreparedStatement selectVillainStatement = connection.prepareStatement(selectVillainQuery);
            selectVillainStatement.setInt(1,villain_id);
            ResultSet selectVillainResult = selectVillainStatement.executeQuery();
            if(!selectVillainResult.next()){
                System.out.printf("No villain with ID %d exists in the database.",villain_id);
                return;
            }

            String nameVillain = "";
            if(selectVillainResult.next()){
                nameVillain = selectVillainResult.getString("name");
            }

            PreparedStatement selectMinionsStatement = connection.prepareStatement(selectMinionsServingGivenVillain);
            selectMinionsStatement.setInt(1, villain_id);
            ResultSet resultMinionsStatement = selectMinionsStatement.executeQuery();



            ResultSetMetaData data = resultMinionsStatement.getMetaData();

            int columnsMinionsResultCount = data.getColumnCount();
            System.out.println("Villain: "+nameVillain);
         //   System.out.println(columnsMinionsResultCount);
            int idx = 1;

            while(resultMinionsStatement.next()){
                System.out.print(idx+". ");

                for (int i = 1; i <= columnsMinionsResultCount; i++) {
                    String value = resultMinionsStatement.getString(i);
                    System.out.print(value+" ");

                }
                idx++;
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
