package operations;

import book.BookList;

public class DisplayOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("显示所有图书");
    }

}
