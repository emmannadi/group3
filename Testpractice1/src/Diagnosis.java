import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Diagnosis extends JFrame {

	private JPanel contentPane;
	private JTextField txtrid;
	private JTextField txtrfirstname;
	private JTextField txtrlastname;
	private JTextField txtrdescription;
	private JTable table;
	private JCheckBox medication;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diagnosis frame = new Diagnosis();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn = null;
	public void refreshtable()
	{
		try {
			String query = "Select * from diagnosisresult";
			PreparedStatement pst= conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			//convert result set to model for the table to view database data
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public Diagnosis() {
		conn=MysqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 488);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblrid = new JLabel("ID");
		lblrid.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblrid.setBounds(31, 66, 50, 30);
		contentPane.add(lblrid);
		
		JLabel lblrfirstname = new JLabel("Firstname");
		lblrfirstname.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblrfirstname.setBounds(31, 107, 80, 30);
		contentPane.add(lblrfirstname);
		
		JLabel lblrlastname = new JLabel("Lastname");
		lblrlastname.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblrlastname.setBounds(31, 148, 80, 30);
		contentPane.add(lblrlastname);
		
		txtrid = new JTextField();
		txtrid.setBounds(115, 66, 65, 30);
		contentPane.add(txtrid);
		txtrid.setColumns(10);
		
		txtrfirstname = new JTextField();
		txtrfirstname.setBounds(115, 107, 188, 30);
		contentPane.add(txtrfirstname);
		txtrfirstname.setColumns(10);
		
		txtrlastname = new JTextField();
		txtrlastname.setBounds(115, 148, 188, 30);
		contentPane.add(txtrlastname);
		txtrlastname.setColumns(10);
		
		JCheckBox chckbxasprin = new JCheckBox("Asprin");
		chckbxasprin.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		chckbxasprin.setBounds(31, 317, 100, 30);
		contentPane.add(chckbxasprin);
		
		JCheckBox chckbxdrip = new JCheckBox("Drip (IV)");
		chckbxdrip.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		chckbxdrip.setBounds(383, 317, 100, 30);
		contentPane.add(chckbxdrip);
		
		JCheckBox chckbxantiboitics = new JCheckBox("Anti-Biotics");
		chckbxantiboitics.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		chckbxantiboitics.setBounds(149, 317, 100, 30);
		contentPane.add(chckbxantiboitics);
		
		JCheckBox chckbxxray = new JCheckBox("Xray");
		chckbxxray.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		chckbxxray.setBounds(149, 361, 100, 30);
		contentPane.add(chckbxxray);
		
		txtrdescription = new JTextField();
		txtrdescription.setBounds(115, 200, 250, 97);
		contentPane.add(txtrdescription);
		txtrdescription.setColumns(10);
		
		JLabel lblrdescription = new JLabel("Description");
		lblrdescription.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblrdescription.setBounds(31, 200, 80, 30);
		contentPane.add(lblrdescription);
		
		JCheckBox chckbxbp = new JCheckBox("BP Test");
		chckbxbp.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		chckbxbp.setBounds(31, 361, 100, 30);
		contentPane.add(chckbxbp);
		
		JCheckBox chckbxbloodtest = new JCheckBox("BloodTest");
		chckbxbloodtest.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		chckbxbloodtest.setBounds(265, 361, 100, 30);
		contentPane.add(chckbxbloodtest);
		
		JCheckBox chckbxinjection = new JCheckBox("Injection");
		chckbxinjection.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		chckbxinjection.setBounds(265, 317, 100, 30);
		contentPane.add(chckbxinjection);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String medication =(String)medication();
					medication = "chckbxasprin, chckbxantiboitics, chckbxinjection, chckbxdrip, chckbxbp, chckbxxray, chckbxbloodtest";
					String query = "insert into diagnosisresult (RID,Rfirstname, Rlastname,Rdescription,Rmedication) values (?,?,?,?)";
					PreparedStatement pst= conn.prepareStatement(query);
					pst.setString(1, txtrid.getText());
					pst.setString(2, txtrfirstname.getText());
					pst.setString(3, txtrlastname.getText());
					pst.setString(4, txtrdescription.getText());
					pst.setString(5, medication().toString());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Result Saved");
					
					pst.close();
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			private String medication() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnNewButton.setBounds(31, 408, 100, 30);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			}
		});
		scrollPane.setBounds(383, 55, 334, 242);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JCheckBox chckbxpregtest = new JCheckBox("Preg. Test");
		chckbxpregtest.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		chckbxpregtest.setBounds(383, 361, 100, 30);
		contentPane.add(chckbxpregtest);
		
		JButton btnNewButton_1 = new JButton("Load record");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "Select * from diagnosisresult";
					PreparedStatement pst= conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					//convert result set to model for the table to view database data
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					rs.close();
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				refreshtable();
			}
		});
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnNewButton_1.setBounds(597, 308, 120, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m= new Main();
				m.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnNewButton_2.setBounds(149, 408, 100, 30);
		contentPane.add(btnNewButton_2);
	}
}
