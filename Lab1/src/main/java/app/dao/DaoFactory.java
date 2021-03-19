package app.dao;

public class DaoFactory {

    private final static ConnectionPool connectionPool = ConnectionPool.getInstance();

    public static UserDao createUserDao() {
        return new UserDao(connectionPool.getConnection());
    }

    public static IngredientsDao createIngredientsDao() {
        return new IngredientsDao(connectionPool.getConnection());
    }

    public static DrinksDao createDrinksDao() {
        return new DrinksDao(connectionPool.getConnection());
    }
}
