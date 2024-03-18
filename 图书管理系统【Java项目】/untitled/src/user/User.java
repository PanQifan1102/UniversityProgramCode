package user;

import book.BookList;
import operations.IOperation;

//所有用户的相关内容
public abstract class User {
    protected String name;//每个用户都有姓名
    protected IOperation[] iOperations;//定义一个操作数组但不初始化

    //给NormalUser提供构造方法
    public User(String name){
        this.name = name;
    }
    public abstract int menu();
    public void doOPERATION(int choice, BookList bookList) {
        iOperations[choice].work(booklist);
    }
}
