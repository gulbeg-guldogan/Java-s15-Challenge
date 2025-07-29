package Library;

import Library.Books.Book;
import Library.People.Author;
import Library.People.Reader;
import Library.enums.Status;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {

    private Set<Book> books;
    private Set<Reader> readers;
    private Map<Reader, Set<Book>> readerAndBooks;
    private final int BorrowFee = 10;

    public Library(){
        this.books = new HashSet<>();
        this.readers = new HashSet<>();
        this.readerAndBooks = new HashMap<>();
    }


    public Book getBooksById(Long bookId){
        for(Book item: books){
            if(item.getBookId() == bookId){
                return item;
            }
        }
        System.out.println("Bu Id'e ait bir kitap YOK!");
        return null;
    }

    public Set<Book> getBooksByName(String name){
        String sSearchKey = name.toLowerCase();
        Set<Book> booksResult = new HashSet<>();
        for(Book item: books){
            if(item.getTitle().toLowerCase().contains(sSearchKey)){
                booksResult.add(item);
            }
        }

        if(!booksResult.isEmpty()){
            return booksResult;
        }else {
            System.out.println("Bu isimde kitap bulunamadı.");
            return null;
        }


    }

    public Set<Book> getBooksByAuthor(Author author){
         Set<Book> authorBook = new HashSet<>();
        for(Book item : books){
            if(item.getAuthor().equals(author)){
                authorBook.add(item);
            }
        }
        if(!authorBook.isEmpty()){
            return authorBook;
        }else {
            System.out.println("Girilen yazara ait kitap bulunamadı.");
            return null;
        }
    }

    public Set<Book> getBooksByCategory(String category){
        Set<Book> categoryBooks = new HashSet<>();
        for(Book item : books){
            if(item.getCategoryName().equals(category)){
                categoryBooks.add(item);
            }
        }
        if(!categoryBooks.isEmpty()){
            return categoryBooks;
        }else {
            System.out.println("Böyle bir kategori bulunamadı.");
            return null;
        }
    }

    public Reader getReaderByBookName(String bookName){
        for(Map.Entry<Reader, Set<Book>> item : readerAndBooks.entrySet()){
            for(Book book : item.getValue()){
                if(book.getTitle().equalsIgnoreCase(bookName)){
                    return item.getKey();
                }
            }
        }
        System.out.println("Girilen kitab boştadır.");
        return null;
    }

    public Reader getReaderByName(String name){
        for(Reader item : readers){
            if(item.getName().equals(name)){
                return item;
            }
        }
        System.out.println("Yeni Üye");
        return null;
    }

    public void lendBook(Reader reader, Book book) {

        if (book.getStatus() == Status.UNAVAILABLE)
        {
            System.out.println("Kitap durumu uygun değil..");
            return;
        }


        // reader daha önce bir kitap ödünç almış mı ?
        if (readerAndBooks.containsKey(reader)) {
            int iLendBookCount = readerAndBooks.get(reader).size();
            if (iLendBookCount == 5)
            {
                System.out.println("Zaten beş tane almışsın amk evladı napıcan bu kadar kitabı.");
            }
            else{
                readerAndBooks.get(reader).add(book);
                // kitap ödnüç verildi.. ya bir flag de ödünç verildiği tut yada kitabı listeden kaldır.
                books.remove(book);
                reader.setBalance(reader.getBalance() - BorrowFee);
            }


        } else {
            // reader henüz eklenmemiş
            readerAndBooks.put(reader,  new HashSet<>());
            readerAndBooks.get(reader).add(book);
            books.remove(book);
            reader.setBalance(reader.getBalance() - BorrowFee);
        }

    }

    public void takeBackBook(Reader reader, Book book){

        if (readerAndBooks.containsKey(reader))
        {
            readerAndBooks.get(reader).remove(book);
            books.add(book);
        }
    }
    public Set<Book> getBookListForReader(Reader reader){
        if (readerAndBooks.containsKey(reader))
        {
            return readerAndBooks.get(reader);
        }
        return  null;
    }

    public void addReaders(Reader reader) {
        readers.add(reader);
        System.out.println(reader.getName() + " kullanıcısı başarıyla eklendi.");
    }

    public Set<Reader> getReaders(){
        return readers;
    }

    public void newBook(Book book){
        books.add(book);
        System.out.println(book.getTitle() + " kitabı başarıyla eklendi.");
    }

    public void deleteBook(Book book){
        books.remove(book);
        System.out.println(book.getTitle() + " kitabı başarıyla silindi.");
    }

    public void showBooks(){
        System.out.println(books);
    }
}
