
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame //implements ActionListener 
{

    HotelManagementSystem(){
        setSize(1366,565);
        setLocation(2,90);
        
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/ff1.png"));
        JLabel image= new JLabel(i1);
        image.setBounds(0,0,1366,565);
                add(image);
                 
             JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
             text.setBounds(400,1,1000,90);
             text.setForeground(Color.WHITE);
             text.setFont(new Font("Dialog",Font.PLAIN,40));
             image.add(text);
             
             
            /* JButton next=new JButton("Next");
             next.setBounds(1140,480,120,50);
             next.setBackground(Color.WHITE);
             next.setForeground(Color.BLACK);
             next.addActionListener(this);
             next.setFont(new Font("Serif",Font.BOLD,20));
             image.add(next);*/
             
            
                
                
                setVisible(true);
               /* while(true) {
                   text.setVisible(false);
                   try {
                       Thread.sleep(500);
                     }  catch (Exception e) {
                         e.printStackTrace();
                     }
                     text.setVisible(true);
                     try {
                       Thread.sleep(500);
                     }  catch (Exception e) {
                         e.printStackTrace();
                     }*/
               
                     try {
                       Thread.sleep(2000);
                       new Login();
                       setVisible(false);
                     }  catch (Exception e) {
                         e.printStackTrace();
                     }
                     
    }
              
    
     /*public void actionPerformed(ActionEvent ae ){
             new Login();
         
     }*/
      
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
