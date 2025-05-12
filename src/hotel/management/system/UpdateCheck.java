
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;



public class UpdateCheck extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending,tfid;
    JButton check, update, back;
    
    UpdateCheck(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Update Status");
        text.setFont(new Font("Tahona",Font.BOLD,28));
        text.setBounds(90,20,200,33);
        text.setForeground(Color.BLUE);
        add(text);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,80,100,20);
        add(lblname);
        
        ccustomer=new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblroom=new JLabel("Room number");
        lblroom.setBounds(30,120,100,20);
        add(lblroom);
        
        tfroom=new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);
        
         JLabel lblid=new JLabel("Customer Id");
        lblid.setBounds(30,160,100,20);
        add(lblid);
        
         tfid=new JTextField();
        tfid.setBounds(200,160,150,25);
        add(tfid);
        
         JLabel lblcheckin=new JLabel("Checkin Time");
        lblcheckin.setBounds(30,200,100,20);
        add(lblcheckin);
        
         tfcheckin=new JTextField();
        tfcheckin.setBounds(200,200,150,25);
        add(tfcheckin);
        
         JLabel lblpaid=new JLabel("Amount paid");
        lblpaid.setBounds(30,240,100,20);
        add(lblpaid);
        
         tfpaid=new JTextField();
        tfpaid.setBounds(200,240,150,25);
        add(tfpaid);
        
        /*  JLabel lblpending=new JLabel("Pending Amount");
        lblpending.setBounds(30,280,100,20);
        add(lblpending);  
        
         tfpending=new JTextField();
        tfpending.setBounds(200,280,150,25);
        add(tfpending);  */
        
        check=new JButton("check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,370,100,32);
        check.addActionListener(this);
        add(check);
        
         update=new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,370,100,32);
        update.addActionListener(this);
        add(update);
        
         back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,370,100,32);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
        
        setBounds(300,150,950,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String id=ccustomer.getSelectedItem();
            String query="select * from customer where name='"+id+"'";
            try {
                Conn c=new Conn();
                ResultSet rs= c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                    tfid.setText(rs.getString("number"));
                    tfcheckin.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposit"));
                }
               
                /*  ResultSet rs2=c.s.executeQuery("select * from room where roomnumber ='"+tfroom.getText()+"'");
                while(rs2.next()){
                    String price=rs2.getString("price");
                    int amountpaid=Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
                    tfpending.setText(""+amountpaid);
                } */
            }catch (Exception e){
                e.printStackTrace();
                }
            
        } else if (ae.getSource()==update){
            String name=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String id=tfid.getText();
            String checkin=tfcheckin.getText();
            String deposit=tfpaid.getText();
            
           try{
               Conn c=new Conn();
               c.s.executeUpdate("update customer set room='"+room+"',number='"+id+"',checkintime='"+checkin+"',deposit='"+deposit+"' where name='"+name+"'");
               
               JOptionPane.showMessageDialog(null,"Updated data successfully");
               
               setVisible(false);
               new Reception();
               
           }catch (Exception e){
                   e.printStackTrace();    
                       }
           
            
        }else {
            setVisible(false);
               new Reception();
        }
        
    }
    
    public static void main(String[] args){
        new UpdateCheck();
    }
}
