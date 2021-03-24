package app.command;

import javax.servlet.http.HttpServletRequest;

import app.model.user.User;
import app.service.UserService;
import app.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RegistrationCommand extends Command{
    static final Logger logger = LogManager.getLogger(LoginCommand.class);
    private final UserService userService = new UserService();

    public RegistrationCommand() {
        path = Command.pagesPath + "registration.jsp";
    }

    @Override
    public String execute(HttpServletRequest request) {
        logger.info("Starting executing Register command");
        try {
            if (request.getParameter("email") == null) {                    //TODO check how does it work really
                return path;
            }
            User user = CommandUtility.createUserFromRequest(request);
            Validator.registrationValidate(user);
            request.getSession().setAttribute("user", userService.registerNewUser(user));
            logger.info("New user has been registered: {}", user.toString());
        } catch (Exception e) {
            request.getSession().setAttribute("errorRegister", e.getMessage());
            logger.warn("Registration failed: {}", e.getMessage());
            return path;

        }

        return "redirect:/login";
    }
}
