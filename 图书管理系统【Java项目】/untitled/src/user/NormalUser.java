package user;

import operations.*;

import java.util.Scanner;

//普通用户
public class NormalUser extends User {
    public NormalUser(String name){
        super(name);
        this.iOperations = new IOperation[]{
          new ExitOperation(),
          new FindOperation(),
          new AddOperation(),
          new DelOperation()

        };
    }
    public int menu(){
        System.out.println("欢迎普通用户："+name);
        System.out.println("=============================");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.推出系统");
        System.out.println("=============================");
        System.out.println("请输入你的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
