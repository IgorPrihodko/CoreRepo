package homework15.dao;

import homework15.db.Storage;
import homework15.lib.Dao;

import java.util.List;
@Dao
public class OrderDaoImpl implements DaoInterface {

    @Override
    public void add(Object o) {
        Storage.ORDERS.add(o);
    }

    @Override
    public List<Object> getAll() {
        return Storage.ORDERS;
    }
}
