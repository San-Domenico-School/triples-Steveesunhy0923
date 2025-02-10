
/**
 * Write a description of class Scorekeeper here.
 * 
 * @author (Steve Sun) 
 * @version (a version number or a date)
 */
public class Scorekeeper
{
    private static int deckSize;
    private static int score;
    private static long startTime = System.currentTimeMillis();

    public static void setDeckSize(int s)
    {
        deckSize = s;
    }

    public static void updateScore()
    {
        score += 10;
    }

    public static int getScore()
    {
        return score;
    }
}
