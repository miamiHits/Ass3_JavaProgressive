package Trivia;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Questionnaire
{
    private LinkedList<TriviaQuestion> shuffledQuestions;
    private static Random random = new Random();

    public Questionnaire(List<TriviaQuestion> questions)
    {
        int[] randomPermutationIndexes = generateRandomPermutation(questions.size());
        this.shuffledQuestions = new LinkedList<TriviaQuestion>();

        for (int i = 0; i < questions.size(); i++)
        {
            int nextQuestion = randomPermutationIndexes[i];
            this.shuffledQuestions.add(questions.get(nextQuestion));
        }
    }

    public TriviaQuestion peekNextQuestion()
    {
        return shuffledQuestions.peek();
    }

    //comparison is case insensitive.
    //once an answer is submitted will move on to the next question
    public boolean submitAnswer(String answer)
    {
        TriviaQuestion currentQuestion = shuffledQuestions.peek();
        String correctAnswer = currentQuestion.getCorrectAnswer();
        return answer.toLowerCase().equals(correctAnswer.toLowerCase());
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
    private static int getRandomNumberInRange(int min, int max)
    {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return random.nextInt((max - min) + 1) + min;
    }
}
