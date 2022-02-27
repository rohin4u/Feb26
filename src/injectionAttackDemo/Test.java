package injectionAttackDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pwd = "password";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url, user, pwd);
		Statement st = con.createStatement();
		
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter username:");
		
		String uname = sc.next();
		
		System.out.println("Enter pwd:");
		String upwd = sc.next();
		
		String sqlQuery = "select count(*) from users where username='" + uname + "' and password='" + upwd + "'";
		
		
//		String sqlQuery = "select * from customer where customerId=101";
		ResultSet rs = st.executeQuery(sqlQuery);
		int c = 0;
		if (rs.next()) {
			c = rs.getInt(1);
		}
		if (c == 0)
			System.out.println("Invalid Credentials");
		else
			System.out.println("Valid Credentials");
		con.close();
		
		

	}

}
