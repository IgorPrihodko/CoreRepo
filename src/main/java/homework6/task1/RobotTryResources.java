package homework6.task1;

public class RobotTryResources {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, final int toX, final int toY) {

        for (int i = 0; i < 3; i++) {
            try(RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                i = 3;
            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw new RobotConnectionException((e.getMessage()));
                }
            }
        }
    }
}
