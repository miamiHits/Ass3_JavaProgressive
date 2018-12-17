package Trivia;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Questionnaire
{
    public static int TIME_LIMIT_IN_MILLISECONDS = 5000; // TODO set proper value

    private LinkedList<TriviaQuestion> shuffledQuestions;
    private static Random random = new Random();
    private int score = 0;
    private Timer timer;

    public Questionnaire(List<TriviaQuestion> questions)
    {
        int[] randomPermutationIndexes = generateRandomPermutation(questions.size());
        this.shuffledQuestions = new LinkedList<TriviaQuestion>();

        for (int i = 0; i < questions.size(); i++)
        {
            int nextQuestion = randomPermutationIndexes[i];
            this.shuffledQuestions.add(questions.get(nextQuestion));
        }

        shuffleAnswers();
    }

    private void shuffleAnswers() {
        for (TriviaQuestion triviaQuestion : shuffledQuestions)
        {
            ArrayList<String> permutations = new ArrayList();
            permutations.add(triviaQuestion.getCorrectAnswer());
            permutations.add(triviaQuestion.getWrongAnswer1());
            permutations.add(triviaQuestion.getWrongAnswer2());
            permutations.add(triviaQuestion.getWrongAnswer3());
            Collections.shuffle(permutations);
            triviaQuestion.setCorrectAnswer(permutations.get(0));
            triviaQuestion.setWrongAnswer1(permutations.get(1));
            triviaQuestion.setWrongAnswer2(permutations.get(2));
            triviaQuestion.setWrongAnswer3(permutations.get(3));
        }

    }

    //returns null when there are no questions
    public TriviaQuestion peekNextQuestion(final TimeoutListener timeoutListener)
    {
        this.timer = new Timer(TIME_LIMIT_IN_MILLISECONDS, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                timeoutListener.setTimeoutFlag(true);
                submitAnswer(null);
            }
        });
        this.timer.start();
        if (!shuffledQuestions.isEmpty())
        {
            return shuffledQuestions.peek();
        }
        else
        {
            return null;
        }
    }

    //comparison is case insensitive.
    //once an answer is submitted will move on to the next question
    public boolean submitAnswer(String answer)
    {
        boolean isAnswerCorrect = false;
        if (answer == null || answer.isEmpty())
        {
            this.score -= 5;
            isAnswerCorrect = false;
        }
        else
        {
            TriviaQuestion currentQuestion = shuffledQuestions.remove();
            String correctAnswer = currentQuestion.getCorrectAnswer();
            isAnswerCorrect = answer.toLowerCase().equals(correctAnswer.toLowerCase());
            this.score += isAnswerCorrect ? 10 : -5;
        }

        this.timer.stop();
        return isAnswerCorrect;
    }

    public int getScore()
    {
        return this.score;
    }

    private static int[] generateRandomPermutation(int size)
    {
        int[] result = new int[size];
        for (int i = 0; i < size; i++)
        {
            result[i] = i;
        }

        for (int i = 0; i < size; i++)
        {
            int random = getRandomNumberInRange(0, size - 1);
            int temp = result[i];
            result[i] = result[random];
            result[random] = temp;
        }

        return result;
    }


    //includes max
    public static int getRandomNumberInRange(int min, int max)
    {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return random.nextInt((max - min) + 1) + min;
    }
}
