import com.sun.xml.internal.ws.client.ContentNegotiation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class ChangeTownNamesCasing {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String country = reader.readLine();

        String changeNameOfTownsQuery = "UPDATE towns AS t\n" +
                "SET t.name = UPPER (t.name)\n" +
                "WHERE t.country = ?;";
        String selectTownsQuery = "SELECT t.name\n" +
                "FROM towns as t\n" +
                "WHERE t.country = ?;";
        try(
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                ) {

            PreparedStatement changeNameOfTownsStatement = connection.prepareStatement(changeNameOfTownsQuery);
            changeNameOfTownsStatement.setString(1,country);
            int affectedRows = changeNameOfTownsStatement.executeUpdate();

            System.out.println(affectedRows+" town names were affected.");

            PreparedStatement selectTowns = connection.prepareStatement(selectTownsQuery);
            selectTowns.setString(1, country);
            ResultSet result = selectTowns.executeQuery();

            ResultSetMetaData data = result.getMetaData();
            int countColumns = data.getColumnCount();
            String output = "";
            while(result.next()) {
                for (int i = 1; i <= countColumns; i++) {
                    output += (result.getString(i))+", ";
                }
            }

            System.out.print("["+output.substring(0,output.length()-2)+"]");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
