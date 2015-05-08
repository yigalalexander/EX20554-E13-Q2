import javax.swing.*;
import java.awt.*;

/**
 * Created by yigalalexander on 5/6/15.
 */
public class TriviaGui extends JFrame
{
    private JLabel lblTime;
    private QuestionPanel pnlQuestions;
    private JPanel pnlButtons;
    private JPanel pnlTime;

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
        pnlTime = new JPanel();

        JButton btnNext = new JButton("Next");
        JButton btnExit = new JButton("Exit");

        pnlButtons.add(btnNext);
        pnlButtons.add(btnExit);

        lblTime = new JLabel("Remaining Time:");
        pnlTime.add(lblTime);


        add(pnlQuestions);
        add(pnlButtons);
        add(pnlTime);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(new Dimension(400, 400));
        setResizable(false);
    }

    public void displayQuesion (Question newQuestion)
    {
        pnlQuestions.updateQuestion(newQuestion);
    }
}
