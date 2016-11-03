/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rockpaperscissors;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Elijah
 */
public class Board extends JPanel{
    
    Image lizard;
    Image spock;
    JLabel rockPaperScissorsText;
    
    public Board()
    {        
        showImages();
        showFont();
    }

    private void showImages() {
        ImageIcon lizardIcon = new ImageIcon(this.getClass().getResource("lizard.png"));
        ImageIcon spockIcon = new ImageIcon(this.getClass().getResource("spock.png"));
        
        lizard = lizardIcon.getImage();
        spock = spockIcon.getImage();
    }
    
    private void showFont()
    {
        rockPaperScissorsText = new JLabel("Rock Paper Scissors");
        rockPaperScissorsText.setFont(new Font("Garamond", Font.PLAIN, 25));
        
        
        
    }
    
    public void paint(Graphics graphics)
    {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(lizard, 105, 105, null);
        graphics2D.drawImage(spock, 275, 105, null);
        rockPaperScissorsText.setVisible(true);
    }
    
}
