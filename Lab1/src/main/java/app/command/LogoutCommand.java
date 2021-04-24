package app.command;

import javax.servlet.http.HttpServletRequest;

import app.model.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LogoutCommand extends Command {
    static final Logger logger = LogManager.getLogger(LogoutCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        logger.info("Executing logout command");
        User tempUser = (User) request.getSession().getAttribute("user");
        if (tempUser != null) {
            CommandUtility.logOutUser(request, tempUser.getName());
            logger.info("User logged out");
        }
        return "redirect:/login";
    }
}
