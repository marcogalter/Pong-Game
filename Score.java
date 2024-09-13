
package ponggame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Score extends Rectangle{
    static int GAME_WIDTH;
    static int GAME_HEIGTH;
    int player1;
    int player2;
    
    Score(int GAME_WIDTH, int GAME_HEIGTH){
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGTH = GAME_HEIGTH;
    }
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.PLAIN,60));
        g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGTH);
        g.drawString(String.valueOf(player1), GAME_WIDTH/2 - 85, 50);
        g.drawString(String.valueOf(player2), GAME_WIDTH/2 + 20, 50);
    }
}
