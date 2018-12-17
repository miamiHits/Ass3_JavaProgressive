package Trivia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class QuestionBankParser
{
    public static List<TriviaQuestion> parseQuestionBankFile()
    {
        ArrayList<TriviaQuestion> result = new ArrayList<TriviaQuestion>();

        try
        {
            Scanner input = new Scanner(new File("trivia.txt"));
            LinkedList<String> lines = new LinkedList<String>();

            while (input.hasNext())
            {
                String st = input.next();
                lines.add(st);
            }

            while (!lines.isEmpty())
            {
                String question = lines.remove();
                String correctAnswer = lines.remove();
                String wrongAnswer1 = lines.remove();
                String wrongAnswer2 = lines.remove();
                String wrongAnswer3 = lines.remove();

                if (questionStructureValid(question, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3))
                {
                    TriviaQuestion parsedQuestion = new TriviaQuestion(question, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3);
                    result.add(parsedQuestion);
                }
            }

        } catch (Exception e)//TODO consider catching a more specific exception
        {
            System.out.println("Failed parsing question bank file with the below exception");
            e.printStackTrace();
        }

        return result;
    }

    private static boolean questionStructureValid(String question, String correctAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3)
    {
        return question != null && !question.isEmpty() &&
                correctAnswer != null && !correctAnswer.isEmpty() &&
                wrongAnswer1 != null && !wrongAnswer1.isEmpty() &&
                wrongAnswer2 != null && !wrongAnswer2.isEmpty() &&
                wrongAnswer3 != null && !wrongAnswer3.isEmpty();

    }
}
