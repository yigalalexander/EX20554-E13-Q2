import javax.swing.*;
import java.awt.*;

/**
 * Created by yigalalexander on 5/8/15.
 */
public class QuestionPanel extends JPanel
{
    private ButtonGroup answersBlock;
    private JLabel lblQuestionText;
    private JRadioButton [] answers = new JRadioButton[TriviaGame.maxAnswers];

    public QuestionPanel()
    {
        super();
        setLayout(new GridLayout( TriviaGame.maxAnswers+1 , 1));
        lblQuestionText = new JLabel();

        this.add(lblQuestionText);

        answersBlock = new ButtonGroup();

        for (int i=0; i<answers.length; i++)
        {
            answers[i]=new JRadioButton();
            answersBlock.add(answers[i]);
            this.add(answers[i]);
        }

        setPreferredSize(new Dimension(350,30));
    }

    public void updateQuestion(Question source) {
        lblQuestionText.setText(source.toString());
        updateAnswers(source);
        answersBlock.clearSelection();
    }

    public int getSelectedIndex()
    {
        for (int i=0; i<answers.length; i++)
            if (answers[i].isSelected())
                return i;
        return -1;
    }

    private void updateAnswers(Question source)
    {
        for (int i=0; i<TriviaGame.maxAnswers; i++)
        {
            answers[i].setText( source.getAnswer(i) );
        }
    }


}
