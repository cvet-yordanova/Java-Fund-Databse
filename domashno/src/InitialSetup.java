import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialSetup {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        String createQuery = "CREATE DATABASE minions_db";
        String useQuery = "USE minions_db;";
        String createMinionTableQuery = "CREATE TABLE minions ( "+
                "minion_id int AUTO_INCREMENT  PRIMARY KEY, "+
                "name VARCHAR(50), "+
                "age INT, " +
                "town_id INT, " +
                "CONSTRAINT fk_minions_towns FOREIGN KEY (town_id) REFERENCES towns(town_id));";

        String createTownsTableQuery = "CREATE TABLE towns ( "+
                "town_id int PRIMARY KEY AUTO_INCREMENT, "+
                "name VARCHAR(50), "+
                "country VARCHAR(50))";

        String createTableVillainsQuery = "CREATE TABLE villains ( "+
                "villain_id int PRIMARY KEY AUTO_INCREMENT, "+
                "name VARCHAR(200), "+
                "evilnessFactor VARCHAR(15)); ";

        String createVillains_minionsTableQuery = "CREATE TABLE villains_minions ( "+
                "villain_id INT, "+
                "minion_id INT, "+
                "CONSTRAINT pk_villains_minions PRIMARY KEY (villain_id, minion_id), "+
                "CONSTRAINT fk_villains_minions_villains FOREIGN KEY (villain_id) REFERENCES villains(villain_id), "+
                "CONSTRAINT fk_villains_minions_minions FOREIGN KEY (minion_id) REFERENCES minions(minion_id))";

        String insertMinionsQuery = "INSERT INTO minions(name, age, town_id) "+
                "VALUES ('Bob',13,1),('Kevin',14,3),('Steward', 19, 2), ('Simon',22, 4 ), ('Mel', 13, 1);";
        String insertVillainsQuery = "INSERT INTO villains(name, evilnessFactor) "+
                "VALUES ('Grue','good'),('Ivo','bad'),('John', 'evil'), ('Jen', 'bad'), ('Horse', 'super evil');";
        String isertTownsQuery = "INSERT INTO towns (name, country) "+
                "VALUES ('Bobovdol', 'Madagaskar'), ('Dolni dybnik', 'BG'), ('Dupnica', 'BG'), ('Karaisen', 'Paris'), ('Polski trymbesh', 'USA')";
        String insertVillainsMinions = "INSERT INTO villains_minions(villain_id, minion_id) "+
                "VALUES (1, 2),(2, 3),(1, 4), (3, 2), (3, 4)";


        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement(); )
        {
            statement.executeUpdate(createQuery);
            statement.executeQuery(useQuery);
            statement.executeUpdate(createTownsTableQuery);
            statement.executeUpdate(createMinionTableQuery);
            statement.executeUpdate(createTableVillainsQuery);
            statement.executeUpdate(createVillains_minionsTableQuery);
            statement.executeUpdate(isertTownsQuery);
            statement.executeUpdate(insertMinionsQuery);
            statement.executeUpdate(insertVillainsQuery);
            statement.executeUpdate(insertVillainsMinions);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
