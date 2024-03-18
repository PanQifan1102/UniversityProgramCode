package operations;

import book.BookList;

public class ReturnOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("归还图书");
    }
}
