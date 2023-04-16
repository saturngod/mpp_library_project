package business.usecases;

import business.models.LibraryMember;
import business.exceptions.InvalidMemberException;

public interface AddLibraryMemberUseCase {
	public void addLibraryMember(LibraryMember member) throws InvalidMemberException;
}
