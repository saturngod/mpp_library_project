package business.usecases;

import dataaccess.Auth;
import business.exceptions.LoginException;

public interface LogInUseCase {
	public Auth login(String id, String password) throws LoginException;
}
