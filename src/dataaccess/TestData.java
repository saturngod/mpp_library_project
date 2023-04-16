package dataaccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import business.models.Address;
import business.models.Author;
import business.models.Book;
import business.models.LibraryMember;

/**
 * This class loads data into the data repository and also sets up the storage
 * units that are used in the application. The main method in this class must be
 * run once (and only once) before the rest of the application can work
 * properly. It will create three serialized objects in the dataaccess.storage
 * folder.
 * 
 *
 */
public class TestData {
	public static void main(String[] args) {
		TestData td = new TestData();
		td.bookData();
		td.libraryMemberData();
		td.userData();

		td.authorData();

		td.checkOutRecordData();

		DataAccess da = new DataAccessFacade();
		System.out.println(da.readBooksMap());
		System.out.println(da.readUserMap());
	}

	/// create books
	public void bookData() {
		allBooks.get(0).addCopy();
		allBooks.get(0).addCopy();
		allBooks.get(1).addCopy();
		allBooks.get(3).addCopy();
		allBooks.get(2).addCopy();
		allBooks.get(2).addCopy();
		DataAccessFacade.loadBookMap(allBooks);

	}

	public void userData() {
		DataAccessFacade.loadUserMap(allUsers);
	}

	public void authorData() {
		DataAccessFacade.loadAuthorMap(allAuthors);
	}

	public void checkOutRecordData() {
//		@SuppressWarnings("serial")
//		LibraryMember libraryMember = new LibraryMember("1001", "Andrew", "Smiths", "444-333-2211", addresses.get(4));
//
//		CheckOutRecordEntry entry = new CheckOutRecordEntry(LocalDate.now(), LocalDate.now(),
//				allBooks.get(0).getCopy(0));
//		CheckOutRecordEntry entry1 = new CheckOutRecordEntry(LocalDate.now(), LocalDate.now(),
//				allBooks.get(0).getCopy(0));
//
//		List<CheckOutRecordEntry> list = new ArrayList<CheckOutRecordEntry>();
//		list.add(entry);
//		list.add(entry1);
//		@SuppressWarnings("serial")
//		CheckOutRecord checkOutRecord = new CheckOutRecord(libraryMember, list);
//
//		DataAccessFacade.loadCheckOutRecordMap(checkOutRecord);
	}

	public void libraryMemberData() {
		LibraryMember libraryMember = new LibraryMember("0000", "Htain Lin", "Shwe", "111-222-3333", addresses.get(4));
		members.add(libraryMember);
		libraryMember = new LibraryMember("0001", "Han Tun", "Zaw", "123-456-7890", addresses.get(5));
		members.add(libraryMember);

		libraryMember = new LibraryMember("0002", "Carey", "Nyein", "999-999-9999", addresses.get(6));
		members.add(libraryMember);

		libraryMember = new LibraryMember("1004", "Toe Myint", "Aung", "000-000-0000", addresses.get(2));
		members.add(libraryMember);

		DataAccessFacade.loadMemberMap(members);
	}

	///////////// DATA //////////////
	List<LibraryMember> members = new ArrayList<LibraryMember>();
	@SuppressWarnings("serial")

	List<Address> addresses = new ArrayList<Address>() {
		{
			add(new Address("1000N 4th Street", "Fairfield", "IA", "52556"));
			add(new Address("1000N 4th Street", "MIU", "MI", "65434"));
			add(new Address("1000N 4th Street", "Palo Alto", "CA", "94301"));
			add(new Address("1000N 4th Street", "Seville", "Georgia", "41234"));
			add(new Address("1000N 4th Street", "Fairfield", "IA", "52556"));
			add(new Address("1000N 4th Street", "Los Angeles", "CA", "93736"));
			add(new Address("1000N 4th Street", "Ottumwa", "IA", "57789"));
		}
	};

	@SuppressWarnings("serial")
	public List<Author> allAuthors = new ArrayList<Author>() {
		{
			add(new Author("A001", "JK", "Rowling", "999-999-9999", addresses.get(0), "Harry Potter"));
			add(new Author("A002", "Dam", "Brown", "999-999-9999", addresses.get(0), "Inferno"));
			add(new Author("A003", "Kim", "Ji Won", "999-999-9999", addresses.get(1), "Duty After School"));
			add(new Author("A004", "Michael", "Owen", "999-999-9999", addresses.get(2), "The Night Agent"));
			add(new Author("A005", "Sung", "Hye Jo", "999-999-9999", addresses.get(3), "Weak Hero"));
		}
	};

	@SuppressWarnings("serial")
	List<Book> allBooks = new ArrayList<Book>() {
		{
			add(new Book("23-11111", "Harry Potter", 21, Arrays.asList(allAuthors.get(0), allAuthors.get(1))));
			add(new Book("28-12345", "Inferno", 7, Arrays.asList(allAuthors.get(2))));
			add(new Book("99-22222", "Duty After School", 21, Arrays.asList(allAuthors.get(3))));
			add(new Book("48-44444", "Weak Hero", 7, Arrays.asList(allAuthors.get(4))));
		}
	};

	@SuppressWarnings("serial")
	List<User> allUsers = new ArrayList<User>() {
		{
			add(new User("Htain", "htain", Auth.LIBRARIAN));
			add(new User("Han", "han", Auth.ADMIN));
			add(new User("Carey", "carey", Auth.BOTH));
		}
	};

}
