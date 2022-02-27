package injectionAttackDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pwd = "password";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url, user, pwd);
		Statement st = con.createStatement();
		
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer Name:");
		
		String customerName = sc.next();
		

		String sqlQuery = "select * from customer where customerName='"+customerName+"'";
		ResultSet rs = st.executeQuery(sqlQuery);
//		int c = 0;
//		if (rs.next()) {
//			c = rs.getInt(1);
//		}
//		if (c == 0)
//			System.out.println("Invalid Credentials");
//		else
//			System.out.println("Valid Credentials");
		
		if(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
		}
		con.close();

	}

}
