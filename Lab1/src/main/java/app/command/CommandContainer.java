package app.command;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private static final Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("/login", new LoginCommand());

        commands.put("/registration", new RegistrationCommand());

        commands.put("/logout", new LogoutCommand());

        commands.put("/exception", new ExceptionCommand());

        commands.put("/order", new OrderCommand());

        commands.put("/ordersList", new OrdersListCommand());

        commands.put("/profile", new ProfileCommand());

        commands.put("/admin", new AdminCommand());

    }

    private static boolean contains (String name) {
        return commands.containsKey(name);
    }


    public static Command get(String commandName) {
        //commandName = commandName.replace("/coffee", "");
        if(commandName.equals("/")) {
            commandName = "/login";
        }
        return contains(commandName) ? commands.get(commandName) : commands.get("/exception");
    }
}
