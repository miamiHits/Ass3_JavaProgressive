package Trivia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class QuestionFrame extends JFrame {
    private JPanel questionPanel;
    private JPanel answersPanel;
    private JTextArea questionText;
    private JRadioButton optionA;
    private JRadioButton optionB;
    private JRadioButton optionC;
    private JRadioButton optionD;
    private JButton selectButton;
    private ButtonGroup answersGroup;
    private JPanel buttonsPanel;
    private JButton startNewGameButton;
    private JLabel scoreLabel;
    private TimeoutListener timeoutListener;
    private Questionnaire questionnaire;


    public QuestionFrame(){
        super("Trivia");
        timeoutListener = new TimeoutListener(this);
        initTriviaFrame();
        reset_page();

    }

    private void initTriviaFrame() {
        questionPanel = new JPanel();
        questionText = new JTextArea();
        questionPanel.add(questionText);
        add(questionPanel, BorderLayout.NORTH);
        answersPanel = new JPanel();
        answersPanel.setLayout(new GridLayout(5,1));
        optionA = new JRadioButton();
        optionB = new JRadioButton();
        optionC = new JRadioButton();
        optionD = new JRadioButton();
        selectButton = new JButton("Choose Answer from A-D.");
        answersGroup = new ButtonGroup();
        answersGroup.add(optionA);
        answersGroup.add(optionB);
        answersGroup.add(optionC);
        answersGroup.add(optionD);
        answersPanel.add(optionA);
        answersPanel.add(optionB);
        answersPanel.add(optionC);
        answersPanel.add(optionD);
        answersPanel.add(selectButton);
        add(answersPanel, BorderLayout.CENTER);
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout());
        startNewGameButton = new JButton("Start New Game");
        buttonsPanel.add(startNewGameButton);
        add(buttonsPanel, BorderLayout.SOUTH);
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(Color.RED);
        scoreLabel.setFont(new Font("Serif", Font.PLAIN, 36));
        scoreLabel.setVisible(true);
        add(scoreLabel, BorderLayout.AFTER_LINE_ENDS);
        setSize(500,500);
        setVisible(true);
        setResizable(false);
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onSubmit();
            }
        } );
        startNewGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset_page();
            }
        } );

    }
    /**
     * Start a new game and clear previous score and data.
     */
    private void reset_page() {
        QuestionBankParser bankParser = new QuestionBankParser();
        List<TriviaQuestion> questionsList =  bankParser.parseQuestionBankFile();
        questionnaire = new Questionnaire(questionsList);
        scoreLabel.setText("Score: 0");
        this.selectButton.setEnabled(true);
        this.answersGroup.clearSelection();
        TriviaQuestion triviaQuestion = questionnaire.peekNextQuestion(timeoutListener);
        showQuestion(triviaQuestion);
    }

    private void showQuestion(TriviaQuestion triviaQuestion) {
        questionText.setText(triviaQuestion.getQuestion());
        optionA.setText(triviaQuestion.getCorrectAnswer());
        optionB.setText(triviaQuestion.getWrongAnswer1());
        optionC.setText(triviaQuestion.getWrongAnswer2());
        optionD.setText(triviaQuestion.getWrongAnswer3());

    }

    public void onTimeout()
    {
        JOptionPane.showMessageDialog(null, "You got out of time :/ Minus 5pts and moving to next question");
        timeoutListener.setTimeoutFlag(false);
        onSubmit();
    }

    private void onSubmit() {
        String chosenAnswer = "";
        if (this.optionA.isSelected()) chosenAnswer = this.optionA.getText();
        if (this.optionB.isSelected()) chosenAnswer = this.optionB.getText();
        if (this.optionC.isSelected()) chosenAnswer = this.optionC.getText();
        if (this.optionD.isSelected()) chosenAnswer = this.optionD.getText();
        questionnaire.submitAnswer(chosenAnswer);
        this.scoreLabel.setText("Score: " + questionnaire.getScore());
        TriviaQuestion triviaQuestion = questionnaire.peekNextQuestion(timeoutListener);
        if (triviaQuestion != null) {
            JOptionPane.showMessageDialog(null, "Moving to next question ...");
            showQuestion(triviaQuestion);
            this.answersGroup.clearSelection();
        }
        else {
            this.selectButton.setEnabled(false);
            this.scoreLabel.setBackground(Color.YELLOW);
            this.scoreLabel.setText("FINAL Score: " + questionnaire.getScore());
        }
    }

}
