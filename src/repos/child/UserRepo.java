package repos.child;

import business.exceptions.LoginException;
import dataaccess.DataAccess;

import dataaccess.User;
import repos.BaseRepo;

import java.util.HashMap;

public class UserRepo extends BaseRepo {

    public UserRepo(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }
    public User login(String id, String password) throws LoginException {

        HashMap<String, User> map = dataAccess.readUserMap();

        if (!map.containsKey(id)) {
            throw new LoginException("Invalid Credentials");
        }

        String userPass = map.get(id).getPassword();
        if (!userPass.equals(password)) {
            throw new LoginException("Invalid Credentials");
        }

        User user = map.get(id);
        return user;


    }
}
