package java10;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ListenerSample extends JFrame {

    public ListenerSample() {
        setTitle("Action 이벤트 리스너 작성");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Action");
        MyActionListener myActionListener = new MyActionListener();
        button.addActionListener(myActionListener);
        add(button);
        setSize(300, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ListenerSample();
    }
}

class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        if (button.getText().equals("Action")) {
            button.setText("액션");
            return;
        }
        button.setText("Action");
    }
}
