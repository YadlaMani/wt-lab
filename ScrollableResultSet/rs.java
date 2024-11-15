import java.sql.*;
public class rs {
    public static void main(String[] args) {
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","5002@hsakA")){
            Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
            ResultSet.CONCUR_READ_ONLY
);
            ResultSet rs=st.executeQuery("SELECT * FROM stud");
            
            if(rs.last()){
                System.out.println(rs.getString(1));
            }
            
            if(rs.first()){
                System.out.println(rs.getString(1));
            }
            if(rs.relative(2)){
                System.out.println(rs.getString(1));
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}