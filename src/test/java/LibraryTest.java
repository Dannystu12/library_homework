import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class LibraryTest {

    Library library;
    Book book1;
    Book book2;

    @Before
    public void setup(){
        library = new Library(1);
        book1 = new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari");
        book2 = new Book("A Brief History of Time", "Stephen Hawking");
    }

    @Test
    public void checkBookCount(){
        assertEquals(0, library.countBooks());
        library.addBook(book1);
        assertEquals(1, library.countBooks());
    }

    @Test
    public void checkHasCapacityTrue(){
        assertTrue(library.hasCapacity());
    }

    @Test
    public void checkHasCapacityFalse(){
        library.addBook(book1);
        assertFalse(library.hasCapacity());
    }

    @Test
    public void canAddBook(){
        library.addBook(book1);
        assertEquals(1, library.countBooks());
    }

    @Test
    public void cantAddBookOverCapacity(){
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(1, library.countBooks());
    }

    @Test
    public void canRemoveExistingTitle(){
        library.addBook(book1);
        Book borrowedBook = library.removeTitle(book1.getTitle());
        assertEquals(book1, borrowedBook);
        assertEquals(0, library.countBooks());
    }

    @Test
    public void cantRemoveNonExistantTitle(){
        library.addBook(book1);
        Book borrowedBook = library.removeTitle(book2.getTitle());
        assertNull(borrowedBook);
        assertEquals(1, library.countBooks());
    }

}
