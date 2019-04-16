package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable {

    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color color;

    public Block() {
        xPos = 0;
        yPos = 0;
        width = 10;
        height = 10;
        color = Color.BLACK;
    }

    //add other Block constructors - x , y , width, height, color
    public Block(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    public Block(int xPos, int yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }
    
    public Block(int xPos, int yPos, int width, int height, Color color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    
    //add the other set methods
    public void setPos(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    /**
     * @return the xPos
     */
    public int getX() {
        return xPos;
    }

    /**
     * @param xPos the xPos to set
     */
    public void setX(int xPos) {
        this.xPos = xPos;
    }

    /**
     * @return the yPos
     */
    public int getY() {
        return yPos;
    }

    /**
     * @param yPos the yPos to set
     */
    public void setY(int yPos) {
        this.yPos = yPos;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * @param col the color to set
     */
    public void setColor(Color col) {
        this.color = col;
    }
    

    public void draw(Graphics window) {
        //uncomment after you write the set and get methods
        window.setColor(color);
        window.fillRect(getX(), getX(), getWidth(), getHeight());
    }

    public void draw(Graphics window, Color col) {
        window.fillRect(xPos, yPos, width, height);
    }

    public boolean equals(Object obj) {
        Block temp = (Block) obj;
        if(this.getColor() != null && temp.getColor() != null){
            if( this.getX() == temp.getX() && this.getY() == temp.getY() && 
                    this.getWidth() == temp.getWidth() && this.getHeight() == temp.getHeight() && 
                    this.getColor().equals(temp.getColor())){
                return true;
            }
        }
        return false;
    }

    //add a toString() method  - x , y , width, height, color
    public String toString(){
        return this.xPos + " " + this.yPos + " " + this.width + " " + this.height + " " + this.color;
    }
    
}
