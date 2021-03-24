package app.command;

import app.model.user.User;
import app.model.user.UserBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

public class CommandUtility {
    @SuppressWarnings("unchecked")
    static boolean checkIsUserLoggedIn(HttpServletRequest request, String email) {
         HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedInUsers");

        if (loggedUsers.stream().anyMatch(email::equals)) {
            return true;
        }

        loggedUsers.add(email);
        request.getSession().getServletContext()
                .setAttribute("loggedInUsers", loggedUsers);
        return false;
    }

    @SuppressWarnings("unchecked")
    static void logOutUser(HttpServletRequest request, String email) {
        ((HashSet<String>) request.getSession().getServletContext().getAttribute("loggedInUsers")).remove(email);
        request.getSession().removeAttribute("user");
    }

    static User createUserFromRequest(HttpServletRequest request) {
        return new UserBuilder()
                .setName(request.getParameter("username"))
                .setEmail(request.getParameter("email"))
                .setPass(request.getParameter("password"))
                .build();
    }

}
