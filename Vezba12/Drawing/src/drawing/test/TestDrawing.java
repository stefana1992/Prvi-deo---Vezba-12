package drawing.test;

import javax.swing.*;

public class TestDrawing {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.getContentPane().add(new TestPanel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(10, 10, 800, 600);
        jFrame.setVisible(true);

    }
}