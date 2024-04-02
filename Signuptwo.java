
package asimulatorsystem;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author RUSIRAJSINH
 */
public class Signuptwo extends JFrame implements ActionListener {
    
    
    
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,occupation,education,income;
    String random;

    
     Signuptwo (String random){
   
    
           this.random = random;
           setLayout(null);
          
           setTitle("New Account Application Form - Page 2 ");
           
           JLabel additionaldetails = new JLabel("Page 2 : Additional Details");
           additionaldetails.setFont (new Font("Raleway",Font.BOLD,22));
           additionaldetails.setBounds(230,80,400,30);
           add(additionaldetails);
           
           JLabel Religion = new JLabel("Religion :");
           Religion.setFont (new Font("Raleway",Font.BOLD,20));
           Religion.setBounds(100,140,100,30);
           add(Religion);
           
           String religion1[] ={"HINDU","MUSLIM","SIKH","CHRISTIAN","others"}; 
           religion = new JComboBox(religion1);
           religion.setBounds(300,140,400,30);
           religion.setBackground(Color.white);
           add(religion);
           
           JLabel Category = new JLabel("Category :");
           Category.setFont (new Font("Raleway",Font.BOLD,20));
           Category.setBounds(100,190,200,30);
           add(Category);
           
           String category1[] ={"GENRAL","OBC","SC","ST","others"}; 
           category = new JComboBox(category1);
           category.setBounds(300,190,400,30);
           category.setBackground(Color.white);
           add(category);
           
           
           JLabel Income = new JLabel("Income :");
           Income.setFont (new Font("Raleway",Font.BOLD,20));
           Income.setBounds(100,240,200,30);
           add(Income);
           
           String income1[] ={"NULL","< 1,50,000","<2,50,000","<5,00,000","Up to 10,00,000"}; 
           income= new JComboBox(income1);
           income.setBounds(300,240,400,30);
           income.setBackground(Color.white);
           add(income);
                      
           
           JLabel Educational = new JLabel("Educational  ");
           Educational.setFont (new Font("Raleway",Font.BOLD,20));
           Educational.setBounds(100,290,400,30);
           add(Educational);
           
            
           JLabel Qualification = new JLabel("Qualification : ");
           Qualification.setFont (new Font("Raleway",Font.BOLD,20));
           Qualification.setBounds(100,315,200,30);
           add(Qualification);
           
           String educationalvalues[] ={"Non-Graduation","Graduaction","Post-Graduaction","Phd","Others"}; 
           education= new JComboBox(educationalvalues);
           education.setBounds(300,315,400,30);
           education.setBackground(Color.white);
           add(education);
           
           JLabel Occupation = new JLabel("Occupation : ");
           Occupation.setFont (new Font("Raleway",Font.BOLD,20));
           Occupation.setBounds(100,390,200,30);
           add(Occupation);
           
           String occupationvalues[] ={"Salaried","Self Employed","Buisnessman","Student","Retired","Others"}; 
           occupation = new JComboBox(occupationvalues);
           occupation.setBounds(300,390,400,30);
           occupation.setBackground(Color.white);
           add(occupation);
           
      
           JLabel pan = new JLabel("Pan Number :  ");
           pan.setFont (new Font("Raleway",Font.BOLD,20));
           pan.setBounds(100,440,200,30);
           add(pan);
           
           panTextField = new JTextField();
           panTextField.setFont(new Font("Raleway",Font.BOLD,14));
           panTextField.setBounds(300,440,400,30);
           add(panTextField);
            
            
           JLabel aadharNumber= new JLabel("Aadhar Number : ");
           aadharNumber.setFont (new Font("Raleway",Font.BOLD,20));
           aadharNumber.setBounds(100,490,200,30);
           add(aadharNumber);
           
           aadharTextField = new JTextField();
           aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
           aadharTextField.setBounds(300,490,400,30);
           add(aadharTextField);
            
           JLabel siniorcitizen = new JLabel("Sinior Citizen : ");
           siniorcitizen.setFont (new Font("Raleway",Font.BOLD,20));
           siniorcitizen.setBounds(100,540,200,30);
           add(siniorcitizen);
            
           syes = new JRadioButton("YES");
           syes.setBounds(300,540,100,30);
           syes.setBackground(Color.white);
           add(syes);
           
           sno = new JRadioButton("NO");
           sno.setBounds(450,540,100,30);
           sno.setBackground(Color.white);
           add(sno);
           
           
           ButtonGroup siniorgroup = new ButtonGroup();
           siniorgroup.add(syes);
           siniorgroup.add(sno);
           
           JLabel eaccount= new JLabel("Existing Account :");
           eaccount.setFont (new Font("Raleway",Font.BOLD,20));
           eaccount.setBounds(100,590,200,30);
           add(eaccount);
           
           eyes = new JRadioButton("YES");
           eyes.setBounds(300,590,100,30);
           eyes.setBackground(Color.white);
           add(eyes);
           
           eno = new JRadioButton("NO");
           eno.setBounds(450,590,100,30);
           eno.setBackground(Color.white);
           add(eno);
           
           
           ButtonGroup eaccount1 = new ButtonGroup();
           eaccount1.add(eyes);
           eaccount1.add(eno);
            
           
           JButton next = new JButton("NEXT");
           next.setBackground(Color.black);
           next.setForeground(Color.white);
           next.setFont(new Font("Raleway",Font.BOLD,14));
           next.setBounds(620, 660, 80, 30);
           next.addActionListener(this );
           add(next);
           
            
           getContentPane().setBackground(Color.white);
            
           setSize(850,800);
           setLocation(350,10);
           setVisible(true);
    
    }
    
        public void actionPerformed(ActionEvent ae){
            
      
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String siniorcitizen = null;
        if (syes.isSelected()){
           siniorcitizen = "YES";
        } else if (sno.isSelected()){
           siniorcitizen = "NO";
        }
        String eaccount = null;
        if (eyes.isSelected()){
           eaccount = "YES";
        } else if (eno.isSelected()){
           eaccount = "NO";
        } 
        
        String span = (String) panTextField.getText();
        String saadhar  = (String) aadharTextField.getText();
        
           try {
           
           Conn c = new Conn();
           String query = "insert into signuptwo values('"+this.random+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+siniorcitizen+"','"+eaccount+"','"+span+"','"+saadhar+"')";
           c.s.executeUpdate(query);
                
                setVisible(false);
                new Signupthree(random).setVisible(true);   
        } catch (Exception e) {
            System.out.println(e);
        }

        
    }
        
    
    public static void main(String args[]) {
       new Signuptwo("") {};
    }
    
}
