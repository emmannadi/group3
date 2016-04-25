import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class AdminHomeTest {

	
	String Firstname = "Emmanuel";
	String Lastname = "james";
	String Username = "user";
	String password = "12345";
	String role = "doctor";
	
	Scanner in = new Scanner(System.in);
	
	String fname, lname, uname, pword, urole;
	
	@Test
	public void test() {
	      
	      System.out.println("Enter a Firstname");
	      fname = in.nextLine();
	      
	      System.out.println("Enter a Lastname");
	      lname = in.nextLine();
	      
	      System.out.println("Enter a Username");
	      uname = in.nextLine();
	      
	      System.out.println("Enter a Password");
	      pword = in.nextLine();
	      
	      System.out.println("Enter a Role");
	      urole = in.nextLine();
	      
	      assertEquals(fname, Firstname);
	      assertEquals(lname, Lastname);
	      assertEquals(uname, Username);
	      assertEquals(pword, password);
	      assertEquals(urole, role);
	}

}
