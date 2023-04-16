package business.controllers;

public class ControllerFactory {
	private ControllerFactory() {
	}

	public static <T> T getController(ControllerType type) {
		switch (type) {
			case Login:
				return (T) new LogInController();
			case Author:
				return (T) new GetAuthorController();
			case Book:
				return (T) new BookController();
			case CheckOutBook:
				return (T) new CheckOutBookController();
			case LibraryMember:
				return (T) new LibraryMemberController();
			default:
				throw new IllegalArgumentException("Invalid controller type: " + type);
		}
	}


}
