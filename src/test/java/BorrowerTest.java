import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BorrowerTest {

    Borrower borrower;
    Library library;
    Book book1;
    Book book2;

    @Before
    public void setup(){
        borrower = new Borrower();
        library = new Library(2);
        book1 = new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari");
        book2 = new Book("A Brief History of Time", "Stephen Hawking");
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    public void canCountBooks(){
        assertEquals(0, borrower.countBooks());
        borrower.addBook(book1);
        assertEquals(1, borrower.countBooks());
    }

    @Test
    public void canAddBook(){
        borrower.addBook(book1);
        borrower.addBook(book2);
        assertEquals(2, borrower.countBooks());
    }

    @Test
    public void canBorrowByTitleInStock(){
        borrower.borrowByTitle(book1.getTitle(), library);
        assertEquals(1, borrower.countBooks());
        assertEquals(1, library.countBooks());
    }

    @Test
    public void cantBorrowByTitleOutOfStock(){
        borrower.borrowByTitle("Head First Jave", library);
        assertEquals(0, borrower.countBooks());
        assertEquals(2, library.countBooks());
    }
}
