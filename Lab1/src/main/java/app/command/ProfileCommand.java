package app.command;

import app.model.user.User;
import app.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ProfileCommand extends Command{
    static final Logger logger = LogManager.getLogger(ProfileCommand.class);
    private final UserService userService = new UserService();

    public ProfileCommand() {
        path = Command.pagesPath + "profile.jsp";
    }

    @Override
    public String execute(HttpServletRequest request) {
        logger.info("Starting executing Profile command");
        if(request.getParameter("deposit") != null) {
            User currUser = (User) request.getSession().getAttribute("user");
            int moneyAmount = Integer.parseInt(request.getParameter("finalMoneyAmountHName"));
            System.out.println(moneyAmount + "- asdadas");
            userService.setMoney(currUser.getEmail(), (long) moneyAmount);
            currUser.setMoney((long) moneyAmount);
            request.setAttribute("changedAmount", moneyAmount);
            request.getSession().setAttribute("user", currUser);
        }
        logger.info("Profile command is successfully executed");
        return path;
    }
}
