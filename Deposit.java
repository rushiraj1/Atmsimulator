
package asimulatorsystem;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author RUSIRAJSINH
 */
public class Deposit extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton deposit,back;
    String pin;
    
    Deposit(String pin){
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("asimulatorsystem\\atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter Amount You Want To Deposit");
        text.setForeground(Color.white );
        text.setFont(new Font("Railway",Font.BOLD,14));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Railway",Font.BOLD,22));
        amount.setBounds(170,330,320,25);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(355,480,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
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
             if(ae.getSource()==deposit){
            String number = amount.getText();
            Date date = new Date();
           
            if(amount.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
          }else{
                
                Conn c = new Conn();
                String query = ("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+number+"')");
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+number+" Deposited Successfully");
                setVisible(false);
                new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
      new Deposit("").setVisible(true);
    }

}
