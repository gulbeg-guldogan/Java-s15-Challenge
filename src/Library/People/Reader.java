package Library.People;

import Library.Books.Book;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Reader extends Person {
    private Set<Book> books;
    private int balance;

    public Reader(String name, int balance){
        super(name);
        books = new HashSet<>();
        this.balance = balance;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void purchaseBook(Book book){
        books.add(book);
        book.changeOwner(whoYouAre());
        book.updateStatus();
    }

    public void borrowBook(Book book){

//        // 5 ten fazla ödünç alamam.
//        if (books.size() < 5){
//            books.add(book);
//            book.changeOwner(whoYouAre());
//            book.updateStatus();
//        }

        books.add(book);
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reader reader = (Reader) o;
        return Objects.equals(books, reader.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), books);
    }
}
