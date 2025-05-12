
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    
    JButton rec,ad;
    
    Dashboard(){
        
        super("HOTEL MANAGEMENT SYSTEM");
        setBounds(0,0,1550,1000);// 1550 1000
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/gg.gif"));
        Image i2=i1.getImage().getScaledInstance(1550,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,700);
        add(image);
        
        JLabel text=new JLabel("THE TAJ GROUP WELCOME YOU");
        text.setBounds(300,50,1000,50);
        text.setFont(new Font("tahona",Font.BOLD,46));
         text.setForeground(Color.WHITE);      
        image.add(text);
        
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/res.jpeg"));
        Image i8=i7.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel image2=new JLabel(i9);
        image2.setBounds(400,330,200,195);
        image.add(image2);
        
        rec=new JButton("RECEPTION");
        rec.setBounds(430,540,140,38);
        rec.setFont(new Font("tahona",Font.BOLD,15));
        rec.setBackground(Color.DARK_GRAY);
        rec.setForeground(Color.WHITE);//new(255,98,0
        rec.addActionListener(this);
        image.add(rec);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/ad.jpeg"));
        Image i5=i4.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image1=new JLabel(i6);
        image1.setBounds(780,330,200,195);
        image.add(image1);
        
        ad=new JButton("ADMIN");
        ad.setBounds(800,540,140,38);
        ad.setFont(new Font("tahona",Font.BOLD,15));
        ad.setBackground(Color.DARK_GRAY);
        ad.setForeground(Color.WHITE);
        ad.addActionListener(this);
        image.add(ad);
        
        
        
        /*JMenuBar nb=new JMenuBar();
        nb.setBounds(0,0,1550,30);
        image.add(nb);
        
        JMenu hotel=new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        nb.add(hotel);
        
        JMenuItem reception=new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        nb.add(admin);
      
        JMenuItem addemployee=new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms=new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem adddrivers=new JMenuItem("ADD DRIVERS");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);*/
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
      if (ae.getSource()==ad){
            new Login2();
            //setVisible(false);
        } /*else if (ae.getActionCommand().equals("ADD ROOMS")) {
             new AddRooms();
           
    } else if (ae.getActionCommand().equals("ADD DRIVERS")){
        new AddDriver();
       } */ else if(ae.getSource()==rec){
           new Reception();
       }
    }
    public static void main(String[] args){
        new Dashboard();
        
    }
    
   
}
    

 
