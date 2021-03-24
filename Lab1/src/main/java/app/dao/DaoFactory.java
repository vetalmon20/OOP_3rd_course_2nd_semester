package app.dao;

public class DaoFactory {

    private final static ConnectionPool connectionPool = ConnectionPool.getInstance();

    public static UsersDao createUserDao() {
        return new UsersDao(connectionPool.getConnection());
    }

    public static IngredientsDao createIngredientsDao() {
        return new IngredientsDao(connectionPool.getConnection());
    }

    public static DrinksDao createDrinksDao() {
        return new DrinksDao(connectionPool.getConnection());
    }

    public static OrdersDao createOrdersDao() {
        return new OrdersDao(connectionPool.getConnection());
    }
}
