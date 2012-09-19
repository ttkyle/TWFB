import javax.swing.*;

/**
 * The driver for the GUI
 */
public class AppGui {

    public void drawUI() {

        //Draws the UI at 800x780 pixels and sets the title
        //of the frame
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new MainFrame("TWFB - Tribal Wars Farm Bot");
                frame.setSize(800, 825);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}