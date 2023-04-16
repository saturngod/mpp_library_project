package repos.child;

import business.models.Author;
import dataaccess.DataAccess;
import repos.BaseRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AuthorRepo extends BaseRepo {
    public AuthorRepo(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public List<Author> getAllAuthors() {
        HashMap<String, Author> authors = dataAccess.readAuthorMap();
        if (authors == null)
            return null;
        return new ArrayList<>(authors.values());
    }
}
