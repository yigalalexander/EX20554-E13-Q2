/**
 * Created by yigalalexander on 5/6/15.
 */
public class TriviaGame
{

    private int score;
    private QuestionCollection questions;
    private boolean over;
    private TriviaGui currentGui;
    public static final int maxAnswers=4;


    public TriviaGame(TriviaGui activeGui)
    {
        over=false;
        score=0;
        questions=new QuestionCollection("trivia.txt");
        currentGui=activeGui;
    }

    public void play()
    {
        currentGui.setVisible(true);
    }


    public int getScore()
    {
        return score;
    }

    public boolean isOver()
    {
        return over;
    }
}
