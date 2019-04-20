package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable {

    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private boolean[] keys;
    private BufferedImage back;
    private int leftScore;
    private int rightScore;

    public Pong() {
        //set up all variables related to the game
        ball = new BlinkyBall();

        leftPaddle = new Paddle(50, 300, 10, 50, Color.BLUE);

        rightPaddle = new Paddle(740, 300, 10, 50, Color.BLACK);

        keys = new boolean[4];

        leftScore = 0;
        rightScore = 0;

        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
        addKeyListener(this);		//starts the key thread to log key strokes
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        //set up the double buffering to make the game animation nice and smooth
        Graphics2D twoDGraph = (Graphics2D) window;

        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();

        ball.moveAndDraw(graphToBack);
        leftPaddle.draw(graphToBack);
        rightPaddle.draw(graphToBack);

        //handle if either paddle goes out of bounds
//        if(!(leftPaddle.getY() >= 0 && leftPaddle.getY() + leftPaddle.getHeight() <= 600)){
//            leftPaddle.remPad(window);
//            leftPaddle.setY(600 - leftPaddle.getY());
//        }
//        
//        if(!(rightPaddle.getY() >= 0 && rightPaddle.getY() + rightPaddle.getHeight() <= 600)){
//            rightPaddle.remPad(window);
//            rightPaddle.setY(600 - rightPaddle.getY());
//        }
        
        //see if ball hits left wall or right wall
        if (!(ball.getX() >= 0 && ball.getX() <= window.getClipBounds().width - ball.getWidth())) {
            ball.setXSpeed(0);
            ball.setYSpeed(0);

            handleWin(window, graphToBack);
            
            ball.remBall(graphToBack);
        }
        
        graphToBack.setColor(Color.WHITE);
        graphToBack.fillRect(440, 520, 80, 80);
        
        leftPaddle.draw(graphToBack);
        rightPaddle.draw(graphToBack);

        graphToBack.setColor(Color.red);

        graphToBack.drawString("Right score: " + rightScore, window.getClipBounds().width/2, 540);
        graphToBack.drawString("Left score: " + leftScore, window.getClipBounds().width/2, 560);

        //see if the ball hits the top or bottom wall 
        if (!(ball.getY() >= 0 && ball.getY() <= window.getClipBounds().height - ball.getHeight())) {
            ball.setXSpeed(ball.getXSpeed());
            ball.setYSpeed(-ball.getYSpeed());
        }

        //see if the ball hits the left paddle
        if (ball.didCollideLeft(leftPaddle)) {
            if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed())) {
                ball.setYSpeed(ball.getYSpeed());
            } else {
                ball.setXSpeed(-ball.getXSpeed());
            }
        }

        //see if the ball hits the right paddle
        if (ball.didCollideRight(rightPaddle)) {
            if (ball.getX() + ball.getWidth() <= rightPaddle.getX() - Math.abs(ball.getXSpeed())) {
                ball.setYSpeed(ball.getYSpeed());
            } else {
                ball.setXSpeed(-ball.getXSpeed());
            }
        }

        //see if the paddles need to be moved
        if (keys[0] == true) {
            leftPaddle.moveUpAndDraw(graphToBack);
        }
        if (keys[1] == true) {
            leftPaddle.moveDownAndDraw(graphToBack);
        }
        if (keys[2] == true) {
            rightPaddle.moveUpAndDraw(graphToBack);
        }
        if (keys[3] == true) {
            rightPaddle.moveDownAndDraw(graphToBack);
        }

        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void handleWin(Graphics window, Graphics graphToBack) {
        if (ball.getX() <= 0) {
            rightScore++;
        }
        if (ball.getX() >= window.getClipBounds().width - ball.getWidth()) {
            leftScore++;
        }

        try {
            Thread.currentThread().sleep(950);
        } catch (Exception e) {
        }

        ball.draw(graphToBack, Color.WHITE);
        ball.setX((int) (Math.random() * 50) + 400);
        ball.setY((int) (Math.random() * 50) + 300);

        int rand = (int) (Math.random() * 2);
        if (rand == 0) {
            ball.setXSpeed(2);
            ball.setYSpeed(1);
        } else {
            ball.setXSpeed(-2);
            ball.setYSpeed(1);
        }

    }

    public void keyPressed(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = true;
                break;
            case 'Z':
                keys[1] = true;
                break;
            case 'I':
                keys[2] = true;
                break;
            case 'M':
                keys[3] = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = false;
                break;
            case 'Z':
                keys[1] = false;
                break;
            case 'I':
                keys[2] = false;
                break;
            case 'M':
                keys[3] = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(8);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
