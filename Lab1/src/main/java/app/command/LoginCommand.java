package app.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import app.model.drink.Drink;
import app.service.DrinksService;
import app.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class LoginCommand extends Command{
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);
    private final UserService userService = new UserService();
    private final DrinksService drinksService = new DrinksService();

    public LoginCommand() {
        path = Command.pagesPath + "login.jsp";
    }

    @Override
    public String execute(HttpServletRequest request) {
        logger.info("Starting executing Log in command");

        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            CommandUtility.logOutUser(request, email);

            if (email == null || password == null || CommandUtility.checkIsUserLoggedIn(request, email)) {
                return path;
            }

            HttpSession session = request.getSession();
            session.setAttribute("user", userService.loginUser(email, password));

            List<Drink> drinks = drinksService.getAllDrinks();
            session.setAttribute("drinks", drinks);
            logger.info("Current user: " + session.getAttribute("user"));

            return "redirect:/drinks";                                           
        } catch (Exception e) {
            request.getSession().setAttribute("errorMessage", e.getMessage());
            logger.error("Cannot log in with current user {}", e.getMessage());

            return path;
        }
    }
}
