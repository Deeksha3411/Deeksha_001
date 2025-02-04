package deeksha2;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Scanner;

class Form extends Frame implements ActionListener
{
	Label l1,l2,l3,l4,l5,l6,l7,l8;
	TextField tf1,tf2,tf3,tf4,tf5,tf6;
	Checkbox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8;
	Choice ch;
	List list1;
	Button b1,b2,b3,b4,b5;
	CheckboxGroup cbg;
	
	Form()
	{
	    l1=new Label("ROLLNO ");
		l1.setBounds(50,50,100,20);
		tf1=new TextField(20);
		tf1.setBounds(160,50,100,20);
		
		b1=new Button("SEARCH");
		b1.addActionListener(this);
		b1.setBounds(280,50,70,40);
		
		l2=new Label("NAME ");
		l2.setBounds(50,110,100,20);
		tf2=new TextField(20);
		tf2.setBounds(160,110,100,20);
	
		
		l3=new Label("GENDER");
		l3.setBounds(50,160,100,20);
		cbg=new CheckboxGroup();
		cb1=new Checkbox("male",cbg,true);
		cb1.setBounds(160,150,50,20);
		cb2=new Checkbox("female",cbg,true);
		cb2.setBounds(220,150,50,20);
		cb3=new Checkbox("oth",cbg,false);
		cb3.setBounds(280,150,50,20);
		
		
		l4=new Label("EDUCATION");
		l4.setBounds(50,210,100,20);
		tf3=new TextField(20);
		tf3.setBounds(160,210,100,20);
		ch=new Choice();
		ch.setBounds(160,210,100,20);
		
		ch.add("Matric");
		ch.add("Intermediate");
		ch.add("Graduate");
		ch.add("Post-Graduate");
		ch.add("Singing");
		
		
		l5=new Label("CITY");
		l5.setBounds(50,260,100,20);
		list1=new List();
		list1.setBounds(160,260,100,50);
		
		list1.add("Dehradun");
		list1.add("Delhi");
		list1.add("Mumbai");
		list1.add("Bangalore");
		list1.add("Pune");
		
		
		
		
		l6=new Label("ADD");
		l6.setBounds(50,340,100,20);
		tf4=new TextField(20);
		tf4.setBounds(160,340,100,20);
		
		
		b2=new Button("INSERT");
		b2.addActionListener(this);
		b2.setBounds(160,390,70,40);
		
		b3=new Button("DELETE");
		b3.addActionListener(this);
		b3.setBounds(240,390,70,40);
		
		b4=new Button("DISPLAY");
		b4.addActionListener(this);
		b4.setBounds(160,440,70,40);
		
		b5=new Button("UPDATE");
		b5.addActionListener(this);
		b5.setBounds(240,440,70,40);
		
		
		
		add(l1);
		add(tf1);
		add(l2);
		add(tf2);
		add(l3);
		add(l4);
		add(cb1);
		add(cb2);
		add(cb3);
		add(l5);
		add(ch);
		add(list1);
		add(l6);
		add(tf3);
		add(tf4);
	

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		
		
		
	
		
		setSize(500,500);
		setLayout(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==b2)
		{
			String a=tf1.getText();
			String b=tf2.getText();
			
			String g="";
			if(cb1.getState()==true)
				g=cb1.getLabel();
			if(cb2.getState()==true)
				g=cb2.getLabel();
			if(cb3.getState()==true)
				g=cb3.getLabel();
			
			String c=ch.getSelectedItem();
			String d=list1.getSelectedItem();
			String e=tf3.getText();
			
			/*System.out.println(a);
			System.out.println(b);
			System.out.println(g);
			System.out.println(c);
			System.out.println(d);
			System.out.println(e);
			*/
			
		
	     String query="insert into table1 values("+a+",'"+b+"','"+g+"','"+c+"','"+d+"','"+e+"')";
			
			try
			{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/form_mm","root","12345");  
				System.out.print("Connection Established ");
				Statement st=con.createStatement();
				st.executeUpdate(query);
				con.close(); 
			}catch(Exception e1){ System.out.println(e1);}
		}
		
		
		
		if(ae.getSource()==b3)
		{
			Scanner sc= new Scanner(System.in);
			String a=tf1.getText();
			
			String query="delete from table1 where rollno = "+a;
				
				try
				{  
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/form_mm","root","12345");  
					System.out.print("Connection Established ");
					Statement st=con.createStatement();
					st.executeUpdate(query);
					con.close(); 
				}catch(Exception e1){ System.out.println(e1);}
			
		}
	
	
		if(ae.getSource()==b4)
		{
		
	         String a=tf1.getText();
	         String b=tf2.getText();
				
				String g="";
				if(cb1.getState()==true)
					g=cb1.getLabel();
				if(cb2.getState()==true)
					g=cb2.getLabel();
				if(cb3.getState()==true)
					g=cb3.getLabel();
				
				String c=ch.getSelectedItem();
				String d=list1.getSelectedItem();
				String e=tf3.getText();
				
		
			String query="update table1 set name='"+b+"',gender='"+g+"',graduate='"+c+"',city='"+d+"',address='"+e+"' rollno="+a;
			try
			{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/form_mm","root","12345");  
				System.out.print("Connection Established ");
				Statement st=con.createStatement();
				st.executeUpdate(query);
				con.close(); 
			}catch(Exception e1){ System.out.println(e1);}
		}
		
		
			
		if(ae.getSource()==b5)
		{
		   	String query="select * from table1";
			try
			{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_ee","root","12345");  
				System.out.print("Connection Established ");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);
				
				while(rs.next())
					System.out.println(rs.getString("rollno")+" "+rs.getString("name")+" "+rs.getString("gender")+" "+rs.getString("education")+""+rs.getString("city")+" "+rs.getString("address"));
				
				con.close(); 
			}catch(Exception e1){ System.out.println(e1);}  
		}
		   
		   
	}
	
	public static void main(String [] ar)
	{
		new Form();
	}
}
		
		
	