package Library.Books;

import Library.People.Author;
import Library.enums.Status;

import java.time.LocalDate;

public class Journal extends Book {
    public Journal(Long bookId, String author, String name, double price, Status status, String edition, LocalDate dateOfPurchase, String categoryName, String owner) {
        super(bookId, author, name, price, status, edition, dateOfPurchase, categoryName, owner);
    }
}
