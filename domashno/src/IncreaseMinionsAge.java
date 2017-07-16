import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class IncreaseMinionsAge {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s");

        String updateMinionsQuery = "UPDATE minions AS m\n" +
                "SET \tm.age = m.age+1,\n" +
                "\t\tm.name = CONCAT(UPPER(SUBSTRING(m.name,1,1)),SUBSTRING(m.name,2))\n" +
                "WHERE m.minion_id = ?;";
        String selectMinionsQuery = "SELECT m.name, m.age\n" +
                "FROM minions as m;";

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            for (int i = 0; i < input.length; i++) {
                int minionId = Integer.parseInt(input[i]);

                PreparedStatement updateMinionStatement = connection.prepareStatement(updateMinionsQuery);
                updateMinionStatement.setInt(1,minionId);
                updateMinionStatement.executeUpdate();
                updateMinionStatement.close();

            }

            Statement selectFromMinionsStatement = connection.createStatement();
            ResultSet result = selectFromMinionsStatement.executeQuery(selectMinionsQuery);

            ResultSetMetaData data =result.getMetaData();
            int countColumns = data.getColumnCount();

            while(result.next()){

                for (int i = 1; i <= countColumns; i++) {
                    System.out.print(result.getString(i)+" ");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
