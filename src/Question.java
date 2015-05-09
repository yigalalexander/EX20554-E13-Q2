import com.sun.javaws.exceptions.InvalidArgumentException;
import java.util.Random;

/**
 * Created by yigalalexander on 5/6/15.
 */
public class Question
{


    private String question;
    private String answers[];

    private int correctIndex;
    private final int maxAnswers=TriviaGame.maxAnswers;

    public Question(String ans[],String question, int correct)
    {
        if (ans!=null && question!=null
                && ans.length==maxAnswers &&
                correct>=0 && correct<maxAnswers)
        {
            answers = new String[maxAnswers];
            for (int i=0; i<maxAnswers; i++)
            {
                answers[i]= ans[i];
            }

            this.question = new String(question);
            correctIndex=correct;
        }

        shuffleAnswers();

    }

    public void shuffleAnswers()
    {
        String temp = new String(answers[correctIndex]);
        int tempIndex;

        Random random = new Random();
        do
            tempIndex=random.nextInt(maxAnswers-1);
        while (tempIndex==correctIndex); //find a new index to swap it with

        answers[correctIndex]=answers[tempIndex];
        answers[tempIndex]=temp;
        correctIndex=tempIndex;
    }

    public int getCorrectIndex()
    {
        return correctIndex;
    }

    public String toString()
    {
        return question;
    }

    public String getAnswer(int index)
    {
        return new String (answers[index]);
    }

}
