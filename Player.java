import greenfoot.*;
import java.util.ArrayList;
/**
 * steve sun
 * feb 3
 */


public class Player extends Actor
{
    private Dealer dealer;
    private Card[] cardsSelected;
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;

    public Player(Dealer d)
    {
        dealer = d;
        cardsSelected = new Card[3];
        cardsOnBoard = new ArrayList<Card>();
        selectedCardsIndex = new ArrayList<Integer>();
    }

    public void addedToWorld(World w)
    {
        cardsOnBoard = (ArrayList<Card>) getWorld().getObjects(Card.class);
    }

    public void act()
    {
        selectCards();
        boolean threeCardsHaveBeenSelected = setCardsSelected();
        if(threeCardsHaveBeenSelected)
        {
            dealer.setCardsSelected(cardsOnBoard, selectedCardsIndex, cardsSelected);
            dealer.checkIfTriple(cardsSelected);
            resetCardsSelected();
        }
    }

    private void selectCards()
    {
        for(int i = 0; i < cardsOnBoard.size(); i++)
        {
            Card c = cardsOnBoard.get(i);
            if(Greenfoot.mouseClicked(cardsOnBoard.get(i)))
            {
                if(c.getIsSelected())
                {
                    c.setIsSelected(false);
                    c.setImage(c.getCardImage());
                    selectedCardsIndex.remove((Integer) i);
                }
                else
                {
                    c.setIsSelected(true);
                    c.setImage(c.getSelectedCardImage());
                    selectedCardsIndex.add(i);
                }
            }
        }
    }

    private boolean setCardsSelected()
    {
        if(selectedCardsIndex.size() == 3)
        {
            for(int i = 0; i < 3; i++)
            {
                cardsSelected[i] = cardsOnBoard.get(selectedCardsIndex.get(i));
            }
            return true;
        }
        return false;
    }

    private void resetCardsSelected()
    {
        for(int i = 0; i < cardsOnBoard.size(); i++)
        {
            Card c = cardsOnBoard.get(i);
            c.setImage(c.getCardImage());
            c.setIsSelected(false);
        }
        selectedCardsIndex.clear();
    }
}


