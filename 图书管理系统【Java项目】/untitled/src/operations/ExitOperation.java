package operations;

import book.BookList;

public class ExitOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("退出系统");
    }
}
