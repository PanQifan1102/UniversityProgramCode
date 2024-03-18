package login;

import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class manager_login {
	
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
			PreparedStatement ps= (PreparedStatement) con.prepareStatement("select manager_passward from manager where manager_id=?");
			System.out.println("请输入账号(Please enter the manager_ID)： ");
			ps.setInt(1, sc.nextInt());
			System.out.println("请输入密码(Please enter the password)： ");
			String password = sc.next();
			ResultSet rs=ps.executeQuery();			
			
			while(rs.next()) {
				String manager_passward = rs.getString(1);
				if(manager_passward.equals(password)) {
					System.out.println("登录成功(Login successful)");
				}else {
					System.out.println("登陆失败：账号或密码错误！(Login failed: account or password is incorrect!)");
					System.exit(0);;
				}
				
			}
			
			
		} catch (SQLException e) {
			
			
		}
		


	}

}
