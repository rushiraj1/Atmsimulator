
package asimulatorsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author RUSIRAJSINH
 */
public class Balanceenquiry  extends JFrame implements ActionListener {
    
    JButton back;
    String pin;
    JLabel l1;
    
    Balanceenquiry(String pin){
        this.pin = pin;
        setLayout(null);
        
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("asimulatorsystem\\atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);
            
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
                            
          Conn c = new Conn();
          int balance = 0;
          try {              
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while(rs.next()){
            if (rs.getString("type").equals("Deposit")) {
             balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }   
                    } catch (Exception e) {
                            
                             e.printStackTrace();
                    }
        l1 = new JLabel("Your Current Balance Is Rs." + balance);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(170,300,400,30);
        image.add(l1);
            
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pin).setVisible(true);
       
    } 
    
    public static void main(String args[]) {
        new Balanceenquiry("").setVisible(true);
    }
}
