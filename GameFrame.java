
package ponggame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameFrame extends JFrame{
    
    GamePanel painel = new GamePanel();
    JButton resetButton = new  JButton("Reiniciar bola");
    
    GameFrame(){
     this.add(painel);
    this.add(resetButton, BorderLayout.SOUTH);
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                painel.newBall(); // As vezes a bola ficava presa quicando apenas no meio, tentei fazer um botão para reiniciar ela.
                painel.requestFocusInWindow();
            }
        });

     this.setTitle("JOGO PONG");
     this.setResizable(false);
     this.setBackground(Color.black);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.pack();
     this.setVisible(true);
     this.setLocationRelativeTo(null);
     

    }
}
