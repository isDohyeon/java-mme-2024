package java10.ex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex05Main extends JFrame {

    private static final String JACKPOT_PROMPT = "Jackpot!!!";
    private static final String RETRY_PROMPT = "Try Again~~";

    private JPanel contentPane;
    private JPanel east;
    private JPanel center;
    private JLabel firstNumber;
    private JLabel secondNumber;
    private JLabel thirdNumber;
    private JButton pullButton;
    private JPanel numberPanel;
    private JPanel promptPanel;
    private JLabel prompt;

    public Ex05Main() {
        initializeFrame();
        addButtonListener();
    }

    private void initializeFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        setVisible(true);
    }

    private void addButtonListener() {
        pullButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = getRandomNumber();
                int num2 = getRandomNumber();
                int num3 = getRandomNumber();
                updateNumbers(num1, num2, num3);
                if (validateJackpot(num1, num2, num3)) {
                    return;
                }
                prompt.setText(RETRY_PROMPT);
            }

            private boolean validateJackpot(int num1, int num2, int num3) {
                if (num1 == num2 && num2 == num3) {
                    prompt.setText(JACKPOT_PROMPT);
                    return true;
                }
                return false;
            }

            private void updateNumbers(int num1, int num2, int num3) {
                firstNumber.setText(Integer.toString(num1));
                secondNumber.setText(Integer.toString(num2));
                thirdNumber.setText(Integer.toString(num3));
            }
        });
    }

    private int getRandomNumber() {
        return (int) (Math.random() * 4);
    }

    public static void main(String[] args) {
        new Ex05Main();
    }
}
