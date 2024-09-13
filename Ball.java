/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ponggame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Ball extends Rectangle {
    Random random;
    int xVelocity;
    int yVelocity;
    int inicialSpeed = 3 ;
    
    Ball(  int x, int y, int width, int heigth){
      super(x,y,width,heigth);
      random = new Random();
      int randomXDirection = random.nextInt(3)-1;
      
         setXDirection(randomXDirection*inicialSpeed);
      
      int randomYDirection = random.nextInt(3)-1;

         setYDirection(randomYDirection*inicialSpeed);
      
    }
    public void setXDirection (int randomXDirection){
      xVelocity = randomXDirection;
       }
    public void setYDirection (int randomYDirection){
      yVelocity = randomYDirection;
       }
    public void move(){
      x += xVelocity;
      y += yVelocity;
    }
    public void draw(Graphics g){
      g.setColor(Color.WHITE);
      g.fillOval(x, y, width, height);
    }
}
