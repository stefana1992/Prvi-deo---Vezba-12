package drawing.gui;

import drawing.exceptions.CircleException;
import drawing.model.Donut;

import javax.swing.*;
import java.awt.event.*;

public class DlgDonut extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lblCenterX;
    private JLabel lblCenterY;
    private JLabel lblRadius;
    private JLabel lblInnerRadius;
    private JTextField txtCenterX;
    private JTextField txtCenterY;
    private JTextField txtRadius;
    private JTextField txtInnerRadius;
    private Donut donut;

    public DlgDonut() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
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

    private void onOK() throws Exception {
        this.donut.getCenter().setX(Integer.parseInt(this.txtCenterX.getText()));
        this.donut.getCenter().setY(Integer.parseInt(this.txtCenterY.getText()));
        try {
            this.donut.setRadius(Integer.parseInt(this.txtRadius.getText()));
            this.donut.setInnerRadius(Integer.parseInt(this.txtInnerRadius.getText()));
        } catch (CircleException e) {
            e.printStackTrace();
        }

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        donut = null;
        dispose();
    }

    public static void main(String[] args) {
        DlgDonut dialog = new DlgDonut();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public Donut getDonut() {
        return donut;
    }

    public void setDonut(Donut donut) {
        this.donut = donut;
        this.txtCenterX.setText(String.valueOf(this.donut.getCenter().getX()));
        this.txtCenterY.setText(String.valueOf(this.donut.getCenter().getY()));
        if (donut.getRadius() != -1 && donut.getInnerRadius() != -1) {
            this.txtRadius.setText(String.valueOf(donut.getRadius()));
            this.txtInnerRadius.setText(String.valueOf(donut.getInnerRadius()));
        }
    }
}
