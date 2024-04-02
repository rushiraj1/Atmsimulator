
package asimulatorsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author RUSIRAJSINH
 */
public class Ministatement extends JFrame implements ActionListener{
    String pin;
    Ministatement(String pin){
    this.pin = pin; 
        setTitle("Mini Statement");
        setLayout(null);
 
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel cardno =  new JLabel();
        cardno.setBounds(20,82,300,20);
        add(cardno);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login where pin = '"+pin+"'");
            while(rs.next()){
            cardno.setText("cardno ="+ rs.getString("cardno").substring(0,4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        try {
            int bal = 0;
            Conn c  = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your total Balance is Rs "+bal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);    
    }
     public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String args[]) {
        new Ministatement("").setVisible(true);
        
    }
}
