package user;

import book.BookList;
import operations.IOPeration;

/**
 * @Author 12629
 * @Description：
 */
public abstract class User {
    protected String name;
    protected IOPeration[] ioPerations;//只是定义数组 但是没有初始化 内存都没分配

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();

    public void doOperation(int choice, BookList bookList) {
        ioPerations[choice].work(bookList);
    }
}
