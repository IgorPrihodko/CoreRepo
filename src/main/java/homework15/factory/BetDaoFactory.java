package homework15.factory;

import homework15.dao.BetDao;
import homework15.dao.BetDaoImpl;

public class BetDaoFactory {

    private static BetDao instance;

    public static BetDao getBetDao() {
        if (instance == null) {
            instance = new BetDaoImpl();
        }
        return instance;
    }
}
