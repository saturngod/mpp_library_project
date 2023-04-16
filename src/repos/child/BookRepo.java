package repos.child;

import business.exceptions.BookCopyNotAvailableException;
import business.exceptions.BookNotFoundException;
import business.models.*;
import dataaccess.DataAccess;
import repos.BaseRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookRepo extends BaseRepo {

    public BookRepo(DataAccess da) {
        this.dataAccess = da;
    }

    public Book searchBook(String isbn) {
        HashMap<String, Book> map = dataAccess.readBooksMap();
        return map.get(isbn);
    }

    public void addBook(Book book) {
        if (searchBook(book.getIsbn()) == null) {

            dataAccess.saveNewBook(book);
        }
    }

    public List<Book> getBookCollection() {
        HashMap<String, Book> map = dataAccess.readBooksMap();
        List<Book> books = new ArrayList<>(map.values());
        return books;
    }

    public Book addBookCopy(Book book, int noOfCopies) throws BookNotFoundException {
        HashMap<String, Book> hmBooks = dataAccess.readBooksMap();

        if (hmBooks.containsKey(book.getIsbn())) {
            Book bookFromDB = hmBooks.get(book.getIsbn());

            for (int i = 0; i < noOfCopies; i++) {
                bookFromDB.addCopy();
            }

            hmBooks.put(bookFromDB.getIsbn(), bookFromDB);
            dataAccess.updateBookHM(hmBooks);
            return bookFromDB;
        } else {
            throw new BookNotFoundException(book.getIsbn());
        }
    }

    public void checkOutBook(Book book, LibraryMember member) throws BookCopyNotAvailableException {

        // Check Book Available
        BookCopy bookCopy = book.getNextAvailableCopy();

        if (bookCopy == null) {
            throw new BookCopyNotAvailableException(book.getIsbn());
        }

        bookCopy.changeAvailability();

        CheckOutRepo repo = new CheckOutRepo(this.dataAccess);
        repo.checkOutBook(bookCopy,member);


        book.updateCopies(bookCopy);
        updateBook(book);

    }

    public void updateBook(Book book) {
        HashMap<String, Book> hmBooks = dataAccess.readBooksMap();
        Book bookFromDB = hmBooks.get(book.getIsbn());

        hmBooks.put(bookFromDB.getIsbn(), book);
        dataAccess.updateBookHM(hmBooks);
    }
}
