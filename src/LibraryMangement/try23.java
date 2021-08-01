package LibraryMangement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class try23 extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	

	
	public static void main(String[] args) {
		try23 o1=new try23();
		o1.abcd();
		
		
	}
	void abcd()
	{
		String col1[]= {"Book ID,Book Name,Author ID,Publisher ID,No of Copies"};
		final Object d[][]= {{"1","jdj","ww","ww","2"},{"1","jdj","ww","ww","2"}};
		//DefaultTableModel model = new DefaultTableModel();
		//model.setColumnIdentifiers(col1);
		 
		JTable table=new JTable(d,col1);
		 table.setColumnSelectionAllowed(true);
		 table.setCellSelectionEnabled(true);
		 table.setBounds(60, 34, 285, 158);
		
		 
		//model.insertRow(1, d[0]);
		//model.insertRow(2, d[1]);
		//model.insertRow(3, d[2]);
		//model.insertRow(4, d[3]);
		//model.insertRow(5, d[4]);
		//model.insertRow(1,d);
		//table.setModel(model);
		//add(table);
		 
		 int v= ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		 int h= ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		 JScrollPane jsp=new JScrollPane(table,v,h);
		 contentPane.add(jsp);
		 getContentPane().add(table);
		 
		 setVisible(true);
	}
	/**
	 * Create the frame.
	 */
	public try23() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 34, 282, 152);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		//table = new JTable();
		
	}
}
