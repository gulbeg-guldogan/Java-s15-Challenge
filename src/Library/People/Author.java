package Library.People;

import Library.Books.Book;

import java.util.Objects;
import java.util.Set;

public class Author extends Person {
    private Set<Book> books;

    public Author(String name){
        super(name);
    }

    public Author(String name, Set<Book> books) {
        super(name);
        this.books = books;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Author author = (Author) o;
        return Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), books);
    }

    @Override
    public String toString() {
        return "Library.People.Author{" +
                "books=" + books +
                '}';
    }
}
