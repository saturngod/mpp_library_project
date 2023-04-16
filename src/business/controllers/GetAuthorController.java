package business.controllers;

import java.util.List;

import business.usecases.GetAuthorUseCase;
import dataaccess.DataAccessFacade;
import business.models.Author;
import repos.child.AuthorRepo;

public class GetAuthorController extends BaseController implements GetAuthorUseCase {
	GetAuthorController() {
	}
	@Override
	public List<Author> getAllAuthors() {
		AuthorRepo repo = new AuthorRepo(new DataAccessFacade());
		return repo.getAllAuthors();
	}
}
