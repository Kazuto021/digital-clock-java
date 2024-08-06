import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DigitalClock extends JFrame {

    private JLabel timeLabel;
    private SimpleDateFormat timeFormat;

    public DigitalClock() {
        // Set up the JFrame
        setTitle("Digital Clock");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize time format
        timeFormat = new SimpleDateFormat("hh:mm:ss a");

        // Create and configure the time label
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 48));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setBackground(Color.DARK_GRAY);
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timeLabel, BorderLayout.CENTER);

        // Start the clock
        startClock();

        // Make the JFrame visible
        setVisible(true);
    }

    private void startClock() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Update the time label with the current time
                String time = timeFormat.format(new Date());
                timeLabel.setText(time);
            }
        }, 0, 1000); // Update every second
    }

    public static void main(String[] args) {
        // Run the clock in the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new DigitalClock());
    }
}
