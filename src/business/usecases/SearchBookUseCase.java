package business.usecases;

import java.util.List;

import business.models.Book;

public interface SearchBookUseCase {
	public Book searchBook(String isbn);

	public List<Book> getBookCollection();
}
