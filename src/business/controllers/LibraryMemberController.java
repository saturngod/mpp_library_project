package business.controllers;

import business.usecases.AddLibraryMemberUseCase;
import business.usecases.CheckMemberUseCase;
import dataaccess.DataAccessFacade;
import business.models.LibraryMember;
import business.exceptions.InvalidMemberException;
import repos.child.LibraryMemberRepo;

public class LibraryMemberController extends BaseController implements AddLibraryMemberUseCase, CheckMemberUseCase {
	LibraryMemberController() {
	}

	@Override
	public void addLibraryMember(LibraryMember member) throws InvalidMemberException {
		LibraryMemberRepo libMemRepo = new LibraryMemberRepo(new DataAccessFacade());
		libMemRepo.addLibraryMember(member);
	}

	@Override
	public boolean checkMember(String memberId) {

		LibraryMemberRepo libMemRepo = new LibraryMemberRepo(new DataAccessFacade());

		return libMemRepo.checkMember(memberId);


	}

	@Override
	public LibraryMember getMember(String memberId) {
		LibraryMemberRepo libMemRepo = new LibraryMemberRepo(new DataAccessFacade());
		return libMemRepo.getMember(memberId);

	}


}
