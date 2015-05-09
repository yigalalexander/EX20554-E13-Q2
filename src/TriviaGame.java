import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yigalalexander on 5/6/15.
 */
public class TriviaGame
{

    private int score,remainingTime;
    private QuestionCollection questions;
    private TriviaGui currentGui;
    private Timer gameTimer,tickerTimer;
    private Question currentQuestion;

    public static final int maxAnswers=4;
    private static final int timeToAnswer=15000;

    public TriviaGame(TriviaGui activeGui)
    {
        score=0; remainingTime=0;
        questions=new QuestionCollection("trivia.txt");
        gameTimer = new Timer(timeToAnswer,new TimerListener());
        tickerTimer = new Timer(1000,new TimerListener());
        currentGui=activeGui;
        currentGui.btnNext.addActionListener(new ButtonListener());
        currentGui.btnExit.addActionListener(new ButtonListener());
    }

    public void play()
    {
        currentGui.setVisible(true);


            replaceQuestion(); // put up a question + star the timer
            gameTimer.start();

        // if the game is over then suggest to start again

    }

    private void handleQuestionTimer()
    {
        // when timer expires it will show a message,
        if (checkAnswer()) // check the answer + update score
        {
            score+=10;
        }
        else
        {
            score-=5;
        }
        currentGui.updateScore(score);
        if (replaceQuestion()) // try to replace the question
        {
            currentGui.updateRemQuestions(questions.getNumRemainingQuestions() + 1);

            tickerTimer.start();
            gameTimer.start();
        } else //game is over
        {
            tickerTimer.stop();
            JOptionPane.showMessageDialog(currentGui,"Game is over! \n Your score is "+ score);
        }

    }

    private boolean checkAnswer()
    {
            return (currentQuestion.getCorrectIndex()==currentGui.getSelectedAnswer());
    }

    private boolean replaceQuestion()
    {

        if (!isOver())
        {
            currentQuestion = questions.getNextQuestion();
            currentGui.displayQuestion(currentQuestion);
            remainingTime=timeToAnswer/1000;
            tickerTimer.start();

            return true;
        }
        return false;

    }



    public boolean isOver()
    {
        return(questions.getNumRemainingQuestions()==0);
    }

    private class TimerListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==gameTimer)
            {
                gameTimer.stop();
                JOptionPane.showMessageDialog(currentGui,"Time is up!");
                handleQuestionTimer();
            } else
            {
                updateRemainingTime(-1);
                tickerTimer.start();
            }

        }


    }

    private void updateRemainingTime(int i)
    {
        remainingTime+=i;
        currentGui.updateRemTime(remainingTime);
    }

    private void restart()
    {
        score=0;
        questions.switchLists();
        handleQuestionTimer();

    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==currentGui.btnNext)
            {
                gameTimer.stop();
                handleQuestionTimer();
            } else
            {
                System.exit(0);

            }
        }
    }


}
