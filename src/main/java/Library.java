import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Book> books;
    private int capacity;
    private Map<String, Integer> genres;

    public Library(int capacity){
        books = new ArrayList<>();
        this.capacity = capacity;
        this.genres = new HashMap<>();
    }

    public int countBooks(){
        return books.size();
    }

    public void addBook(Book book){
        if(hasCapacity()) {
            books.add(book);
        }

        // Add to genre count
        addToGenreCount(book);
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

        // Change genre count
        if(book != null){
            removeFromGenreCount(book);
        }

        return book;
    }

    public int getGenreCount(String genre){
        return genres.getOrDefault(genre, 0);
    }

    private void addToGenreCount(Book book){
        if(genres.containsKey(book.getGenre())){
            int currentCount = genres.get(book.getGenre());
            currentCount++;
            genres.put(book.getGenre(), currentCount);
        } else {
            genres.put(book.getGenre(), 1);
        }
    }

    private void removeFromGenreCount(Book book){

        int currentCount = genres.get(book.getGenre());

        if(currentCount == 1){
            genres.remove(book.getGenre());
        } else {
            genres.put(book.getGenre(), currentCount - 1);
        }
    }

}
