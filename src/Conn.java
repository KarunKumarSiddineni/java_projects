import java.sql.*;

public class Conn{
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/atm2_schema";
        String user = "root";
        String password = "Prabhu@123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
        }
        Connection con = DriverManager.getConnection(url, user, password);
        
        System.out.println(con);
    }

}
