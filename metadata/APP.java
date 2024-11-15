import java.sql.*;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String username = "root";
        String password = "----";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Retrieve Database Metadata
            DatabaseMetaData metaData = conn.getMetaData();
            
            // Print general metadata information
            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
            System.out.println("Driver Name: " + metaData.getDriverName());
            System.out.println("Driver Version: " + metaData.getDriverVersion());

            // Get list of tables in the database
            System.out.println("\nList of Tables:");
            ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("- " + tableName);

                // For each table, retrieve and print its columns
                System.out.println("  Columns in table " + tableName + ":");
                ResultSet columns = metaData.getColumns(null, null, tableName, "%");
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    String columnType = columns.getString("TYPE_NAME");
                    int columnSize = columns.getInt("COLUMN_SIZE");
                    System.out.println("    - " + columnName + " (" + columnType + ", size: " + columnSize + ")");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}