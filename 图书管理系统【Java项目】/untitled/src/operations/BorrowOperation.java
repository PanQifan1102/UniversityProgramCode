package operations;

import book.BookList;

public class BorrowOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("借阅图书");
    }
}
