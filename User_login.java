import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class User_login extends Frame implements ActionListener{
	private TextField tf;
	private TextField tf2;
	private int C=0;
	public User_registration reg;
	public Employee_login em;
	public User_panel up;
	public User_login(){
		super("User Login");
		reg=new User_registration(this);
		em=new Employee_login(this);
		up=new User_panel(this);
		Label l=new Label("Email");
		Label l2=new Label("Password");
		tf=new TextField(20);
		tf2=new TextField(20);
		Button b=new Button("Login");
		Button b1=new Button("Register");
		Button b2=new Button("Employee Login");
		l.setBounds(30,100,80,25);
		tf.setBounds(120,100,200,30);
		l2.setBounds(30,150,80,25);
		tf2.setBounds(120,150,200,30);
		b.setBounds(120,220,60,40);
		b1.setBounds(180,220,60,40);
		b2.setBounds(250,220,100,40);
		setLocation(600,300);
		add(l);add(tf);
		add(l2);add(tf2);
		add(b);add(b1);add(b2);
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setSize(600,500);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Login")){
			DataAccess da= new DataAccess();
			String q="";
			String cEmail=tf.getText();
			String cPass= tf2.getText();
			ResultSet rs=null;
			try{
				q="select * from customer";
				rs=da.getData(q);
				//System.out.println(rs);
				while(rs.next()){
					
					C=0;
					String n = rs.getString("c_email");
					String p= rs.getString("c_password");
					String cid=rs.getString("c_id");
					int id = Integer.parseInt(cid);		
					if(n.equals(cEmail) && p.equals(cPass)){
								C=100;
								this.setVisible(false);
								up.setParent(this,id);
								up.setVisible(true);
						//break;
				}
							
							
			
			}
			if(C>100){
				JOptionPane.showMessageDialog(this,"Error!");
							}
		}
			catch(Exception ex){
				ex.printStackTrace();
			}
		} 
		else if(s.equals("Register")){
			this.setVisible(false);
			reg.setParent(this);
			reg.setVisible(true);	
	}
	else if(s.equals("Employee Login")){
			this.setVisible(false);
			em.setParent(this);
			em.setVisible(true);
			
	}
	
}
}