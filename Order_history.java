import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Order_history extends Frame implements ActionListener{
	private Button b1;
	private Button b2;
	private Button b3;
	private TextArea ta;
	public  int c_id;
	private Frame parent;
	public static int c=0;
	public User_panel up;
	public Order_history(User_panel u){
		super("Order History");
		up=u;
		DataAccess da=new DataAccess();ResultSet rs=null;
		rs=da.getData("select * from product_order");
		try{
		while(rs.next()){
				c++;
			}
		}catch(Exception ex){ex.printStackTrace();}
		setSize(700,700);
		setLocation(600,200);
		ta=new TextArea(c,300);
		setLayout(null);
		b1=new Button("Show");
		b3=new Button("Next");
		b2=new Button("Back To User Panel");
		add(ta);add(b1);add(b3);add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		ta.setBounds(50,50,300,300);
		b1.setBounds(200,450,60,40);
		b3.setBounds(300,450,60,40);
		b2.setBounds(400,450,150,40);

	}
	public void setParent(Frame f,int id){parent=f;c_id=id;}
	
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		System.out.println(ta.getText());
		ta.setText("");
		if(s.equals("Show")||s.equals("next")){
			try{
				DataAccess da=new DataAccess();ResultSet rs=null;
				rs=da.getData("select * from product_order where customer_id='"+c_id+"'");
				while(rs.next()){
					String string = rs.getString("o_currentTime");
					String[] parts = string.split(" ");
					String part1 = parts[0]; 
					String part2 = parts[1]; 
					String pickAdress=rs.getString("o_pickupadress");
					String deliveryAdress=rs.getString("o_deliveryadress");
					String weight=rs.getString("product_weight");
					String description=rs.getString("product_description");
					ta.setText("Product order time: "+part1+"\nProduct Pick up adress :"+pickAdress+
					"\nProduct Delivery Adress: "+deliveryAdress+ "\nProduct weight: "+weight+
					"\nProduct Description: "+description+"\n\n\n");
					break;
				}
			}catch(Exception ex){ex.printStackTrace();}
			//ta.append("my text\n");
		}
		else if(s.equals("Back To User Panel")){
			this.setVisible(false);
			parent.setVisible(true);
		}
		else if(s.equals("Next")){
			try{
				DataAccess da=new DataAccess();ResultSet rs=null;
				rs=da.getData("select * from product_order where customer_id='"+c_id+"'");
				while(rs.next()){
					String string = rs.getString("o_currentTime");
					String[] parts = string.split(" ");
					String part1 = parts[0]; 
					String part2 = parts[1]; 
					String pickAdress=rs.getString("o_pickupadress");
					String deliveryAdress=rs.getString("o_deliveryadress");
					String weight=rs.getString("product_weight");
					String description=rs.getString("product_description");
					ta.setText("Product order time: "+part1+"\nProduct Pick up adress :"+pickAdress+
					"\nProduct Delivery Adress: "+deliveryAdress+ "\nProduct weight: "+weight+
					"\nProduct Description: "+description+"\n\n\n");
					break;
				}
			}catch(Exception ex){ex.printStackTrace();}
		}
	}
}

					