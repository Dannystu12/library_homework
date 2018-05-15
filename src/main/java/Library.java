import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
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

    public Book removeTitle(String title){
        Book book = null;
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getTitle().equals(title)){
                book = books.remove(i);
                break;
            }
        }
        return book;
    }
}
