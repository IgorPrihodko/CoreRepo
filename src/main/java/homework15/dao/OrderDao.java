package homework15.dao;

import homework15.lib.Dao;
import homework15.model.Order;

import java.util.List;

@Dao
public interface OrderDao {
    void add(Order order);
    List<Order> getAll();
}
