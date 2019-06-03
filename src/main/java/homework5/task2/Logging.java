package homework5.task2;

import java.util.logging.*;

public class Logging {

    private static void configureLogging() {
        Handler consoleHandler = new ConsoleHandler();
        Formatter xmlFormatter = new XMLFormatter();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(xmlFormatter);
        Logger.getLogger("org.stepic.java").setUseParentHandlers(false);
        Logger.getLogger("org.stepic.java").addHandler(consoleHandler);
        Logger.getLogger("org.stepic.java.logging.ClassA").setLevel(Level.ALL);
        Logger.getLogger("org.stepic.java.logging.ClassB").setLevel(Level.WARNING);
    }
}
