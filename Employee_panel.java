import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Employee_panel extends Frame implements ActionListener{
	private Frame parent;
	private Employee_login elog;
	//public View_order vo;
	public int person_id;
	public int customer_id=0;
	public Employee_panel(Employee_login log){
		super("Employee Panel");
		elog=log;
		//vo=new View_order(this);
		Button b1=new Button("View Order");
		Button b2=new Button("Logout");
		//Button b3=new Button("Edit Order");
		b1.setBounds(150,120,70,70);
		b2.setBounds(300,120,70,70);
		//b3.setBounds(300,120,70,70);
		//b4.setBounds(200,210,70,70);
		b1.addActionListener(this);
		b2.addActionListener(this);
		//b3.addActionListener(this);
		//b4.addActionListener(this);
		add(b1);add(b2);//add(b4);
		setSize(500,300);
		setLocation(600,400);
		setLayout(null);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("View Order")){
			//this.setVisible(false);
			//vo.setParent(this);
			//vo.setVisible(true);
		}
		else if(s.equals("Logout")){
			this.setVisible(false);
			parent.setVisible(true);
		}
	}
	public void setParent(Frame f, int id){parent=f;person_id=id;}
}

