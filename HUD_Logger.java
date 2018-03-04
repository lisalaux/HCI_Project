import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * This class is responsible for writing a detailed log of the user interaction
 * with our prototype head up display. It particularly logs the individual keystrokes
 * and their times, so that sources of confusion for the user can be identified.
 * It produces an output file called HUD_Prototype.log in the directory where the program is located.
 */

public class HUD_Logger {

    /*
     * Instance variables of the HUD_Logger class consisting of
     * a line separator String as well as Logger [and FileHandler] objects.
     */
    private static final Logger hudLogger = Logger.getLogger("HUD_Logger");
    private static FileHandler logFileHandler;

    /**
     * Constructor for the HUD_Logger class.
     * @try to instantiate FileHandler and SimpleFormatter objects
     * @catch security exception se
     * @catch IOException ioe (file cannot be found etc.)
     */
    public HUD_Logger() {

        try {

            // instantiate the FileHandler and define file storage location
            logFileHandler = new FileHandler("HUD_Prototype.log");
            hudLogger.addHandler(logFileHandler);

            // needed to format the output as log
            SimpleFormatter formatter = new SimpleFormatter();
            logFileHandler.setFormatter(formatter);

            // this line disables the log output to the console.
            hudLogger.setUseParentHandlers(false);

        }

        catch (SecurityException se) {
            se.printStackTrace();
        }

        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Methods to log the individual key presses.
     * The keys to enter and exit the system are omitted on purpose.
     */
    public void logRightArrow() {
        hudLogger.info("\r\nThe user pressed key RIGHT\r\n");
    }

    public void logLeftArrow() {
        hudLogger.info("\r\nThe user pressed key LEFT\r\n");
    }

    public void logUpArrow() {
        hudLogger.info("\r\nThe user pressed key UP\r\n");
    }

    public void logDownArrow() {
        hudLogger.info("\r\nThe user pressed key DOWN\r\n");
    }

    public void logQKey() {
        hudLogger.info("\r\nThe user pressed key Q\r\n");
    }

    public void logAKey() {
        hudLogger.info("\r\nThe user pressed key A\r\n");
    }

    /**
     * Write a summary of all the direct user interactions that occurred in
     * the current session.
     */
    public void writeSummary(int counterRightArrow, int counterLeftArrow, int counterUpArrow, int counterDownArrow, int counterQ, int counterA) {

        String summary = "\r\n\r\nSummary for the current session:";
        StringBuilder summaryBuilder = new StringBuilder(summary);

        summaryBuilder.append("\r\nRIGHT arrow clicks: " + counterRightArrow);
        summaryBuilder.append("\r\nLEFT arrow clicks: " + counterLeftArrow);
        summaryBuilder.append("\r\nUP arrow clicks: " + counterUpArrow);
        summaryBuilder.append("\r\nDOWN arrow clicks: " + counterDownArrow);
        summaryBuilder.append("\r\nQ key clicks: " + counterQ);
        summaryBuilder.append("\r\nA key clicks: " + counterA);

        hudLogger.info(summaryBuilder.toString());

    }

    /**
     * Close the logFileHandler object after finishing writing to the HUD_Prototype.log file.
     * Otherwise the old file might not be overwritten (apparently a bug in java 8).
     */
    public void closeFileHandler() {

        logFileHandler.close();

    }
}
