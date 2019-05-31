package homework4.task1;

public class Robot {

    public Direction getDirection() {
       return this.getDirection(); // текущее направление взгляда
    }

    public int getX() {
       return this.getX(); // текущая координата X
    }

    public int getY() {
       return this.getY(); // текущая координата Y
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        if (robot.getX() > toX) {
            while (robot.getDirection() != Direction.LEFT)
                robot.turnRight();
            while (robot.getX() != toX)
                robot.stepForward();
        } else if (robot.getX() < toX) {
            while (robot.getDirection() != Direction.RIGHT)
                robot.turnRight();
            while (robot.getX() != toX)
                robot.stepForward();
        }
        if (robot.getY() > toY) {
            while (robot.getDirection() != Direction.DOWN)
                robot.turnRight();
            while (robot.getY() != toY)
                robot.stepForward();
        } else if (robot.getY() < toY) {
            while (robot.getDirection() != Direction.UP)
                robot.turnRight();
            while (robot.getY() != toY)
                robot.stepForward();
        }
    }
}
