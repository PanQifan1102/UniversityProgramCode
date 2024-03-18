package operations;

import book.BookList;

/**
 * @Author 12629
 * @Description：
 */
public class ExitOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统!");
        System.exit(0);
    }
}
