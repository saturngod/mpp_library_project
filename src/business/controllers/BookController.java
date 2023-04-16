package business.controllers;

import java.util.List;

import business.exceptions.BookNotFoundException;
import business.usecases.*;
import dataaccess.*;
import business.models.*;
import repos.child.BookRepo;

public class BookController extends BaseController implements SearchBookUseCase, AddBookUseCase, BookCopyUseCase {

	BookController() {
	}

	@Override
	public Book searchBook(String isbn) {
		BookRepo repo = new BookRepo(new DataAccessFacade());
		return repo.searchBook(isbn);
	}

	@Override
	public void addBook(Book book) {
		BookRepo repo = new BookRepo(new DataAccessFacade());
		repo.addBook(book);
	}

	@Override
	public List<Book> getBookCollection() {
		BookRepo repo = new BookRepo(new DataAccessFacade());
		return repo.getBookCollection();
	}


	@Override
	public Book addBookCopy(Book book, int noOfCopies) throws BookNotFoundException {

		BookRepo repo = new BookRepo(new DataAccessFacade());
		return repo.addBookCopy(book,noOfCopies);

	}
}
