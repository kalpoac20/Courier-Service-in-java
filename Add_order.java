import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Add_order extends Frame implements ActionListener{
	private Frame parent;
	public User_panel upanel;
	public int Customer_id;
	public TextField tf1;
	public TextField tf2;
	public TextField tf3;
	public TextField tf4;
	public Add_order(User_panel up){
		super("Add Order");
		upanel=up;
		Label l1=new Label("Product Description");
		tf1=new TextField(100);
		Label l2=new Label("Product Pick Up location");
		tf2=new TextField(50);
		Label l3=new Label("Product Delivery Location");
		tf3=new TextField(50);
		Label l4=new Label("Product Weight");
		tf4=new TextField(10);
		Button b1=new Button("Add Order");
		Button b2=new Button("Back to User panel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(l1);add(tf1);add(l2);add(tf2);add(l3);add(tf3);add(l4);add(tf4);add(b1);add(b2);
		l1.setBounds(100,100,150,30);
		tf1.setBounds(270,100,200,100);
		l2.setBounds(100,270,150,30);
		tf2.setBounds(270,270,200,100);
		l3.setBounds(100,390,150,30);
		tf3.setBounds(270,390,200,100);
		l4.setBounds(100,510,150,30);
		tf4.setBounds(270,510,40,40);
		b1.setBounds(150,600,150,40);
		b2.setBounds(330,600,150,40);
		setSize(800,800);
		setLayout(null);
	}
	public void setParent(Frame f,int id){parent=f;Customer_id=id;}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Back to User panel")){
			this.setVisible(false);
			parent.setVisible(true);
		}
		else if(s.equals("Add Order")){
			DataAccess da=new DataAccess();
			String pd=tf1.getText();
			String ppl=tf2.getText();
			String pdl=tf3.getText();
			String weight=tf4.getText();
			int w= Integer.parseInt(weight);	
			String q="insert into product_order values(NULL,NOW(),'"+ppl+"','"+pdl+"','not_received','"+w+"','"+pd+"','"+Customer_id+"')";
			da.updateDB(q);
			JOptionPane.showMessageDialog(this,"Order added");
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
		}
	}
	
}