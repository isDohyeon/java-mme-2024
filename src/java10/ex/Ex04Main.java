package java10.ex;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class Ex04Main extends JFrame {

    private final JPanel contentPane;
    private final JPanel panelDown;

    private static final String PANEL_LEFT = "버튼3개";
    private static final String BUTTON_CENTER = "이전연습문제";
    private static final String BUTTON_RIGHT = "글자";

    public Ex04Main() {
        contentPane = new JPanel();
        initializeFrame();

        JPanel panelUp = createButtonPanel();

        panelDown = createCardLayoutPanel();

        contentPane.add(panelUp, BorderLayout.NORTH);
        contentPane.add(panelDown, BorderLayout.CENTER);

        setVisible(true);
    }

    private void initializeFrame() {
        setTitle("CardLayout 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);
    }

    private JPanel createButtonPanel() {
        JPanel panelUp = new JPanel();

        JButton leftButton = new JButton(PANEL_LEFT);
        JButton centerButton = new JButton(BUTTON_CENTER);
        JButton rightButton = new JButton(BUTTON_RIGHT);

        leftButton.addActionListener(e -> cardButtonClick(e));
        centerButton.addActionListener(e -> cardButtonClick(e));
        rightButton.addActionListener(e -> cardButtonClick(e));

        panelUp.add(leftButton);
        panelUp.add(centerButton);
        panelUp.add(rightButton);

        return panelUp;
    }

    private JPanel createCardLayoutPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new CardLayout());

        panel.add(createLeftButtonPanel(), PANEL_LEFT);
        panel.add(createCenterButtonPanel(), BUTTON_CENTER);
        panel.add(createRightButtonPanel(), BUTTON_RIGHT);

        return panel;
    }

    private JPanel createLeftButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JButton button1 = new JButton("button1");
        JButton button2 = new JButton("button2");
        JButton button3 = new JButton("button3");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        return panel;
    }

    private JPanel createCenterButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        JButton hannamButton = new JButton("Hannam");
        JButton universityButton = new JButton("University");
        JButton studentButton = new JButton("Student");
        buttonPanel.add(hannamButton);
        buttonPanel.add(universityButton);
        buttonPanel.add(studentButton);

        JLabel outputLabel = new JLabel("Press button", SwingConstants.CENTER);
        outputLabel.setFont(new Font("Arial", Font.BOLD, 14));

        hannamButton.addActionListener(e -> centerButtonClick(e, outputLabel));
        universityButton.addActionListener(e -> centerButtonClick(e, outputLabel));
        studentButton.addActionListener(e -> centerButtonClick(e, outputLabel));

        panel.add(buttonPanel);
        panel.add(outputLabel);

        return panel;
    }

    private JPanel createRightButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel rightLabel = new JLabel("오른쪽 입니다");
        rightLabel.setFont(new Font("Arial", Font.BOLD, 14));

        panel.add(rightLabel);

        return panel;
    }

    private static void centerButtonClick(ActionEvent e, JLabel outputLabel) {
        JButton button = (JButton) e.getSource();
        outputLabel.setText(button.getText());
    }

    private void cardButtonClick(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        CardLayout cardLayout = (CardLayout) panelDown.getLayout();
        cardLayout.show(panelDown, button.getText());
    }

    public static void main(String[] args) {
        new Ex04Main();
    }
}
