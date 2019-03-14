package utils;

import java.util.logging.Logger;

/**
 * Created by Chandandeep Singh on 14-03-2019.
 */
public class SuiteLogger extends Logger{

    /**
     * Protected method to construct a logger for a named subsystem.
     * <p>
     * The logger will be initially configured with a null Level
     * and with useParentHandlers set to true.
     *
     * @param name               A name for the logger.  This should
     *                           be a dot-separated name and should normally
     *                           be based on the package name or class name
     *                           of the subsystem, such as java.net
     *                           or javax.swing.  It may be null for anonymous Loggers.
     * @param resourceBundleName name of ResourceBundle to be used for localizing
     *                           messages for this logger.  May be null if none
     *                           of the messages require localization.
     */
    protected SuiteLogger(String name, String resourceBundleName) {
        super(name, resourceBundleName);
    }
}
