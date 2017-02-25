package sams.steven.reflectiveframe;

/**
 * Hello world!
 *
 */
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextArea;

public class App
{
    private static final int FRAME_COUNT = 10;

    JDesktopPane pane;

    private App() {

        /* Apply screen shot onto fake desktop */
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        BufferedImage bi = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        pane = new JDesktopPane();
        // move
        pane.add(new ImagePanel(bi), JDesktopPane.DEFAULT_LAYER);

        /* display frames */
        for (int i = 0; i < FRAME_COUNT; i++) {
            this.createFrame("Frame "+ i, i);
        }

        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setAlwaysOnTop(true);
        frame.setContentPane(pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void createFrame(String title, int count) {
        ///ReflectiveJinternalFrame frame = new ReflectiveJinternalFrame(title);
        JInternalFrame frame = new JInternalFrame(title);
        frame.setPreferredSize(new Dimension(550, 200));

        JTextArea textarea = new JTextArea();
        textarea.setWrapStyleWord(true);
        textarea.setLineWrap(true);
        textarea.setText("some text");
        frame.setLayout(new BorderLayout());
        frame.add(textarea, BorderLayout.CENTER);
        frame.pack();

        pane.add(frame, count);
        int n = (frame.getHeight() / 7);
        frame.setLocation(count * n, count * n);
        frame.setVisible(true);
        frame.toFront();
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

    public static void main( String[] args ) {
        App app = new App();
    }
}
