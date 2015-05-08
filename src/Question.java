import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by yigalalexander on 5/6/15.
 */
public class Question
{


    private String question;
    private String answers[];

    private int correctIndex;
    private final int maxAnswers=TriviaGame.maxAnswers;

    public Question(String ans[],String question, int correct) throws InvalidArgumentException
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
//        else
//            throw new InvalidArgumentException();
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
