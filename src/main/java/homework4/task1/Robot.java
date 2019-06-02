package homework4.task1;

public class Robot {

    public Direction getDirection() {
       return this.getDirection();
    }

    public int getX() {
       return this.getX();
    }

    public int getY() {
       return this.getY();
    }

    public void turnLeft() {
    }

    public void turnRight() {
    }

    public void stepForward() {
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        if (robot.getX() > toX) {
            if (robot.getDirection() == Direction.UP) {
                while (robot.getDirection() != Direction.LEFT) {
                    robot.turnLeft();
                }
                while (robot.getX() != toX) {
                    robot.stepForward();
                }
            } else {
                while (robot.getDirection() != Direction.LEFT) {
                    robot.turnRight();
                }
                while (robot.getX() != toX) {
                    robot.stepForward();
                }
            }
        } else if (robot.getX() < toX) {
            if (robot.getDirection() == Direction.UP) {
                while (robot.getDirection() != Direction.RIGHT) {
                    robot.turnRight();
                }
                while (robot.getX() != toX) {
                    robot.stepForward();
                }
            } else {
                while (robot.getDirection() != Direction.RIGHT) {
                    robot.turnLeft();
                }
                while (robot.getX() != toX) {
                    robot.stepForward();
                }
            }
        }
        if (robot.getY() > toY) {
            if (robot.getDirection() == Direction.RIGHT) {
                while (robot.getDirection() != Direction.DOWN) {
                    robot.turnRight();
                }
                while (robot.getY() != toY) {
                    robot.stepForward();
                }
            } else {
                while (robot.getDirection() != Direction.DOWN) {
                    robot.turnLeft();
                }
                while (robot.getY() != toY) {
                    robot.stepForward();
                }
            }
        } else if (robot.getY() < toY) {
            if (robot.getDirection() == Direction.RIGHT) {
                while (robot.getDirection() != Direction.UP) {
                    robot.turnLeft();
                }
                while (robot.getY() != toY) {
                    robot.stepForward();
                }
            } else {
                while (robot.getDirection() != Direction.UP) {
                    robot.turnRight();
                }
                while (robot.getY() != toY) {
                    robot.stepForward();
                }
            }
        }
    }
}
