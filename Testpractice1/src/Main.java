import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTable tablemain;
	private JComboBox comboBoxselection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	private JTextField textFieldsearch;
	private JTextField textFielddescription;
	private JTextField textFieldpfirstname;
	private JTextField textFieldplastname;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_1;
	private JTextField textFieldID;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	public void refreshtable()
	{
		try {
			String query = "Select * from managepatient";
			PreparedStatement pst= conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			//convert result set to model for the table to view database data
			tablemain.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//public void fillcomboBox()
	//{
	//	try {
	//		String query = "Select * from managepatient";
	//		PreparedStatement pst= conn.prepareStatement(query);
	//		ResultSet rs=pst.executeQuery();
	//		while(rs.next())
	//		{
	//			comboBoxviewcases.addItem(rs.getString("Doctor"));
	//		}
	//		pst.close();
	//		rs.close();
			
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//	}
	//}
	/**
	 * Create the frame.
	 */
	public Main() {
		conn=MysqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 743, 475);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 51, 693, 192);
		contentPane.add(scrollPane);
		//table click and select
		tablemain = new JTable();
		tablemain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row = tablemain.getSelectedRow();
					String PID_=(tablemain.getModel().getValueAt(row, 0)).toString();
					//String Pfirstname_=(tablemain.getModel().getValueAt(row, 1)).toString();
					//String Plastname_=(tablemain.getModel().getValueAt(row, 2)).toString();
					//String Description_=(tablemain.getModel().getValueAt(row, 3)).toString();
					
					String query = "Select * from managepatient where PID='"+PID_+"'";
					PreparedStatement pst= conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						textFieldID.setText(rs.getString("PID"));
						textFieldpfirstname.setText(rs.getString("pfirstname"));
						textFieldplastname.setText(rs.getString("plastname"));
						textFielddescription.setText(rs.getString("Description"));
					}
					
					pst.close();
					rs.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(tablemain);
		
		JLabel lblNewLabel = new JLabel("MAIN SCREEN");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(24, 11, 124, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnloadcases = new JButton("Load Cases");
		btnloadcases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "Select * from managepatient";
					PreparedStatement pst= conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					//convert result set to model for the table to view database data
					tablemain.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					rs.close();
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				refreshtable();
				
			}
		});
		btnloadcases.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnloadcases.setBounds(586, 380, 131, 34);
		contentPane.add(btnloadcases);
		
		 comboBoxselection = new JComboBox();
		 comboBoxselection.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	}
		 });
		 comboBoxselection.setModel(new DefaultComboBoxModel(new String[] {"Doctor", "PID", "Pfirstname", "Plastname"}));
		comboBoxselection.setBounds(586, 299, 131, 25);
		contentPane.add(comboBoxselection);
		
		JButton btndiagnosisresult = new JButton("Diagnosis Result");
		btndiagnosisresult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Diagnosis dn= new Diagnosis();
				dn.setVisible(true);
				dispose();
			}
		});
		btndiagnosisresult.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btndiagnosisresult.setBounds(586, 335, 131, 34);
		contentPane.add(btndiagnosisresult);
		//keyhandler for searching from database
		textFieldsearch = new JTextField();
		textFieldsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String selection =(String)comboBoxselection.getSelectedItem();
					String query = "Select * from managepatient where "+selection+"=?";
					System.out.println(query);
					PreparedStatement pst= conn.prepareStatement(query);
					pst.setString(1, textFieldsearch.getText());
					ResultSet rs=pst.executeQuery();
					tablemain.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		textFieldsearch.setBounds(586, 254, 131, 34);
		contentPane.add(textFieldsearch);
		textFieldsearch.setColumns(10);
		
		textFielddescription = new JTextField();
		textFielddescription.setBounds(245, 281, 317, 133);
		contentPane.add(textFielddescription);
		textFielddescription.setColumns(10);
		
		textFieldpfirstname = new JTextField();
		textFieldpfirstname.setBounds(24, 332, 160, 30);
		contentPane.add(textFieldpfirstname);
		textFieldpfirstname.setColumns(10);
		
		textFieldplastname = new JTextField();
		textFieldplastname.setBounds(24, 383, 160, 30);
		contentPane.add(textFieldplastname);
		textFieldplastname.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Firstname");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(24, 317, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Lastname");
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(24, 368, 90, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_1 = new JLabel("Description");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(245, 264, 104, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(24, 286, 86, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(23, 264, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton = new JButton("Sign out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnNewButton.setBounds(628, 15, 89, 23);
		contentPane.add(btnNewButton);
		
		
		//fillcomboBox();
	}
}
