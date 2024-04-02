
package asimulatorsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author RUSIRAJSINH
 */
public class Login extends JFrame implements ActionListener {
        
    JButton login,signup,clear;
    JTextField cardnoTextField;
    JPasswordField pinTextField;
    
   Login(){
   
       
       setTitle("AUTOMATED TELLER MACHINE");
       setLayout(null);
       
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("asimulatorsystem\\icons\\logo.jpg"));
       Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel label = new JLabel(i3);
       label.setBounds(70,10,100,100);
       add(label);
       
       JLabel text = new JLabel("Welcome to ATM");
       text.setFont(new Font("Osward", Font.BOLD ,30));
       text.setBounds(200,40,400,40);
       add(text);
       
       JLabel cardno = new JLabel("Card No:");
       cardno.setFont(new Font("Raleway", Font.BOLD ,30));
       cardno.setBounds(120,150,150,30);
       add(cardno);
       
       cardnoTextField = new JTextField();
       cardnoTextField.setBounds(300,150,230,30);
       cardnoTextField.setFont(new Font("Arial",Font.BOLD,14));
       add(cardnoTextField);
       
       JLabel pin = new JLabel("PIN:");
       pin.setFont(new Font("Raleway", Font.BOLD ,30));
       pin.setBounds(120,220,250,30);
       add(pin);
       
       pinTextField = new JPasswordField();
       pinTextField.setBounds(300,220,230,30);
       pinTextField.setFont(new Font("Arial",Font.BOLD,14));
       add(pinTextField);
       
       login = new JButton("SIGN IN");
       login.setBounds(300,300,100,30);
       login.setBackground(Color.black);
       login.setForeground(Color.white);
       login.addActionListener( this);
       add(login);
       
       clear = new JButton("CLEAR");
       clear.setBounds(430,300,100,30);
       clear.setBackground(Color.black);
       clear.setForeground(Color.white);
       clear.addActionListener( this);
       add(clear);
       
       signup  = new JButton("SIGN UP");
       signup.setBounds(300,350,230,30);
       signup.setBackground(Color.black);
       signup.setForeground(Color.white);
       signup.addActionListener( this);
       add(signup);
       
       
       getContentPane().setBackground(Color.white);
       setSize(800,480);
       setVisible(true);
       setLocation(350,200);
       
      
   
   }
   public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==clear){
            cardnoTextField.setText("");
            pinTextField.setText("");  
           } else if (ae.getSource() == login){
           Conn c = new Conn();
           
           String cardno  =  cardnoTextField.getText();
           String pin  =  pinTextField.getText();
           String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";

           ResultSet rs = c.s.executeQuery(q);
           if(rs.next()){
           setVisible(false);
           new Transactions(pin).setVisible(true);
           }else{
               JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
           }
            }else if(ae.getSource()==login){
                cardnoTextField.setText("");
                pinTextField.setText("");
            }else if(ae.getSource()==signup){
                setVisible(false);
                new Signupone().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
   
   }
   
   
    public static void main(String args[]) {
       new Login();
    }
}
