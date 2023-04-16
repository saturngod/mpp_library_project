package repos.child;

import business.exceptions.InvalidMemberException;
import business.models.LibraryMember;
import dataaccess.DataAccess;
import repos.BaseRepo;

import java.util.HashMap;

public class LibraryMemberRepo extends BaseRepo {

    public LibraryMemberRepo(DataAccess da) {
        this.dataAccess = da;
    }

    public boolean checkMember(String memberId) {
        if (getMember(memberId) != null)
            return true;

        return false;

    }

    public LibraryMember getMember(String memberId) {
        HashMap<String, LibraryMember> map = dataAccess.readMemberMap();
        return map.get(memberId);
    }

    public void addLibraryMember(LibraryMember member) throws InvalidMemberException {


        if (member == null) {
            throw new InvalidMemberException("Member is null");
        }

        if (member.getMemberId().isEmpty()) {
            throw new InvalidMemberException("Invalid Member Id");
        }

        if (member.getFirstName().isEmpty()) {
            throw new InvalidMemberException("Invalid First Name");
        }

        if (member.getLastName().isEmpty()) {
            throw new InvalidMemberException("Invalid Last Name");
        }

        if (checkMember(member.getMemberId())) {
            throw new InvalidMemberException("Member ID already exist");
        }

        dataAccess.saveNewMember(member);

    }
}
