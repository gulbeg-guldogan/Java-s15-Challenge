import java.util.HashSet;
import java.util.Set;

public class Reader extends Person{
    private Set<Book> books;

    public Reader(String name){
        super(name);
        books = new HashSet<>();
    }

    public void purchaseBook(Book book){
        books.add(book);
        book.changeOwner(whoYouAre());
        book.updateStatus();
    }

    public void borrowBook(Book book){
        books.add(book);
        book.changeOwner(whoYouAre());
        book.updateStatus();
    }

    public void returnBook(Book book){
        books.remove(book);
        book.changeOwner(whoYouAre());
        book.updateStatus();
    }

    public void showBooks(){
        System.out.println(books);
    }

    @Override
    public String whoYouAre() {
        return super.whoYouAre();
    }
}
