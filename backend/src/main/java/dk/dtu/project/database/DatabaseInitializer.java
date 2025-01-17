import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // read file schema.sql
            String schema = new String(Files.readAllBytes(Paths.get("src/main/resources/db/schema.sql")));

            //Execute SQL command
            Statement stmt = connection.createStatement();
            stmt.execute(schema);

            System.out.println("The table structure has been created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
