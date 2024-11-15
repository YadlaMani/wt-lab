import java.sql.*;

class DML {
    public static void main(String[] args){
         String url = "jdbc:mysql://127.0.0.1:3306/demo";
        String username = "root";
        String password = "5002@hsakA";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement st=conn.createStatement();
            PreparedStatement st1=conn.prepareStatement("Insert into stud values(?)");
            st1.setString(1,"Vishal");
            st1.executeUpdate();
            ResultSet rs=st.executeQuery("Select * from stud");
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            st.executeUpdate("Delete from stud where demo='Vishal'");
            rs=st.executeQuery("Select * from stud");
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
           


            while(rs.next()){
                System.out.println(rs.getString(1));
            }

            

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}