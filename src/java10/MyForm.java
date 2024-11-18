package java10;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyForm extends JFrame {

    private JPanel contentPane;
    private JPanel centerPanel;
    private JPanel southPanel;
    private JButton ok;
    private JPanel left;
    private JPanel right;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel typeId;

    public MyForm() {
        setTitle("Multiple Layout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(contentPane);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyForm();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
