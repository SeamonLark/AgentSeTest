package eu.axasoft.agentsetest;


import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;
import java.util.logging.Level;

public class AgentSeTest {

    private static final Logger LOGGER = Logger.getLogger(AgentSeTest.class.getName());

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java SimpleLoggerApp <delay_in_ms>");
            return;
        }

        long delay;
        try {
            delay = Long.parseLong(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid delay. Please provide a number.");
            return;
        }

        Timer timer = new Timer("LoggerTimer", true);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                LOGGER.log(Level.INFO, "Logging message...");
            }
        };

        timer.scheduleAtFixedRate(task, 0, delay);

        LOGGER.info("Logger started with delay: " + delay + " ms. Press Ctrl+C to stop.");

        // Keep main thread alive so app doesn't exit immediately
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            LOGGER.warning("Application interrupted.");
        }
    }
}

