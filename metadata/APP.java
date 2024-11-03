import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
class APP{
    public static void main(String[] args) {
        String url="jdbc:mysql://127.0.01:2206/TEMP";
        String user="root";
        String password="1234";
        Connection connection=DriverManager.getConnection(url,user,password);
        DatabaseMetaData metaData=connection.getMetaData();
        System.out.println("Database product Name:"+metaData.getDatabaseProductName());
        System.out.println("Database product version:"+metaData.getDatabaseProductVersion());
        System.out.println("Dirver name:"+metaData.getDriverName());
        System.out.println("Driver version:"+metaData.getDriverVersion());
    }
}
