package homework15.factory;

import homework15.dao.OrderDao;
import homework15.dao.OrderDaoImpl;

public class OrderDaoFactory {

    private static OrderDao instance;

    public static OrderDao getInstance(){
        if (instance == null) {
            instance = new OrderDaoImpl();
        }
        return instance;
    }
}
