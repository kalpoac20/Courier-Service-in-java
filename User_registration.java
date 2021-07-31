import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class User_registration extends Frame implements ActionListener{
	private Frame parent;
	private int Count=0;
	private User_login log;
	public TextField tf[];
	/*private TextField tf2;
	private TextField tf3;
	private TextField tf4;
	private TextField tf5;
	private TextField tf6;
	private TextField tf7;
	private TextField tf8;*/
	public User_registration()
					{}
	public User_registration(User_login l){
		super("User Registration");
		log=l;
		Label l10=new Label("User Name");
		Label l2=new Label("Password");
		Label l3=new Label("Email");
		Label l4=new Label("Age");
		Label l5=new Label("Gender");
		Label l6=new Label("Birthdate");
		Label l7=new Label("Home Adress");
		Label l8=new Label("Phone Number");
		Button b=new Button("Register");
		Button b2=new Button("Login");
		b.addActionListener(this);
		b2.addActionListener(this);
		tf=new TextField[8];
		for(int i=0;i<8;i++)
		{
			tf[i]=callTextfield(i);
		}
		/*tf=new TextField(20);
		tf2=new TextField(20);
		tf3=new TextField(20);
		tf4=new TextField(20);
		tf5=new TextField(20);
		tf6=new TextField(20);
		tf7=new TextField(20);
		tf8=new TextField(20);*/
		l10.setBounds(60,100,80,25);
		tf[0].setBounds(170,100,350,30);
		l2.setBounds(60,150,80,25);
		tf[1].setBounds(170,150,350,30);
		l3.setBounds(60,200,100,25);
		tf[2].setBounds(170,200,350,30);
		l4.setBounds(60,250,80,25);
		tf[3].setBounds(170,250,350,30);
		l5.setBounds(60,300,80,25);
		tf[4].setBounds(170,300,350,30);
		l6.setBounds(60,350,80,25);
		tf[5].setBounds(170,350,350,30);
		l7.setBounds(60,400,80,25);
		tf[6].setBounds(170,400,350,30);
		l8.setBounds(60,450,100,25);
		tf[7].setBounds(170,450,350,30);
		b.setBounds(60,500,60,40);
		b2.setBounds(120,500,60,40);
		add(l10);add(tf[0]);
		add(l2);add(tf[1]);
		add(l3);add(tf[2]);
		add(l4);add(tf[3]);
		add(l5);add(tf[4]);
		add(l6);add(tf[5]);
		add(l7);add(tf[6]);
		add(l8);add(tf[7]);
		add(b);add(b2);
		setSize(800,700);
		setLocation(600,200);
		setLayout(null);
	}
	public TextField callTextfield(int i){
		TextField lf= new TextField(20);
		return lf;
		
	}
	public void actionPerformed(ActionEvent ae){
		System.out.println("Button Pressed");
		String s=ae.getActionCommand();
		if(s.equals("Login")){
			this.setVisible(false);
			parent.setVisible(true);
		}
		else if(s.equals("Register")){
			for(int i=0;i<8;i++){
				if(tf[i].getText().length()==0){
					Count++;
				}
					
			}
			if(Count>0){
				JOptionPane.showMessageDialog(this,"You Must Type");
				Count=0;
			}
			else{
			DataAccess da=new DataAccess();
			String Uname=tf[0].getText();
			String Upass=tf[1].getText();
			String Uemail=tf[2].getText();
			String Uage=tf[3].getText();
			String Ugender=tf[4].getText();
			String Ubdate=tf[5].getText();
			String Uhadress=tf[6].getText();
			String Uphone=tf[7].getText();
			String q="insert into customer values(NULL,'"+Uname+"','"+Upass+"','"+Uemail+"','"+Uphone+"','"+Ugender+"','"+Ubdate+"','"+Uage+"','"+Uhadress+"','n')";
			da.updateDB(q);
			}
			
			
		}
	}
	public void setParent(Frame f){parent=f;}
}