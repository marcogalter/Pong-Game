
package ponggame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class GamePanel extends JPanel implements Runnable{
    
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGTH = (int)(GAME_WIDTH *(0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGTH);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGTH = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;
    
            
    GamePanel(){
        newPaddle();
        newBall();
        score = new Score(GAME_WIDTH,GAME_HEIGTH);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }
    public void newBall(){
        random = new Random();
        ball = new Ball((GAME_WIDTH/2) - (BALL_DIAMETER/2),random.nextInt(GAME_HEIGTH-BALL_DIAMETER), BALL_DIAMETER,BALL_DIAMETER);
    }
    
    public void newPaddle(){
        paddle1 = new Paddle(0,(GAME_HEIGTH/2) -(PADDLE_HEIGTH/2),PADDLE_WIDTH,PADDLE_HEIGTH,1);
        paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGTH/2) -(PADDLE_HEIGTH/2),PADDLE_WIDTH,PADDLE_HEIGTH,2);
    }
    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }
    public void draw(Graphics g){
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }
    
    public void move(){
       ball.move();
       paddle1.move();
       paddle2.move();
    }
    public void checkCollision(){
        //Quic da bola no paddle
        if (ball.intersects(paddle1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; // opcional para aumentar a velocidade e dificuldade
            if (ball.yVelocity>0) 
                ball.yVelocity++; // opcional para aumentar a velocidade e dificuldade
             else
                ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if (ball.intersects(paddle2)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; // opcional para aumentar a velocidade e dificuldade
            if (ball.yVelocity>0) 
                ball.yVelocity++; // opcional para aumentar a velocidade e dificuldade
             else
                ball.yVelocity--;
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        

        //colisão da bola com a base da tela
        if (ball.y <= 0) {
            ball.setYDirection(-ball.yVelocity);
        }
        if (ball.y >= GAME_HEIGTH-BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
        }
        //Parar os paddles nos cantos
        if (paddle1.y<=0) {
            paddle1.y = 0;
        }
        if (paddle1.y>=(GAME_HEIGTH-PADDLE_HEIGTH)){
            paddle1.y = GAME_HEIGTH-PADDLE_HEIGTH;
        }
        if (paddle2.y<=0) {
            paddle2.y = 0;
        }
        if (paddle2.y>=(GAME_HEIGTH-PADDLE_HEIGTH)){
            paddle2.y = GAME_HEIGTH-PADDLE_HEIGTH;
        }
        //Dar ao player 1 ponto e criar uma nova bola
        if (ball.x <= 0) {
            score.player2++;
            
            newBall();
            System.out.println("PLAYER 2: "+score.player2);
        }
        if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            score.player1++;
           
            newBall();
            System.out.println("PLAYER 1: "+score.player1);
        }
    }
    public void run(){
        //loop do jogo
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta +=(now-lastTime) / ns;
            lastTime = now;
            if (delta>=1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }

    }
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            paddle1.keyEselead(e);
            paddle2.keyEselead(e);
        }
    }
}
