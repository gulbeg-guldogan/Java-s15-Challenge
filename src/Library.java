import java.util.HashSet;
import java.util.Set;

public class Library {

    private Set<Book> books;
    private Set<Reader> readers;

    public Library(Set<Book> books){
        this.books = books;
        this.readers = new HashSet<>();
    }

    public Book getBooks(Long bookId){
        for(Book item: books){
            if(item.getBookId() == bookId){
                return item;
            }
        }
        System.out.println("Böyle bir kitap YOK!");
        return null;
    }

    public Book getBooks(String name){
        for(Book item: books){
            if(item.getTitle().equals(name)){
                return item;
            }
        }
        System.out.println("Böyle bir kitap YOK!");
        return null;
    }

    public Set<Book> getBooks(Author author){
         Set<Book> authorBook = new HashSet<>();
        for(Book item: books){
            if(item.getAuthor().equals(author)){
                authorBook.add(item);
            }
        }
        return authorBook;
    }

    public Set<Reader> getReaders(){
        return readers;
    }

    public void newBook(Book book){
        books.add(book);
    }

    public void lendBook(Book book){
        books.remove(book);
    }

    public void takeBackBook(Book book){
        books.add(book);
    }

    public void deleteBook(Book book){
        books.remove(book);
    }

    public void showBooks(){
        System.out.println(books);
    }
}
