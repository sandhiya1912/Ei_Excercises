
package exercise_1.Utils;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class AppLogger {
    private static final Logger logger = Logger.getLogger("GlobalLogger");

    static {
        logger.setUseParentHandlers(false); // disable default console
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);
    }

    private AppLogger() {
    }

    public static Logger getLogger() {
        return logger;
    }
}
