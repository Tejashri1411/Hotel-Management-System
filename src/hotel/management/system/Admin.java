
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Admin extends JFrame implements ActionListener {
    
    JButton addemp,adddriver,addroom,back;
    
    Admin(){
        addroom=new JButton("ADD ROOMS");
        addroom.setForeground(Color.BLACK);
        addroom.setBackground(Color.WHITE);
        addroom.setBounds(400,70,160,30);
        addroom.setFont(new Font("Tahona",Font.BOLD,15));
        addroom.addActionListener(this);
        add(addroom);
        
        addemp=new JButton("ADD EMPLOYEE");
        addemp.setForeground(Color.BLACK);
        addemp.setBackground(Color.WHITE);
        addemp.setBounds(400,200,160,30);
        addemp.setFont(new Font("Tahona",Font.BOLD,13));
        addemp.addActionListener(this);
        add(addemp);
        
        adddriver=new JButton("ADD DRIVERS");
        adddriver.setForeground(Color.BLACK);
        adddriver.setBackground(Color.WHITE);
        adddriver.setBounds(400,320,160,30);
        adddriver.setFont(new Font("Tahona",Font.BOLD,15));
        adddriver.addActionListener(this);
        add(adddriver);
        
        back=new JButton("BACK");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setBounds(280,460,130,30);
        back.setFont(new Font("Tahona",Font.PLAIN,15));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/rr.jpg"));
        Image i2=i1.getImage().getScaledInstance(190,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(120,50,190,100);
        add(image);
        
         ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/ee.jpg"));
        Image i5=i4.getImage().getScaledInstance(190,100,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image1=new JLabel(i6);
        image1.setBounds(120,170,190,100);
        add(image1);
        
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i8=i7.getImage().getScaledInstance(190,100,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel image2=new JLabel(i9);
        image2.setBounds(120,290,190,100);
        add(image2);
        
        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setBounds(270,100,700,550);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() ==addroom){
            new AddRooms();
        } else if(e.getSource() ==addemp){
             new AddEmployee();     
    } else if(e.getSource() ==adddriver){
        new AddDriver();
       } else if(e.getSource() ==back){
        new Dashboard();
        setVisible(false);
    }
        
    }
    public static void main(String[] args){
        new Admin();
    }
}
