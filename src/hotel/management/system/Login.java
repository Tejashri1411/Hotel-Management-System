
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    
    JTextField username;
    JPasswordField password,p;
    JButton login,cancel;
    JCheckBox ch1;
  
    Login() {
      getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        JLabel User=new JLabel("Username");
        User.setBounds(40,20,100,30);
        add(User);
        
         username=new JTextField();
        username.setBounds(150,20,150,30);
        add(username);
        
        JLabel pass=new JLabel("Password");
        pass.setBounds(40,80,100,30);
        add(pass);
        
         password=new JPasswordField ();
        password.setBounds(150,80,150,30);
        add(password);
        
        login=new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
         cancel=new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
       /* ch1=new JCheckBox("Show Password");
        ch1.setBounds(30,100,130,30);
        getContentPane().add(ch1);
        ch1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(ch1.isSelected()){
            p.setEchoChar((char)0);
        }else{
            p.setEchoChar('*');
        }
            }
        });
        
        p=new JPasswordField();
        p.setBounds(150,100,150,30);
        getContentPane().add(p);   */
        
        
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
        
         setBounds(500,200,600,300);
         setVisible(true);
    }   
        public void actionPerformed(ActionEvent ae)
        {
            if (ae.getSource() == login) {
            String user=username.getText();
            String pass=password.getText();
         
            
            try  {
                 Conn c=new Conn();
                 
                 
                 String query="select * from login where username='"+user+"'and password='"+pass+"'";
                 
                 ResultSet rs=c.s.executeQuery(query);
                 
                 if (rs.next()){
                     setVisible(false);
                     Dashboard dash=new Dashboard();
                     dash.show();
                   
                 } else {
                      JOptionPane.showMessageDialog(null,"Invalid username or password");
                      //setVisible(false);
                 }
                 
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            
            
         } else if (ae.getSource()  == cancel) {
            setVisible(false);
        }
            
        }
        
        
         public static void main(String[] args) {
          new Login();
         
          
           
    } 
        
}
