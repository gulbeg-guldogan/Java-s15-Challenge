import Library.Books.Book;
import Library.Books.Journal;
import Library.Library;
import Library.People.Librarian;
import Library.People.Reader;
import Library.enums.Status;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("## Güldoğan Kütüphanecilik A.Ş.  ##");


        while(runConditions)
        {
            // Login değil ise kullanıcı girişi isteyelim.
            if (!isLogged)
            {
                UserLogin();
            }
            // kullanıcı giriş yapmış.. menüleri gösterelim..
            else {

                UserMenu();
            }

        }
    }
}