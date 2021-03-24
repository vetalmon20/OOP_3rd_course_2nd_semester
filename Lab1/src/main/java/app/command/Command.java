package app.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Implementing command pattern in order to convert requests to the objects
 */
public abstract class Command {
    protected final static String pagesPath = "pages/";
    protected String path;
    public abstract String execute(HttpServletRequest request);
}
