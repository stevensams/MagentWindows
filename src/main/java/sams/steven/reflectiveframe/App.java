package sams.steven.reflectiveframe;

import sams.steven.reflectiveframe.Windowing.Desktop;
import sams.steven.reflectiveframe.Windowing.ReflectiveJInternalFrame;

public class App
{
    private static final int FRAME_COUNT = 10;

    public static void main( String[] args ) {
        Desktop pane = new Desktop();
        /* display frames */
        for (int i = 0; i < FRAME_COUNT; i++) {
            ReflectiveJInternalFrame frame = new ReflectiveJInternalFrame("Frame "+ i);
            pane.add(frame);
            frame.setLocation(i);
            frame.setVisible(true);
        }
    }
}
