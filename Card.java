import greenfoot.*; 
/**
 * Game Board for Triples
 * Steve Sun 2024
 * ...
 */


public class Card extends Actor
{
    public enum Color 
    {
        RED, BLUE, GREEN, NO_COLOR;
    }
    public enum Shape 
    {
        CIRCLE, SQUARE, TRIANGLE, NO_SHAPE;
    }
    private Shape shape;
    private Color color;
    private boolean isSelected;
    private GreenfootImage cardImage;
    private GreenfootImage selectedCardImage;
    private int numberOfShapes;
    private int shading;

    public Card(Shape shape, Color color, int numberOfShapes, 
                int shading, GreenfootImage cardImage, GreenfootImage selectedCardImage)
    {
        this.shape = shape;
        this.color = color;
        this.numberOfShapes = numberOfShapes;
        this.shading = shading;
        this.cardImage = cardImage;
        this.selectedCardImage = selectedCardImage;

        setImage(cardImage);
    }

    public Color getColor() 
    {
        return color;
    }

    public Shape getShape() 
    {
        return shape;
    }

    public GreenfootImage getCardImage() 
    {
        return cardImage;
    }

    public GreenfootImage getSelectedCardImage() 
    {
        return selectedCardImage;
    }

    public int getNumberOfShapes() 
    {
        return numberOfShapes;
    }

    public int getShading() 
    {
        return shading;
    }
    
    public boolean getIsSelected()
    {
        return isSelected;
    }
    
    public void setIsSelected(boolean selected) 
    {
        this.isSelected = selected;
    }
}

