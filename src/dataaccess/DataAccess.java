package dataaccess;

import java.util.HashMap;

import business.models.Author;
import business.models.Book;
import business.models.CheckOutRecord;
import business.models.LibraryMember;

public interface DataAccess {
	public HashMap<String, Book> readBooksMap(); 

	public HashMap<String, User> readUserMap();

	public HashMap<String, LibraryMember> readMemberMap();

	public HashMap<String, Author> readAuthorMap(); 

	public HashMap<String, CheckOutRecord> readCheckOutRecordsMap();

	public void saveNewMember(LibraryMember member);

	public void saveNewBook(Book book);

	public void updateBookHM(HashMap<String, Book> hmBooks);

	public void saveCheckOutRecord(HashMap<String, CheckOutRecord> hmCheckOutRecords);

}
