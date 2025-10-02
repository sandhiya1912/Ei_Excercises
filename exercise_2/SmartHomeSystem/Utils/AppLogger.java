package exercise_2.SmartHomeSystem.Utils;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class AppLogger {
    private static final Logger LOGGER = Logger.getLogger(AppLogger.class.getName());
    private static boolean handlerInitialized = false;
    private static final String LOG_FILE = "exercise_2/SmartHomeSystem/Utils/smarthome.log";

    private AppLogger() {}

    public static void initialize() {
        if (!handlerInitialized) {
            try {
                FileHandler fileHandler = new FileHandler(LOG_FILE, true);
                fileHandler.setFormatter(new SimpleFormatter());
                fileHandler.setLevel(Level.INFO);
                LOGGER.addHandler(fileHandler);
                LOGGER.setUseParentHandlers(false);
                handlerInitialized = true;
            } catch (Exception e) {
                System.err.println("Failed to initialize AppLogger: " + e.getMessage());
            }
        }
    }

    public static Logger getLogger() {
        if (!handlerInitialized) {
            initialize();
        }
        return LOGGER;
    }

}