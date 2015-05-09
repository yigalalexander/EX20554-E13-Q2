import javax.swing.*;
/**
 * Created by yigalalexander on 5/6/15.
 */
public class TriviaGame
{

    private int score;
    private QuestionCollection questions;
    private boolean over;
    private TriviaGui currentGui;
    private Timer gameTimer;

    public static final int maxAnswers=4;
    private static final int timeToAnswer=15000;



    public TriviaGame(TriviaGui activeGui)
    {
        over=false;
        score=0;
        questions=new QuestionCollection("trivia.txt");
        gameTimer = new Timer(timeToAnswer,null);
        currentGui=activeGui;
    }

    public void play()
    {
        currentGui.setVisible(true);
        currentGui.updateScore(0);
        currentGui.displayQuesion(questions.getNextQuestion());
        currentGui.updateRemQuestions(questions.getNumRemainingQuestions()+1);

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
