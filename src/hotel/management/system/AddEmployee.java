
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField tfname,tfemail,tfphone,tfage,tfsalary,tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit,cancel;
    JComboBox cbjob;
    
    AddEmployee() {
        setLayout(null);
        
        JLabel heading=new JLabel("Add Employee Details");
         heading.setFont(new Font("Arial Black",Font.BOLD,24));
         heading.setBounds(410,25,300,30);
         add(heading);
        
        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
        
        JLabel lblage=new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lblage);
        
        tfage=new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);
        
        JLabel lblgender=new JLabel("GENDER");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lblgender);
        
        rbmale=new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahona",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale=new JRadioButton("female");
        rbfemale.setBounds(280,130,70,30);
        rbfemale.setFont(new Font("Tahona",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lbljob=new JLabel("JOB");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lbljob);
        
        String str[]={"Front Desk clerks","Porters","Housekeeping","Kitchen Staff","Room Services","Chefs","Waiter/Waitness","Manager","Accountant"};
        cbjob=new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
        JLabel lblsalary=new JLabel("SALARY");
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lblsalary);
        
        tfsalary=new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);
        
        JLabel lblphone=new JLabel("PHONE");
        lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lblphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);
        
        JLabel lblemail=new JLabel("EMAIL");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lblemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);
        
        JLabel lblaadhar=new JLabel("AADHAR");
        lblaadhar.setBounds(60,380,120,30);
        lblaadhar.setFont(new Font("Tahona",Font.PLAIN,17));
        add(lblaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(200,380,150,30);
        add(tfaadhar);
        
        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(150,430,120,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(320,430,120,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);
        
        //setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setBounds(260,105,850,540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
        String name=tfname.getText();
        String age=tfage.getText();
        String salary=tfsalary.getText();
        String phone=tfphone.getText();
          int length=phone.length();
           if(length==10){
               setVisible(true);
           } else {
                      JOptionPane.showMessageDialog(null,"Enter correct phone number");
                      setVisible(true);
                 }
          
        
        String email=tfemail.getText();
        String aadhar=tfaadhar.getText();
        
        String gender=null;
        
        if(rbmale.isSelected()){
            gender="Male";
        }else if (rbfemale.isSelected()) {
            gender="female";
        }
        
        String job=(String) cbjob.getSelectedItem();
        if(length==10){
        try{
            Conn Conn =new Conn();
            
            String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            
            Conn.s.executeUpdate(query);
            
            //if(length==10)
            {
            
            JOptionPane.showMessageDialog(null,"Employee address successfully");
            setVisible(false);
            }
           // else{
             //   setVisible(true);
                
            //}
            
        } catch (Exception e){
            e.printStackTrace();
        }
        }
        else{
                setVisible(true);
                }
              
    }else{
            setVisible(false);
            new Admin();
        }
   
    }
    public static void main(String[] args) {
        new AddEmployee();
    }
}
