package business.usecases;

import business.models.Book;
import business.exceptions.BookNotFoundException;

public interface BookCopyUseCase {
	public Book addBookCopy(Book book, int noOfCopies) throws BookNotFoundException;
}
