package homework15;

import homework15.controller.ConsoleHandler;
import homework15.dao.DaoInterface;
import homework15.dao.OrderDaoImpl;
import homework15.lib.Injector;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleHandler.handleOrder();
        DaoInterface orderDao = new OrderDaoImpl();
        System.out.println(orderDao.getAll());
    }
}
