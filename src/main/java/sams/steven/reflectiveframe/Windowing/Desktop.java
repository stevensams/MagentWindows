package sams.steven.reflectiveframe.Windowing;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Steven Sams
 */

public class Desktop extends JFrame {

    public Desktop() {

        /* Apply screen shot onto fake desktop */
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        BufferedImage bi = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        JDesktopPane pane = new JDesktopPane();
        pane.add(new ImagePanel(bi), JDesktopPane.DEFAULT_LAYER);
        this.setContentPane(pane);
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.pack();
        this.setVisible(true);
    }

    private static class ImagePanel extends JLabel {

        private BufferedImage img;

        public ImagePanel(BufferedImage img) {
            this.img = img;
            Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);
        }

        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
    }
}
