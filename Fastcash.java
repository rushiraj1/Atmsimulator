
package asimulatorsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author RUSIRAJSINH
 */
public class Fastcash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pin;
    
    Fastcash(String pin){
            this.pin = pin;
            setLayout(null);
          
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("asimulatorsystem\\atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);
            
            JLabel text = new JLabel("Please Select Amount To Withdrawl ");
            text.setBounds(210,300,700,35);
            text.setForeground(Color.white);
            text.setFont(new Font("Railway",Font.BOLD,16));
            image.add(text);
            
            deposit = new JButton("RS 100");
            deposit.setBounds(170,420,150,30);
            deposit.addActionListener(this);
            image.add(deposit);
            
            withdrawl = new JButton("RS 500");
            withdrawl.setBounds(355,420,150,30);
            withdrawl.addActionListener(this);
            image.add(withdrawl);
            
            fastcash = new JButton("RS 1000");
            fastcash.setBounds(170,450,150,30);
            fastcash.addActionListener(this);
            image.add(fastcash);
            
            ministatement = new JButton("RS 2000");
            ministatement.setBounds(355,450,150,30);
            ministatement.addActionListener(this);
            image.add(ministatement);
            
            pinchange = new JButton("RS 5000");
            pinchange.setBounds(170,480,150,30);
            pinchange.addActionListener(this);
            image.add(pinchange);
            
            balanceenquiry = new JButton("RS 10000");
            balanceenquiry.setBounds(355,480,150,30);
            balanceenquiry.addActionListener(this);
            image.add(balanceenquiry);
            
            exit = new JButton("Back");
            exit.setBounds(270,520,150,30);
            exit.addActionListener(this);
            image.add(exit);
            
            setSize(900,900);
            setLocation(300,0);
            setVisible(true);
        }
     
            public void actionPerformed(ActionEvent ae){
                if (ae.getSource()== exit){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else{
                     try {
                        String amount =((JButton) ae.getSource()).getText().substring(3);
                        Conn c = new Conn();
                       
                            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
                            int balance = 0;
                            while(rs.next()){
                    if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }   String num = "17";
                       if(ae.getSource() != exit && balance <Integer.parseInt(amount) ){
                           JOptionPane.showMessageDialog(null, "Insufficiant Balance");
                           return;
                       }
                       Date date = new Date();
                       String query = ("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                       c.s.executeUpdate(query);
                       JOptionPane.showMessageDialog(null, "Rs" +amount+ " Debited Successfully");
                            setVisible(false);
                            new Transactions(pin).setVisible(true);
                     
                    } catch (Exception e) {
                            
                             e.printStackTrace();
                    }
                }
            
            }
    public static void main(String args[]) {
       new Fastcash("");
    }
}
