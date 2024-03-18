package NormalUserModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class usermain {
	
	
	
	static Scanner sc = new Scanner(System.in);
	static String username="root";
	static String password="root";
	static String driver5="com.mysql.jdbc.Driver";
	static String url5="jdbc:mysql://localhost:3306/account_book"; 
	static Connection con;
	static Statement stmt;
	
	 public static void ognization() {
		 System.out.println("enter ognization!");
	 }
	 
	 public static void account() {
		 System.out.println("enter account!");
	 }
	 
	 public static void complaints() {
		 System.out.println("enter complaints!");
	 }

	 public static void main1(){
	    	System.out.println("欢迎来到普通用户界面");
	        System.out.println("1->用户登录(user login)");
	        System.out.println("2->用户注册(user register)");
	        System.out.println("0->退出用户界面(exit the user interface)");
	        System.out.println("============================");
	        System.out.print("输入你要进行的操作（Enter the action you want to take）：");
	        int choice1 = sc.nextInt();
	        String[] args = null;
			switch (choice1) {
	            case 1: {
	            	 System.out.println("欢迎来到用户登录页面(Welcome to the user login page)");
	                 login.userlogin.main(args);  
	                 break;
	            	}
	            
	            
	                
	            case 2: {
	            	System.out.println("欢迎进行用户注册(Welcome to user registration)");
	            	register.user_register.main(args);
	            	System.out.println("欢迎来到用户登录页面((Welcome to the user login page)");
	            	login.userlogin.main(args); 
	                break;
	            
	            }
	            
	            case 0: {
	               main.main.main(args);
	               
	            	}
	                
	              
	        }
	    }
	 

	 public static void main2(String[] args) {
		 
		 System.out.println("欢迎用户(Hi! Welcome to Family Wallet)");
	        System.out.println("1->进入组织（enter ognization）");
	        System.out.println("2->进入账目（enter account）");
	        System.out.println("0->退出用户界面（Exit the normal user interface）");
	        System.out.println("============================");
		
		 Choice:
		        do {
		            System.out.print("输入你要进行的操作（Enter the action you want to take）：");
		            int choice = sc.nextInt();
		            switch (choice) {
		                case 1: {
		                	ognization();
		                	user_og.main(args);
						
		                    break;
		                }
		                
		                case 2: {
		                	account();
		                	NorMain.main(args);
		                    break;
		                }
		                 
		                
		                case 0: {
		                    System.out.println("退出成功（Exit successful）");
		                    main1();
		                }
		                default: {
		                    System.out.println("选择非法重新选择！（Select Illegal, select again）");
		                    System.out.println("============================");
		                }
		            }
		        }while(true);
		 
	 }
	public static void main(String[] args) {
		
		main1();
		main2(args);
		
		
	    }

}
