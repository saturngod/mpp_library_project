package business.usecases;

import java.util.List;

import business.exceptions.LoginException;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;

	public List<String> allMemberIds();

	public List<String> allBookIds();

}
