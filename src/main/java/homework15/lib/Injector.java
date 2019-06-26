package homework15.lib;

import homework15.controller.ConsoleHandler;
import homework15.dao.BetDaoImpl;
import homework15.dao.DaoInterface;
import homework15.dao.OrderDaoImpl;
import homework15.factory.BetDaoFactory;
import homework15.factory.OrderDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoImplClass = BetDaoImpl.class;
        Class<OrderDaoImpl> orderDaoImplClass = OrderDaoImpl.class;

        if (betDaoImplClass.getDeclaredAnnotation(Dao.class) != null) {
            Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
            for (Field field : consoleHandlerFields) {
                if (field.getDeclaredAnnotation(Inject.class) != null && field.getType().equals(DaoInterface.class)) {
                    field.setAccessible(true);
                    field.set(null, BetDaoFactory.getBetDao());
                }
            }
        }

        if (orderDaoImplClass.getDeclaredAnnotation(Dao.class) != null) {
            Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
            for (Field field : consoleHandlerFields) {
                if (field.getDeclaredAnnotation(Inject.class) != null && field.getType().equals(DaoInterface.class)) {
                    field.setAccessible(true);
                    field.set(null, OrderDaoFactory.getInstance());
                }
            }
        }
    }
}
