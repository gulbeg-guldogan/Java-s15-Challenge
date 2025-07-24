import java.util.HashSet;
import java.util.Set;

public class Author extends Person {
    private Set<Book> books;

    public Author(String name) {
        super(name);
        books = new HashSet<>();
    }

    public void newBook(Book book) {
        books.add(book);
    }

    public void show_book(){
        System.out.println(books);
    }

    @Override
    public String whoYouAre(){
        return super.whoYouAre();
    }
}
