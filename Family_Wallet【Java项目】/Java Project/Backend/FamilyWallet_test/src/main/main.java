package main;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
        //首页菜单
        System.out.println("#######################################");
        System.out.println("欢迎来到家庭钱包(Welcome to Family Wallet)");
        System.out.println("  1->管理员入口（Administrator Entrance）");
        System.out.println("  2->普通用户入口（Normal Users Entrance）");
        System.out.println("  0->退出钱包（Exit Wallet）");
        System.out.println("=======================================");
        //首页从菜单选择
        Scanner scanner = new Scanner(System.in);
        MenuChoice:
        do{
            System.out.printf("请输入你要进行的操作（Please push your operation）：");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:{
                    System.out.println("进入管理员界面（Enter the administrator interface）");
                    AdministratorModule.AdministratorModule.main(args);
                    break MenuChoice;
                }
                case 2:{
                	
                    System.out.println("进入普通用户界面（Enter the normal user interface）");
                    NormalUserModule.usermain.main(args);
                    break MenuChoice;
                }
                case 0:{
                    System.out.println("退出钱包（Exit Wallet）");
                   System.exit(0);
                }
                default:{
                    System.out.println("选项错误，重新选择（Operation error and reselect!）");
                    break;
                }
            }
        }while(true);


	}

}
