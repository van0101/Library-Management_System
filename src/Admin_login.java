import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;




import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;


class Admin_login 
{
	JFrame w1=new JFrame("Admin");
	JButton btnIssueBooks = new JButton("Issue Books");
	JButton btnAddBooks = new JButton("Add Books");
	JButton btnReturnBook = new JButton("Return Book");
	JButton btnStudentInfo = new JButton("Student info");
	JButton btnViewTransactions = new JButton("View Transactions");
	String pub_id,aut_id;
	private final JButton btnViewBooks = new JButton("View Books");
	
	Admin_login()
	{
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld=LocalDate.now();
		w1.setSize(501,305);
		w1.getContentPane().setLayout(null);
		w1.setLocationRelativeTo(null); 
		JLabel lblDate = new JLabel(dtf.format(ld));
		lblDate.setBounds(402, 11, 72, 14);
		w1.getContentPane().add(lblDate);
		
		JLabel lblLibrary = new JLabel("LIBRARY");
		lblLibrary.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblLibrary.setBounds(188, 9, 141, 14);
		w1.getContentPane().add(lblLibrary);
		
		
		
		btnIssueBooks.setBounds(68, 109, 141, 23);
		w1.getContentPane().add(btnIssueBooks);
		
		
		btnAddBooks.setBounds(68, 143, 141, 23);
		w1.getContentPane().add(btnAddBooks);
		
		
		
		btnReturnBook.setBounds(252, 109, 141, 23);
		w1.getContentPane().add(btnReturnBook);
		
		
		
		btnStudentInfo.setBounds(252, 143, 141, 23);
		w1.getContentPane().add(btnStudentInfo);
		
		
		
		btnViewTransactions.setBounds(68, 177, 141, 23);
		w1.getContentPane().add(btnViewTransactions);
		
		btnViewBooks.setBounds(252, 177, 141, 23);
		
		w1.getContentPane().add(btnViewBooks);
		w1.setVisible(true);
	}
	void all_action()throws Exception
	{
		
		btnAddBooks.addActionListener(new ActionListener() {//opens add new books jframe w1
			public void actionPerformed(ActionEvent arg0)
			{
				w1.setVisible(false);
			   Add_Books ab1=new Add_Books();
				boolean flag1=true;
				
				//while(flag1)
				//{
					
					ab1.btnAdd.addActionListener(new ActionListener() //adds books in the add books jframe
					{
						public void actionPerformed(ActionEvent arg0)
						{
							// 0)pname ,1)aname,2)book_name,3)dept,4)book_id;
							String book_id="";
							try
							{
								book_id=getValues(ab1.textField,ab1.textField_1,ab1.textField_2,ab1.textField_3,ab1.textField_5);
							    update_book(book_id,pub_id,aut_id,ab1.textField_2.getText(),ab1.textField_5.getText());
							    ab1.textField_4.setText(book_id);
							}
							catch(Exception e)
							{
								e.printStackTrace();
								System.out.println("Error!");
							}
							
						}
					});
				
					ab1.btnDone.addActionListener(new ActionListener() {//closes the add new books jframe w_add is closed w1 is opened
						public void actionPerformed(ActionEvent arg0) 
						{
							ab1.w_add.setVisible(false);
							w1.setVisible(true);
						}
					});
				
			
			}
		});
		
		btnIssueBooks.addActionListener(new ActionListener() {//opens issue books window w2 opens w1 closes
			public void actionPerformed(ActionEvent e) 
			{
				
				
				Test2 ob1 =new Test2();
				w1.setVisible(false);
				ob1.w2.setVisible(true);
		
				ob1.btnIssue.addActionListener(new ActionListener() {//issues new book in transaction table
					public void actionPerformed(ActionEvent e) 
					{
						LocalDate ld=LocalDate.now();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
						LocalDate nextWeek = ld.plus(1, ChronoUnit.WEEKS);
						
						String sid=ob1.textField_1.getText();
						String bid=ob1.textField_2.getText();
						String tid=sid+"-"+bid;
						String today=ld.format(formatter);
						String return_date=nextWeek.format(formatter);
						String query="insert into transaction(Transaction_id,Student_id,Transaction_date,Book_id,Return_date) values(?,?,?,?,?)";
						
						boolean c=false;
						try
						{
							//check whether the sid is new or old
							c=chk_id(sid);//true it exists ---false it does not
							//only to input in student info
						}
						catch(Exception e2)
						{
							e2.printStackTrace();
						}
						
						String query2;
					
						Connection c2;
						c2=Connection1.getConnection();//inserting into transaction table nevertheless
						try
						{
							PreparedStatement ps=c2.prepareStatement(query);
							ps.setString(1, tid);
							ps.setString(2, sid);
							ps.setString(3, today);
							ps.setString(4, bid);
							ps.setString(5, return_date);
							
							int count =ps.executeUpdate();
							System.out.println(count+"Row/s effected!");
							
							if(c==false)//new id added
							{
								query2="insert into student_info(Student_id,fine) values(?,?)";	
								System.out.println(query2);
								int f=0;
								ps=c2.prepareStatement(query2);
								ps.setString(1,sid);
								ps.setString(2, "0");
							
							}
							
							
							 
						}
						catch(Exception e1)
						{
							e1.printStackTrace();
						}
						
					}
				});
				JButton temp=ob1.btnDone;
				temp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						w1.setVisible(true);
						ob1.w2.setVisible(false);
					}
				});
				
				
			}
		});
	
		btnReturnBook.addActionListener(new ActionListener() {//opens the return book window
			public void actionPerformed(ActionEvent e) {
				ReturnBook rb1 =new ReturnBook();
				w1.setVisible(false);
				rb1.Rb.setVisible(true);
				
				JButton tem=rb1.btnGo;
				tem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						try
						{
							rb1.action();
						}
						catch(Exception e3)
						{
							e3.printStackTrace();
						}
					}
				});
				tem=rb1.btnDone1;
				tem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						rb1.Rb.setVisible(false);
						w1.setVisible(true);
					}
				});
				
			}
		});
		

		btnStudentInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				w1.setVisible(false);
				Display_info stud=new Display_info();
				stud.dpt.setVisible(true);
				
				String query="select * from student";
				Connection c6;
				c6=Connection1.getConnection();
				try
				{
					PreparedStatement ps=c6.prepareStatement(query);
					ResultSet rt=ps.executeQuery(query);
			
					stud.display(rt);
					
				}
				catch(Exception e4)
				{
					e4.printStackTrace();
				}
				stud.btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						stud.dpt.setVisible(false);
						w1.setVisible(true);
					}
				});

			}
		});
		btnViewTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				w1.setVisible(false);
				Display_info b=new Display_info();
				b.dpt.setVisible(true);
				
				String query="select * from transaction";
				Connection c6;
				c6=Connection1.getConnection();
				try
				{
					PreparedStatement ps=c6.prepareStatement(query);
					ResultSet rt=ps.executeQuery(query);
			
					b.display(rt);
					
				}
				catch(Exception e4)
				{
					e4.printStackTrace();
				}
			
			b.btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					b.dpt.setVisible(false);
					w1.setVisible(true);
				}
			});
				
				
		}
		});
		btnViewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				w1.setVisible(false);
				Display_info b=new Display_info();
				b.dpt.setVisible(true);
				
				String query="select * from books";
				Connection c6;
				c6=Connection1.getConnection();
				try
				{
					PreparedStatement ps=c6.prepareStatement(query);
					ResultSet rt=ps.executeQuery(query);
			
					b.display(rt);
					
				}
				catch(Exception e4)
				{
					e4.printStackTrace();
				}
				b.btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						b.dpt.setVisible(false);
						w1.setVisible(true);
					}
				});
			}
			
			
			
		});
	}
	
	boolean chk_id(String sid)throws Exception
	{
		boolean b=false;
		String query="select student_id from student_info where student_id ='"+sid+"'";
		System.out.println(query);
		Connection c4;
		c4=Connection1.getConnection();
		PreparedStatement ps=c4.prepareStatement(query);
		ResultSet rt=ps.executeQuery(query);
		
		if(rt.next())
		{
			b=true;//if the id exists then return true
			System.out.println(rt.getString(1));
		}
		else
			b=false;//if it does not exists then return false
		
		return b;
	}
	
    void update_book(String bid,String pid,String aid,String name,String copies)throws Exception
	{
    	String query="insert into books values(?,?,?,?,?)";
    	Connection c2;
    	c2=Connection1.getConnection();
    	PreparedStatement ps=c2.prepareStatement(query);
		ps.setString(1,bid);
		ps.setString(2,name);
		ps.setString(3,aid);
		ps.setString(4,pid);
		ps.setString(5,copies);
		
		int count=ps.executeUpdate();//to update data in a table
		System.out.println(count+"row/s effected");
		
		ps.close();
		
    	
	}
	String getValues(JTextField j,JTextField j1,JTextField j2,JTextField j3,JTextField j5)throws Exception
	{
		String val[]=new String[6];
		
		val[0]=j.getText();
		if(chk_publisher(val[0],"publisher")==0)
		{
			System.out.println("NEW PUBLISHER ADDED!");
		}
		
		val[1]=j1.getText();
		if(chk_publisher(val[1],"author")==0)
		{
			System.out.println("NEW AUTHOR ADDED!");
		}
		val[2]=j2.getText();//book name
		val[3]=j3.getText();//department *
		String b_id=getBook_id(val[3],pub_id+aut_id);
		val[5]=j5.getText();//no. of copies
		
		return b_id;
	}
	int chk_publisher(String p,String t)throws Exception//checks for both publisher and author
	{
		String query="select "+t+"_id "+"from "+t+" where "+t+"_id ="+"\""+p+"\"";//searches for the existing name
		System.out.println(query);
		String id;
		 Connection c1;
		 c1=Connection1.getConnection();
		 if(c1==null)
		 {
			 System.out.println("con is null!");
		 }
		PreparedStatement ps=c1.prepareStatement(query);
		
		ResultSet rt=ps.executeQuery(query);
		
		if(!rt.next())
		{
			System.out.println("rt is null!");
			int count=0;
			do
			{
				
				String q="insert into "+t+"("+t+"_id,"+t+"_name) values(?,?)";
				System.out.println(q);
				String p_id=generate_id(p);//publisher name id
				
				query="select "+t+"_id from "+t+" where "+t+"_id="+"\""+p_id+"1"+"\"";//
				System.out.println(query);
				ps=c1.prepareStatement(query);
				rt=ps.executeQuery(query);
				
				query="select count("+t+"+_id) from "+t;
				System.out.println(query);
				
				if(!rt.next())//returned query is null 
					p_id=p_id+1;//First occurrence of the id 
				else
				{
					p_id=p_id+(((49-(int)(rt.getString(1).charAt((rt.getString(1).length()-1))))+2));
					ps=c1.prepareStatement(query);
					rt=ps.executeQuery(query);
					rt.next();
					p_id=p_id+(String.valueOf(rt.getString(1))+1);
					
				}
				
				
					
				System.out.println("id is "+p_id);
				if(t.equals("author"))
				{
					aut_id=p_id;
				}
				else
					pub_id=p_id;
				ps=c1.prepareStatement(q);
				
				ps.setString(1,p_id);
				ps.setString(2,p);
				
				count=ps.executeUpdate();
				
			}while(count==0);
			
			
			ps.close();
			rt.close();
			return 0;
		}
		else
			id = rt.getString(1);//pid of the existing pname
		
		ps.close();
		rt.close();
		return 1;
	}
	
	
	String generate_id(String s)
	{
		s.trim();
		String id;
		id=Character.toString(s.charAt(0));
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==' ')
			{
				
				
				id=id+Character.toString(s.charAt(i-1))+Character.toString(s.charAt(i+1));
				System.out.println("id is "+id);
				break;
			}
		}
		
		return id;
	}
	
	String getBook_id(String d,String b)//generating book id by adding the p_id and a_id
	{
		if(d.equals("M"))
		{
			b="A-"+b;
		}
		if(d.equals("C"))
		{
			b="B-"+b;
		}
		if(d.equals("E"))
		{
			b="D-"+b;
		}
		if(d.equals("H"))
		{
			b="C-"+b;
		}
		
		return b;
	}
	public static void main(String args[])throws Exception
	{
		Admin_login Al1=new Admin_login();
		Al1.all_action();
	}
	
}
