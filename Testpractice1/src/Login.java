import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;



import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn = null;
	private JTextField txtusername;
	private JPasswordField passwordField;
	private JComboBox comboBoxlist;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		conn = MysqlConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 545, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setForeground(Color.WHITE);
		lblusername.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblusername.setBounds(218, 126, 101, 35);
		frame.getContentPane().add(lblusername);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setForeground(Color.WHITE);
		lblpassword.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblpassword.setBounds(218, 172, 101, 35);
		frame.getContentPane().add(lblpassword);
		
		txtusername = new JTextField();
		txtusername.setBounds(319, 126, 189, 35);
		frame.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(319, 172, 189, 35);
		frame.getContentPane().add(passwordField);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//try{
					//String query="Select * from loginaccess where username=? and password=?";
					//PreparedStatement pst= conn.prepareStatement(query);
					//pst.setString(1, txtusername.getText());
					//pst.setString(2, passwordField.getText());
					
					
					//ResultSet rs=pst.executeQuery();
					
					//int count =0;
					//while(rs.next()){
					//	count=count+1;
						
					
					//String uname = rs.getString("username");
			        //String pass = rs.getString("password");
					//String role = (comboBoxlist.getSelectedItem().toString());
					
					//if ((txtusername.equals(uname)) && (passwordField.equals(pass))){
					//if (role.equals("ADMIN")){
					//		JOptionPane.showMessageDialog(null, "WELCOME ADMIN");
					//		frame.dispose();
					//		AdminHome admhm = new AdminHome();
					//		admhm.setVisible(true);
					//}
					
					//	else if(role.equals("NURSE")){
					//			JOptionPane.showMessageDialog(null, "WELCOME NURSE");
					//			ManagePatient mp = new ManagePatient();
					//			mp.setVisible(true);
					//}
					//	else if(role.equals("DOCTOR")){
					//			JOptionPane.showMessageDialog(null, "WELCOME Doctor");
					//			Main m= new Main();
					//			m.setVisible(true);
					//	}
					//	else{
					//		JOptionPane.showMessageDialog(null, "Username and password is INVALID");
					//	}
					//}
				//}
					//rs.close();
					//pst.close();
					//}catch (Exception e){
					//JOptionPane.showMessageDialog(null, e);
				
				//}				
				
				
				
				
				
				
				
				
				try{
					
					String query="Select * from loginaccess where username=? and password=?";
					PreparedStatement pst= conn.prepareStatement(query);
					pst.setString(1, txtusername.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					int count =0;
					while(rs.next()){
						count=count+1;
					}
					if(count ==1)
					{
						JOptionPane.showMessageDialog(null, "Welcome Admin");
						frame.dispose();
						AdminHome admhm = new AdminHome();
						admhm.setVisible(true);
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "User already exist");
					}
					else{
						JOptionPane.showMessageDialog(null, "Username and password is INVALID");
					}
					rs.close();
					pst.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		btnlogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnlogin.setBounds(407, 218, 101, 35);
		frame.getContentPane().add(btnlogin);
		
		JComboBox comboBoxlist = new JComboBox();
		comboBoxlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBoxlist.setBounds(319, 75, 189, 35);
		frame.getContentPane().add(comboBoxlist);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\JEFFERY\\Desktop\\images\\background.jpg"));
		label.setBounds(0, 0, 529, 305);
		frame.getContentPane().add(label);
	}
}
