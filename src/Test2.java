import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test2  {

	JPanel contentPane;
	 JTextField textField;
	 JTextField textField_1;
	 JTextField textField_2;
	 JButton btnIssue = new JButton("ISSUE");
		
	JFrame w2=new JFrame("ISSUE BOOKS");
	//public final JButton btnDone;
	static final public JButton btnDone=new JButton("Done");;
	
	public Test2() {
		w2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w2.setBounds(100, 100, 450, 300);
		w2.setUndecorated(true);
		w2.setLocationRelativeTo(null); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		w2.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(130, 75, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblTransactionId = new JLabel("Transaction ID");
		lblTransactionId.setBounds(30, 78, 90, 14);
		contentPane.add(lblTransactionId);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(30, 109, 73, 14);
		contentPane.add(lblStudentId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 106, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBookId = new JLabel("Book Id");
		lblBookId.setBounds(30, 140, 46, 14);
		contentPane.add(lblBookId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 137, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		btnIssue.setBounds(30, 185, 89, 23);
		contentPane.add(btnIssue);
		
		//btnDone = new JButton("Done");
		
		btnDone.setBounds(202, 185, 89, 23);
		contentPane.add(btnDone);
		
		w2.setVisible(true);
	}

}
