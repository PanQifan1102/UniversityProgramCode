package user;

import operations.*;

import java.util.Scanner;

//管理员
public class AdminUser extends User{
    public AdminUser(String name){
        super(name);
        this.iOperations = new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation()

        };
    }
    public int menu(){
        System.out.println("欢迎管理员："+name);
        System.out.println("=============================");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("1.删除图书");
        System.out.println("1.显示图书");
        System.out.println("0.推出系统");
        System.out.println("=============================");
        System.out.println("请输入你的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
