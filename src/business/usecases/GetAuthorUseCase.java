package business.usecases;

import java.util.List;

import business.models.Author;

public interface GetAuthorUseCase {

	public List<Author> getAllAuthors();
}
