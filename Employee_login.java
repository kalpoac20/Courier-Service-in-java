import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Employee_login extends Frame implements ActionListener{
	private Frame parent;
	private User_login log;
	public TextField tf;
	public TextField tf2;
	public int id;
	public Employee_panel epanel;
	public int C=0;
	public Employee_login()
					{}
	public Employee_login(User_login k){
		super("Employee Login");
		log=k;
		epanel=new Employee_panel(this);
		Label l10=new Label("Email");
		Label l2=new Label("Password");
		tf=new TextField(20);
		tf2=new TextField(20);
		Button b1=new Button("Login");
		Button b2=new Button("User Login");
		add(l10);add(tf);
		add(l2);add(tf2);
		add(b1);add(b2);
		l10.setBounds(30,100,80,25);
		tf.setBounds(120,100,200,30);
		l2.setBounds(30,150,80,25);
		tf2.setBounds(120,150,200,30);
		b1.setBounds(120,220,60,40);
		b2.setBounds(180,220,80,40);
		setSize(600,500);
		setLocation(600,300);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);
		setVisible(false);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Login")){
			DataAccess da= new DataAccess();
			String q="";
			String cpEmail=tf.getText();
			String cpPass= tf2.getText();
			ResultSet rs=null;
			try{
				q="select * from courirer_person";
				rs=da.getData(q);
				//System.out.println(rs);
				while(rs.next()){
					C=0;
					String n = rs.getString("cp_email");
					String p= rs.getString("cp_password");
					String oid=rs.getString("cp_id");
					int id=Integer.parseInt(oid);		
					if(n.equals(cpEmail) && p.equals(cpPass)){
						//System.out.println("Correct Cred.");
						this.setVisible(false);
						//	epanel.setVisible(this);
						epanel.setParent(this,id);
					
						//break;
				}
							
							
			
			}
			if(C==0){
								JOptionPane.showMessageDialog(this,"Wrong Username or Password");
							}
		}
			catch(Exception ex){
				ex.printStackTrace();
			}
		} 
		else if(s.equals("User Login")){
			this.setVisible(false);
			//em.setParent(this);
			log.setVisible(true);	
	}
	}
	public void setParent(Frame f){parent=f;}
}