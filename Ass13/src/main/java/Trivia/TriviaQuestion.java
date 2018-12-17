package Trivia;

public class TriviaQuestion
{
    private String question;

    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;

    public TriviaQuestion(String question, String correctAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3)
    {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.wrongAnswer3 = wrongAnswer3;
    }

    public String getQuestion()
    {
        return question;
    }

    public String getCorrectAnswer()
    {
        return correctAnswer;
    }

    public String getWrongAnswer1()
    {
        return wrongAnswer1;
    }

    public String getWrongAnswer2()
    {
        return wrongAnswer2;
    }

    public String getWrongAnswer3()
    {
        return wrongAnswer3;
    }

    public String toString() {
        int correctAnswerIndex = Questionnaire.getRandomNumberInRange(1, 4);
        String[] wrongAnswers = {this.wrongAnswer1, this.wrongAnswer2, this.wrongAnswer3};
        StringBuilder sb = new StringBuilder();
        sb.append("Question: " + this.question + "\n");
        int j = 0;
        for (int i = 1; i <= 4; i++)
        {
            if (i == correctAnswerIndex)
            {
                sb.append(i + ": " + this.correctAnswer + "\n");
            }
            else
            {
                sb.append(i + ": " + wrongAnswers[j] + "\n");
                j++;
            }
        }
        return sb.toString();
    }
}
