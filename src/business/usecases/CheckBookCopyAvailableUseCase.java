package business.usecases;

import business.models.Book;

public interface CheckBookCopyAvailableUseCase {
	public Book checkBookAvailableCopy(String bookId);
}
