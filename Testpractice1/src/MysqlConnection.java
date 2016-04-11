import java.sql.*;
import javax.swing.*;


public class MysqlConnection {

	Connection conn=null;
	
	public static Connection dbConnector()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/fanduel_user","root","");
			JOptionPane.showMessageDialog(null, "Connection Established");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}


