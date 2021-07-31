import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Customer_status extends Frame implements ActionListener{
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;
	private TextField tf1;
	private TextField tf2;
	private Frame parent;
	public static int x=1;
	public int finish=0;
	private Admin_panel panel;
	private int c=0;
	public Customer_status(){}
	public Customer_status(Admin_panel p){
		super("Customer Status");
		panel=p;
		String no=new String("n");
		setSize(500,300);
		setLocation(600,200);
		tf1=new TextField(10);
		tf2=new TextField(10);
		b1=new Button("Approve");
		b2=new Button("Deny");
		b4=new Button("Next");
		b3=new Button("Back to Admin Panel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		add(tf1);add(tf2);add(b1);add(b2);add(b4);add(b3);
		tf1.setBounds(40,120,70,30);
		tf2.setBounds(150,120,70,30);
		b1.setBounds(270,120,60,30);
		b2.setBounds(400,120,60,30);
		b4.setBounds(200,160,60,40);
		b3.setBounds(150,250,200,30);
		DataAccess da=new DataAccess();
	    ResultSet rs=null;
	    rs=da.getData("select * from customer");
		try{
		while(rs.next()){
			finish++;
		}
		}catch(Exception ex){ex.printStackTrace();}
		
		setLayout(null);
		rs=da.getData("select * from customer where c_id="+x+"");
			try{
			while(rs.next()){
				String str=rs.getString("c_username");
				String str2=rs.getString("c_status");
				System.out.println(str2);
				if(str2.equals(no))
				{
					
					str2="Not approved";
				}
				else
				{
						str2="Approved";
				}
				tf1.setText(str);
				tf2.setText(str2);
				break;
				
			}
			}
			catch(Exception ex){ex.printStackTrace();}
		/*while(rs.next()){
			c++;
		}
		tf1=new TextField[c];
		tf2=new TextField[c];
		b1=new Button[c];
		b2=new Button[c];
		for(int i=0;i<c;i++)
		{
			tf[i]=callTextfieldemail(i);
			String str=rs.getString("c_username")
			tf.setText(str);
			tf2[i]=callTextfieldstatus(i);
			String str2=rs.getString("c_status")
			if(str2.equals('0'))
			{
				tf2.setText("Not approved");
			}
			else
			{
				tf2.setText("Approved");
			}
			b1[i]=callButtonApprove(i);
			b2[i]=callButtonDeny(i);
			add(l1[i]);add(l2[i]);add(b1[i]);add(b2[i]);
			l1[i].setBounds(s1,s2,
			
		}
	}
	public TextField callTextfieldemail(int i){
		TextField tf= new TextField(10);
		return tf;
		
	}
	public TextField callTextfieldstatus(int i){
		TextField tf= new TextField(10);
		return tf2;
		
	}
	public Button callButtonApprove(int i){
		Button b1= new Button(10);
		return b1;
		
	}
	public Button callButtonDeny(int i){
		Button b2= new Button(10);
		return b2;
		
	}*/
}
public void actionPerformed(ActionEvent ae){
	DataAccess da=new DataAccess();
	ResultSet rs=null;
	String no=new String("n");
	rs=da.getData("select * from customer");
		String s=ae.getActionCommand();
		if(s.equals("Approve"))
		{
			tf2.setText("approved");
			String q="update Customer set c_status='y' where c_id="+x+"";
			da.updateDB(q);
		}
		else if(s.equals("Deny"))
		{
			tf2.setText("not approved");
			String q="update Customer set c_status='n' where c_id="+x+"";
			da.updateDB(q);
		}
		else if(s.equals("Next"))
		{
			if(x<finish){
			x++;
			rs=da.getData("select * from customer where c_id="+x+"");
			try{
			while(rs.next()){
				String str=rs.getString("c_username");
				String str2=rs.getString("c_status");
				if(str2.equals(no))
				{
					str2="Not approved";
					System.out.println(str2);
				}
				else
				{
						str2="Approved";
				}
				tf1.setText(str);
				tf2.setText(str2);
				System.out.println(x);
				break;
				
			}
			}
			catch(Exception ex){ex.printStackTrace();}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"List finished !");
				x=finish;
			}
		}
		else if(s.equals("Back to Admin Panel"))
		{
			this.setVisible(false);
			parent.setVisible(true);
		}
		
		
}
public void setParent(Frame f){parent=f;}
}