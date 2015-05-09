import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * Created by yigalalexander on 5/6/15.
 */
public class QuestionCollection
{


    public void setNumQuestions(int numQuestions)
    {
        this.numQuestions = numQuestions;
    }

    private int numQuestions;
    private ArrayList<Question> activeQuestions;
    private ArrayList<Question> usedQuestions;


    public QuestionCollection(String pathToFile)
    {
        numQuestions=0;
        activeQuestions = new ArrayList<Question>();
        usedQuestions = new ArrayList<Question>();
        loadQuestions(pathToFile);
    }

    private boolean loadQuestions(String path)
    {


        Scanner input;
        String lineBuffer;
        String questionBuffer = new String();
        String [] answersBuffer = new String[TriviaGame.maxAnswers];
        int qPos=0;

        try
        {
            input = new Scanner(new File(path));// open the file, assuming file is at the startup folder
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return false;
        }


        for (int i=0; input.hasNext(); i++) // parse it
        {
            lineBuffer = input.nextLine();
            qPos=i%(TriviaGame.maxAnswers+1);
            if (qPos==0) // Its the first line
            {
                questionBuffer=lineBuffer;
            }
            else //were reading the answers
            {
                answersBuffer[qPos-1]=new String(lineBuffer);
                if (qPos==TriviaGame.maxAnswers) //just read the last answer
                {
                    activeQuestions.add(new Question(answersBuffer,questionBuffer,0));// add questions to the array list
                    numQuestions++;
                }
            }
        }

        input.close();
        return true;
    }

    public int getNumQuestions()
    {
        return numQuestions;
    }

    public int getNumRemainingQuestions()
    {
        return activeQuestions.size();
    }

    public Question getNextQuestion()
    {
        if (activeQuestions.size() >0)
        {
            Random random = new Random();

            int tempIndex = random.nextInt( getNumRemainingQuestions() - 1);

            Question tempQuestion = activeQuestions.get(tempIndex);
            usedQuestions.add(tempQuestion);
            activeQuestions.remove(tempIndex);

            return tempQuestion;
        }

        return null;

    }

    public void switchLists()
    {
        ArrayList<Question> tempPointer;
        tempPointer=activeQuestions;
        activeQuestions=usedQuestions;
        usedQuestions=tempPointer;
    }
}
