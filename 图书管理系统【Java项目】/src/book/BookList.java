package book;

/**
 * @Author 12629
 * @Description：
 */
public class BookList {

    private Book[] books = new Book[10];
    private int usedSize; //存储当前书的个数

    /**
     * 事先通过构造方法  初始化的时候 给数组里面预存3本书，usedSize = 3;
     */
    public BookList() {
        books[0] = new Book("三国演义","罗贯中",89,"小说");
        books[1] = new Book("西游记","吴承恩",78,"小说");
        books[2] = new Book("红楼梦","曹雪芹",49,"小说");
        this.usedSize = 3;
    }

    //这里应该去写一些 操作这个数组的方法  但是我们这里不这么做  换一种做法


    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public Book getPos(int pos) {
        return books[pos];
    }

    /**
     * 存储一本书 到指定的位置
     * @param book
     * @param pos 在这里指的树 当前最后可以存储书的位置
     */
    public void setBooks(Book book,int pos) {
        //pos合法不？合法
        books[pos] = book;
    }
}
