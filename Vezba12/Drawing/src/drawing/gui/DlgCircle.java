package drawing.gui;

import drawing.exceptions.CircleException;
import drawing.model.Circle;

import javax.swing.*;
import java.awt.event.*;

public class DlgCircle extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lblCenterX;
    private JLabel lblCenterY;
    private JLabel lblRadius;
    private JTextField txtCenterX;
    private JTextField txtCenterY;
    private JTextField txtRadius;

    private Circle circle;

    public DlgCircle() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        this.circle.getCenter().setX(Integer.parseInt(this.txtCenterX.getText()));
        this.circle.getCenter().setY(Integer.parseInt(this.txtCenterY.getText()));
        try {
            this.circle.setRadius(Integer.parseInt(this.txtRadius.getText()));
        } catch (CircleException e) {
            e.printStackTrace();
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        circle = null;
        dispose();
    }

    public static void main(String[] args) {
        DlgCircle dialog = new DlgCircle();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
        this.txtCenterX.setText(String.valueOf(circle.getCenter().getX()));
        this.txtCenterY.setText(String.valueOf(circle.getCenter().getY()));
        if (circle.getRadius() != -1) {
            this.txtRadius.setText(String.valueOf(circle.getRadius()));
        }
    }
}