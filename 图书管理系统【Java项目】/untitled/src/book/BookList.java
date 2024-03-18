package book;
//构造一个存放书的类-书架
//用数组存储
public class BookList {
    public Book[] books = new Book[10];//创建一个书架，且默认此时该书架只能放10本书
    public int usedSize;//用来存储当前书架里书的个数

    public BookList(){
        //初始化创建书的信息
        //通过构造方法，初始化的时候给数组里预存3本书
        books[0] = new Book("三国演义","罗贯中",89,"小说");
        books[1] = new Book("西游记","吴承恩",78,"小说");
        books[2] = new Book("红楼梦","曹雪芹",120,"小说");
        this.usedSize = 3;
    }
}
