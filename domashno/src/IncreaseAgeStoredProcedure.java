import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class IncreaseAgeStoredProcedure {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int id = Integer.parseInt(reader.readLine());

        String uspGetOlder = "{ CALL usp_get_older(?)}";
        String selectMinion = "SELECT m.name, m.age FROM minions as m WHERE m.minion_id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
          PreparedStatement callProcedure = connection.prepareStatement(uspGetOlder);

            callProcedure.setInt(1,id);
            callProcedure.executeUpdate();

            PreparedStatement selectMinionStatement = connection.prepareStatement(selectMinion);
            selectMinionStatement.setInt(1, id);
            ResultSet result = selectMinionStatement.executeQuery();

            if(result.next()) {
                String nameMinion = result.getString("name");
                int minionAge = result.getInt("age");
                System.out.println(nameMinion+" "+minionAge);
            }

            selectMinionStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
