import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class AddMinions {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] minionsInfo = reader.readLine().split("\\s");
        String minionsName = minionsInfo[1];
        Integer minionsAge = Integer.parseInt(minionsInfo[2]);
        String townName = minionsInfo[3];

        String[] villainInfo = reader.readLine().split("\\s");
        String villainName = villainInfo[1];

        String selectTownQuery = "SElECT * FROM towns WHERE name = ?";
        String selectVillainQuery = "SELECT * FROM villains WHERE name = ?";
        String selectMinionsQuery = "SELECT * FROM minions WHERE name = ?";

        String insertTownQuery = "INSERT INTO towns(name) VALUE (?)";
        String insertVIllainQuery = "INSERT INTO villains(name,evilnessFactor) VALUE(?,'evil')";

        String insertMinionQuery = "INSERT INTO minions(name, age, town_id) VALUE(?,?,?)";
        String insertMapTableQuery = "INSERT INTO villains_minions(villain_id, minion_id) VALUE(?,?)";

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);
        ) {
            PreparedStatement townStatement = connection.prepareStatement(selectTownQuery);
            townStatement.setString(1, townName);
            ResultSet townResult = townStatement.executeQuery();


            if(!townResult.next()){
                PreparedStatement insertTownStatement = connection.prepareStatement(insertTownQuery);
                insertTownStatement.setString(1,townName);
                insertTownStatement.executeUpdate();
                System.out.printf("Town %s was added to the database.\n",townName);
                insertTownStatement.close();
            }
            int townId = 0;
            ResultSet townResultUpdated = townStatement.executeQuery();

            if(townResultUpdated.next()){
                townId = townResultUpdated.getInt("town_id");
            }
            townStatement.close();

            PreparedStatement selectVillainStatement = connection.prepareStatement(selectVillainQuery);
            selectVillainStatement.setString(1,villainName);

            ResultSet villainResult = selectVillainStatement.executeQuery();

            if(!villainResult.next()){
                PreparedStatement insertVillainStatement = connection.prepareStatement(insertVIllainQuery);
                insertVillainStatement.setString(1,villainName);
                insertVillainStatement.executeUpdate();
                System.out.printf("Villain %s was added to the database.\n", villainName);
                insertVillainStatement.close();
            }

            int villainId = 0;
            ResultSet villainResultUpdated = selectVillainStatement.executeQuery();
            if(villainResultUpdated.next()){
                villainId = villainResultUpdated.getInt("villain_id");
            }

            selectVillainStatement.close();

            PreparedStatement insertMinionStatement = connection.prepareStatement(insertMinionQuery);
            insertMinionStatement.setString(1,minionsName);
            insertMinionStatement.setInt(2,minionsAge);
            insertMinionStatement.setInt(3,townId);
            insertMinionStatement.executeUpdate();

            insertMinionStatement.close();

            PreparedStatement selectMinionStatement = connection.prepareStatement(selectMinionsQuery);
            selectMinionStatement.setString(1,minionsName);

            ResultSet minionResult = selectMinionStatement.executeQuery();
            int minionId = 0;
            if(minionResult.next()){
                minionId = minionResult.getInt("minion_id");
            }

            selectMinionStatement.close();

            PreparedStatement insertMapTableStatement = connection.prepareStatement(insertMapTableQuery);
            insertMapTableStatement.setInt(1,villainId);
            insertMapTableStatement.setInt(2,minionId);
            insertMapTableStatement.executeUpdate();
            System.out.printf("Successfully added %s to be minion of %s\n",minionsName, villainName);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
