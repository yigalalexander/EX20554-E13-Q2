import javax.swing.*;
import java.awt.*;

/**
 * Created by yigalalexander on 5/6/15.
 */
public class TriviaGui extends JFrame
{
    private JLabel lblTime;
    private JLabel lblScore;
    private JLabel lblRemQuestions;
    private QuestionPanel pnlQuestions;
    private JPanel pnlButtons;
    private JPanel pnlStatus;
    public JButton btnNext;
    public JButton btnExit;

    public TriviaGui()
    {
        super("Trivia");
        initGui();

    }

    private void initGui()
    {
        setLayout(new GridLayout(3, 1));

        pnlQuestions = new QuestionPanel();
        pnlButtons = new JPanel(new GridLayout(1,2));
        pnlStatus = new JPanel(new GridLayout(2,2));


        btnExit = new JButton("Exit");
        btnNext = new JButton("Next");

        pnlButtons.add(btnNext);
        pnlButtons.add(btnExit);
        pnlButtons.setPreferredSize(new Dimension(400, 50));

        lblTime = new JLabel(" Remaining Time:");
        lblScore = new JLabel("Score:");
        lblRemQuestions = new JLabel(" Remaining Questions:");
        pnlStatus.add(lblTime);
        pnlStatus.add(lblScore);
        pnlStatus.add(lblRemQuestions);


        add(pnlQuestions);
        add(pnlButtons);
        add(pnlStatus);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(new Dimension(400, 300));
        setResizable(false);
    }

    public void displayQuestion(Question newQuestion)
    {
        pnlQuestions.updateQuestion(newQuestion);

    }

    public void updateScore (int score)
    {
        lblScore.setText("Score: " + score);
    }

    public void updateRemQuestions (int num)
    {
        lblRemQuestions.setText(" Remaining Questions: " + num);
    }

    public int getSelectedAnswer()
    {
        return pnlQuestions.getSelectedIndex();
    }


    public void updateRemTime(int remainingTime)
    {
        lblTime.setText(" Remaining Time: "+remainingTime + "sec.");
    }
}
