package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable{

    private int XSpeed;
    private int YSpeed;

    public Ball() {
        super(200, 200);
        XSpeed = 3;
        YSpeed = 1;
    }

    public Ball(int x, int y) {
        super(x, y);
        XSpeed = 3;
        YSpeed = 1;
    }

    public Ball(int x, int y, int xs, int ys) {
        super(x, y);
        XSpeed = xs;
        YSpeed = ys;
    }

    public Ball(int x, int y, int w, int h, Color c) {
        super(x, y, w, h, c);
        XSpeed = 3;
        YSpeed = 1;
    }

    public Ball(int x, int y, int w, int h, Color c, int xs, int ys) {
        super(x, y, w, h, c);
        XSpeed = xs;
        YSpeed = ys;
    }

    public void moveAndDraw(Graphics window) {
        remBall(window);
        setX(getX() + getXSpeed());
        setY(getY() + getYSpeed());
        window.setColor(super.getColor());
        window.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
    
    public void remBall(Graphics window) {
        window.setColor(Color.WHITE);
        window.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }

    public boolean equals(Object obj) {
        Ball temp = (Ball) obj;
        return super.equals(obj) && XSpeed == temp.getXSpeed() && YSpeed == temp.getYSpeed();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    //add a toString() method
    public int getXSpeed() {
        return XSpeed;
    }

    public void setXSpeed(int xSpeed) {
        this.XSpeed = xSpeed;
    }

    public int getYSpeed() {
        return YSpeed;
    }

    public void setYSpeed(int ySpeed) {
        this.YSpeed = ySpeed;
    }

    @Override
    public String toString() {
        return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + getXSpeed() + " " + getYSpeed();
    }
    
    public boolean didCollideLeft(Object obj){
        Paddle paddle = (Paddle) obj;
        if((super.getX() <= paddle.getX() + paddle.getWidth() + Math.abs(getXSpeed())) &&
                (super.getY() >= paddle.getY() && 
                super.getY() <= paddle.getY() + paddle.getHeight() ||
                super.getY() + super.getHeight() <= paddle.getY() &&
                super.getY() + super.getHeight() < paddle.getY() + paddle.getHeight())){
            return true;
        }
        return false;
    }
    
    public boolean didCollideRight(Object obj){
        Paddle paddle = (Paddle) obj;
        if((super.getX() + super.getWidth() <= paddle.getX() + Math.abs(getXSpeed())) &&
                (super.getY() >= paddle.getY() && 
                super.getY() <= paddle.getY() + paddle.getHeight() ||
                super.getY() + super.getHeight() <= paddle.getY() &&
                super.getY() + super.getHeight() < paddle.getY() + paddle.getHeight())){
            return true;
        }
        return false;
    }

}
