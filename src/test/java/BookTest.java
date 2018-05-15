import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BookTest {

    Book book;

    @Before
    public void setup(){
        book = new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari");
    }

    @Test
    public void hasTitle(){
        assertEquals("Sapiens: A Brief History of Humankind", book.getTitle());
    }

    @Test
    public void hasAuthor(){
        assertEquals("Yuval Noah Harari", book.getAuthor());
    }
}
