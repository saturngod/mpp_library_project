package business.controllers;

import business.usecases.CheckOutBookUseCase;
import dataaccess.DataAccessFacade;
import business.models.Book;
import business.models.CheckOutRecord;
import business.models.LibraryMember;
import business.exceptions.BookCopyNotAvailableException;
import business.exceptions.BookNotFoundException;
import business.exceptions.MemberNotFoundException;
import repos.child.BookRepo;
import repos.child.CheckOutRepo;
import repos.child.LibraryMemberRepo;

public class CheckOutBookController extends BaseController implements CheckOutBookUseCase {


	@Override
	public void checkOutBook(String memberId, String bookId)
			throws BookNotFoundException, MemberNotFoundException, BookCopyNotAvailableException {

		BookRepo bookRepo = new BookRepo(new DataAccessFacade());
		LibraryMemberRepo libmemRepo = new LibraryMemberRepo(new DataAccessFacade());

		Book book = bookRepo.searchBook(bookId);

		if (book == null) {
			throw new BookNotFoundException("Book not found");
		}


		if (!libmemRepo.checkMember(memberId)) {
			throw new MemberNotFoundException("Member not found");
		}

		LibraryMember member = libmemRepo.getMember(memberId);

		bookRepo.checkOutBook(book,member);


	}

	@Override
	public CheckOutRecord getCheckOutRecord(String memberId) {
		CheckOutRepo checkoutRepo = new CheckOutRepo(new DataAccessFacade());
		return checkoutRepo.getCheckOutRecord(memberId);
	}
}
