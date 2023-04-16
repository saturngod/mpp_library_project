package business.usecases;

import business.exceptions.BookNotFoundException;
import business.exceptions.MemberNotFoundException;
import business.exceptions.BookCopyNotAvailableException;

public interface CheckOutBookUseCase extends PrintCheckOutRecordUseCase {
	public void checkOutBook(String memberId, String bookId)
			throws BookNotFoundException, MemberNotFoundException, BookCopyNotAvailableException;
}
