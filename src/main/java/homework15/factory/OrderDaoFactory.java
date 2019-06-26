package homework15.factory;

import homework15.dao.DaoInterface;
import homework15.dao.OrderDaoImpl;

public class OrderDaoFactory {

    private static DaoInterface instance;

    public static DaoInterface getInstance(){
        if (instance == null) {
            instance = new OrderDaoImpl();
        }
        return instance;
    }
}
