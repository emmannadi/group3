import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class LoginTest {
	String username = "abcde";
	String password = "12345";
	Scanner scn = new Scanner(System.in);
	
	String user, pass;

	@Test
	public void test() {
		System.out.println("Enter username");
		user = scn.nextLine();
		
		System.out.println("Enter password");
		pass = scn.nextLine();
		
		
		assertEquals(user, username);
		assertEquals(pass, password);
	}

}
