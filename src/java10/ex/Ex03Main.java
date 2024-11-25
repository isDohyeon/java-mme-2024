package java10.ex;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

public class Ex03Main extends JFrame {

    private JLabel outputLabel;

    private static final String LEFT_BUTTON_TEXT = "Hannam";
    private static final String CENTER_BUTTON_TEXT = "University";
    private static final String RIGHT_BUTTON_TEXT = "Student";

    public Ex03Main() {
        initializeFrame();

        JPanel buttonPanel = createButtonPanel();

        JPanel outputPanel = createOutputPanel();

        add(buttonPanel);
        add(outputPanel);

        setVisible(true);
    }

    private void initializeFrame() {
        setTitle("버튼 눌러 텍스트 보여주기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(2, 1));
        setLocationRelativeTo(null);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));

        JButton hannamButton = new JButton(LEFT_BUTTON_TEXT);
        JButton universityButton = new JButton(CENTER_BUTTON_TEXT);
        JButton studentButton = new JButton(RIGHT_BUTTON_TEXT);

        hannamButton.addActionListener(e -> buttonClick(e));
        universityButton.addActionListener(e -> buttonClick(e));
        studentButton.addActionListener(e -> buttonClick(e));

        buttonPanel.add(hannamButton);
        buttonPanel.add(universityButton);
        buttonPanel.add(studentButton);

        return buttonPanel;
    }

    private JPanel createOutputPanel() {
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());

        outputLabel = new JLabel("Press button", SwingConstants.CENTER);
        outputPanel.add(outputLabel, BorderLayout.CENTER);

        return outputPanel;
    }

    private void buttonClick(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        outputLabel.setText(button.getText());
    }

    public static void main(String[] args) {
        new Ex03Main();
    }
}
