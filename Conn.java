
package asimulatorsystem;
import java.sql.*;
/**
 *
 * @author RUSIRAJSINH
 */
public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","");
            s = c.createStatement();
            
        } catch (Exception e) {
            System.out.println(e);
            
        }
        
            
            
        
        
    }
    
    }

   
    

