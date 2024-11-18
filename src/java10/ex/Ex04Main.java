package java10.ex;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class Ex04Main extends JFrame {

    private final JPanel contentPane; // 메인 패널
    private final JPanel panelDown;  // CardLayout이 적용될 하단 패널

    private static final String PANEL_LEFT = "버튼3개";
    private static final String BUTTON_CENTER = "이전연습문제";
    private static final String BUTTON_RIGHT = "글자";

    public Ex04Main() {
        // 프레임을 초기화한다.
        contentPane = new JPanel(); // 메인 패널을 생성한다.
        initializeFrame();

        // 상단 버튼 패널을 생성한다.
        JPanel panelUp = createButtonPanel();

        // 하단 CardLayout 패널을 생성한다.
        panelDown = createCardLayoutPanel();

        // 메인 패널에 상단과 하단 패널을 추가한다.
        contentPane.add(panelUp, BorderLayout.NORTH);  // 상단 버튼 패널 추가
        contentPane.add(panelDown, BorderLayout.CENTER);  // 하단 CardLayout 패널 추가

        // 프레임을 화면에 표시한다.
        setVisible(true);
    }

    // 프레임을 초기화하는 메서드
    private void initializeFrame() {
        setTitle("CardLayout 예제"); // 프레임 제목을 설정한다.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 클릭 시 프로그램을 종료한다.
        setBounds(100, 100, 400, 300); // 프레임 크기와 위치를 설정한다.

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // 메인 패널에 여백을 추가한다.
        contentPane.setLayout(new BorderLayout(0, 0)); // BorderLayout으로 설정한다.
        setContentPane(contentPane); // 메인 패널을 프레임에 추가한다.
    }

    // 상단 버튼 패널을 생성하여 반환하는 메서드
    private JPanel createButtonPanel() {
        JPanel panelUp = new JPanel(); // 상단 패널을 생성한다.

        // 버튼을 생성한다.
        JButton leftButton = new JButton(PANEL_LEFT);
        JButton centerButton = new JButton(BUTTON_CENTER);
        JButton rightButton = new JButton(BUTTON_RIGHT);

        // 버튼 클릭 이벤트를 설정한다.
        leftButton.addActionListener(this::ButtonClick); // 메서드 참조. e -> ButtonClick(e)와 같은 의미이다.
        centerButton.addActionListener(this::ButtonClick);
        rightButton.addActionListener(this::ButtonClick);

        // 버튼을 패널에 추가한다.
        panelUp.add(leftButton);
        panelUp.add(centerButton);
        panelUp.add(rightButton);

        return panelUp; // 생성된 패널을 반환한다.
    }

    // 하단 CardLayout 패널을 생성하여 반환하는 메서드
    private JPanel createCardLayoutPanel() {
        JPanel panel = new JPanel(); // 패널을 생성한다.
        panel.setLayout(new CardLayout()); // CardLayout을 설정한다.

        // 각 하위 패널을 생성하여 CardLayout에 추가한다.
        panel.add(createLeftButtonPanel(), PANEL_LEFT);      // 버튼 3개 패널 추가
        panel.add(createCenterButtonPanel(), BUTTON_CENTER); // 텍스트 출력 패널 추가
        panel.add(createRightButtonPanel(), BUTTON_RIGHT);   // 오른쪽 텍스트 패널 추가

        return panel; // 생성된 패널을 반환한다.
    }

    // "버튼3개"에 해당하는 패널을 생성하여 반환하는 메서드
    private JPanel createLeftButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)); // FlowLayout으로 설정한다.
        JButton button1 = new JButton("button1");
        JButton button2 = new JButton("button2");
        JButton button3 = new JButton("button3");

        // 버튼을 패널에 추가한다.
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        return panel; // 생성된 패널을 반환한다.
    }

    // "이전연습문제"에 해당하는 패널을 생성하여 반환하는 메서드
    private JPanel createCenterButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        // 상단에 배치할 버튼 패널을 생성한다.
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 0, 0)); // GridLayout으로 버튼을 배치
        JButton hannamButton = new JButton("Hannam");
        JButton universityButton = new JButton("University");
        JButton studentButton = new JButton("Student");
        buttonPanel.add(hannamButton);
        buttonPanel.add(universityButton);
        buttonPanel.add(studentButton);

        // 출력 라벨을 생성한다.
        JLabel outputLabel = new JLabel("Press button", SwingConstants.CENTER);
        outputLabel.setFont(new Font("Arial", Font.BOLD, 14)); // 폰트 설정

        // 버튼 클릭 이벤트를 설정한다.
        hannamButton.addActionListener(e -> outputLabel.setText("Hannam"));
        universityButton.addActionListener(e -> outputLabel.setText("University"));
        studentButton.addActionListener(e -> outputLabel.setText("Student"));

        // 패널에 버튼 패널과 출력 라벨을 추가한다.
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(outputLabel, BorderLayout.SOUTH);

        return panel; // 생성된 패널을 반환한다.
    }

    // "글자"에 해당하는 패널을 생성하여 반환하는 메서드
    private JPanel createRightButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // 중앙에 배치할 라벨을 생성한다.
        JLabel rightLabel = new JLabel("오른쪽 입니다");
        rightLabel.setFont(new Font("Arial", Font.BOLD, 16)); // 폰트 스타일과 크기 설정

        // 라벨을 패널에 추가한다.
        panel.add(rightLabel, BorderLayout.CENTER);

        return panel; // 생성된 패널을 반환한다.
    }

    // 버튼 클릭 이벤트를 처리하는 메서드
    private void ButtonClick(ActionEvent e) {
        JButton button = (JButton) e.getSource(); // 클릭된 버튼을 가져온다.
        CardLayout cardLayout = (CardLayout) panelDown.getLayout(); // CardLayout 객체를 가져온다.
        cardLayout.show(panelDown, button.getText()); // 버튼 텍스트에 해당하는 패널을 표시한다.
    }

    public static void main(String[] args) {
        new Ex04Main(); // 프로그램을 실행한다.
    }
}
