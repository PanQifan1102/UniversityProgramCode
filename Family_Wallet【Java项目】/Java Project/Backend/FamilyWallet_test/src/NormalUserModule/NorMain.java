package NormalUserModule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class NorMain {
    //账目操作
	static Scanner sc = new Scanner(System.in);
	static String username="root";
	static String password="root";
	static String driver5="com.mysql.jdbc.Driver";
	static String url5="jdbc:mysql://localhost:3306/account_book"; 
	static Connection con;
	static Statement stmt;
    public static void add()
    {
        System.out.println("Add an account"); 
  
        
    }
    public static void modify()
    {
        System.out.println("Modify an account");
    }
    public static void find()
    {
        System.out.println("Find an account");
    }
    public static void delete()
    {
        System.out.println("Delete an account");
    }
    //普通用户登录成功页面
    static void NorInterface(String[] args){
        
        Scanner scan = new Scanner(System.in);

        Choice:
        do {
        	System.out.println("欢迎用户(Hi! Welcome to Family Wallet)");
            System.out.println("1->添加新的账目（Add a new account）");
            System.out.println("2->修改账目金额（Modify existing accounts money）");
            System.out.println("3->查找账目基本信息（Find statistical accounts basic information）");
            System.out.println("4->删除已有账目(Delete existing accounts)");
            System.out.println("5->查看组织账目基本信息(View oganizational accounts)");
            System.out.println("6->增加账目支付人(Add the number of payers of the accounts)");
            System.out.println("7->删除账目支付人(Delete the number of payers of the accounts)");
            System.out.println("8->修改支付人缴费情况（Modify the payer's payment status）");
            System.out.println("9->查看账目支付人名单以及支付情况(View the list of payers on the account and the status of payments)");
            System.out.println("10->查看某人的未缴账目(View someone's outstanding accounts)");
            System.out.println("0->退出账目界面（Exit the account interface）");
            System.out.println("============================");
            System.out.print("输入你要进行的操作（Enter the action you want to take）：");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    add();
                    try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("insert into account values(?,?,?,?);");
                		System.out.println("请设置account_ID(Please set the account_ID): ");
                		ps.setInt(1, sc.nextInt());
                		System.out.println("请设置account_type(Please set the account_type): ");
                		ps.setString(2, sc.next());
                		System.out.println("请设置account_founder_id(Please set the account_foundedr_id): ");
                		ps.setInt(3, sc.nextInt());         		
                		System.out.println("请设置account_money(Please set the account_money): ");
                		ps.setInt(4, sc.nextInt());
                		ps.executeUpdate();
                		PreparedStatement pss= (PreparedStatement) con.prepareStatement("insert into og_account values(?,?);");
                		System.out.println("请再次设置account_ID(Please set the account_ID again): ");
                		pss.setInt(1, sc.nextInt());
                		System.out.println("请设置account_og(Please set the account_og_id)");
                		pss.setInt(2, sc.nextInt());
                		pss.executeUpdate();
                		   		
                	}catch(Exception e)
                	{
                		
                	}
                	}
				
                    break;
                
                case 2: {
                    modify();
                    try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("update account set account_money=? where account_id=?;");
                		System.out.println("Please enter the money which you want to update: ");   
                		ps.setInt(1, sc.nextInt());
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
                    find();
                    try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select * from account where account_id= ?;");
                		System.out.println("请输入id(Please enter the account_id)： ");
                		ps.setInt(1, sc.nextInt());
                		
                		ResultSet rs=ps.executeQuery();
                		System.out.println("请输入id(Please enter the account_id again)： ");
                		PreparedStatement pss= (PreparedStatement) con.prepareStatement("select og_id from og_account where account_id= ?;");
                		
                		pss.setInt(1, sc.nextInt());
                		ResultSet rss=pss.executeQuery();
                		while(rs.next()&&rss.next()) {
                			System.out.println("account_id ----> "+rs.getInt(1)+" "+" account_type ---->"+rs.getString(2)+" "
                			+" account_founder ----> "+rs.getInt(3)+" "+" account_money"+rs.getInt(4)+" "+"og_id ---->"+rss.getInt(1));
                		}
                		
                		System.out.println("Done..");

                		
                		stmt=con.createStatement();
                    }catch(Exception e)
                	{
                		
                	}
                	}
                    break;
                 
                case 4: {
                    delete();
                    try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("delete  from account_pay where account_id=?;");
                		System.out.println("Please enter the account_id which you want to delete: "); 	
                		ps.setInt(1, sc.nextInt());
                		ps.executeUpdate();
                		PreparedStatement pss= (PreparedStatement) con.prepareStatement("delete from og_account where account_id=?");
                		System.out.println("Please enter the account_id which you want to delete again: "); 
                		pss.setInt(1, sc.nextInt());
                		pss.executeUpdate();
                		PreparedStatement psss= (PreparedStatement) con.prepareStatement("delete  from account where account_id=?;");
                		System.out.println("Please enter the account_id which you want to delete on the third time: "); 
                		psss.setInt(1, sc.nextInt());
                		psss.executeUpdate();
                		stmt=con.createStatement();   		
                	}catch(Exception e)
                	{
                		
                	}
                	}
                    break;
                case 5:{
                	
                	try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select * from account left join og_account on (account.account_id=og_account.account_id)where og_account.og_id=? ;");
                		System.out.println("Please enter the og_id: ");
                		ps.setInt(1, sc.nextInt());
                		ResultSet rs=ps.executeQuery();
                		
                		while(rs.next()) {
                			System.out.println("account_id ----> "+rs.getInt(1)+" "+" account_type ---->"+rs.getString(2)+" "
                			+" account_founder ----> "+rs.getInt(3)+" "+" account_money"+rs.getInt(4));
                		}
                		
                		System.out.println("Done..");

                		//step- 3 Statement Object
                		stmt=con.createStatement();
                    }catch(Exception e)
                	{
                		
                	}
                	
                }
                break;
                
                case 6:{
                	try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("insert into account_pay values(?,?,?);");
                		System.out.println("请输入account_ID(Please enter the account_ID): ");
                		ps.setInt(1, sc.nextInt());
                		System.out.println("请输入user_id(Please enter the user_id): ");
                		ps.setInt(2, sc.nextInt());
                		System.out.println("请选择是否支付完成(Please select whether the payment is complete)（yes=1;no=0): ");
                		ps.setInt(3, sc.nextInt());
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
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("delete from account_pay where account_id=?&& user_id =?;");
                		System.out.println("请输入account_ID(Please enter the account_ID): ");
                		ps.setInt(1, sc.nextInt());
                		System.out.println("请输入user_id(Please enter the user_id need to be deleted): ");
                		ps.setInt(2, sc.nextInt());
                		ps.executeUpdate();
                		
                    }catch(Exception e)
                	{
                		
                	}
                }
                break;
                case 8:{
                	 try {
                 		Class.forName(driver5);
                 		con = DriverManager.getConnection(url5,username,password);        	    
                 		PreparedStatement ps= (PreparedStatement) con.prepareStatement("update account_pay set yes_no =? where account_id=?&&  user_id=?;");
                 		System.out.println("请选择是否支付完成（yes=1;no=0): ");   	
                 		ps.setInt(1, sc.nextInt());
                 		System.out.println("请输入account_ID(Please enter the account_ID): ");
                 		ps.setInt(2, sc.nextInt());
                 		System.out.println("请输入user_id(Please enter the user_id): ");
                		ps.setInt(3, sc.nextInt());
                 		ps.executeUpdate();
                 		stmt=con.createStatement();   		
                 	}catch(Exception e)
                 	{
                 		
                 	}
                }
                break;
                case 9:{
                	try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select * from account_pay where account_id= ?;");
                		System.out.println("请输入account_id(Please enter the account_id)： ");
                		ps.setInt(1, sc.nextInt());
                		
                		ResultSet rs=ps.executeQuery();
                		
                		while(rs.next()) {
                			System.out.println("account_id ----> "+rs.getInt(1)+" "+" user_id ---->"+rs.getInt(2)+" "
                			+" yes_no ----> "+rs.getInt(3));
                		}
                		
                		System.out.println("Done..");

                		
                		stmt=con.createStatement();
                    }catch(Exception e)
                	{
                		
                	}
                	}
                    break;
                case 10:{
                	try {
                		Class.forName(driver5);
                		con = DriverManager.getConnection(url5,username,password);        	    
                		PreparedStatement ps= (PreparedStatement) con.prepareStatement("select * from account_pay where user_id= ?&&yes_no=0;");
                		System.out.println("请输入id(Please enter the user_id)： ");
                		ps.setInt(1, sc.nextInt());
                		
                		ResultSet rs=ps.executeQuery();
                		
                		while(rs.next()) {
                			System.out.println("account_id ----> "+rs.getInt(1)+" "+" user_id ---->"+rs.getInt(2)+" "
                			+" yes_no ----> "+rs.getInt(3));
                		}
                		
                		System.out.println("Done..");

                		
                		stmt=con.createStatement();
                    }catch(Exception e)
                	{
                		
                	}
                	}
                    break;
              
                case 0: {
                    System.out.println("退出成功（Exit successful）");
                  usermain.main2(args);
                    
                }
                default: {
                    System.out.println("选择非法重新选择！（Select Illegal, select again）");
                    System.out.println("============================");
                }
            }
        }while(true);
    }
    public static void NorMain(){
        int NorId = 456;
        String NorPassword = "456";
        int count = 3;
        Operation:{
            do {
            System.out.print("输入用户账号（Push the id of user）：");
            Scanner scan = new Scanner(System.in);
            int id = scan.nextInt();
            System.out.print("输入用户密码（Push the password of user）：");
            String password = scan.next();
            System.out.println("============================================================================");
            if (id == NorId && password.equals(NorPassword)) {
                System.out.println("登陆成功（success!）");
                System.out.println("============================================================================");
             
                break Operation;
            } else {
                System.out.println("登录失败，账户信息错误，重新登陆（Error！）");
                --count;
                System.out.println("你还有" + count + "次登录机会（You only have " + count + " opportunity!）");
                System.out.println("============================================================================");
            }
        }while(count > 0);
        System.out.println("登录次数超过限制。退出系统！（Login exceeded the limit,exiting the system）");
    }
        

    }
    public static void main(String[] args) {
    	
    	NorInterface(args);
    }
}