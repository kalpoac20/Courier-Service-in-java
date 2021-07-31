import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Admin_login extends Frame implements ActionListener{
	public TextField tf;
	public TextField tf2;
	public Admin_panel apanel;
	public Admin_login(){
		
		super("Admin Login");
		apanel=new Admin_panel(this);
		Label l=new Label("User Name");
		Label l2=new Label("Password");
		tf=new TextField(20);
		tf2=new TextField(20);
		
		Button b=new Button("Login");
		l.setBounds(30,50,80,25);
		tf.setBounds(120,50,200,30);
		l2.setBounds(30,125,80,25);
		tf2.setBounds(120,125,200,30);
		b.setBounds(160,170,60,40);
		b.addActionListener(this);
		add(l);add(tf);
		add(l2);add(tf2);
		add(b);
		setSize(500,400);
		setLocation(500,400);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Login")){
			DataAccess da= new DataAccess();
			String q="";
			String aName=tf.getText();
			String aPass= tf2.getText();
			ResultSet rs=null;
			try{
				q="select * from admin";
				rs=da.getData(q);
				//System.out.println(rs);
				while(rs.next()){
					

					String n = rs.getString("a_username");
					String p= rs.getString("a_pass");
					if(n.equals(aName) && p.equals(aPass)){
						this.setVisible(false);
						apanel.setParent(this);
						apanel.setVisible(true);
				}
							
							else{
								JOptionPane.showMessageDialog(this,"Wrong Username or Password");
								
							}
			
			}
		}
			catch(Exception ex){
				ex.printStackTrace();
			}
		} 
	}
}