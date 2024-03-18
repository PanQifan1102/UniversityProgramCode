package book;
//构造一个书的信息
public class Book {
    private String name;//书名-三国演义
    private String author;//作者-罗贯中
    private int price;//价格-55
    private String type;//类型-小说
    private boolean isBorrowed;//状态-未借出

    //提供构造方法
    //初始化
    //将来构造一本书的时候用
    //alt+ins -> Constructor
    public Book(String name, String author, int price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
        //状态为构造方法，因为一本书的初始状态便是未借出，其布尔值为F；
    }

    //【Question-1】get和set方法？干什么用的？
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    //【Question-2】干啥用的？？？？
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}
