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

                TriviaQuestion parsedQuestion = new TriviaQuestion(question, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3);

                result.add(parsedQuestion);
            }

        } catch (Exception e)//TODO consider catching a more specific exception
        {
            System.out.println("Failed parsing question bank file with the below exception");
            e.printStackTrace();
        }

        return result;
    }
}
