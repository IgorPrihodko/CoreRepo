package homework15.controller;

import homework15.dao.DaoInterface;
import homework15.lib.Inject;
import homework15.model.Bet;
import homework15.model.Order;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static DaoInterface orderDao;
    @Inject
    private static DaoInterface betDao;

    public static void handleOrder() {
        try(Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter the dish : ");
                String inputDish = scanner.nextLine();
                if (inputDish.equals("")) {
                    System.out.println("Your last input was empty!");
                    return;
                }
                System.out.println("Enter amount : ");
                int inputAmount = scanner.nextInt();
                if (inputAmount < 0) {
                    System.out.println("Amount can't be less then 0!!!");
                    return;
                }
                Order order = new Order(inputDish, inputAmount);
                orderDao.add(order);
                scanner.nextLine();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Bad input data");
        }
    }

    public static void handleBet() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("")) {
                    return;
                }
                String[] data = command.split(" ");
                int value = Integer.parseInt(data[0]);
                double risk = Double.parseDouble(data[1]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Данные введены некорректно");
        }
    }
}

