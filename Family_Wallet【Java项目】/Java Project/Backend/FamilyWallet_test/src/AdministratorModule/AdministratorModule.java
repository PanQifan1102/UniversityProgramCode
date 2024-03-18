package AdministratorModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class AdministratorModule {
	static Scanner sc = new Scanner(System.in);
	static String username="root";
	static String password="root";
	static String driver5="com.mysql.jdbc.Driver";
	static String url5="jdbc:mysql://localhost:3306/account_book"; 
	static Connection con;
	static Statement stmt;
	private static String[] args;
    static void addUser(){
        System.out.println("add");
    }
    static void findUser(){
        System.out.println("find");
    }
    static void modifyUser(){
        System.out.println("mod");
    }
    static void delUser(){
        System.out.println("del");
    }

    static void menu(){
    	System.out.println("欢迎系统管理员(Hi! Administrator.)");
        System.out.println("1->添加用户(Add users)");
        System.out.println("2->修改用户信息(Modify user information)");
        System.out.println("3->查找用户(Find the user)");
        System.out.println("4->删除用户(Delete the user)");
        System.out.println("0->退出管理员界面(Exit the administrator interface)");
        System.out.println("============================");
        
        Scanner scan = new Scanner(System.in);

        Choice:
        do {
        	
            System.out.print("输入你要进行的操作(Enter the action you want to take)：");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    addUser();
                    try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("insert into user values(?,?,?,?);");
                		System.out.println("请设置user_id(Please set the user_id): ");
                		ps.setInt(1, sc.nextInt());
                		System.out.println("请设置user_passward(Please set the user_passward): ");
                		ps.setString(2, sc.next());
                		System.out.println("请设置user_name(Please set the user_name): ");
                		ps.setString(3, sc.next());
                		System.out.println("请设置user_mailbox(Please set the user_mailbox): ");
                		ps.setString(4, sc.next());
                		ps.executeUpdate();
                		   		
                	}catch(Exception e)
                	{
                		
                	}
                	}
					
                       
                    break;
                
                    
                case 2: {
                    modifyUser();
                    try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("update user set user_passward = ? where user_id=?;");
                		System.out.println("Please enter the password which you want to update: ");
                		ps.setString(1, sc.next());
                		System.out.println("Please enter the id which you want to update: ");
                		ps.setInt(2, sc.nextInt());
                		ps.executeUpdate();
                		stmt=con.createStatement();   		
                	}catch(Exception e)
                	{
                		
                	}
                	}
                    break;
                
                case 3: {
                    findUser();
                    try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select * from user where user_id= ?;");
                		System.out.println("请输入id(Please enter ID)： ");
                		ps.setInt(1, sc.nextInt());
                		
                		ResultSet rs=ps.executeQuery();
                		
                		while(rs.next()) {
                			System.out.println("user_id ----> "+rs.getInt(1)+" "+" user_password ---->"+rs.getString(2)
                			+" user_name ----> "+"  "+rs.getString(3)+"  "+"user_mailbox ---- > "+rs.getString(4));
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
                    delUser();
                    try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);   
                		PreparedStatement pss= (PreparedStatement) con.prepareStatement("delete  from account_pay where user_id=?;");
                		System.out.println("Please enter the id which you want to delete: "); 		
                		pss.setInt(1, sc.nextInt());
                		pss.executeUpdate();
                		PreparedStatement psss= (PreparedStatement) con.prepareStatement("delete  from og_user where user_id=?;");
                		System.out.println("Please enter the id which you want to delete again: "); 		
                		psss.setInt(1, sc.nextInt());
                		psss.executeUpdate();
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("delete  from user where user_id=?;");
                		System.out.println("Please enter the id which you want to delete on the third time: "); 		
                		ps.setInt(1, sc.nextInt());
                		ps.executeUpdate();
                		stmt=con.createStatement();   		
                	}catch(Exception e)
                	{
                		
                	}
                	}
                    break;
                
                case 0: {
                    System.out.println("退出成功(Exit successful)");               
                    main1();
                    break Choice;
                }
                default: {
                    System.out.println("选择非法重新选择!(Select Illegal Re-selection!)");
                    System.out.println("============================");
                }
            }
        }while(true);
    }

    public static void main1(){
    	System.out.println("欢迎来到管理员界面(Welcome to the Administrator Interface)");
        System.out.println("1->管理员登录(Administrator login)");
        System.out.println("2->管理员注册(Administrator registration)");
        System.out.println("0->退出管理员界面(Exit the administrator interface)");
        System.out.println("============================");
        System.out.print("输入你要进行的操作(Enter the action you want to take)：");
        int choice1 = sc.nextInt();
        switch (choice1) {
        
        
            case 1: {
            	 System.out.println("欢迎来到管理员登陆页面(Welcome to the admin landing page)");
                 login.manager_login.main(args);    
                 break;
            	}
            
            
                
            case 2: {
            	System.out.println("欢迎来到管理员注册页面(Welcome to the Admin Registration page)");
            	register.manager_register.main(args);
            	System.out.println("欢迎来到管理员登陆页面(Welcome to the admin landing page)");
                login.manager_login.main(args);   
                break;
            
            }
            
            case 0: {
               main.main.main(args);
               
            	}
                
              
        }
    }
        

    
    public static void main(String[] args) {
    	main1();
    	menu();
    	

    }
}



