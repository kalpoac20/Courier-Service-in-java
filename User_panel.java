import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class User_panel extends Frame implements ActionListener{
	private Frame parent;
	private User_login ulog;
	public Add_order ao;
	public Order_history oh;
	public User_panel(){}
	public int customer_id=0;
	public User_panel(User_login log){
		super("User Panel");
		ulog=log;
		ao=new Add_order(this);
		oh=new Order_history(this);
		Button b1=new Button("Add Order");
		Button b2=new Button("History");
		//Button b3=new Button("Edit Order");
		Button b4=new Button("Logout");
		b1.setBounds(150,120,70,70);
		b2.setBounds(300,120,70,70);
		//b3.setBounds(300,120,70,70);
		b4.setBounds(200,210,70,70);
		b1.addActionListener(this);
		b2.addActionListener(this);
		//b3.addActionListener(this);
		b4.addActionListener(this);
		add(b1);add(b2);add(b4);
		setSize(500,300);
		setLocation(600,400);
		setLayout(null);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Add Order")){
			this.setVisible(false);
			ao.setParent(this,customer_id);
			ao.setVisible(true);
			
		}
		else if(s.equals("History")){
			this.setVisible(false);
			oh.setVisible(true);
			oh.setParent(this,customer_id);
		}
		else if(s.equals("Logout")){
			this.setVisible(false);
			parent.setVisible(true);
		}
	}
	public void setParent(Frame f, int id){parent=f;customer_id=id;}
}

