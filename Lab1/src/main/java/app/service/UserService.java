package app.service;

import app.dao.DaoFactory;
import app.dao.UsersDao;
import app.model.user.User;

public class UserService {

    private final UsersDao usersDao;

    public UserService() {
        this.usersDao = DaoFactory.createUserDao();
    }

    public User loginUser(String email, String password) {
        User resultUser;
        resultUser = usersDao.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cant find user with credentials"));


        if (resultUser.getPass().equals(password)) {
            return resultUser;
        }
        throw new IllegalArgumentException("Different password");
    }

    public User registerNewUser(User user) throws Exception {

        return usersDao.create(user).orElseThrow(() -> new Exception("User with email already exist"));

    }
}
