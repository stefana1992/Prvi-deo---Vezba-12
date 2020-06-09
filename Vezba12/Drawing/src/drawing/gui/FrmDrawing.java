package drawing.gui;

import drawing.model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmDrawing {
    private JPanel rootPanel;
    private JToolBar toolBar;
    private JButton editButton;
    private JButton deleteButton;
    private JToggleButton tglSelection;
    private JToggleButton tglPoint;
    private JToggleButton tglLine;
    private JToggleButton tglRectangle;
    private JToggleButton tglCircle;
    private JToggleButton tglDonut;
    private DrawingPanel drawingPanel1;
    private Shape selection;

    public FrmDrawing() {
        drawingPanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                panelClicked(e);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteButtonActionPerformed();
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editButtonActionPerformed();
            }
        });
    }

    private void editButtonActionPerformed() {
        if (selection instanceof Circle) {
            DlgCircle dlg = new DlgCircle();
            dlg.setCircle((Circle) selection);
            dlg.pack();
            dlg.setVisible(true);
        } else if (selection instanceof Rectangle) {
            DlgRectangle dlgRectangle = new DlgRectangle();
            dlgRectangle.setRectangle((Rectangle) selection);
            dlgRectangle.pack();
            dlgRectangle.setVisible(true);
        } else {
            DlgDonut dlgDonut = new DlgDonut();
            dlgDonut.setDonut((Donut) selection);
            dlgDonut.pack();
            dlgDonut.setVisible(true);
        }
        this.drawingPanel1.repaint();
    }

    private void deleteButtonActionPerformed() {
        int confirm = JOptionPane.showConfirmDialog(this.drawingPanel1, "Are you sure... ?", "Deletion",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.drawingPanel1.getShapes().remove(this.selection);
            this.drawingPanel1.repaint();
            this.selection = null;
            this.deleteButton.setEnabled(false);
            this.editButton.setEnabled(false);
        }

    }

    private void panelClicked(MouseEvent e) {
        if (this.tglSelection.isSelected()) {
            selection = null;
            for (Shape shape : this.drawingPanel1.getShapes()) {
                shape.setSelected(false);
                if (shape.contains(e.getX(), e.getY())) {
                    selection = shape;
                }
            }
            if (selection != null) {
                selection.setSelected(true);
                this.deleteButton.setEnabled(true);
                this.editButton.setEnabled(true);
            } else {
                this.deleteButton.setEnabled(false);
                this.editButton.setEnabled(false);
            }
        } else if (this.tglPoint.isSelected()) {
            this.drawingPanel1.getShapes().add(new Point(e.getX(), e.getY()));
        } else if (this.tglLine.isSelected()) {
            if (this.drawingPanel1.getStartPoint() == null) {
                this.drawingPanel1.setStartPoint(new Point(e.getX(), e.getY()));
            } else {
                this.drawingPanel1.getShapes().add(new Line(this.drawingPanel1.getStartPoint(), new Point(e.getX(), e.getY())));
                this.drawingPanel1.setStartPoint(null);
            }
        } else if (this.tglRectangle.isSelected()) {
            DlgRectangle dlg = new DlgRectangle();
            dlg.pack();
            dlg.setRectangle(new Rectangle(new Point(e.getX(), e.getY()), -1, -1));
            dlg.setVisible(true);
            this.drawingPanel1.getShapes().add(dlg.getRectangle());
        } else if (this.tglCircle.isSelected()) {
            DlgCircle dlg = new DlgCircle();
            dlg.pack();
            dlg.setCircle(new Circle(new Point(e.getX(), e.getY()), -1));
            dlg.setVisible(true);
            if (dlg.getCircle() != null) {
                this.drawingPanel1.getShapes().add(dlg.getCircle());
            }
        } else if (this.tglDonut.isSelected()) {
            DlgDonut dlg = new DlgDonut();
            dlg.pack();
            dlg.setDonut(new Donut(new Point(e.getX(), e.getY()), -1, -1));
            dlg.setVisible(true);
            this.drawingPanel1.getShapes().add(dlg.getDonut());
        }
        this.drawingPanel1.repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing");
        frame.setContentPane(new FrmDrawing().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.pack();
        frame.setBounds(100, 100, 800, 600);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        this.drawingPanel1 = new DrawingPanel();
    }
}