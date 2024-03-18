package NormalUserModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class useroganization {
	
	static Scanner sc = new Scanner(System.in);
	static String username="root";
	static String password="root";
	static String driver5="com.mysql.jdbc.Driver";
	static String url5="jdbc:mysql://localhost:3306/account_book"; 
	static Connection con;
	static Statement stmt;
	
	public static void create() {
		System.out.println("请输入创建组织的信息：");
		 
     	}	
	
	
	public static void query() {

		 Choice:
		        do {
		            System.out.println("输入你要进行的操作（Enter the action you want to take）：");
		            System.out.println("1->关于我的组织");
		            System.out.println("2->已知组织ID查询组织");
		            int choice = sc.nextInt();	
		            switch (choice) {		
		            case 1:{			
		            	System.out.println("请输入你的ID：");
		            	try {
	                		Class.forName(driver5);
	                		con = DriverManager.getConnection(url5,username,password);        	    
	                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select * from oganization where oganization_id= (select og_id from og_user where user_id=?);"); 
	                				
	                		ps.setInt(1, sc.nextInt());	
	                		ResultSet rs=ps.executeQuery();
	                		
	                		while(rs.next()) {
	                			System.out.println("og_id ----> "+rs.getInt(1)+"   "+"og_name ---->"+rs.getString(2)+"   "+"og_founder ---->"+rs.getString(3));//有疑问，如何输出一个表
	                		}
	                		
	                		stmt=con.createStatement();
	                	
	                		   		
	                	}catch(Exception e)
	                	{
	                		
	                	}
	                	}
		            
		            case 2:{
		            	System.out.println("请输入需查询组织的ID：");
		            	try {
	                		Class.forName(driver5);
	                		con = DriverManager.getConnection(url5,username,password);        	    
	                		
	                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select * from oganization where og_id= ?;");
	                		ps.setInt(1, sc.nextInt());	
	                		ResultSet rs=ps.executeQuery();
	                		
	                		while(rs.next()) {
	                			System.out.println("og_id ----> "+rs.getInt(1)+" "+" user_id ---->"+rs.getInt(2));
	                		}
	                		stmt=con.createStatement();
		            	    }catch(Exception e)
	                		{
	                    		
	                    	}
		            }
		            }}while(true);
	}
	
	public static void delete() {
		System.out.println("Please enter the og_id which you want to delete: "); 
		 try {
     		Class.forName(driver5);
     		con = DriverManager.getConnection(url5,username,password);        	    
     		PreparedStatement ps= (PreparedStatement) con.prepareStatement("delete  from oganization where og_id=?;");   				
     		ps.setInt(1, sc.nextInt());
     		ps.executeUpdate();
     		stmt=con.createStatement();   		
     	}catch(Exception e)
     	{
     	}
		
	}
	
	public static void resetting() {
		 try {
     		Class.forName(driver5);
     		con = DriverManager.getConnection(url5,username,password);        	    
     		PreparedStatement ps= (PreparedStatement) con.prepareStatement("update account set og_name=?,og_founder=? where og_id=?;");
     		System.out.println("改变后组织的名字: ");
     		ps.setString(1, sc.next());
     		System.out.println("改变后组织的创建者: ");
     		ps.setString(2, sc.next());
     		System.out.println("被改变的组织ID是: ");
     		ps.setInt(3, sc.nextInt());
     		ps.executeUpdate();
     		stmt=con.createStatement();   		
     	}catch(Exception e)
     	{
     		
     	}
		
	}

	public static void main(String[] args) {
		
		System.out.println("欢迎用户(Hi! Welcome to oganization)");
        System.out.println("1->创建组织（create oganiztion）");
        System.out.println("2->查询组织（query oganization）");
        System.out.println("3->删除组织(delete oganization)");
        System.out.println("4->重置组织信息(resetting oganization infomation)");
        System.out.println("0->退出组织界面（Exit the normal oganization interface）");
        System.out.println("============================");
        Scanner sc = new Scanner(System.in);
        Choice:
	        do {
	            System.out.print("输入你要进行的操作（Enter the action you want to take）：");
	            int choice = sc.nextInt();
	            switch (choice) {
	                case 1: {
	                	create() ;	
	                	try {
	                 		Class.forName(driver5);
	                 		con = DriverManager.getConnection(url5,username,password);        	        			                 		
	                 		PreparedStatement ps= (PreparedStatement) con.prepareStatement("insert into oganization values(?,?,?);");
	                 		System.out.println("Please enter the ognization_id which you want to add: ");
	                 		System.out.println("Please enter the og_name which you want to add: ");
	                 		System.out.println("Please enter the og_founder which you want to add: ");
	                 		ps.setInt(1, sc.nextInt());
	                 		ps.setString(2, sc.next());
	                 		ps.setString(2, sc.next());
	                   		ps.executeUpdate();
	                 		   		
	                 	}catch(Exception e)
	                 	{
	                 		
	                 	}
	                	break;
	                }
	               
	                
	                case 2: {
	                	
	                	query();
	                    break;
	                }
	                case 3: {
	                	delete();                    
	                    break;
	                }
	                case 4:{
	                	resetting();
	                	break;
	                }
	                 
	                
	                case 0: {
	                    System.out.println("退出成功（Exit successful）");
	                    usermain.main(args);
	                }
	                default: {
	                    System.out.println("选择非法重新选择！（Select Illegal, select again）");
	                    System.out.println("============================");
	                }
	            }
	        }while(true);

	}

}
