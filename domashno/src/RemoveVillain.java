import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class RemoveVillain {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int villain_id = Integer.parseInt(reader.readLine());

        String deleteFromMapTable = "DELETE FROM villains_minions WHERE villain_id = ?";
        String deleteFromVillainsTable = "DELETE from villains WHERE villain_id = ?";
        String selectVillain = "SELECT * FROM villains WHERE villain_id = ?";

        try(
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                ) {

            PreparedStatement selectVillainStatement = connection.prepareStatement(selectVillain);
            selectVillainStatement.setInt(1, villain_id);

            ResultSet villainResult = selectVillainStatement.executeQuery();

            if(villainResult.next()){

                String villainName = villainResult.getString("name");
                PreparedStatement deleteFromMapTableStatement = connection.prepareStatement(deleteFromMapTable);
                deleteFromMapTableStatement.setInt(1,villain_id);
                int minionsCount = deleteFromMapTableStatement.executeUpdate();
                deleteFromMapTableStatement.close();


                PreparedStatement deleteFromVillainsStatement = connection.prepareStatement(deleteFromVillainsTable);
                deleteFromVillainsStatement.setInt(1, villain_id);
                deleteFromVillainsStatement.executeUpdate();
                deleteFromVillainsStatement.close();

                System.out.printf("Villain %s was deleted.\n",villainName);
                System.out.printf("%d minions were released.\n",minionsCount);

            }
            else {
                System.out.println("No such villain was found");
            }

            selectVillainStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
