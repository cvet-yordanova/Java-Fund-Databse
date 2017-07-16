import java.sql.*;

public class GetVillainsNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        String getVillainsNames = "SELECT v.name, villain_minions.count_minions as minions_c\n" +
                "FROM   villains as v\n" +
                "LEFT JOIN \n" +
                "\t\t(SELECT    v.villain_id, COUNT(v.minion_id) AS count_minions\n" +
                "\t\tFROM \t    villains_minions as v\n" +
                "\t\tGROUP BY  v.villain_id\n" +
                "\t\tHAVING count_minions > 3) AS villain_minions\n" +
                "ON v.villain_id = villain_minions.villain_id\n" +
                "ORDER BY minions_c DESC;";


        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement(); )
        {

            ResultSet rs = statement.executeQuery(getVillainsNames);
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = rs.getString(i);
                   System.out.print(columnValue + " ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
