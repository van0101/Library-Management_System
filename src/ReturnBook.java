

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBook  
{
	 JFrame Rb=new JFrame("Return Book");
	 JPanel contentPane;
	  JTextField textField;
	  JTextField textField_1;
	  JTextField textField_2;
	  public final JButton btnDone1;
	  public final JButton btnGo;
	

	public ReturnBook() {
		
		Rb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Rb.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Rb.setContentPane(contentPane);
		contentPane.setLayout(null);
		Rb.setUndecorated(true);
		Rb.setLocationRelativeTo(null); 
		
		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setBounds(30, 52, 85, 14);
		contentPane.add(lblStudentId);
		
		textField = new JTextField();
		textField.setBounds(155, 49, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBookId = new JLabel("Book Id");
		lblBookId.setBounds(30, 91, 46, 14);
		contentPane.add(lblBookId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(155, 88, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(155, 178, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		JLabel lblFine = new JLabel("Fine");
		lblFine.setBounds(30, 181, 46, 14);
		contentPane.add(lblFine);
		
		btnGo = new JButton("GO");
		
		btnGo.setBounds(82, 129, 69, 23);
		contentPane.add(btnGo);
		
		
		btnDone1=new JButton("Done");
		btnDone1.setBounds(76, 228, 89, 23);
		contentPane.add(btnDone1);
	}
	
	public void action()throws Exception
	{
		String sid=textField.getText();
		String bid=textField_1.getText();
		String query="select transaction_date,return_date from transaction where book_id = \""+bid+"\" and student_id = \""+sid+"\"";
		
		System.out.println(query);
		Connection c3;
		
		c3=(Connection) Connection1.getConnection();
		
		PreparedStatement ps=c3.prepareStatement(query);
		ResultSet rt=ps.executeQuery(query);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		
		if(!rt.next())
			System.out.println("rt is null!");
		//rt.next();
		
		String r_date=rt.getString(2);//return date 
		System.out.println(r_date);
		
		LocalDate ld=LocalDate.now();
		String i_date=ld.format(formatter);
		System.out.println(i_date);
		
		int r=Integer.parseInt(Character.toString(r_date.charAt(0))+Character.toString(r_date.charAt(1)));
		int i=Integer.parseInt(Character.toString(i_date.charAt(0))+Character.toString(i_date.charAt(1)));
		
		int fd=r-i;
		
		int fine;
		if(fd>7)
		{
			fine =(fd-7)*10;
			textField_2.setText(String.valueOf(fine));
			query="update student_info set fine ="+String.valueOf(fine);
			ps.executeQuery(query);
		}
		else
			textField_2.setText(String.valueOf(0));
		
	}
}
