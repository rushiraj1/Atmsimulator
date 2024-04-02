
package asimulatorsystem;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
/**
 *
 * @author RUSIRAJSINH
 */
public class Withdrawl extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton withdraw,back;
    String pin;
    
    Withdrawl(String pin){
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("asimulatorsystem\\atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter Amount You Want To Withdrawl");
        text.setForeground(Color.white );
        text.setFont(new Font("Railway",Font.BOLD,14));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Railway",Font.BOLD,22));
        amount.setBounds(170,330,320,25);
        image.add(amount);
        
        withdraw = new JButton("withdraw");
        withdraw.setBounds(355,480,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(170,480,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
      public void actionPerformed(ActionEvent ae){
        try{        
            String number = amount.getText();
            Date date = new Date();
            if(ae.getSource()==withdraw){
                if(amount.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c = new Conn();
                    
                    ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(number)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+number+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

    
    
    public static void main(String[] args){
        new Withdrawl("").setVisible(true);
    }
}


