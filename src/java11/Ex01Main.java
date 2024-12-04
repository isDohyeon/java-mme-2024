package java11;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import javax.swing.*;

public class Ex01Main extends JFrame {

    private static final String TITLE = "좌우로 이미지 넘기기";
    private static final Deque<ImageIcon> images = new ArrayDeque<>();
    private static final List<String> imagePaths = List.of(
            "out/images/치킨.jpeg",
            "out/images/고양이.jpeg",
            "out/images/고양이2.jpeg",
            "out/images/고양이3.jpeg"
    );

    private JLabel imageLabel;
    private JButton leftButton;
    private JButton rightButton;

    public Ex01Main() {
        initializeFrame();
        loadImages();
        initializeImageLabel();
        initializeButtons();
        setVisible(true);
    }

    private void initializeFrame() {
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void loadImages() {
        for (String imagePath : imagePaths) {
            images.add(new ImageIcon(imagePath));
        }
    }

    private void initializeImageLabel() {
        imageLabel = new JLabel(images.peekFirst());
        add(imageLabel, BorderLayout.CENTER);
    }

    private void initializeButtons() {
        JPanel buttonPanel = new JPanel(new FlowLayout());
        leftButton = createButton("out/images/왼쪽_화살표.png");
        rightButton = createButton("out/images/오른쪽_화살표.png");
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JButton createButton(String imagePath) {
        JButton button = new JButton(new ImageIcon(imagePath));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        button.addActionListener(e -> buttonClick(e));
        return button;
    }

    private void buttonClick(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        if (button == leftButton) {
            images.offerFirst(images.pollLast());
        } else if (button == rightButton) {
            images.offerLast(images.pollFirst());
        }
        imageLabel.setIcon(images.peekFirst());
    }

    public static void main(String[] args) {
        new Ex01Main();
    }
}
