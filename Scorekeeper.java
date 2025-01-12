/**
 * Write a description of class Scorekeeper here.
 * 
 * @author (Steve Sun) 
 * @version (a version number or a date)
 */
public class Scorekeeper extends Animations
{
    private int deckSize;
    private int score;
    private long startTime;

    /**
     * Constructor for objects of class Scorekeeper
     */
    public Scorekeeper()
    {
        this.startTime = System.currentTimeMillis();
    }
    
    public void setDeckSize(int input)
    {
        this.deckSize = input;
    }
    
    public void updateScore()
    {   
        long currentTime = System.currentTimeMillis();
        long elapsedTime = (currentTime - startTime) / 1000;
        int timeBonus = Math.max(1, 100 - (int) elapsedTime);
        int deckBonus = deckSize * 10; 
        this.score += timeBonus + deckBonus;
        this.startTime = currentTime; 
    }
    
    public int getScore()
    {
        return this.score;
    }
    
    public void act()
    {
        
    }
}
