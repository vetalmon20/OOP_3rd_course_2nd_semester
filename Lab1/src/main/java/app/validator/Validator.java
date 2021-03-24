package app.validator;

import app.model.user.User;

public class Validator {
    public static boolean registrationValidate(User user) throws Exception {
        if(!user.getName().matches("^(?=.{4,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$")){
            throw new Exception("Entered wrong username!");
        }

        if (user.getPass().length() < 5) {
            throw new Exception("Password too short");
        }

        if (!user.getEmail().matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+")) {
            throw new Exception("Email is not correct");
        }

        return true;
    }
}
