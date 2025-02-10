import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Board for Triples
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameBoard extends World
{
    private final int NUM_CARDS_IN_DECK = 81;
    
    public GameBoard()
    {   
        super(430, 600, 1, false); 
        prepareScene();
        //new Tester("Scorekeeper");
        //new Tester(NUM_CARDS_IN_DECK);
    }
    private void prepareScene()
    {
        // Create a Dealer passing in the total number of cards to use
        Dealer dealer = new Dealer(NUM_CARDS_IN_DECK);
        Player player = new Player(dealer);
        Scorekeeper scorekeeper = new Scorekeeper();
        // Add the Dealer to the world at an offscreen location (-30, -30) 
        // so it doesn't appear on the board
        addObject(dealer, -30, -30);
        addObject(player, -100, 100);
        
        
        
        // You may add other setup code here, if needed.
    }

}
