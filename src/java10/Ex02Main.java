package java10;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex02Main extends JFrame {

    public Ex02Main() {
        setTitle("BorderLayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        add(new JButton("Package Explorer"), BorderLayout.WEST);
        add(new JButton("Test.java"), BorderLayout.CENTER);
        add(new JButton("Console"), BorderLayout.SOUTH);

        setSize(700, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex02Main();
    }
}
