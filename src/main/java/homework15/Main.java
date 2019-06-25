package homework15;

import homework15.controller.ConsoleHandler;
import homework15.dao.OrderDao;
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

    public static void main(String[] args) throws Exception {
        /*System.out.println("Если хотите сделать ставку, введите \n" +
                "сумму и риск через пробел");
        ConsoleHandler.handleBet();
        BetDao betDao = new BetDaoImpl();
        System.out.println(betDao.getAll());*/

        ConsoleHandler.handleOrder();
        OrderDao orderDao = new OrderDaoImpl();
        System.out.println(orderDao.getAll());
    }


}




