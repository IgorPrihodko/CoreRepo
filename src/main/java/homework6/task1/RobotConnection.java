package homework6.task1;

public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);

    void close();
}
