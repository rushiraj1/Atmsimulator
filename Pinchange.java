
package asimulatorsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



/**
 *
 * @author RUSIRAJSINH
 */
public class Pinchange  extends JFrame implements ActionListener {
    JButton change,back;
    JPasswordField pin1,repin;
    String pin;
    Pinchange(String pin){
        this.pin = pin;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("asimulatorsystem\\atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);
            
            JLabel text = new JLabel("CHANGE YOUR PIN");
            text.setForeground(Color.white);
            text.setFont(new Font("Railway",Font.BOLD,16));
            text.setBounds(250,280,500,35);
            image.add(text);
            
            JLabel pintext = new JLabel("NEW PIN");
            pintext.setForeground(Color.white);
            pintext.setFont(new Font("Railway",Font.BOLD,16));
            pintext.setBounds(165,320,100,25);
            image.add(pintext);
            
            pin1 = new JPasswordField();
            pin1.setFont(new Font("Railway",Font.BOLD,16));
            pin1.setBounds(330,320,180,25);
            image.add(pin1);
            
            JLabel repintext = new JLabel("Enter AGAIN");
            repintext.setForeground(Color.white);
            repintext.setFont(new Font("Railway",Font.BOLD,16));
            repintext.setBounds(165,360,100,25);
            image.add(repintext);
            
            repin = new JPasswordField();
            repin.setFont(new Font("Railway",Font.BOLD,16));
            repin.setBounds(330,360,180,25);
            image.add(repin);
            
            change = new JButton("Change");
            change.setBounds(355,485,150,30);
            change.addActionListener(this);
            image.add(change);
            
            back = new JButton("Back");
            back.setBounds(355,520,150,30);
            back.addActionListener(this);
            image.add(back);
            
            setSize(900,900);
            setLocation(300,0);
            setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            String npin = pin1.getText();
            String rpin = repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource()==change){
                if (pin1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (repin.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                Conn c = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin ='"+pin+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"'";
                String q3 = "update signupthree set pin = '"+rpin+"' where pin ='"+pin+"' ";

                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                c.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
            }else if(ae.getSource()==back){
                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    } 
    
    public static void main(String args[]) {
       new Pinchange("").setVisible(true);
    }
}
