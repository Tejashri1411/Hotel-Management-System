
package hotel.management.system;
import javax.swing.*;
import java.awt.*;   // For colour class
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class Checkout extends JFrame implements ActionListener{
     
    Choice ccustomer;
    JLabel roomnumber,lblcheckinn,lblcheckoutt,lblamountt,lblname,lbltotall,lbldayss,lblpaidd;
    JButton Checkout,Back,Check;
    JTextField lblroomnumber,lblcheckin,lblcheckout,lbldays,lbltotal,lblpaid,lblamount;
    Checkout(){
        
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
      
      JLabel text=new JLabel("Checkout");
      text.setBounds(90,20,170,30);
      text.setForeground(Color.BLUE);
      text.setFont(new Font("Tahona",Font.BOLD,30));
      add(text);
      
      lblname=new JLabel("Name");
      lblname.setBounds(30,80,100,30);
      add(lblname);
      
       ccustomer=new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);
        
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("name"));
              // lblroomnumber.setText(rs.getString("room"));
               //lblcheckin.setText(rs.getString("checkintime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel tick=new JLabel(i3);
        tick.setBounds(310,80,20,20);
        add(tick);
       
        
        JLabel lblroom=new JLabel("Room Number");
      lblroom.setBounds(30,130,100,30);
      add(lblroom);
      
       lblroomnumber=new JTextField();
      lblroomnumber.setBounds(150,130,150,25);
      add(lblroomnumber);
      
        lblcheckinn=new JLabel("Checkin Time ");
      lblcheckinn.setBounds(30,180,100,30);
      add(lblcheckinn);
      
       lblcheckin=new JTextField();
      lblcheckin.setBounds(150,180,150,25);
      add(lblcheckin);
      
       lblcheckoutt=new JLabel("Checkout Time ");
      lblcheckoutt.setBounds(30,230,100,30);
      add(lblcheckoutt);
      
      SimpleDateFormat obj=new SimpleDateFormat("dd/MM/yyyy");
      Date date=new Date();
       lblcheckout=new JTextField();
       lblcheckout.setText(obj.format(date));
       
      lblcheckout.setBounds(150,230,150,25);
      add(lblcheckout);
      
      lbldayss=new JLabel("Total Days");
      lbldayss.setBounds(30,280,100,30);
      add(lbldayss);
      
      lbldays=new JTextField();
      lbldays.setBounds(150,280,150,25);
      add(lbldays);
      
      lbltotall=new JLabel("Total Amount");
      lbltotall.setBounds(30,330,100,30);
      add(lbltotall);
      
      lbltotal=new JTextField();
      lbltotal.setBounds(150,330,150,25);
      add(lbltotal);
      
      lblpaidd=new JLabel("Paid Amount");
      lblpaidd.setBounds(30,380,100,30);
      add(lblpaidd);
      
      lblpaid=new JTextField();
      lblpaid.setBounds(150,380,150,25);
      add(lblpaid);
      
       lblamountt=new JLabel("Pending Amount");
      lblamountt.setBounds(30,430,100,30);
      add(lblamountt);
      
      lblamount=new JTextField();
      lblamount.setBounds(150,430,150,25);
      add(lblamount);
      
        
      Check=new JButton("Check");
      Check.setBackground(Color.BLACK);
      Check.setForeground(Color.WHITE);
      Check.setBounds(10,470,100,30);
      Check.addActionListener(this);
      add(Check);
      
      Checkout=new JButton("Checkout");
      Checkout.setBackground(Color.BLACK);
      Checkout.setForeground(Color.WHITE);
      Checkout.setBounds(120,470,100,30);
      Checkout.addActionListener(this);
      add(Checkout);
      
      Back=new JButton("Back");
      Back.setBackground(Color.BLACK);
      Back.setForeground(Color.WHITE);
      Back.setBounds(230,470,120,30);
      Back.addActionListener(this);
      add(Back);
      
      /*try{
            Conn c=new Conn();
             //ccustomer.getSelectedItem();
            ResultSet rs=c.s.executeQuery("select * from customer where number='"+ccustomer.getSelectedItem()+"'");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckin.setText(rs.getString("checkintime"));
                lblamount.setText(rs.getString("deposit"));
                
            }
            ResultSet rs2=c.s.executeQuery("select * from room where roomnumber ='"+lblroomnumber.getText()+"'");
                while(rs2.next()){
                    String price=rs2.getString("price");
                    int amountpaid=Integer.parseInt(price)-Integer.parseInt(lblamount.getText());
                    lblamount.setText(""+amountpaid);
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        } */
      
                     
       ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(350,50,400,250);
        add(image);
      
        setBounds(300,100,800,550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==Checkout){
            String query1="delete from customer where number='"+ccustomer.getSelectedItem()+"'";
            String query2="update room set availability='Available' where roomnumber='"+lblroomnumber.getText()+"'";
            
              try {
                  Conn c=new Conn();
                  c.s.executeUpdate(query1);
                  c.s.executeUpdate(query2);
                  
                  JOptionPane.showMessageDialog(null,"Checkout Done");
                  
                  setVisible(false);
                  new Reception();
              }catch (Exception e) {
                  e.printStackTrace();
              }
              
            }
        if(ae.getSource()==Check){
            String name=ccustomer.getSelectedItem();
            String query="select * from customer where name='"+name+"'";
            try {
                Conn c=new Conn();
                ResultSet rs= c.s.executeQuery(query);
                while(rs.next()){
                    lblroomnumber.setText(rs.getString("room"));
                    lblcheckin.setText(rs.getString("checkintime"));
                     lblpaid.setText(rs.getString("deposit"));
                    
                }
              /* String dateBeforeString=rs.getString(7);
                SimpleDateFormat myformat=new SimpleDateFormat("lblcheckin");
                java.util.Date dateBefore=myformat.parse(dateBeforeString);
                
                String dateAfterString=myformat.format(lblcheckout);
                java.util.Date dateAfter=myformat.parse(dateAfterString);
                long difference=dateAfter.getTime()-dateBefore.getTime();
                int nodays=(int)(difference/(1000*60*60*24));*/
               
                ResultSet rs2=c.s.executeQuery("select * from room where roomnumber ='"+lblroomnumber.getText()+"'");
                while(rs2.next()){
                   String price=rs2.getString("price");
                   
                   String s1,s2;
                   s1=lblcheckout.getText();
                   s2=lblcheckin.getText();
                   SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                   Date d1=format.parse(s1);
                   Date d2=format.parse(s2);
                   long diff=d1.getTime()-d2.getTime();
                   int days=(int)(diff/(1000*60*60*24));
                   if(days==0)
                       days=1;
                   lbldays.setText(String.valueOf(days));
                  int total=Integer.parseInt(rs2.getString("price"))*days;
                  lbltotal.setText((String.valueOf(total)));
                 // int amountpaid=Integer.parseInt(lbltotal.getText())-Integer.parseInt(lblamount.getText());
                 int amountpaid=Integer.parseInt(lbltotal.getText())-Integer.parseInt(lblpaid.getText());
                  //int amountpaid=setText(String.valueOf(nodays*price));
                    lblamount.setText(""+amountpaid);
                    //lblamount.setText((String.valueOf(amountpaid)));
                   //Integer.parseInt(price)
                }
            }catch (Exception e){
                e.printStackTrace();
                }
            
        } 
        
          else {
            setVisible(false);
               new Reception();
        }
     } 
         
         public static void main(String[] args)
        {
         Checkout ct=new Checkout();
          ct.show();
        }
}
