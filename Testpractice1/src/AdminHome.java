import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;


public class AdminHome extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	private JTextField txtid;
	private JTextField txtfirstname;
	private JTextField txtlastname;
	private JTextField txtusername;
	private JTextField txtpassword;
	private JTextField txtrole;
	//refresh table
	public void refreshtable()
	{
		try {
			String query = "Select * from loginaccess";
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
	public AdminHome() {
		conn=MysqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 746, 492);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 59, 494, 295);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		//load details saved from the admin
		JButton btnloaddetails = new JButton("Load Detail");
		btnloaddetails.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnloaddetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "Select * from loginaccess";
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
		});
		btnloaddetails.setBounds(602, 391, 111, 34);
		contentPane.add(btnloaddetails);
		
		JLabel lblid = new JLabel("ID");
		lblid.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblid.setBounds(10, 28, 111, 34);
		contentPane.add(lblid);
		
		txtid = new JTextField();
		txtid.setBounds(10, 59, 188, 34);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblfirstname = new JLabel("Firstname");
		lblfirstname.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblfirstname.setBounds(10, 92, 111, 34);
		contentPane.add(lblfirstname);
		
		txtfirstname = new JTextField();
		txtfirstname.setBounds(10, 126, 188, 34);
		contentPane.add(txtfirstname);
		txtfirstname.setColumns(10);
		
		JLabel lbllastname = new JLabel("Lastname");
		lbllastname.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lbllastname.setBounds(10, 160, 111, 34);
		contentPane.add(lbllastname);
		
		txtlastname = new JTextField();
		txtlastname.setBounds(10, 193, 188, 34);
		contentPane.add(txtlastname);
		txtlastname.setColumns(10);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblusername.setBounds(10, 226, 111, 34);
		contentPane.add(lblusername);
		
		txtusername = new JTextField();
		txtusername.setBounds(10, 258, 188, 34);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblpassword.setBounds(10, 290, 111, 34);
		contentPane.add(lblpassword);
		
		txtpassword = new JTextField();
		txtpassword.setBounds(10, 321, 188, 34);
		contentPane.add(txtpassword);
		txtpassword.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "insert into loginaccess (ID,Firstname, Lastname,Username,Password,role) values (?,?,?,?,?,?)";
					PreparedStatement pst= conn.prepareStatement(query);
					pst.setString(1, txtid.getText());
					pst.setString(2, txtfirstname.getText());
					pst.setString(3, txtlastname.getText());
					pst.setString(4, txtusername.getText());
					pst.setString(5, txtpassword.getText());
					pst.setString(6, txtrole.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					pst.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				refreshtable();
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnNewButton.setBounds(239, 391, 111, 34);
		contentPane.add(btnNewButton);
		
		JButton btnmanagepatient = new JButton("ManagePatient");
		btnmanagepatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagePatient mp = new ManagePatient();
				mp.setVisible(true);
				dispose();
				
			}
		});
		btnmanagepatient.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnmanagepatient.setBounds(589, 12, 131, 34);
		contentPane.add(btnmanagepatient);
		
		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete!!!","Delete",JOptionPane.YES_NO_OPTION);
				if(action==0)
				try {
					String query = "Delete from loginaccess where ID = '"+txtid.getText()+"'";
					PreparedStatement pst= conn.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Record Deleted");
					
					pst.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				refreshtable();
			}
		});
		btndelete.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btndelete.setBounds(360, 391, 111, 34);
		contentPane.add(btndelete);
		
		JButton btnupdate = new JButton("Update");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "update loginaccess set ID = '"+txtid.getText()+"', Firstname= '"+txtfirstname.getText()+"',Lastname= '"+txtlastname.getText()+"',"
							+ " Username= '"+txtusername.getText()+"', Password= '"+txtpassword.getText()+"' where ID = '"+txtid.getText()+"'";
					PreparedStatement pst= conn.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Update Saved");
					
					pst.close();
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				refreshtable();
			}
		});
		btnupdate.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnupdate.setBounds(481, 391, 111, 34);
		contentPane.add(btnupdate);
		
		JButton btnmain = new JButton("Main");
		btnmain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m= new Main();
				m.setVisible(true);
				dispose();
			}
		});
		btnmain.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnmain.setBounds(454, 12, 131, 34);
		contentPane.add(btnmain);
		
		JLabel lblNewLabel = new JLabel("WELCOME ADMIN");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 0, 131, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblrole = new JLabel("Role");
		lblrole.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblrole.setBounds(10, 355, 111, 34);
		contentPane.add(lblrole);
		
		txtrole = new JTextField();
		txtrole.setBounds(10, 392, 188, 34);
		contentPane.add(txtrole);
		txtrole.setColumns(10);
		
		
	}
}
