package sams.steven.reflectiveframe.Windowing;

import javax.swing.*;
import java.awt.*;

public class ReflectiveJInternalFrame extends JInternalFrame {

    public ReflectiveJInternalFrame(String title) {
        this(title, "Some Text");
    }

    public ReflectiveJInternalFrame(String title, String body) {
        super(title);
        this.setPreferredSize(new Dimension(550, 200));
        JTextArea textarea = new JTextArea();
        textarea.setWrapStyleWord(true);
        textarea.setLineWrap(true);
        textarea.setText(body);
        this.setLayout(new BorderLayout());
        this.add(textarea, BorderLayout.CENTER);
        this.toFront();
        this.pack();
        this.setVisible(true);
    }

    public void setLocation(int count) {
        int n = (this.getHeight() / 7);
        this.setLocation(count * n, count * n);
    }
}
