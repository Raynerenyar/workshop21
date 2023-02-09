package sg.edu.nus.iss.workshop21.repo;

public class Queries {
    public static String SELECT_CUSTOMER_SQL = "SELECT * FROM Customers LIMIT 5 OFFSET ?";
    public static String COUNT_CUSTOMER_SQL = "SELECT COUNT(*) count FROM Customers";
    public static String GET_CUSTOMER_BY_ID_SQL = "SELECT * FROM Customers WHERE id = ?";
    public static String GET_CUSTOMER_ORDERS_SQL = "SELECT * FROM Orders WHERE customer_id = ?";
}
