package homework15.db;

import homework15.model.Bet;
import homework15.model.Order;

import java.util.ArrayList;
import java.util.List;

//ЭТО НАША БД
public class Storage {
    public static final List<Bet> bets = new ArrayList<>();
    public static final List<Order> orders = new ArrayList<>();
}
