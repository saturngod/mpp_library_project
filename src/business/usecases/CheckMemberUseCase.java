package business.usecases;

import business.models.LibraryMember;

public interface CheckMemberUseCase {
	public boolean checkMember(String memberId);

	public LibraryMember getMember(String memberId);
}
