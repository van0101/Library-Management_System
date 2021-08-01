

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Display_info {

	private JPanel contentPane;
	JFrame dpt=new JFrame();
	//stud.col[]= {"Book ID,Book Name,Author ID,Publisher ID,No of Copies"};
	
	public Display_info() {
		dpt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dpt.setBounds(100, 100, 654, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		dpt.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 634, 230);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		btnBack = new JButton("BACK");
		
		btnBack.setBounds(283, 290, 89, 23);
		contentPane.add(btnBack);
		dpt.setUndecorated(true);
		dpt.setLocationRelativeTo(null); 
		
		
	}
	
	//static JTable table;
	
	private JTable table_1;
	public JButton btnBack;
	void display(ResultSet rt)
	{
		table_1.setModel(DbUtils.resultSetToTableModel(rt));
	}
	

}
