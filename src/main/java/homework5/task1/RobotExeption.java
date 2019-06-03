package homework5.task1;

public class RobotExeption {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, final int toX, final int toY) {
        RobotConnection robotConnection = null;
        for (int i = 0; i < 3; i++) {
            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
                return;
            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw new RobotConnectionException((e.getMessage()));
                }
            } finally {
                try {
                    if (robotConnection != null)
                        robotConnection.close();
                } catch (Throwable throwable) {

                }

            }
        }
    }
}
