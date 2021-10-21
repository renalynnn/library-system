 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author N N
 */
public class db {
     private static String servername = "localhost";
    private static String username = "root";
    private static String dbname = "test";
    private static Integer portnumber = 3306;
    private static String password = "";
    
    public static Connection getConnection ()
    {
       Connection connection = null;
      
       MysqlDataSource datasource = new MysqlDataSource();
       
       
       datasource.setServerName(servername);
       datasource.setUser(username);
       datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
         datasource.setPassword(password);
        
         try {
             connection = (Connection) datasource.getConnection();
         } catch (SQLException ex) {
             Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
         }
         
       
       
       return connection; 
    }
}
