/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Acer
 */
public class users {
    


    public boolean login(String username, String pass) {
        boolean accountVerified = false;
        Connection conn = db.getConnection();
        String query = "SELECT * FROM users where username='" + username + "' and password='" + pass + "'";
        System.out.println(query);
        
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                accountVerified = true;
                System.out.println("Account is verified!");
            } else {
                System.out.println("Account was not found");
            }

        } catch (SQLException e) {
            System.out.println("Failed to execute database!" + e);
        }
        
        return accountVerified;
    }
}
