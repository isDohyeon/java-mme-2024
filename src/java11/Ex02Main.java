package java11;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.*;

public class Ex02Main extends JFrame {

    private static final String TITLE = "사용자 등록 예제";
    private static int studentNumber = 20200001;

    private JTextArea outputTextArea;
    private JTextField nameTextField;
    private JTextField studentNumberTextField;

    private final List<String> types = List.of("교수", "직원", "학생");
    private ButtonGroup buttonGroup;
    private String selectedType;

    public Ex02Main() {
        initializeFrame();
        initializeInputPanel();
        initializeControlPanel();
        initializeOutputArea();
        setVisible(true);
    }

    // 프레임 기본 설정
    private void initializeFrame() {
        setTitle(TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    // 사용자 입력 패널 초기화
    private void initializeInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(1, 2));

        // 왼쪽 레이블 영역
        JPanel labelPanel = createLabelPanel();
        inputPanel.add(labelPanel);

        // 오른쪽 입력 영역
        JPanel inputFieldsPanel = createInputFieldsPanel();
        inputPanel.add(inputFieldsPanel);

        add(inputPanel, BorderLayout.NORTH);
    }

    // 왼쪽 레이블 패널 생성
    private JPanel createLabelPanel() {
        JPanel labelPanel = new JPanel(new GridLayout(3, 1));
        labelPanel.add(new JLabel("학번"));
        labelPanel.add(new JLabel("타입"));
        labelPanel.add(new JLabel("이름"));
        return labelPanel;
    }

    // 오른쪽 입력 필드 패널 생성
    private JPanel createInputFieldsPanel() {
        JPanel inputFieldsPanel = new JPanel(new GridLayout(3, 1));

        // 학번 텍스트 필드
        studentNumberTextField = new JTextField(String.valueOf(studentNumber));
        studentNumberTextField.setEditable(false);
        inputFieldsPanel.add(studentNumberTextField);

        // 라디오 버튼 패널
        JPanel radioButtonPanel = createRadioButtonPanel();
        inputFieldsPanel.add(radioButtonPanel);

        // 이름 입력 필드
        nameTextField = new JTextField();
        inputFieldsPanel.add(nameTextField);

        return inputFieldsPanel;
    }

    // 라디오 버튼 패널 생성
    private JPanel createRadioButtonPanel() {
        JPanel radioButtonPanel = new JPanel(new FlowLayout());
        buttonGroup = new ButtonGroup();

        for (String type : types) {
            JRadioButton button = new JRadioButton(type);
            button.addActionListener(e -> selectedType = type); // 선택된 타입 저장
            buttonGroup.add(button);
            radioButtonPanel.add(button);
        }

        return radioButtonPanel;
    }

    // 버튼 및 제어 패널 초기화
    private void initializeControlPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // "추가" 버튼 생성
        JButton addButton = new JButton(new ImageIcon("out/images/더하기.png"));
        addButton.setBorder(BorderFactory.createEmptyBorder());
        addButton.setContentAreaFilled(false);
        addButton.addActionListener(e -> buttonClick());
        buttonPanel.add(addButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    // 출력 영역 초기화
    private void initializeOutputArea() {
        outputTextArea = new JTextArea(7, 20);
        outputTextArea.setEditable(false); // 텍스트 영역 편집 불가
        add(new JScrollPane(outputTextArea), BorderLayout.SOUTH);
    }

    // "추가" 버튼 클릭 핸들러
    private void buttonClick() {
        saveUserInfo();
        resetInputFields();
    }

    // 유저 정보 저장
    private void saveUserInfo() {
        String formattedUserInfo = String.format("id:%d, type:%s, name:%s\n", // 유저 정보 포맷
                studentNumber,
                selectedType,
                nameTextField.getText());
        outputTextArea.append(formattedUserInfo); // 포맷된 유저 정보 쓰기
    }

    // 입력 필드 초기화
    private void resetInputFields() {
        nameTextField.setText(""); // 이름 필드 초기화
        studentNumberTextField.setText(String.valueOf(++studentNumber)); // 학번 증가
        buttonGroup.clearSelection(); // 라디오 버튼 선택 해제
        selectedType = null; // 선택된 타입 초기화
    }

    public static void main(String[] args) {
        new Ex02Main();
    }
}
