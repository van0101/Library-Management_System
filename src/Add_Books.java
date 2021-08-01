import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Add_Books//adding new books
{
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
    JTextField textField_4;
    JTextField textField_5;
    JButton btnAdd= new JButton("ADD");
    JButton btnDone = new JButton("DONE");
    JFrame w_add=new JFrame("ADD BOOKS");
	Add_Books()
	{
			JPanel contentPane;
			w_add.setSize(250,250);
			w_add.setUndecorated(true);
			
			w_add.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			w_add.setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			w_add.setContentPane(contentPane);
			contentPane.setLayout(null);
			
			w_add.setLocationRelativeTo(null); 
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
			textField_4.setBounds(149, 182, 129, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);
			textField_4.setEditable(false);
			
			JLabel lblNoOfCopies = new JLabel("No. of Copies");
			lblNoOfCopies.setBounds(26, 30, 81, 14);
			contentPane.add(lblNoOfCopies);

			textField_5 = new JTextField();
			textField_5.setBounds(149, 33, 129, 20);
			contentPane.add(textField_5);
			textField_5.setColumns(10);
			
			btnAdd.setBounds(45, 228, 89, 23);
			contentPane.add(btnAdd);
			
			
			btnDone.setBounds(160, 228, 89, 23);
			contentPane.add(btnDone);
			
			w_add.setVisible(true);
	}
}
