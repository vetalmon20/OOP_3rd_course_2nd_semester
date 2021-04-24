package app.command;

import app.model.order.Order;
import app.model.user.User;
import app.service.OrdersService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OrdersListCommand  extends Command{
    private static final Logger logger = LogManager.getLogger(OrdersListCommand.class);
    private final OrdersService orderService = new OrdersService();

    public OrdersListCommand() {
        path = Command.pagesPath + "ordersList.jsp";
    }

    @Override
    public String execute(HttpServletRequest request) {
        User currUser = (User) request.getSession().getAttribute("user");
        List<Order> orders = orderService.getUserOrders(currUser.getEmail());

        request.setAttribute("orders", orders);
        logger.info("List of orders was successfully uploaded");
        return path;
    }
}
