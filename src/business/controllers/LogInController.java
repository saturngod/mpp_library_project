package business.controllers;

import business.usecases.LogInUseCase;
import dataaccess.Auth;
import dataaccess.DataAccessFacade;
import dataaccess.User;
import business.exceptions.LoginException;
import repos.child.UserRepo;

public class LogInController extends BaseController implements LogInUseCase {
	LogInController() {
	}

	public static Auth currentAuth = null;

	@Override
	public Auth login(String id, String password) throws LoginException {
		UserRepo userRepo = new UserRepo(new DataAccessFacade());

		User user = userRepo.login(id,password);
		User.updateCurrentUser(user);

		currentAuth = user.getAuthorization();
		return currentAuth;

	}

}
