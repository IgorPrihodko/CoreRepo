package homework15.dao;

import homework15.db.Storage;
import homework15.lib.Dao;
import homework15.model.Order;

import java.util.List;
@Dao
public class OrderDaoImpl implements OrderDao {

    @Override
    public void add(Order order) {
        Storage.orders.add(order);
    }

    @Override
    public List<Order> getAll() {
        return Storage.orders;
    }
}
