package deeksha3;
import java.sql.*;
import java.util.*;

public class de1 
{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		void insert()
		{
			Scanner sc= new Scanner(System.in);
			System.out.print("Enter Employe id, Name, Father Name, City ");
			String eid=sc.nextLine();
			String ename=sc.nextLine();
			String fname=sc.nextLine();
			String city=sc.nextLine();
			
			String query="insert into table1 values("+eid+",'"+ename+"','"+fname+"','"+city+"')";
			
			try
			{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_ee","root","12345");  
				System.out.print("Connection Established ");
				st=con.createStatement();
				st.executeUpdate(query);
				con.close(); 
			}catch(Exception e){ System.out.println(e);}
		}
		
		void delete()
		{
				Scanner sc= new Scanner(System.in);
				System.out.print("Enter Employe id ");
				String eid=sc.nextLine();
				
				String query="delete from table1 where employid = "+eid;
				
				try
				{  
					Class.forName("com.mysql.cj.jdbc.Driver");  
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_ee","root","12345");  
					System.out.print("Connection Established ");
					st=con.createStatement();
					st.executeUpdate(query);
					con.close(); 
				}catch(Exception e){ System.out.println(e);}
		}
			
			
		void update()
		{
				Scanner sc= new Scanner(System.in);
				System.out.print("Enter Employe id ");
				String eid=sc.nextLine();
				
				String query="update table1 set name='aanchal',fathersname='rrr',city='dehradun' where employid="+eid;
				
				try
				{  
					Class.forName("com.mysql.cj.jdbc.Driver");  
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_ee","root","12345");  
					System.out.print("Connection Established ");
					st=con.createStatement();
					st.executeUpdate(query);
					con.close(); 
				}catch(Exception e){ System.out.println(e);}
		}
		
		void display()
		{
			String query="select * from table1";
			try
			{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_ee","root","12345");  
				System.out.print("Connection Established ");
				st=con.createStatement();
				rs=st.executeQuery(query);
				
				while(rs.next())
					System.out.println(rs.getString("employid")+" "+rs.getString("name")+" "+rs.getString("fathersname")+" "+rs.getString("city"));
				
				con.close(); 
			}catch(Exception e){ System.out.println(e);}  
		}
		
		public static void main(String[] args) 
		{
			de1 ob = new de1();
			ob.display();
			ob.insert();
			ob.display();
			ob.delete();
		    ob.display();
			ob.update();
			ob.display();
			
		}
	}
