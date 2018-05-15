import java.util.ArrayList;
import java.util.List;

public class Borrower {

    private List<Book> books;

    public Borrower(){
        books = new ArrayList<>();
    }

    public int countBooks(){
        return books.size();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void borrowByTitle(String title, Library library) {
        Book bookBorrowed = library.removeTitle(title);
        if (bookBorrowed != null) {
            addBook(bookBorrowed);
        }
    }
}
