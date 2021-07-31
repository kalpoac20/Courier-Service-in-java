import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Employee_list extends Frame implements ActionListener{
	private TextArea ta;
	private Frame parent;
	private Admin_panel panel;
	public static int c=0;
	public Employee_list(Admin_panel p){
	super("Employee List");
	panel=p;
	DataAccess da=new DataAccess();ResultSet rs=null;
	rs=da.getData("select * from courirer_person");
	try{
	while(rs.next()){
				c++;
			}
	}catch(Exception ex){ex.printStackTrace();}
	Label l=new Label("Showing Employee List");
	ta=new TextArea(c,30);
	Button b=new Button("Show");
	Button b2=new Button("Exit");
	Button b3=new Button("Back to Admin Panel");
	add(l);add(ta);
	add(b);add(b2);add(b3);
	b.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	setLayout(new FlowLayout());
	setSize(400,400);
	setLocation(800,200);
	}
	
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		System.out.println(ta.getText());
		ta.setText("");
		if(s.equals("Show")){
			try{
				DataAccess da=new DataAccess();ResultSet rs=null;
				rs=da.getData("select * from courirer_person");
				while(rs.next()){
					String str=rs.getString("cp_username")+":"+rs.getString("cp_email");
					ta.append(str+"\n");
				}
			}catch(Exception ex){ex.printStackTrace();}
			//ta.append("my text\n");
		}
		else if(s.equals("Exit")){
			System.exit(0);
		}
		else if(s.equals("Back to Admin Panel")){
			this.setVisible(false);
			parent.setVisible(true);
		}
	}
	public void setParent(Frame f){parent=f;}
}