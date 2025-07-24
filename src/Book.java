import enums.Status;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private Long bookId;
    private Author author;
    private String name;
    private double price;
    private Status status;
    private String edition;
    private LocalDate dateOfPurchase;
    private String owner;

    public Book(Long bookId, Author author, String name, double price, Status status, String edition, LocalDate dateOfPurchase, String owner) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.owner = null;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public void changeOwner(String newOwner) {
        this.owner = newOwner;
    }

    public String getOwner() {
        return owner;
    }

    public void updateStatus(){
        if(status == Status.AVAILABLE){
            status = Status.UNAVAILABLE;
        } else if (status == Status.UNAVAILABLE){
            status = Status.AVAILABLE;
        }
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String display() {
        return "Book{" +
                "bookId=" + bookId +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition='" + edition + '\'' +
                ", dateOfPurchase=" + dateOfPurchase +
                ", owner='" + owner + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) && Objects.equals(author, book.author) && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, author, name);
    }
}
