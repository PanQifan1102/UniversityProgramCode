package register;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class manager_register {
	
	static String username="root";
	static String password="root";
	static String driver5="com.mysql.jdbc.Driver";
	static String url5="jdbc:mysql://localhost:3306/account_book"; 
	static java.sql.Connection con;
	Statement stmt;

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		try {
			con = DriverManager.getConnection(url5,username,password); 
			PreparedStatement ps= (PreparedStatement) con.prepareStatement("insert into manager values(?,?,?,?);");
			System.out.println("请设置账号ID(Please set the manager_id)：");
			ps.setInt(1, sc.nextInt());
			System.out.println("请设置密码(Please set the password)：");
			ps.setString(2, sc.next());
			System.out.println("请设置账户名(Please set the manager_name)：");
			ps.setString(3, sc.next());
			System.out.println("请设置账户邮箱(Pleaase set the manager_mailbox)：");
    		ps.setString(4, sc.next());
    		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			
		}

	}

}
