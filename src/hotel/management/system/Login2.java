
package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login2 extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    
    Login2(){
        
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
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
        
         setBounds(400,240,600,300);
         setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == login) {
            String user=username.getText();
            String pass=password.getText();
            
                     try  {
                 Conn c=new Conn();
                 
                 String query="select * from login2 where username='"+user+"'and password='"+pass+"'";
                 
                 ResultSet rs=c.s.executeQuery(query);
                 
                 if (rs.next()){
                     setVisible(false);
                     new Admin();
                 } else {
                      JOptionPane.showMessageDialog(null,"Invalid username or password");
                      //setVisible(false);
                 }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
         } else if (ae.getSource()  == cancel) {
            setVisible(false);
            new Dashboard();
        } 
    }
    
    public static void main(String[] args){
        new Login2();
        
    }
    
}
