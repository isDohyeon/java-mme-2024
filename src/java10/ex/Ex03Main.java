package java10.ex;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

public class Ex03Main extends JFrame {

    private JLabel outputLabel; // 출력 레이블을 클래스 필드로 선언한다.

    private static final String LEFT_BUTTON_TEXT = "Hannam";
    private static final String CENTER_BUTTON_TEXT = "University";
    private static final String RIGHT_BUTTON_TEXT = "Student";

    public Ex03Main() {
        // 프레임 초기화를 수행한다.
        initializeFrame();

        // 버튼 패널을 생성한다.
        JPanel buttonPanel = createButtonPanel();

        // 출력 패널을 생성한다.
        JPanel outputPanel = createOutputPanel();

        // 버튼 패널과 출력 패널을 프레임에 추가한다.
        add(buttonPanel); // 상단 버튼 패널 추가
        add(outputPanel); // 하단 출력 패널 추가

        // 프레임을 화면에 표시한다.
        setVisible(true);
    }

    // 프레임 초기화를 수행한다.
    private void initializeFrame() {
        setTitle("버튼 눌러 텍스트 보여주기"); // 프레임의 제목을 설정한다.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 클릭 시 프로그램을 종료한다.
        setSize(400, 200); // 프레임 크기를 설정한다.
        setLayout(new GridLayout(2, 1)); // 상단과 하단 패널을 동일한 크기로 배치한다.
    }

    // 버튼 패널을 생성하여 반환한다.
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(); // 버튼 패널을 생성한다.
        buttonPanel.setLayout(new GridLayout(1, 3, 0, 0)); // 버튼을 공백 없이 가로로 배치한다.

        // 버튼을 생성한다.
        JButton hannamButton = new JButton(LEFT_BUTTON_TEXT);
        JButton universityButton = new JButton(CENTER_BUTTON_TEXT);
        JButton studentButton = new JButton(RIGHT_BUTTON_TEXT);

        // 버튼 클릭 이벤트를 설정한다.
        hannamButton.addActionListener(this::buttonClick);
        universityButton.addActionListener(this::buttonClick);
        studentButton.addActionListener(this::buttonClick);

        // 버튼을 패널에 추가한다.
        buttonPanel.add(hannamButton);
        buttonPanel.add(universityButton);
        buttonPanel.add(studentButton);

        return buttonPanel; // 생성된 버튼 패널을 반환한다.
    }

    // 출력 패널을 생성하여 반환한다.
    private JPanel createOutputPanel() {
        JPanel outputPanel = new JPanel(); // 출력 패널을 생성한다.
        outputPanel.setLayout(new BorderLayout()); // 레이블을 중앙에 배치하기 위해 BorderLayout을 사용한다.

        outputLabel = new JLabel("Press button", SwingConstants.CENTER); // 초기 텍스트와 중앙 정렬 설정
        outputLabel.setFont(new Font("Arial", Font.BOLD, 14)); // 텍스트의 폰트와 스타일을 설정한다.
        outputPanel.add(outputLabel, BorderLayout.CENTER); // 출력 레이블을 패널의 중앙에 추가한다.

        return outputPanel; // 생성된 출력 패널을 반환한다.
    }

    // 버튼 클릭 이벤트를 수행한다.
    private void buttonClick(ActionEvent e) {
        // 출력 레이블의 텍스트를 클릭된 버튼의 텍스트로 변경한다.
        JButton button = (JButton) e.getSource();
        outputLabel.setText(button.getText());
    }

    public static void main(String[] args) {
        new Ex03Main(); // 프로그램의 실행을 위해 Ex03Main 인스턴스를 생성한다.
    }
}
