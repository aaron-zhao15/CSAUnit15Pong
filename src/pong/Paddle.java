package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block {
    
    private int speed;

    public Paddle() {
        super(10, 10);
        speed = 5;
    }

    public Paddle(int x, int y){
        super(x, y);
        speed = 5;
    }
    
    public Paddle(int x, int y, int s) {
        super(x, y);
        speed = s;
    }
    
    public Paddle(int x, int y, int w, int h) {
        super(x, y, w, h);
        speed = 5;
    }
    
    public Paddle(int x, int y, int w, int h, Color c) {
        super(x, y, w, h, c);
        speed = 5;
    }
    
    public Paddle(int x, int y, int w, int h, int s) {
        super(x, y, w, h);
        speed = s;
    }
    
    public Paddle(int x, int y, int w, int h, Color c, int s) {
        super(x, y, w, h, c);
        speed = 5;
    }
    
    public void moveUpAndDraw(Graphics window) {
        window.setColor(Color.WHITE);
        window.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
        setY(getY() - getSpeed());
        window.setColor(super.getColor());
        window.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }

    public void moveDownAndDraw(Graphics window) {
        window.setColor(Color.WHITE);
        window.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
        setY(getY() + getSpeed());
        window.setColor(super.getColor());
        window.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public String toString(){
        return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + getSpeed();
    }
    
}
