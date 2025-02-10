import greenfoot.*;
import java.util.ArrayList;

/**
 * steve sun
 * feb 3
 */


public class Dealer extends Actor
{
    private Deck deck;
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;
    private Card[] cardsSelected;
    private int numCardsInDeck;
    private int triplesRemaining;

    public Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
        triplesRemaining = numCardsInDeck / 3;
        deck = new Deck(numCardsInDeck);
        cardsSelected = new Card[3];
        cardsOnBoard = new ArrayList<Card>();
        selectedCardsIndex = new ArrayList<Integer>();
    }

    public void addedToWorld(World w)
    {
        dealBoard();
        setUI();
    }

    public void dealBoard()
    {
        Greenfoot.playSound("shuffle.wav");
         for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                Card card = deck.getTopCard();
                getWorld().addObject(card, 130*j+80, 90*i+50);
            }
        }

    }

    public void setUI()
    {
        Integer d = deck.getNumCardsInDeck();
        Integer s = Scorekeeper.getScore();
        getWorld().showText(d.toString(), 310, 470);
        getWorld().showText(s.toString(), 310, 505);
    }

    public void endGame()
    {
        if(triplesRemaining <= 0)
        {
            Greenfoot.stop();
        }
    }

    public void checkIfTriple(Card[] cards)
    {
        if(isTriple(cards))
        {
            actionIfTriple();
        }
        else
        {
            Animations.wobble(cardsSelected);
        }
    }

    public void actionIfTriple()
    {
        int[][] coords = new int[3][2];
        for(int i = 0; i < 3; i++)
        {
            coords[i][0] = cardsSelected[i].getX();
            coords[i][1] = cardsSelected[i].getY();
        }
        Animations.slideAndTurn(cardsSelected);
        for(int i = 0; i < 3; i++)
        {
            getWorld().removeObject(cardsSelected[i]);
            cardsOnBoard.remove(cardsSelected[i]);
        }
        for(int i = 0; i < 3; i++)
        {
            if(deck.getNumCardsInDeck() > 0)
            {
                Card c = deck.getTopCard();
                cardsOnBoard.add(c);
                getWorld().addObject(c, coords[i][0], coords[i][1]);
            }
        }
        triplesRemaining--;
        Scorekeeper.updateScore();
        setUI();
        endGame();
    }

    public void setCardsSelected(ArrayList<Card> board, ArrayList<Integer> idx, Card[] sel)
    {
        cardsOnBoard = board;
        selectedCardsIndex = idx;
        cardsSelected = sel;
    }

    private boolean isTriple(Card[] sel)
    {
        if(sel[0] == null || sel[1] == null || sel[2] == null) return false;
        if(!featureCheck(sel[0].getShape(), sel[1].getShape(), sel[2].getShape())) return false;
        if(!featureCheck(sel[0].getColor(), sel[1].getColor(), sel[2].getColor())) return false;
        if(!featureCheck(sel[0].getNumberOfShapes(), sel[1].getNumberOfShapes(), sel[2].getNumberOfShapes())) return false;
        if(!featureCheck(sel[0].getShading(), sel[1].getShading(), sel[2].getShading())) return false;
        return true;
    }

    private boolean featureCheck(Object a, Object b, Object c)
    {
        return (a.equals(b) && b.equals(c)) || (!a.equals(b) && !b.equals(c) && !a.equals(c));
    }
    

}






