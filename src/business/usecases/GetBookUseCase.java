package business.usecases;

import java.util.List;

import business.models.Book;

public interface GetBookUseCase {
	public List<Book> getBookCollection();
}
