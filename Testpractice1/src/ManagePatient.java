import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.*;

public class ManagePatient extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagePatient frame = new ManagePatient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn = null;
	private JTextField txtpid;
	private JTextField txtpfirstname;
	private JTextField txtplastname;
	private JTextField txtdoctor;
	
	//refresh the table
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
	public ManagePatient() {
		conn=MysqlConnection.dbConnector();
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 740, 483);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(232, 63, 481, 316);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblmanagepatient = new JLabel("MANAGE PATIENT");
		lblmanagepatient.setFont(new Font("Arial", Font.BOLD, 15));
		lblmanagepatient.setBounds(10, 0, 150, 24);
		contentPane.add(lblmanagepatient);
		
		JButton btnloadpatientdetails = new JButton("Load Details");
		btnloadpatientdetails.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnloadpatientdetails.addActionListener(new ActionListener() {
			//load details from the managepatient
			public void actionPerformed(ActionEvent e) {
				
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
		btnloadpatientdetails.setBounds(571, 390, 131, 34);
		contentPane.add(btnloadpatientdetails);
		
		JLabel lblpid = new JLabel("Patient ID");
		lblpid.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblpid.setBounds(10, 32, 79, 30);
		contentPane.add(lblpid);
		
		txtpid = new JTextField();
		txtpid.setBounds(10, 61, 188, 34);
		contentPane.add(txtpid);
		txtpid.setColumns(10);
		
		JLabel lblpfristname = new JLabel("Patient FirstName");
		lblpfristname.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblpfristname.setBounds(10, 92, 131, 30);
		contentPane.add(lblpfristname);
		
		txtpfirstname = new JTextField();
		txtpfirstname.setBounds(10, 124, 188, 34);
		contentPane.add(txtpfirstname);
		txtpfirstname.setColumns(10);
		
		JLabel lblplastname = new JLabel("Patent LastName");
		lblplastname.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblplastname.setBounds(10, 156, 131, 30);
		contentPane.add(lblplastname);
		
		txtplastname = new JTextField();
		txtplastname.setBounds(10, 191, 188, 34);
		contentPane.add(txtplastname);
		txtplastname.setColumns(10);
		
		JLabel lbldescription = new JLabel("Description");
		lbldescription.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lbldescription.setBounds(10, 223, 111, 30);
		contentPane.add(lbldescription);
		
		JLabel lbldoctor = new JLabel("Doctor");
		lbldoctor.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lbldoctor.setBounds(10, 315, 111, 30);
		contentPane.add(lbldoctor);
		
		txtdoctor = new JTextField();
		txtdoctor.setBounds(10, 345, 188, 34);
		contentPane.add(txtdoctor);
		txtdoctor.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 253, 188, 61);
		contentPane.add(scrollPane_1);
		
		JTextArea txtdescription = new JTextArea();
		txtdescription.setLineWrap(true);
		txtdescription.setWrapStyleWord(true);
		scrollPane_1.setViewportView(txtdescription);
		//assign patient to doctor
		JButton btnassign = new JButton("Assign");
		btnassign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into managepatient (PID,PFirstname, PLastname,Description,Doctor) values (?,?,?,?,?)";
					PreparedStatement pst= conn.prepareStatement(query);
					pst.setString(1, txtpid.getText());
					pst.setString(2, txtpfirstname.getText());
					pst.setString(3, txtplastname.getText());
					pst.setString(4, txtdescription.getText());
					pst.setString(5, txtdoctor.getText());
					
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					pst.close();
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnassign.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnassign.setBounds(10, 390, 131, 34);
		contentPane.add(btnassign);
		
		JButton btnpatientupdate = new JButton("Update");
		btnpatientupdate.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnpatientupdate.setBounds(242, 391, 131, 34);
		contentPane.add(btnpatientupdate);
		
		JButton btnNewButton = new JButton("Bill Patient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Billing b= new Billing();
				b.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnNewButton.setBounds(413, 391, 131, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnNewButton_1.setBounds(625, 38, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
