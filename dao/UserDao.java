package dao;
import java.sql.*;
import model.User;
import util.DBConnection;

public class UserDao {
    

    public boolean register(User user){
        String sql = "INSERT INTO users  VALUES(?,?,?,?)";
        try (Connection con = DBConnection.getConnection(); 
              PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getEmail()); 
                ps.setString(4, user.getRole());

                return ps.executeUpdate() >0;
            
        } catch (SQLException e) {
              System.out.println("Registeration failed:"+ e.getMessage());
              return false;
        }

    }

    public String login(String username, String password){
        String sql = "SELECT role from users where username =? AND password =?";

        try(Connection con = DBConnection.getConnection(); 
              PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet rs  = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("role");
                    
                }

            
        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
        }
        return null;
    }


}
