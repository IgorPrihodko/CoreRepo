package homework15.factory;

import homework15.dao.BetDaoImpl;
import homework15.dao.DaoInterface;

public class BetDaoFactory {

    private static DaoInterface instance;

    public static DaoInterface getBetDao() {
        if (instance == null) {
            instance = new BetDaoImpl();
        }
        return instance;
    }
}
