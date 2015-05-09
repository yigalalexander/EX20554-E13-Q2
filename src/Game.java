

/**
 * Created by yigalalexander on 5/8/15.
 */
public class Game
{
    public static void main (String args[])
    {
        TriviaGui gui = new TriviaGui();
        TriviaGame game = new TriviaGame(gui);
        game.play();

    }
}
