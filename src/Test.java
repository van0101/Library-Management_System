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

public class Test extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnAdd;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPublisherName = new JLabel("Publisher Name");
		lblPublisherName.setBounds(26, 61, 102, 14);
		contentPane.add(lblPublisherName);
		
		textField = new JTextField();
		textField.setBounds(149, 58, 129, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAuthorName = new JLabel("Author Name");
		lblAuthorName.setBounds(26, 92, 102, 14);
		contentPane.add(lblAuthorName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(149, 89, 129, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setBounds(26, 123, 102, 14);
		contentPane.add(lblBookName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(149, 120, 129, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDepartmentName = new JLabel("Department Name");
		lblDepartmentName.setBounds(26, 154, 102, 14);
		contentPane.add(lblDepartmentName);
		
		textField_3 = new JTextField();
		textField_3.setBounds(149, 151, 129, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblBookId = new JLabel("Book Id");
		lblBookId.setBounds(26, 187, 46, 14);
		contentPane.add(lblBookId);
		
		textField_4 = new JTextField();
		textField_4.setBounds(149, 184, 129, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setEditable(false);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBounds(45, 228, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnDone = new JButton("DONE");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDone.setBounds(160, 228, 89, 23);
		contentPane.add(btnDone);
		
		JLabel lblNoOfCopies = new JLabel("No. of Copies");
		lblNoOfCopies.setBounds(26, 30, 81, 14);
		contentPane.add(lblNoOfCopies);
		
		textField_5 = new JTextField();
		textField_5.setBounds(149, 27, 129, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}
