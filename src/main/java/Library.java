import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private int capacity;

    public Library(int capacity){
        books = new ArrayList<>();
        this.capacity = capacity;
    }

    public int countBooks(){
        return books.size();
    }

    public void addBook(Book book){
        if(hasCapacity()) {
            books.add(book);
        }
    }

    public boolean hasCapacity(){
        return countBooks() < capacity;
    }
}
