package NormalUserModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class user_og {
	
	static Scanner sc = new Scanner(System.in);
	static String username="root";
	static String password="root";
	static String driver5="com.mysql.jdbc.Driver";
	static String url5="jdbc:mysql://localhost:3306/account_book"; 
	static Connection con;
	static Statement stmt;
	
	static void addog(){
        System.out.println("add");
    }
    static void findog(){
        System.out.println("find");
    }
    static void modifyog(){
        System.out.println("mod");
    }
    static void delog(){
        System.out.println("del");
    }
    
    static void menu(String[] args){
        System.out.println("欢迎系统管理员(Hi! Administrator.)");
        
        Scanner scan = new Scanner(System.in);

        Choice:
        do {
        	System.out.println("1->添加组织(add the oganization)");
            System.out.println("2->修改组织信息(modify the oganization information)");
            System.out.println("3->查找组织（已知ID）(find the oganization)");
            System.out.println("4->删除组织(delete the oganization)");
            System.out.println("5->查找我的组织(fing my oganization)");
            System.out.println("6->增加组织成员(add the oganization member)");
            System.out.println("7->减少组织成员(delete the oganization member)");
            System.out.println("8->查看组织成员(view the oganization members)");
            System.out.println("0->退出组织界面(exit the oganization interface)");
            System.out.println("============================");
            System.out.print("输入你要进行的操作(Enter the action you want to take)：");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    addog();
                    try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("insert into oganization values(?,?,?);");
                		System.out.println("请设置og_id(Please set the og_id): ");
                		ps.setInt(1, sc.nextInt());
                		System.out.println("请设置og_name(Please set the og_name): ");
                		ps.setString(2, sc.next());
                		System.out.println("请设置og_founder_name(Please set the og_foundedr_name: ");
                		ps.setString(3, sc.next());
                		ps.executeUpdate();
                		   		
                	}catch(Exception e)
                	{
                		
                	}
                	}
				
                    break;
                   
                
                    
                case 2: {
                    modifyog();
                    try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("update oganization set og_name = ?,og_founder = ? where og_id=?;");
                		System.out.println("请输入修改后的组织名(Please enter the modified organization name): ");
                		ps.setString(1, sc.next());
                		System.out.println("请输入修改后的领导者名(Please enter the modified oganization_leader_name)");
                		ps.setString(2, sc.next());
                		System.out.println("Please enter the id which you want to modify: ");
                		ps.setInt(3, sc.nextInt());
                		ps.executeUpdate();
                		stmt=con.createStatement();   		
                	}catch(Exception e)
                	{
                		
                	}
                	}
                    break;
                
                case 3: {
                    findog();
                    try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select * from oganization where og_id= ?;");
                		System.out.println("请输入id(Please enter the og_id)： ");
                		ps.setInt(1, sc.nextInt());
                		
                		ResultSet rs=ps.executeQuery();
                		
                		while(rs.next()) {
                			System.out.println("og_id ----> "+rs.getInt(1)+" "+" og_name ---->"+rs.getString(2)+" "
                			+" og_leader ----> "+rs.getString(3));
                		}
                		
                		System.out.println("Done..");

                		//step- 3 Statement Object
                		stmt=con.createStatement();
                	}catch(Exception e)
                	{
                		
                	}
                	}
                    
                    break;
                    
                
                case 4: {
                    delog();
                    try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);      
                		PreparedStatement pss= (PreparedStatement) con.prepareStatement("delete  from og_user where og_id=?;");
                		System.out.println("Please enter the og_id which you want to delete : "); 		
                		pss.setInt(1, sc.nextInt());
                		pss.executeUpdate();
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("delete  from oganization where og_id=?;");
                		System.out.println("Please enter the og_id which you want to delete again: "); 		
                		ps.setInt(1, sc.nextInt());
                		ps.executeUpdate();
                		stmt=con.createStatement();   		
                	}catch(Exception e)
                	{
                		
                	}
                	}
                    break;
                    
                case 5:{//实现不了，存疑
                	
                	try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select * from og_user where user_id = ?;");
                		System.out.println("请输入id(Please enter your id)： ");
                		ps.setInt(1, sc.nextInt());
                		
                		ResultSet rs=ps.executeQuery();
                		
                		while(rs.next()) {
                			System.out.println("og_id ----> "+rs.getInt(1)+" "+" user_id ---->"+rs.getInt(2));
                		}
                		
                		System.out.println("Done..");

                		//step- 3 Statement Object
                		stmt=con.createStatement();
                	}catch(Exception e)
                	{
                		
                	}
                	
                }
                break;
                
                case 6: {
                    
                    try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("insert into og_user values(?,?);");
                		System.out.println("请输入需要增加成员的组织ID(Please enter the ID of the organization to which you want to add members):");
                		ps.setInt(1, sc.nextInt());
                		System.out.println("Please enter the user_id which you want to add: ");
                		ps.setInt(2, sc.nextInt());
                		ps.executeUpdate();
                		   		
                	}catch(Exception e)
                	{
                		
                	}
                	}
					
                       
                    break;
                case 7:{
                	
                	try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("delete  from og_user where og_id=? && user_id=?;");
                		System.out.println("Please enter the og_id which you want to delete: "); 		
                		ps.setInt(1, sc.nextInt());
                		System.out.println("请输入你要删除的成员ID(Please enter the ID of the member you want to delete): "); 
                		ps.setInt(2, sc.nextInt());
                		ps.executeUpdate();
                		stmt=con.createStatement();   		
                	}catch(Exception e)
                	{
                		
                	}
                	
                }
                
                    break;
                case 8:{
                	
                	try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select * from og_user where og_id= ?;");
                		System.out.println("请输入og_id(Please enter og_id)： ");
                		ps.setInt(1, sc.nextInt());
                		
                		ResultSet rs=ps.executeQuery();
                		
                		while(rs.next()) {
                			System.out.println("og_id ----> "+rs.getInt(1)+" "+" user_id ---->"+rs.getInt(2));
                		}
                		
                		System.out.println("Done..");

                		stmt=con.createStatement();
                	}catch(Exception e)
                	{
                		
                	}
                }
                break;
                case 0: {
                    System.out.println("退出成功(success)");
                    usermain.main2(args);
                }
                default: {
                    System.out.println("选择非法重新选择！(Select Illegal Re-selection!)");
                    System.out.println("============================");
                }
            }
        }while(true);
    }

	public static void main(String[] args) {
		
		menu(args);
	}

}
